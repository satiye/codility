package test.lesson03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.lesson03.FrogJmp;

public class FrogJmpTest {
	private FrogJmp solution;
	
	@BeforeEach
	void setUp() throws Exception {
		solution = new FrogJmp();
	}

	 @ParameterizedTest(name = "{index} => X={0}, Y={1}, D={2}, expectedJump={3}")
	 @MethodSource("dataProvider")
	 void testSolution(int X, int Y, int D, int expectedJump) {
		 assertEquals(solution.solution(X, Y, D), expectedJump);
		 
	 }

	 private static Stream<Arguments> dataProvider() {
	     return Stream.of(
	           Arguments.of(10, 85, 30, 3),
	           Arguments.of(10, 10, 5,  0), // no jump requires
	           Arguments.of(100000000, 1000000000, 10000000, 90) //large numbers
	      );
	 }
}