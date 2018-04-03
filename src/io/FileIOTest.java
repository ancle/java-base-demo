package io;

public class FileIOTest {

	public static void main(String[] args) {
		String filePath = "D:/neno/fileIO.txt";
		String content = "Java IO 学习测试";
		
		writeFile(filePath, content);
		
		String result = readFile(filePath);
		System.out.println("读取内容： " + result);
		
	}

	public static String readFile(String filePath) {
		System.out.println("准备执行读操作：");
		return FileIOUtils.readFile(filePath);
	}
	
	public static void writeFile(String filePath, String content) {
		System.out.println("准备执行写操作：");
		FileIOUtils.writeFile(filePath, content);
	}
}
