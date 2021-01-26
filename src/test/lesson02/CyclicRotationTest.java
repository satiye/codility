package test.lesson02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.lesson02.CyclicRotation;

public class CyclicRotationTest {
	private CyclicRotation solution;
	
	@BeforeEach
	void setUp() throws Exception {
		solution = new CyclicRotation();
	}

	 @ParameterizedTest(name = "{index} => A={0}, K={1}, expectedRotatedA={2}")
	 @MethodSource("dataProvider")
	 void testSolution(int [] A, int K, int [] expectedRotatedA) {
		 int [] actualRotatedA = solution.solution(A, K);
		 
		 assertEquals(actualRotatedA.length, expectedRotatedA.length);
		 for(int i=0; i<actualRotatedA.length; i++) {
			assertEquals(actualRotatedA[i], expectedRotatedA[i]);
		 }
	 }

	 private static Stream<Arguments> dataProvider() {
	     return Stream.of(
	           Arguments.of(new int [] { 3, 8, 9, 7, 6 },  3,  new int [] {  9, 7, 6, 3, 8 }),
	           Arguments.of(new int [] {       0, 0, 0 },  1,  new int [] {        0, 0, 0 }),
	           Arguments.of(new int [] {    1, 2, 3, 4 },  4,  new int [] {     1, 2, 3, 4 }),
	           Arguments.of(new int [] {               },  0,  new int [] {                }),
	           Arguments.of(new int [] {    1, 2, 3, 4 },  100,  new int [] {     1, 2, 3, 4 }) //K is greater than N
	      );
	 }
}
