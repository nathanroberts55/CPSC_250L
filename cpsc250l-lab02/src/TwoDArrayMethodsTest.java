import static org.junit.Assert.*;

import org.junit.Test;

public class TwoDArrayMethodsTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testArrayIsNull() {
		try{
			
			int[][] result = TwoDArrayMethods.transpose(null);
			assertTrue("Method should handle null", null == result);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testOneElementArray() {
		try{
			int[][] original = {{0}};
			int[][] array = {{0}};
			int[][] expected = {{0}};
			int[][] result = TwoDArrayMethods.transpose(array);
			
			assertArrayEquals("Transpose incorrect", expected, result);
			assertArrayEquals("Original array was altered", original, array);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testArrayIsSmallSquareArray() {
		try{
			int[][] original = {{1,2},{3,4}};
			int[][] array = {{1,2},{3,4}};
			int[][] expected = {{1,3},{2,4}};
			int[][] result = TwoDArrayMethods.transpose(array);
			
			assertArrayEquals("Transpose incorrect", expected, result);
			assertArrayEquals("Original array was altered", original, array);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testArrayIsLargeSquareArray() {
		try{
			int[][] original = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
			int[][] array = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
			int[][] expected = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};
			int[][] result = TwoDArrayMethods.transpose(array);
			
			assertArrayEquals("Transpose incorrect", expected, result);
			assertArrayEquals("Original array was altered", original, array);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testArrayIsSmallRectangularArray() {
		try{
			int[][] original = {{1,2,3}};
			int[][] array = {{1,2,3}};
			int[][] expected = {{1},{2},{3}};
			int[][] result = TwoDArrayMethods.transpose(array);
			
			assertArrayEquals("Transpose incorrect", expected, result);
			assertArrayEquals("Original array was altered", original, array);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testArrayIsLargeRectangularArray() {
		try{
			int[][] original = {{2,4},{6,8},{10,12},{14,16},{18,20}};
			int[][] array = {{2,4},{6,8},{10,12},{14,16},{18,20}};
			int[][] expected = {{2,6,10,14,18},{4,8,12,16,20}};
			int[][] result = TwoDArrayMethods.transpose(array);
			
			assertArrayEquals("Transpose incorrect", expected, result);
			assertArrayEquals("Original array was altered", original, array);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testArraySymmetricArray() {
		try{
			int[][] original = {{1,2,3},{2,1,0},{3,0,1}};
			int[][] array = {{1,2,3},{2,1,0},{3,0,1}};
			int[][] expected = {{1,2,3},{2,1,0},{3,0,1}};
			int[][] result = TwoDArrayMethods.transpose(array);
			
			assertArrayEquals("Transpose incorrect", expected, result);
			assertArrayEquals("Original array was altered", original, array);
			
		}
		catch(Exception e){
			fail("No exception should be thrown.");
		}
	}

}
