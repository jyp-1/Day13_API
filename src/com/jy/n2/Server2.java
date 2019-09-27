package com.jy.n2;

import java.net.ServerSocket;
import java.net.Socket;

import com.jy.n2.food.MenuMaker;
import com.jy.n2.network.Network;


public class Server2 {

	public static void main(String[] args) {
		Network network = new Network();
		MenuMaker m = new MenuMaker();

		// 점심메뉴 한개 가져오기

		m.init(); // 호출을 하기 위해서

		try {
			ServerSocket ss = new ServerSocket(8282);
			Socket sc = ss.accept();

			String select = network.receive(sc);

			String menu = m.selectMenu(select);

			network.send(sc, menu);

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
