package com.huwl.oracle.filter;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestRandom {

	@Test
	public void test() {
		System.out.println(new Random().nextInt(20)+20);
	}

}
