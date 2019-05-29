import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;

public class MyZipper {
	
	private String zipPath;
	private String zipName;
	private ArrayList<String> filesList;
	private FileInputStream fis;
	private FileOutputStream fos;
	private ZipOutputStream zos;
	private ZipEntry ze;
	public ArrayList<String> status;
	
	public MyZipper() {
		zipName=null;
		zipPath=null;
		filesList=null;
		fis=null;
		fos=null;
		zos=null;
		ze=null;
		status= new ArrayList<String>();
	}
	
	public MyZipper(String zipName,String zipPath,ArrayList<String> filesList) {
		this.zipName=zipName;
		this.zipPath=zipPath;
		this.filesList=filesList;
		fis=null;
		fos=null;
		zos=null;
		ze=null;
		status= new ArrayList<String>();
	}
	
	public String getZipPath(){
		return zipPath;
	}
	public void setZipPath(String zipPath){
		this.zipPath = zipPath;
	}
	public String getZipName(){
		return zipName;
	}
	public void setZipName(String zipName){
		this.zipName = zipName;
	}
	public ArrayList<String> getFilesList(){
		return filesList;
	}
	public void setFilesList(ArrayList<String> filesList){
		this.filesList = filesList;
	}

	public void global_zip_function() {
		
		//Creation du Zip
		try {
			
			//Testing 
			if(zipPath.equals(null) || zipName.equals(null) || filesList.size()==0) throw new Exception("Empty Field");
			
			status.add("Creating "+zipName+"\n");
			
			fos= new FileOutputStream(zipPath+"\\"+zipName);
			zos= new ZipOutputStream(fos);
			zos.setMethod(ZipOutputStream.DEFLATED);
			zos.setLevel(Deflater.BEST_COMPRESSION);
			
			//parcours du Zip
			for(int i=0;i<filesList.size();i++) {
				File tempfile = new File(filesList.get(i));
				if(tempfile.equals(null)) throw new Exception("File Not Found");
				if(tempfile.isDirectory()) {
					status.add("Zipping a Directory: "+tempfile.getName()+"\n");
					System.out.println("Zipping a Directory: "+tempfile.getName());
					zip_directory(tempfile,fis,fos,zos,ze,1);
				}
				if(tempfile.isFile()) {
					status.add("Zipping File: "+tempfile.getName()+"\n");
					System.out.println("Zipping File: "+tempfile.getName());
					fis=new FileInputStream(filesList.get(i));
					ze= new ZipEntry(getFileShortName(filesList.get(i)));
					zos.putNextEntry(ze);
					byte[] buffer = new byte[1024];
					int len;
			    	while ((len = fis.read(buffer)) > 0) {
			    		zos.write(buffer, 0, len);
			    	}
			    	fis.close();
				}
			}
			
			zos.closeEntry();
			zos.close();
			fos.close();
		} catch (Exception e) {
			status.add("------------------------------\n"+e.getMessage()+"\n------------------------------\n");
			System.err.println(e);
		}
		status.add("Done");
		System.out.println("Done");
	}
	
	private void zip_directory(File tempfile, FileInputStream fis, FileOutputStream fos, ZipOutputStream zos, ZipEntry ze,int depth) {
		File[] children = tempfile.listFiles();
	    if (children != null) {
	        for (int j=0;j<children.length;j++) {
	        	if(children[j].isDirectory()) {
	        		status.add("Zipping A sub-directory: "+getChildrenNameWithDepth(children[j].getPath(),depth)+"\n");
	        		System.out.println("Zipping A sub-directory: "+getChildrenNameWithDepth(children[j].getPath(),depth));
					zip_directory(children[j],fis,fos,zos,ze,depth+1);
				}
				if(children[j].isFile()) {
					try {
						status.add("Zipping a file in sub-dir: "+getChildrenNameWithDepth(children[j].getPath(),depth)+"\n");
						System.out.println("Zipping a file in sub-dir: "+getChildrenNameWithDepth(children[j].getPath(),depth));
						fis=new FileInputStream(children[j]);
						ze= new ZipEntry(getChildrenNameWithDepth(children[j].getPath(),depth));
						zos.putNextEntry(ze);
						byte[] buffer = new byte[1024];
						int len;
				    	while ((len = fis.read(buffer)) > 0) {
				    		zos.write(buffer, 0, len);
				    	}
				    	fis.close();
					}catch(Exception e) {
						status.add("------------------------------\n"+e.getMessage()+"\n------------------------------+\n");
						System.err.println(e);
					}
				}
	        }
	    }
	}

	public String getFileShortName(String N) {
		char[] temp= N.toCharArray();
		int pos=0;
		String res="";
		for(int i=temp.length-1;i>=0;i--) {
			if(temp[i]=='\\') {
				pos=i+1;
				break;
			}
		}
		for(int i=pos;i<temp.length;i++) res+=temp[i];
		return res;
	}
	
	public String getChildrenNameWithDepth(String N,int depth) {
		char[] temp=N.toCharArray();
		int pos=0;
		String res="";
		for(int i=temp.length-1;i>=0;i--) {
			if(temp[i]=='\\') {
				if(depth==0) {
					pos=i;
					break;
				}
				else depth--;
			}
		}
		for(int i=pos+1;i<temp.length;i++) res+=temp[i];
		return res;
	}

	/*public static void main(String[] args) {
		ArrayList<String> filesList = new ArrayList<String>();
		filesList.add("src\\res\\ip");
		filesList.add("src\\res\\res");
		MyZipper temp= new MyZipper("MyZip.zip","src\\res",filesList);
		temp.global_zip_function();
	}*/
	
	/*Methodes a ajouter au Composants de IHM
	 --> filesList.add("File Path") 
	 --> setZipPath 
	 --> setZipName
	 --> filesList.get (display files to zip)
	 --> getZipPath
	 --> getZipName
	 --> global_zip_function (Zip button)
	 */
		
}
