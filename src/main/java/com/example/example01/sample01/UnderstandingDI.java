package com.example.example01.sample01;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Member {
	String name;
	String nickname;
}
public class UnderstandingDI {
	// 앱을 개발하기 위해 Member가 필요하다면
	
	public static void test1() {
		// 개발자가 필요한 객체가 뭔지 알고 직접 new한다  ->  결합도가 높다
		Member m1 = new Member();
	}
	
	public static void test2(Member member) {
		// 앱 외부에서 member가 만들어진 다음 세터로 넣어줬다 -> 의존 주입(Dependency Injection, DI)
		System.out.println(member);
	}
}
