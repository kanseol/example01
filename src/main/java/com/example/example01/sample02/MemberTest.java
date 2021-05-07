package com.example.example01.sample02;

public class MemberTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.example.example01.sample02.Member");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
