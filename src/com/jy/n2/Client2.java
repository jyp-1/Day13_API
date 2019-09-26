package com.jy.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client2 {

	public static void main(String[] args) {
		// 1. 점심메뉴
		// 2. 저녁메뉴

		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);
		InputStream is = null;
		InputStreamReader ir = null;
		boolean check = true;

		File file = new File("c:\\test", "lunch.txt");
		File file2 = new File("c:\\test", "dinner.txt");
		FileReader fr = null;
		BufferedReader bfr = null;

				

		try {
			sc = new Socket("211.238.142.45", 8282);

			while (check) {
				System.out.println("클라이언트 입니다");
				String str = ssc.next();
				
				try {
					Random random = new Random();
					ArrayList<String> ar = new ArrayList<String>();
					ArrayList<String> ar2 = new ArrayList<String>();
					while (check) {
						System.out.println("1. 점심메뉴");
						System.out.println("2. 저녁메뉴");
						int num = ssc.nextInt();

						switch (num) {
						case 1:
							fr = new FileReader(file);
							bfr = new BufferedReader(fr);
							str = bfr.readLine();

							StringTokenizer st = new StringTokenizer(str, "-");
							while (st.hasMoreTokens()) {
								String l = st.nextToken();
								ar = new ArrayList<String>();
								ar.add(l);
								int r = random.nextInt(ar.size());
								System.out.println(ar.get(r));

							}

							break;

						case 2:
							fr = new FileReader(file2);
							bfr = new BufferedReader(fr);
							str = bfr.readLine();
							st = new StringTokenizer(str, ",");
							while (st.hasMoreTokens()) {
								String d = st.nextToken();
								ar2 = new ArrayList<String>();
								ar2.add(d);
								int r = random.nextInt(ar2.size());
								System.out.println(ar2.get(r));
							}
							break;

						default:
						}
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

				
				
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(str + "\r\n");
				bw.flush();

				System.out.println("서버로 전송 완료");
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				bfr = new BufferedReader(ir);
				str = bfr.readLine();
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
