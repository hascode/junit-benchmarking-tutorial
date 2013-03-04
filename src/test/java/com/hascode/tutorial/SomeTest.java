package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class SomeTest {
	ClassUnderTest classUnderTest = new ClassUnderTest();

	@Rule
	public BenchmarkRule benchmarkRun = new BenchmarkRule();

	@Test
	public void testSomething() throws Exception {
		assertTrue(classUnderTest.doTest());
	}

	@BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 4)
	@Test
	public void testSomethingWithWarmups() throws Exception {
		assertTrue(classUnderTest.doTest());
	}

	class ClassUnderTest {
		public boolean doTest() throws InterruptedException {
			for (int i = 0; i < 3000000; i++)
				new String("foo_" + i);

			Thread.sleep(500);
			return true;
		}
	}

}
