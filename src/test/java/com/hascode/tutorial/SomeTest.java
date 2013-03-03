package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class SomeTest {
	@Rule
	public BenchmarkRule benchmarkRun = new BenchmarkRule();

	@Test
	public void testSomething() throws Exception {
		Thread.sleep(200);
		assertTrue(!false);
	}

	@BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
	@Test
	public void testSomethingOther() throws Exception {
		Thread.sleep(20);
		assertTrue(!false);
	}

}
