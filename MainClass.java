package transactionCheck;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {

	    private static int port = 8080;

	    public static void main(String[] args) {

	        try {
	            ServerSocket server = new ServerSocket(port);

	            System.out.println("Server Started.");

	            while (true)
	            {
	                System.out.println("Waiting for connection...");
	                Socket client = server.accept();
	                System.out.println("Connected with " + client.getRemoteSocketAddress());
	                Myserver eachClient = new  Myserver();
	                eachClient.start();
	            }


	        } catch (IOException e) {
	            System.out.println("Can't start server! error: " + e.getMessage());
	        }

	    }



	}



