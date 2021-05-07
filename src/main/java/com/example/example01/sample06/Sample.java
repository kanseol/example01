package com.example.example01.sample06;

import lombok.extern.slf4j.*;

// slf4j : 로깅 표준. trace < debug < info < warn < error 순
@Slf4j
public class Sample {
	public void hello() {
		Log.info("까꿍");
	}
}
