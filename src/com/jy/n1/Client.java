package com.jy.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// 1 단계

		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);

		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {
			sc = new Socket("211.238.142.45", 8282);
			boolean check = true;

			while (check) {
				System.out.println("서버로 전송할 메세지 입력");
				String str = ssc.next();
				os = sc.getOutputStream(); // byte
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(str + "\r\n");
				bw.flush();

				if (str.equals("stop") || str.equals("null")) {
					break;
				}

				System.out.println("서버로 전송 완료");
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				str = br.readLine();
				if (str.equals("stop") || str.equals("null")) {
					break;
				}

				System.out.println(str);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
