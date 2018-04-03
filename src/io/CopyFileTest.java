package io;

public class CopyFileTest {

	public static void main(String[] args) {
		String resourceFile = "D:/neno/input.txt";
		String targetFile = "D:/neno/output.txt";
		
		FileIOUtils.copyFile(targetFile, resourceFile);
	}

}
