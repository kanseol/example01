package com.example.example01.sample06;

import java.sql.*;

import org.springframework.context.*;
import org.springframework.context.support.*;

import lombok.extern.slf4j.*;

// 스프링 MVC 프로젝트를 만들면 설정 xml 파일도 만들어지고 그곳에 설정을 잡으면 된다
// 연습용으로 스프링 수동으로 동작시켜보겠다

@Slf4j
public class DITest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/example/exampl01/sample06/bean.xml");
		
		// ctx에서 빈을 클래스로 검색(type) -> 같은 클래스의 객체가 하나만 있어야한다
		Date date = ctx.getBean(Date.class);
		Log.info("현재 시각: {}", date);
		
		// ctx에서 빈을 이름으로 검색(name)
		Sample sample = (Sample)ctx.getBean("sample");
		sample.hello();
	}
}
