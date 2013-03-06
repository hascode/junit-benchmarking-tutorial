package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.Clock;

@BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5, callgc = false, clock = Clock.REAL_TIME, concurrency = 4)
public class BenchmarkOptionsExample {
	ClassUnderTest classUnderTest = new ClassUnderTest();

	@Rule
	public BenchmarkRule benchmarkRun = new BenchmarkRule();

	@Test
	public void testSomething() throws Exception {
		assertTrue(classUnderTest.doTest());
	}

	@BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 4)
	@Test
	public void testSomethingWithAnotherSetup() throws Exception {
		assertTrue(classUnderTest.doTest());
	}
}
