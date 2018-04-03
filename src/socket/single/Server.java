package socket.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket client = server.accept();

		BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter pw = new PrintWriter(client.getOutputStream());

		while (true) {
			String readMsg = bf.readLine();
			System.out.println("---Server : " + readMsg);
			if (readMsg != null && readMsg.equals("88")) {
				break;
			}

			pw.write("server reply : " + readMsg);
			pw.flush();
		}

		pw.close();
		bf.close();
		client.close();
	}
}
