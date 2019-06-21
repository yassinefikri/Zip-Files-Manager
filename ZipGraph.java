
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*; 
import javax.swing.filechooser.*;

public class ZipGraph extends JPanel implements ActionListener, Runnable {
	private static final int swidth=200;
	private static final int sheight=25;
	private int currentLines=0;
	JTextField pathcont = new JTextField("*loaded files here*");
	JTextField pathcont1 = new JTextField("*loaded zip here*");
	JTextField pathsave = new JTextField("*the zip to save*");
	JTextField pathsave1 = new JTextField("*Choose exctraction directory path *");
	JTextArea consl = new JTextArea();
	JTextArea consl1 = new JTextArea();
	String savename;
	String savename1;
	ArrayList<String> filo = new ArrayList<String>();
	MyZipper temp;
<<<<<<< HEAD:Graph.java
	MyUnzipper tempo;
	public Graph() {
=======
	public ZipGraph() {
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		super();
		temp = new MyZipper();
<<<<<<< HEAD:Graph.java
		tempo = new MyUnzipper();
		JPanel pane= new JPanel();
		JPanel panea = new JPanel();
		pane.setLayout(new GridBagLayout());
		panea.setLayout(new GridBagLayout());
=======
		setLayout(new GridBagLayout());
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		JLabel welcmlbl = new JLabel("Zip :) ~");
		JLabel welcmlbl1 = new JLabel("unZip :) ~");
		JLabel loadlbl = new JLabel("Files to zip: ");
		JLabel loadlbl1 = new JLabel("Files to Unzip: ");
		JButton load = new JButton("load");
		JButton load1 = new JButton("load");
		JLabel savlbl = new JLabel ("Save the zip file : ");
		JLabel savlbl1 = new JLabel ("Save the unzip file : ");
		JButton save = new JButton("Save");
		JButton save1 = new JButton("Save");
		JButton zip = new JButton("Zip it!");
		JButton unzip = new JButton("UNZip it!");
		JButton exit = new JButton ("EXIT");
		JButton exit1 = new JButton ("EXIT");
		pathcont.setPreferredSize(new Dimension(swidth,sheight));
		pathcont1.setPreferredSize(new Dimension(swidth,sheight));
		pathcont.setEditable(false);
		pathcont1.setEditable(false);
		pathsave.setPreferredSize(new Dimension(swidth,sheight));
		pathsave1.setPreferredSize(new Dimension(swidth,sheight));
		pathsave.setEditable(false);
		pathsave1.setEditable(false);
		
		c.gridx=c.gridy=0;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		c.anchor=GridBagConstraints.LINE_START;
		c.insets = new Insets(10,15,0,0);
<<<<<<< HEAD:Graph.java
		d.gridx=d.gridy=0;
		d.gridwidth=GridBagConstraints.REMAINDER;
		d.gridheight=1;
		d.anchor=GridBagConstraints.LINE_START;
		d.insets = new Insets(10,15,0,0);
		pane.add(welcmlbl,c);
		panea.add(welcmlbl1,d);
=======
		add(welcmlbl,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor=GridBagConstraints.BASELINE_LEADING;
		c.insets= new Insets(10,15,0,0);
<<<<<<< HEAD:Graph.java
		d.gridx=0;
		d.gridy=1;
	    d.gridwidth=1;
		d.gridheight=1;
		d.anchor=GridBagConstraints.BASELINE_LEADING;
		d.insets= new Insets(10,15,0,0);
		
		pane.add(loadlbl,c);
	    panea.add(loadlbl1,d);
	
		
=======
		add(loadlbl,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=1;
		c.gridy=1;
		c.weightx=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.BASELINE;
		c.insets= new Insets(0,15,0,10);
<<<<<<< HEAD:Graph.java
		d.gridx=1;
		d.gridy=1;
		d.weightx=1;
		d.fill=GridBagConstraints.HORIZONTAL;
		d.anchor=GridBagConstraints.BASELINE;
		d.insets= new Insets(0,15,0,10);
		pane.add(pathcont,c);
		panea.add(pathcont1,d);
=======
		add(pathcont,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.BASELINE;
		c.gridwidth=GridBagConstraints.REMAINDER;
		d.gridx=2;
		d.gridy=1;
		d.fill=GridBagConstraints.HORIZONTAL;
		d.anchor=GridBagConstraints.BASELINE;
		d.gridwidth=GridBagConstraints.REMAINDER;
		
<<<<<<< HEAD:Graph.java
		pane.add(load,c);
		panea.add(load1,d);
=======
		add(load,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.BASELINE_LEADING;
		c.insets= new Insets(10,15,0,0);
<<<<<<< HEAD:Graph.java
		d.gridx=0;
		d.gridy=2;
		d.gridwidth=1;
		d.anchor=GridBagConstraints.BASELINE_LEADING;
		d.insets= new Insets(10,15,0,0);
		panea.add(savlbl1,d);
=======
		add(savlbl,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets= new Insets(0,15,0,10);
		c.anchor=GridBagConstraints.BASELINE;
<<<<<<< HEAD:Graph.java
		d.gridx=1;
		d.gridy=2;
		d.fill=GridBagConstraints.HORIZONTAL;
		d.insets= new Insets(0,15,0,10);
		d.anchor=GridBagConstraints.BASELINE;
		pane.add(pathsave,c);
		panea.add(pathsave1,d);
=======
		add(pathsave,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=2;
		c.gridy=2;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.BASELINE;
		c.insets= new Insets(0,15,0,10);
		d.gridx=2;
		d.gridy=2;
		d.fill=GridBagConstraints.HORIZONTAL;
		d.anchor=GridBagConstraints.BASELINE;
		d.insets= new Insets(0,15,0,10);

<<<<<<< HEAD:Graph.java
		pane.add(save,c);
		panea.add(save1,d);
=======
		add(save,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=1;
		c.gridy=3;
		c.anchor=GridBagConstraints.LINE_START;
		c.insets= new Insets(0,15,0,10);
		d.gridx=1;
		d.gridy=3;
		d.anchor=GridBagConstraints.LINE_START;
		d.insets= new Insets(0,15,0,10);

<<<<<<< HEAD:Graph.java
		pane.add(zip,c);
		panea.add(unzip,d);
=======
		add(zip,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		c.gridx=2;
		c.gridy=3;
		c.anchor=GridBagConstraints.BASELINE;
		c.insets= new Insets(10,15,10,10);
		d.gridx=2;
		d.gridy=3;
		d.anchor=GridBagConstraints.BASELINE;
		d.insets= new Insets(10,15,10,10);

<<<<<<< HEAD:Graph.java
		pane.add(exit,c);
		panea.add(exit1,d);
=======
		add(exit,c);
		
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.LINE_START;
		c.gridwidth=GridBagConstraints.REMAINDER;
		d.gridx=0;
		d.gridy=4;
		d.fill=GridBagConstraints.BOTH;
		d.anchor=GridBagConstraints.LINE_START;
		d.gridwidth=GridBagConstraints.REMAINDER;
		consl.setRows(20);
		consl.setEditable(false);
		consl1.setRows(20);
		consl1.setEditable(false);
		
		JScrollPane sp = new JScrollPane(consl);
<<<<<<< HEAD:Graph.java
		JScrollPane sp1 = new JScrollPane(consl1);
		pane.add(sp,c);
		panea.add(sp1,d);
		
=======
		add(sp,c);
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
			load.setToolTipText("Afficher la liste de fichiers pour compresser");
			zip.setToolTipText("Compresser");
			load.addActionListener(this);
			save.addActionListener(this);
			zip.addActionListener(this);
			exit.addActionListener(this);
<<<<<<< HEAD:Graph.java
			load1.setToolTipText("Afficher la liste de fichiers pour compresser");
			unzip.setToolTipText("Décompresser");
			JTabbedPane tbp = new JTabbedPane();
			
			tbp.add("zip", pane);
			tbp.add("unzip",panea);
			
			setContentPane(tbp);
			setVisible(true);
			pack();
=======
			
>>>>>>> bd2d06e88b7b4f2de2624328b4d0bc7cfd650927:ZipGraph.java
			}

	 public void actionPerformed(ActionEvent e)
	 {
		 String cm = e.getActionCommand();
		 if(cm.equals("load")) {
			 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
			  j.setMultiSelectionEnabled(true);
	            int r = j.showOpenDialog(null); 
	            
	          
	  
	            // files selected:
	            if (r == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	            	
	            	
	            	File files[] = j.getSelectedFiles();
	            	   int t = 0; 
	            	   for(int i=0; i<files.length; i++) {
	            		   filo.add(files[i].getAbsolutePath());
	            	   }
	            	   for(int i=0; i<filo.size(); i++) {
	            		  char tab[] = filo.get(i).toCharArray();
	            		  String res="";
	            		  for(int k=0;k<tab.length;k++){
	            		   res+=tab[k];
	            		  if(tab[k]=='\\') res+='\\';
	            		  }
	            		  filo.set(i, res);
	            		  
	            		  System.out.println(filo.get(i));
	            	   }
	                   // blanker le contenu de label
	                   pathcont.setText(""); 
	     
	                   // set the label to the path of the selected files 
	                   while (t++ < files.length) 
	                	   pathcont.setText(pathcont.getText() + " \n " + files[t - 1].getName() + "\n"); 
	                // set the label to the path of the selected file 
	              //  pathcont.setText(j.getSelectedFile().getAbsolutePath()); 
	            } 
	            // if the user presses cancel
	            else
	                pathcont.setText("Vous avez annulé l'opération"); 
	        } 
		 
		  if (cm.equals("Save")) { 
	            // create an object of JFileChooser class 
	            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	          //  j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            // resctrict the user to select files of all types 
	            j.setAcceptAllFileFilterUsed(false); 
	  
	            // set a title for the dialog 
	            j.setDialogTitle("Sauvgarder votre  fichier .zip"); 
	  
	            // only allow files of .zip extension 
	            FileNameExtensionFilter restrict = new FileNameExtensionFilter("zip files", "zip"); 
	            j.addChoosableFileFilter(restrict); 
	  
	            // invoke the showsSaveDialog function to show the save dialog 
	            int r = j.showSaveDialog(null); 
	  
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	                // set the label to the path of the selected file 
	            	
						pathsave.setText(j.getSelectedFile().getParent());
					
	            	savename=j.getSelectedFile().getName();
	            } 
	            // if the user cancelled the operation 
	            else
	            	pathsave.setText("Vous avez annulé l'opération"); 
	        } 
		  if(cm.equals("Zip it!")) {
			  System.out.println(filo.size());
			  temp.setZipName(savename);
			  temp.setZipPath(pathsave.getText());
		  temp.setFilesList(filo);
			  System.out.println(pathsave.getText());
				temp.global_zip_function();
		  }
		  
		  if(cm.equals("EXIT")) {
			  System.exit(0);

		  }
	 }
		
	 public void run(){
		 while(true) {
			    if(temp.status.size()>currentLines){
			        for(int i=currentLines;i<temp.status.size();i++) {
			             consl.setText(consl.getText()+temp.status.get(i));
			        }
			        currentLines=temp.status.size();
			    }
			    try{
			    	
			        Thread.currentThread().sleep(100);
			    }catch(Exception e){
			        System.out.println(e);
			    }
		 }

		}

/*	public static void main(String [] args) {
		JFrame an = new JFrame();
		
		Graph a = new Graph();
		an.setContentPane(a);
		an.setVisible(true);
		an.pack();
		
		Thread th = new Thread(a);
		th.start();
	}
*/


}
