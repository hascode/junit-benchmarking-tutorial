package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "benchmark-lists")
public class GraphicOutputTests {
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
