package classloade;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class FileUrlClassLoaderTest {

	public static void main(String[] args) throws MalformedURLException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String rootDir = "D:/workspace/TestPro/bin";
		
		File file = new File(rootDir);
		URI uri = file.toURI();
		URL[] urls = {uri.toURL()};
		
		FileUrlClassLoader urlClassLoader = new FileUrlClassLoader(urls);
		
		try {
			Class<?> clazz = urlClassLoader.loadClass("classloade.test.DemoObj");
			System.out.println(clazz.newInstance().toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
