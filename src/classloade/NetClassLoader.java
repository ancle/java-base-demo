package classloade;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClassLoader extends ClassLoader {
	private String url;
	
	public NetClassLoader(String url) {
		this.url = url;
	}
	
	public Class<?> findClass(String className) throws ClassNotFoundException {
		byte[] classData = getClassDataFromNet(className);
		
		if (null == classData) {
			throw new ClassNotFoundException();
		}
		
		return defineClass(className, classData, 0, classData.length);
	}

	private byte[] getClassDataFromNet(String className) {
		String path = className2Path(className);
		
		try {
			URL url = new URL(path);
			InputStream is = url.openStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			
			int readNum = 0;
			while ((readNum = is.read(buffer)) != -1) {
				baos.write(buffer, 0, readNum);
			}
			
			// 此处省略解密过程
			// ......
			return baos.toByteArray();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String className2Path(String className) {
		return this.url + File.separator + className.replace(".", File.separator) + ".class";
	}
}
