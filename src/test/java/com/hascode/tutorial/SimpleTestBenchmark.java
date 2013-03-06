package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class SimpleTestBenchmark {
	ClassUnderTest classUnderTest = new ClassUnderTest();

	@Rule
	public BenchmarkRule benchmarkRun = new BenchmarkRule();

	@Test
	public void testSomething() throws Exception {
		assertTrue(classUnderTest.doTest());
	}
}
