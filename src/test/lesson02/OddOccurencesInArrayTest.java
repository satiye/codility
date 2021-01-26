package test.lesson02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.lesson02.OddOccurrencesInArray;

public class OddOccurencesInArrayTest {
	private OddOccurrencesInArray solution;
	
	@BeforeEach
	void setUp() throws Exception {
		solution = new OddOccurrencesInArray();
	}

	 @ParameterizedTest(name = "{index} => A={0}, expectedInteger={1}")
	 @MethodSource("dataProvider")
	 void testSolution(int [] A, int expectedInteger) {
		 assertEquals(solution.solution(A), expectedInteger);
		 
	 }

	 private static Stream<Arguments> dataProvider() {
	     return Stream.of(
	           Arguments.of(new int [] { 9, 3, 9, 3, 9, 7, 9 },  7),
	           Arguments.of(new int [] { 1, 1, 9, 1, 1, 2, 2 },  9),
	           Arguments.of(new int [] { 1000000000, 1000000000, 1 },  1) //large numbers
	           
	      );
	 }
}
