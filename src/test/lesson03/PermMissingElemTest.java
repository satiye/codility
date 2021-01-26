package test.lesson03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.lesson03.PermMissingElem;



public class PermMissingElemTest {
	private PermMissingElem solution;
	
	@BeforeEach
	void setUp() throws Exception {
		solution = new PermMissingElem();
	}

	 @ParameterizedTest(name = "{index} => A={0}, missingElement={1}")
	 @MethodSource("dataProvider")
	 void testSolution(int A[], int missingElement) {
		 assertEquals(solution.solution(A), missingElement);
		 
	 }

	 private static Stream<Arguments> dataProvider() {
	     return Stream.of(
	           Arguments.of(new int [] {}, 1 ),
	           Arguments.of(new int [] {2, 3, 1, 5 }, 4 ), 
	           Arguments.of(new int [] { 4, 2, 3, 1, 5, 6, 8, 7 }, 9) 
	      );
	 }
}