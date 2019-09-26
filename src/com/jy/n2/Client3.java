package com.jy.n2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {

	public static void main(String[] args) {
		//Id 입력
		//pw 입력
		//서버로 전송
		//
		
		Socket sc;
		try {
			sc = new Socket("211.238.142.45",8282);
		
			Scanner ssc = new Scanner(System.in);
			System.out.println("Id 입력 ");
			String i = ssc.next();
			System.out.println("Pw 입력 ");
			String p = ssc.next();
			
			String ip = i+","+p;
			
			OutputStream os = sc.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(ow);
			bw.write(ip);
			bw.flush();
			
			
			System.out.println(ip);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
