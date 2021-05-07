package com.example.example01.sample02;

// 자바 reflection : 자바 클래스를 메모리에 로딩한 다음 개조
// @Setter 
public class Member {
	// 1. 인스턴스 초기화
	static int a = 10;
	static int b;
	
	// 2. 정적 초기화
	static {
		b = 30;
		System.out.println("정적 초기화");
	}
	
	// 3. 객체 생성
	public Member() {
		System.out.println("객체 생성");
	}
}
