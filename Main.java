import javax.swing.*;

public class Main extends JFrame implements Runnable{
	JTabbedPane tbp;
	ZipGraph ab;
	JMenuBar menu;
	Main(){
		super("ZIP/UNZIP");	
	tbp = new JTabbedPane();
	ab = new ZipGraph();
	tbp.add(ab,"zip");
	setContentPane(tbp);
	setVisible(true);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	}
	
	public static void main (String [] args) {
		
		
		Main prog = new Main();
		Thread th = new Thread(prog);
		th.start();
		
	}

	public void run() {
		Thread th = new Thread(ab);
		th.start();
		
	}
}
