package com.patrickstar.simple;

import org.junit.Test;

public class SimpleTest {
	@Test
	public void getThisClassName() {
		String className = this.getClass().getSimpleName();
		System.out.println(className);
	}
}
