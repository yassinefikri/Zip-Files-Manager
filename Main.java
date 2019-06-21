import java.awt.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JFrame implements Runnable{
	private JTabbedPane tbp;
	private ZipGraph ab;
	private GraphUnzipper ac;
	private InfoPanel ad;
	Main(){
		super("ZIP/UNZIP");	
	tbp = new JTabbedPane();
	ab = new ZipGraph();
	ac = new GraphUnzipper();
	ad= new InfoPanel();
	tbp.add(ab,"zip");
	tbp.add(ac,"unzip");
	tbp.add(ad,"About");
	setContentPane(tbp);
	setVisible(true);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	}
	
	public void run() {
		Thread th = new Thread(ab);
		th.start();
		Thread ts = new Thread(ac);
		ts.start();
		Thread th1= new Thread(ad);
		th1.start();
	}
	
	public static void main (String [] args) {
		
		
		Main prog = new Main();
		Thread th = new Thread(prog);
		th.start();
		
	}
	
	private class InfoPanel extends JPanel implements Runnable{
		private JLabel l;
		private JLabel lf;
		private ColorPanel cp1,cp2,cp3;
		public InfoPanel() {
			setLayout(new GridLayout(5,1));
			l= new JLabel("developed by:", JLabel.CENTER);
			l.setFont(l.getFont().deriveFont(20f));
			lf= new JLabel("GI3 2019", JLabel.CENTER);
			lf.setFont(lf.getFont().deriveFont(20f));
			cp1= new ColorPanel("Yassine Fikri");
			cp2= new ColorPanel("Soufiane El Mallali");
			cp3= new ColorPanel("Mohammed Ellouke");
			add(l);
			add(cp1);
			add(cp2);
			add(cp3);
			add(lf);
		}
		public void run() {
			while(true) {
				cp1.setColor(new Color(ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),40));
				cp2.setColor(new Color(ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),40));
				cp3.setColor(new Color(ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),40));
				cp1.repaint();
				cp2.repaint();
				cp3.repaint();
				try {
					Thread.currentThread().sleep(2000);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	private class ColorPanel extends JPanel{
		private Color c;
		private String name;
		public ColorPanel(String name) {
			this.name=name;
			setBorder(BorderFactory.createLineBorder(Color.black));
			c= new Color(255,255,255,0);
			setOpaque(false);
			setPreferredSize(new Dimension(150,50));
			setMaximumSize(new Dimension(150,50));
		}
		public Color getColor() {
			return c;
		}
		public void setColor(Color c) {
			this.c=c;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(c);
			g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
			g2d.setColor(Color.BLACK);
			g.setFont(new Font("Helvetica Bold", Font.PLAIN, 30)); 
			FontMetrics fm = g.getFontMetrics();
		    int x = (this.getSize().width - fm.stringWidth(name)) / 2;
		    int y = (fm.getAscent() + (this.getSize().height - (fm.getAscent() + fm.getDescent())) / 2);
		    g2d.drawString(name, x, y);
		}
	}
}
