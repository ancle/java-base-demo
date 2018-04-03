package io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	public static boolean isFile(String filename) {
		return new File(filename).isFile();
	}
	
	public static boolean isDirectory(String path) {
		return new File(path).isDirectory();
	} 
	
	public static boolean isExists(String path, String filename) {
		String fullPath = path + File.separator + filename;
		
		return new File(fullPath).exists();
	}
	
	public static List<String> listFile(String filePath) {
		File file = new File(filePath);
		List<String> files = new ArrayList<String>();
		if (file.isFile()) {
			files.add(file.getAbsolutePath());
			
			return files;
		}
		
		File[] childFiles = file.listFiles();
		for (File child : childFiles) {
			if (child.isDirectory()) {
				files.addAll(listFile(child.getAbsolutePath()));
			}
			
			files.add(child.getAbsolutePath());
		}
		
		return files;
	}
	
	public static void copyFile(File targetFile, File resourceFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream(resourceFile);
			fos = new FileOutputStream(targetFile);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			byte[] buffer = new byte[bis.available()];
			int readNum = 0;
			while ((readNum = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, buffer.length);
			}
			
			bos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
