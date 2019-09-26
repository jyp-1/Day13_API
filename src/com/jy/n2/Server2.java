package com.jy.n2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.jy.n2.food.MenuMaker;

public class Server2 {

	public static void main(String[] args) {

		// 점심메뉴 한개 가져오기

		MenuMaker m = new MenuMaker();
		m.init();
		String menu = m.selectMenu("1");
		System.out.println(menu);

	}

}
