package com.jy.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MemberService {

	// init 메서드
	// 파일의 내용을 읽어서 파싱 작업

	// memberLogin 메서드
	// id pw를 매개변수로 받아서 로그인 유무를 검증

	public void memberLogin(String ip) {
		Member member = new Member();

		String[] c = ip.split(",");
		member.setId(c[0].trim());
		member.setPw(c[1].trim());
		
	}

	public ArrayList<String> init() {

		File file = new File("c:\\test", "member.txt");
		FileReader filereader = null;
		BufferedReader bf = null;
		boolean check = true;

		ArrayList<String> ar = new ArrayList<String>();

		try {
			filereader = new FileReader(file);
			bf = new BufferedReader(filereader);
			while (check) {
				String str = bf.readLine();
				if (str == null) {
					break;
				}

				StringTokenizer st = new StringTokenizer(str, ",");
				while (st.hasMoreTokens()) {
					ar.add(st.nextToken().trim());
				}
			} // 바깥 while문

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

}
