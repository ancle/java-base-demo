package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleTest {

	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		
		int readNum = 0;
		
		InputStream input = null;
		OutputStream out = null;
		
		try {
			input = new FileInputStream("D:/neno/input.txt");
			out = new FileOutputStream("D:/neno/out.txt");
			
			while ((readNum = input.read(buffer)) != -1) {
				System.out.println(new String(buffer));
				out.write(buffer, 0, readNum);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
