package com.jy.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// ServerSocket
		// Socket

		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;

		Scanner ssc = new Scanner(System.in);
		try {
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비중");
			sc = ss.accept(); // 1대1 통신

			boolean check = true;
			while (check) {
				is = sc.getInputStream(); // byte 처리
				ir = new InputStreamReader(is); // char 처리
				br = new BufferedReader(ir); // String 처리
				String str = br.readLine();

				if (str.equals("stop") || str.equals("null")) {
					check = false;
					break;
				}
				System.out.println(str);

				System.out.println("클라이언트로 전송할 메시지 입력");
				str = ssc.next();
				sc.getOutputStream();
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(str + "\r\n");
				bw.flush();

				if (str.equals("stop") || str.equals("null")) {
					check = false;
					break;
				}
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
