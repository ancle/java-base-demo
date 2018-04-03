package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOUtils {
	public static String readFile(String fullFileName) {
		FileInputStream fis = null;

		String result = "";

		try {
			// 根据指定的全路径文件名，生成FileInputStream对象
			fis = new FileInputStream(fullFileName);
			// 获取输入流中可以被读的剩下的bytes字节的估计值
			int size = fis.available();

			byte[] buffer = new byte[size];

			fis.read(buffer);

			result = new String(buffer);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public static void writeFile(String fullFileName, String content) {
		System.out.println("写入文件内容：" + content);
		
		FileOutputStream fos = null;

		try {
			// 根据写入文件的全路径名，生成FileOutputStream对象实例
			fos = new FileOutputStream(fullFileName);

			// 获取写入文件内容的字节数据
			byte[] buffer = content.getBytes();

			fos.write(buffer);

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
		}
	}

	public static void copyFile(String targetPath, String resourcePath) {
		String content = readFile(resourcePath);
		System.out.println("读取文件内容：" + content);
		writeFile(targetPath, content);
	}
}
