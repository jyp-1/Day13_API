package com.jy.n2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.jy.n2.network.Network;

public class Client3 {

	public static void main(String[] args) {
		// Id 입력
		// pw 입력
		// 서버로 전송
		//

		Socket sc = null;
		Network network = new Network();
		Scanner ssc = new Scanner(System.in);
		System.out.println("Id 입력 ");
		String id = ssc.next();
		System.out.println("Pw 입력 ");
		String pw = ssc.next();

		String msg = id + "," + pw;

		try {
			sc = new Socket("211.238.142.45", 8282);
			network.send(sc, msg);
			msg = network.receive(sc);
			if (msg.equals("1")) {
				System.out.println(id + "님 환영합니다.");
			} else {
				System.out.println("로그인 실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
