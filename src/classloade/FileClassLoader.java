package classloade;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileClassLoader extends ClassLoader {
	private String rootDir;
	
	public FileClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		
		if (null == classData) {
			throw new ClassNotFoundException();
		}
		
		return defineClass(name, classData, 0, classData.length);
	}

	private byte[] getClassData(String name) {
		String classPath = className2Path(name);
		
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(classPath);
			baos = new ByteArrayOutputStream();
			
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			
			int bytesNumRead = 0;
			
			while ((bytesNumRead = is.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	private String className2Path(String name) {
		// TODO Auto-generated method stub
		return rootDir + File.separator 
				+ name.replace(".", File.separator) + ".class";
	}
}
