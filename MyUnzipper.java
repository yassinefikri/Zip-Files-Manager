import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;


public class MyUnzipper {
	
	private String zipPath;
	private String destPath;
	private File extractDir;
	private FileInputStream fis;
	private ZipInputStream zis;
	private ZipEntry ze;
	private FileOutputStream fos;
	public ArrayList<String> status;
	
	public MyUnzipper() {
		zipPath=null;
		destPath=null;
		extractDir=null;
		fis=null;
		zis=null;
		ze=null;
		fos=null;
		status= new ArrayList<String>();
	}

	public MyUnzipper(String zipPath,String destPath) {
		this.zipPath=zipPath;
		this.destPath=destPath+"\\"+FileShortName(zipPath);
		extractDir=null;
		fis=null;
		zis=null;
		ze=null;
		fos=null;
		status= new ArrayList<String>();
	}
	
	public String getZipPath() {
		return zipPath;
	}

	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath+"\\"+FileShortName(zipPath);
	}
	
	public void global_unzip_function() {
		
		try {
			
			//Testing
			if(zipPath.equals(null) || destPath.equals(null)) throw new Exception("Empty Field");
			
			//Check Zip Exists and Create Destination Folder
			File temp= new File(zipPath);
			if (!temp.exists()) throw new Exception("File Doesn't Exist");
			status.add("Creating Destination Directory\n");
			extractDir = new File(destPath);
			boolean created = extractDir.mkdir();
			if(!created) throw new Exception("Failed Create Destination Dir");
			
			//Input Streams & ZipEntry
			fis= new FileInputStream(zipPath);
			zis= new ZipInputStream(fis);
			ze= zis.getNextEntry();
			// Parcours du Zip & Copie des Fichier via Streams
			while(ze!=null) {
				System.out.println("Unzipping : "+ze.getName());
				status.add("Unzipping : "+ze.getName()+"\n");
				File tempfile = new File(extractDir,ze.getName());
				new File(tempfile.getParent()).mkdirs();
				fos= new FileOutputStream(tempfile);
				byte[] buffer = new byte[1024];
			    int length;
			    while ((length = zis.read(buffer)) > 0) {
			        fos.write(buffer, 0, length);
			    }
			    fos.close();
			    ze=zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();
			fis.close();
			
		}catch(Exception e) {
			status.add("------------------------------\n"+e.getMessage()+"\n------------------------------\n");
			System.err.println(e);
		}
		
		System.out.println("Done");
		status.add("Done");
		
	}
	
	//Get Destination Folder Name from Zip File
	public String FileShortName(String P) {
		String res="";
		char[] temp=P.toCharArray();
		int pos1=0;
		int pos2=0;
		for(int i=temp.length-1;i>=0;i--) {
			if(temp[i]=='.') pos2=i;
			if(temp[i]=='\\') {
				pos1=i;
				break;
			}
		}
		for(int i=pos1+1;i<pos2;i++) res+=temp[i];
		return res;
	}
	
	/*public static void main(String[] args) {
		//MyUnzipper temp = new MyUnzipper("src\\res\\MyZip.zip","C:\\Users\\Led Info\\Desktop");
		MyUnzipper temp = new MyUnzipper("C:\\Users\\Led Info\\Desktop\\tempj\\MyZip.zip","C:\\Users\\Led Info\\Desktop\\tempj");
		temp.global_unzip_function();
	}*/
	
	/*Methodes a ajouter au Composants de IHM
	 --> setZipPath
	 --> getZipPath
	 --> setDestPath
	 --> getZipPath
	 --> global_unzip_function (unzip button)
	 */

}
