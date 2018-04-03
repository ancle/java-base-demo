package classloade;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String rootDir1 = "D:/workspace/TestPro/bin";
		String rootDir2 = "D:/test";
		
		FileClassLoader loader1 = new FileClassLoader(rootDir1);
		FileClassLoader loader2 = new FileClassLoader(rootDir1);
		
		String className = "classloade.test.DemoObj";
		
		Class<?> load1 = loader1.loadClass(className);
		Class<?> load2 = loader2.loadClass(className);
		
		System.out.println("load1.hashCode:" + load1.hashCode() + " || load2.hashCode:" + load2.hashCode());
		
		Class<?> class1 = loader1.findClass(className);
		Class<?> class2 = loader2.findClass(className);
		
		System.out.println("class1.hashCode : " + class1.hashCode() + " || class2.hashCode:" + class2.hashCode());
		/*System.out.println("class2.hashCode : " + class2.hashCode() + " || value:" + class2.newInstance().toString());*/
		
	}

}
