package io.file;

import java.util.List;

public class FileTest {

	public static void main(String[] args) {
		String targetPath = "D:\\资料";
		List<String> files = FileUtils.listFile(targetPath);
		
		for (String filename : files) {
			System.out.println(filename);
		}
	}

}
