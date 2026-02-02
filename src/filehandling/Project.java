package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Project {
	public static void main(String[] args) throws IOException {
		String mainFolderLocation = "C:\\Users\\Prasanna\\Desktop\\Project";
		String subFolderLocation =  "C:\\Users\\Prasanna\\Desktop\\Project\\folder";
		
		String OgFileAddress = "C:\\Users\\Prasanna\\Desktop\\Project/file.txt";
//		createMainFolder(mainFolderLocation);
//		createMasterFile(mainFolderLocation);		
//		createSubFolder(subFolderLocation,1);
//		createSubFolder(subFolderLocation,2);
		
		//first folder
		String folderName = "\\folder_1";
		String fileName = "/file_";
		
//		for(int i = 1; i <= 10; i++) {
//			createFileCopy(OgFileAddress, mainFolderLocation,folderName,fileName,i);
//		System.out.println("--> " + i);
//		}
		
		//second folder`
		folderName = "\\folder_2";
		for(int i = 1; i <= 10; i++) {
			createFileCopy(OgFileAddress, mainFolderLocation,folderName,fileName,i);
		System.out.println("--> " + i);
		}
	}
	//copying files
	static void createFileCopy(
			String OgFileAddress,
			String mainFolderLocation,
			String folderName,
			String fileName, 
			int number) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(
				mainFolderLocation 
				+ folderName 
				+ fileName 
				+ number 
				+".txt", 
				true);
		
		FileInputStream fis = new FileInputStream(OgFileAddress);
		
		int temp;
		while((temp = fis.read()) != -1) {
			fos.write(temp);
		}	
		
		String s = ", data from " + fileName + number;
		
		
		fos.write(s.getBytes());
	}
	
	//creating folders
	static void createMainFolder(String mainFolderLocation) {
		File f = new File(mainFolderLocation);
		System.out.println(f.mkdir());
	}
	
	static void createSubFolder(String mainFolderLocation, int number) {
		File f = new File(mainFolderLocation + number);
		System.out.println(f.mkdir());
	}
	
	//masterCopy made
	static void createMasterFile(String mainFolderLocation) throws IOException {
		File f = new File(mainFolderLocation +"/file.txt");
		String data = "this is the file";
		
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(data.getBytes());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
