package socket.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8090);

			while (true) {
				Socket client = server.accept();
				invoke(client);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void invoke(Socket client) {
		InvokeThread thread = new InvokeThread(client);
		new Thread(thread).start();
	}
}
