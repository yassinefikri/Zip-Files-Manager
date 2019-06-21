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
	JTextField pathsave = new JTextField("*the zip to save*");
	JTextArea consl = new JTextArea(30,50);
	String savename;
	ArrayList<String> filo = new ArrayList<String>();
	MyZipper temp;
	public ZipGraph() {
		super();
		temp = new MyZipper();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel welcmlbl = new JLabel("Zip :) ~");
		JLabel loadlbl = new JLabel("Files to zip: ");
		JButton load = new JButton("load");
		JLabel savlbl = new JLabel ("Save the zip file : ");
		JButton save = new JButton("Save");
		JButton zip = new JButton("Zip it!");
		JButton exit = new JButton ("EXIT");
		pathcont.setPreferredSize(new Dimension(swidth,sheight));
		pathcont.setEditable(false);
		pathsave.setPreferredSize(new Dimension(swidth,sheight));
		pathsave.setEditable(false);
		c.gridx=c.gridy=0;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		c.anchor=GridBagConstraints.LINE_START;
		c.insets = new Insets(10,15,0,0);
		add(welcmlbl,c);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor=GridBagConstraints.BASELINE_LEADING;
		c.insets= new Insets(10,15,0,0);
		add(loadlbl,c);
		c.gridx=1;
		c.gridy=1;
		c.weightx=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.BASELINE;
		c.insets= new Insets(0,15,0,10);
		add(pathcont,c);
		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.BASELINE;
		c.gridwidth=GridBagConstraints.REMAINDER;
		
		add(load,c);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.BASELINE_LEADING;
		c.insets= new Insets(10,15,0,0);
		add(savlbl,c);
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets= new Insets(0,15,0,10);
		c.anchor=GridBagConstraints.BASELINE;
		add(pathsave,c);
		c.gridx=2;
		c.gridy=2;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.BASELINE;
		c.insets= new Insets(0,15,0,10);

		add(save,c);
		c.gridx=1;
		c.gridy=3;
		c.anchor=GridBagConstraints.LINE_START;
		c.insets= new Insets(0,15,0,10);

		add(zip,c);
		c.gridx=2;
		c.gridy=3;
		c.anchor=GridBagConstraints.BASELINE;
		c.insets= new Insets(10,15,10,10);

		add(exit,c);
		
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.LINE_START;
		c.gridwidth=GridBagConstraints.REMAINDER;
		consl.setEditable(false);
		JScrollPane sp = new JScrollPane(consl);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(sp,c);
			load.setToolTipText("Afficher la liste de fichiers pour compresser");
			zip.setToolTipText("Compresser");
			load.addActionListener(this);
			save.addActionListener(this);
			zip.addActionListener(this);
			exit.addActionListener(this);
			
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
			  consl.setText("");
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
