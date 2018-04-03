package socket.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class InvokeThread implements Runnable {
	private Socket client;

	public InvokeThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		BufferedReader bf = null;
		PrintWriter pw = null;

		try {
			bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream());

			while (true) {
				String msg = bf.readLine();
				System.out.println("--- Server : " + msg);

				pw.write("--- Server reply : " + msg);
				pw.flush();

				if (null != msg && msg.equals("888")) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != pw) {
				pw.close();
			}

			if (null != bf) {
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (null != client) {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
