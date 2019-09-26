package com.jy.n2.food;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MenuMaker {

	private ArrayList<String> lunchs;
	private ArrayList<String> dinners;								//<- 현재는 null값

	public String selectMenu(String select) {
		Random random = new Random();
		String menu = null;
		if (select.equals("1")) {									//값을 한개씩 빼는 코드 
			menu = lunchs.get(random.nextInt(lunchs.size()));		//호출을 먼저 해야 lunchs 값이 null이 되지 않는다.
		} else {													// server2에서 호출 후에 실행시켜야 한다.
			menu = dinners.get(random.nextInt(dinners.size()));
		}

		return menu;
	}

	public void init() {										//호출하는 코드 
		this.lunchs = this.makeMenu("lunch.txt", "-");
		this.dinners = this.makeMenu("dinner.txt", ",");
	}

	private ArrayList<String> makeMenu(String fileName, String delim) { // 메서드 만들기

		File file = new File("c:\\test", fileName); // 파일가져오기
		//System.out.println(file.exists()); // 파일이 있는지 확인
		FileReader fileReader = null;
		BufferedReader br = null;
		boolean check = true;
		ArrayList<String> ar = new ArrayList<String>(); // 데이터 하나씩 넣어주기

		try {
			fileReader = new FileReader(file); // 파일 읽어주기
			br = new BufferedReader(fileReader); // 보조

			while (check) { // 한줄만 읽는건 아니기 때문에 null일때까지 반복
				String str = br.readLine(); // 한줄 읽어왔음
				if (str == null) {
					break;
				}

				StringTokenizer st = new StringTokenizer(str, delim); // 파싱
				while (st.hasMoreTokens()) { // 데이터가 더 있다면
					ar.add(st.nextToken().trim()); // arrylist에 있는 데이터 계속 추가
				}

			} // 바깥 while

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar;
	}

}
