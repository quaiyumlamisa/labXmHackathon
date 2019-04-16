package sertificate;

import java.net.*;  
import java.io.*; 

public class MyClient1
{
	public static void main(String args[])throws Exception{ 
		System.out.println("Welcome to IIT!!!!!");
		
		Socket s=new Socket("127.0.0.1",10000);  
		
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str1="",str2=""; 
		
		while(!str1.equals("stop")){  
			str1=br.readLine();  
			dout.writeUTF(str1);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Bank says: "+str2);  
		}  
		  
		dout.close();  
		s.close();  
		
		System.out.println("Thank you.");

		}
	} 
	

