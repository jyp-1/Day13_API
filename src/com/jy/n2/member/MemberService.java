package com.jy.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MemberService {
	private HashMap<String, Member> map;

	// init 메서드
	// 파일의 내용을 읽어서 파싱 작업

	//public static void main(String[] args) {
	//	MemberService ms = new MemberService();
	//	try {
	//		ms.init();
	//	} catch (Exception e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	//}

	public void init() throws Exception {
		this.map = new HashMap<String, Member>();

		File file = new File("c:\\test", "member.txt");
		FileReader filereader = new FileReader(file);
		BufferedReader bf = new BufferedReader(filereader);
		boolean check = true;

		while (check) {
			String str = bf.readLine();

			if (str == null) {
				break;
			}
			str.trim();
			StringTokenizer st = new StringTokenizer(str, ",");
			while (st.hasMoreTokens()) { // id와 pw 함께 자름 // 아래 정보들을 반복
				Member member = new Member(); // 정보가 들어있는 Member의 객체를 만들어준다.
				member.setId(st.nextToken()); // id //Member에 자른 정보를 아이디에 설정한다.
				member.setPw(st.nextToken()); // Member에 자른 정보를 페스워드에 설정한다.
				map.put(member.getId(), member);// pw //해쉬맵(정보를 모아주는것)에 집어넣는다

			}
		} // 바깥 while문

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String k = it.next();
			Member m = map.get(k);
			System.out.println(m.getId());
			System.out.println(m.getPw());

		}

	}

	// memberLogin 메서드
	// id pw를 매개변수로 받아서 로그인 유무를 검증
	// 로그인 실패 null
	public Member memberLogIn(Member member) {
		Member m = map.get(member.getId());
		if (m != null) {
			if (m.getPw().equals(member.getPw())) {
				// 둘다 맞음, 추가정보 대입
			} else {
				m = null; // id 는 맞지만 pw 는 틀림
			}
		}
		return m;
	}
}
