package com.sotofit.Ifraud.test;

import org.springframework.stereotype.Component;

@Component
public class Trainer implements Coatch {

	@Override
	public String learnBoxing() {
		return "Learning Boxing";
	}
}
