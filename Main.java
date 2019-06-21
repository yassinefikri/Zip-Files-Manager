import javax.swing.*;

public class Main extends JFrame implements Runnable{
	JTabbedPane tbp;
	ZipGraph ab;
	GraphUnzipper ac;
	Main(){
		super("ZIP/UNZIP");	
	tbp = new JTabbedPane();
	ab = new ZipGraph();
	ac = new GraphUnzipper();
	tbp.add(ab,"zip");
	tbp.add(ac,"unzip");
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
	}
	
	
	public static void main (String [] args) {
		
		
		Main prog = new Main();
		Thread th = new Thread(prog);
		th.start();
		
	}
}
