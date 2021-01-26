package test.lesson01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.lesson01.BinaryGap;

class BinaryGapTest {
	private BinaryGap solution;
	
	@BeforeEach
	void setUp() throws Exception {
		solution = new BinaryGap();
	}

	 @ParameterizedTest(name = "{index} => N={0}, expectedBinaryGap={1}")
	 @MethodSource("dataProvider")
	 void testSolution(int N, int expectedBinaryGap) {
		 assertEquals(solution.solution(N), expectedBinaryGap);
	 }

	 private static Stream<Arguments> dataProvider() {
	     return Stream.of(
	           Arguments.of(1041, 5),
	           Arguments.of(15, 0),
	           Arguments.of(32, 0),
	           Arguments.of(1, 0), //min
	           Arguments.of(2147483647, 0) //max
	      );
	 }
}