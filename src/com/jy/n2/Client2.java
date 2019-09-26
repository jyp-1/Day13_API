package com.jy.n2;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.jy.n2.network.Network;

public class Client2 {

	public static void main(String[] args) {
		// 1. 점심메뉴
		// 2. 저녁메뉴

		Scanner ssc = new Scanner(System.in);
		Network network = new Network();

		try {
			Socket sc = new Socket("211.238.142.45", 8282);
			// 자신의 컴퓨터 "127.0.0.1" 혹은 "localhost" 혹은 ##권장 -> ip주소
			System.out.println("1.점심메뉴");
			System.out.println("2.저녁메뉴");
			String select = ssc.next();

			network.send(sc, select);

			System.out.println(select);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
