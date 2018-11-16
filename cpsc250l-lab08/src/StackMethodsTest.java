import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

public class StackMethodsTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	private class StackTest extends Stack<Integer> {
		public StackTest(int[] values) {
			for (int i = values.length - 1; i > -1; i--) {
				push(values[i]);
			}
		}
	}

	@Test
	public void testReflection() {
		Class<?> iClass = StackMethods.class;
		Field[] iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail("Class shouldn't have any fields [found: \"" + f.getName() + "\"]");
			}
		}
	}

	@Test
	public void testGetEvenNumbersEmpty() {
		int[] input = new int[] {};
		Stack<Integer> stack = new StackTest(input);
		Stack<Integer> result = StackMethods.getEvenNumbers(stack);

		assertTrue("result should be empty", result.isEmpty());
		assertTrue("stack should be empty", stack.isEmpty());
		assertTrue("stack and result cannot be the same object", stack != result);
	}

	@Test
	public void testGetEvenNumbers1Odd() {
		int[] input = new int[] { 5 };
		Stack<Integer> stack = new StackTest(input);
		Stack<Integer> result = StackMethods.getEvenNumbers(stack);

		assertTrue("result should be empty", result.isEmpty());

		for (int expected : input) {
			if (stack.isEmpty())
				fail("\"stack\" empty: '" + expected + "' expected");
			else {
				int actual = stack.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		assertTrue("stack and result cannot be the same object", stack != result);
	}

	@Test
	public void testGetEvenNumbers1Even() {
		int[] input = new int[] { 4 };
		Stack<Integer> stack = new StackTest(input);
		Stack<Integer> result = StackMethods.getEvenNumbers(stack);

		for (int expected : new int[] { 4 }) {
			if (result.isEmpty())
				fail("\"result\" empty: '" + expected + "' expected");
			else {
				int actual = result.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		for (int expected : input) {
			if (stack.isEmpty())
				fail("\"stack\" empty: '" + expected + "' expected");
			else {
				int actual = stack.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		assertTrue("stack and result cannot be the same object", stack != result);
	}

	@Test
	public void testGetEvenNumbersNoneEven() {
		int[] input = new int[] { 9, 77, 3, 5, 11 };
		Stack<Integer> stack = new StackTest(input);
		Stack<Integer> result = StackMethods.getEvenNumbers(stack);

		assertTrue("result should be empty", result.isEmpty());

		for (int expected : input) {
			if (stack.isEmpty())
				fail("\"stack\" empty: '" + expected + "' expected");
			else {
				int actual = stack.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		assertTrue("stack and result cannot be the same object", stack != result);
	}

	@Test
	public void testGetEvenNumbersSomeEven() {
		int[] input = new int[] { 44, 77, 8, 3, 5, 12 };
		Stack<Integer> stack = new StackTest(input);
		Stack<Integer> result = StackMethods.getEvenNumbers(stack);

		for (int expected : new int[] { 44, 8, 12 }) {
			if (result.isEmpty())
				fail("\"result\" empty: '" + expected + "' expected");
			else {
				int actual = result.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		for (int expected : input) {
			if (stack.isEmpty())
				fail("\"stack\" empty: '" + expected + "' expected");
			else {
				int actual = stack.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		assertTrue("stack and result cannot be the same object", stack != result);
	}

	@Test
	public void testGetEvenNumbersAllEven() {
		int[] input = new int[] { 12, 22, 6, 14, 12 };
		Stack<Integer> stack = new StackTest(input);
		Stack<Integer> result = StackMethods.getEvenNumbers(stack);

		for (int expected : input) {
			if (result.isEmpty())
				fail("\"result\" empty: '" + expected + "' expected");
			else {
				int actual = result.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		for (int expected : input) {
			if (stack.isEmpty())
				fail("\"stack\" empty: '" + expected + "' expected");
			else {
				int actual = stack.pop();
				assertEquals("incorrect result", expected, actual);
			}
		}
		assertTrue("stack and result cannot be the same object", stack != result);
	}

	@Test
	public void testCheckParenthesesEmpty() {
		String s = "";

		assertTrue(StackMethods.checkParentheses(s));
	}

	@Test
	public void testCheckParenthesesOnePair() {
		String s1 = "( )";
		String s2 = "[ ]";
		String s3 = "{ }";

		assertTrue(StackMethods.checkParentheses(s1));
		assertTrue(StackMethods.checkParentheses(s2));
		assertTrue(StackMethods.checkParentheses(s3));
	}

	@Test
	public void testCheckParenthesesOnePairBad() {
		String s1 = "( ]";
		String s2 = "[ }";
		String s3 = "{ )";

		assertFalse(StackMethods.checkParentheses(s1));
		assertFalse(StackMethods.checkParentheses(s2));
		assertFalse(StackMethods.checkParentheses(s3));
	}

	@Test
	public void testCheckParenthesesTwoPair() {
		String s1 = "( ) ( )";
		String s2 = "[ [ ] ]";
		String s3 = "{ } { }";

		assertTrue(StackMethods.checkParentheses(s1));
		assertTrue(StackMethods.checkParentheses(s2));
		assertTrue(StackMethods.checkParentheses(s3));
	}

	@Test
	public void testCheckParenthesesTwoPairBad() {
		String s1 = "( } { )";
		String s2 = "[ [ } }";
		String s3 = "{ ) ( }";

		assertFalse(StackMethods.checkParentheses(s1));
		assertFalse(StackMethods.checkParentheses(s2));
		assertFalse(StackMethods.checkParentheses(s3));
	}

	@Test
	public void testCheckParenthesesMix() {
		String s1 = "((( { } )) [[ ]] )";
		String s2 = "[ ]{ }( )([{}])";
		String s3 = "(((((((((a+b)))))))))"; // ignore extra characters

		assertTrue(StackMethods.checkParentheses(s1));
		assertTrue(StackMethods.checkParentheses(s2));
		assertTrue(StackMethods.checkParentheses(s3));
	}

	@Test
	public void testCheckParenthesesMixBad() {
		String s1 = "((((( ))))";
		String s2 = "(()) {{}} [[[[[";
		String s3 = "]]}}))";

		assertFalse(StackMethods.checkParentheses(s1));
		assertFalse(StackMethods.checkParentheses(s2));
		assertFalse(StackMethods.checkParentheses(s3));
	}

	@Test
	public void testReverse1() throws IOException {

		String file = "output1.txt";
		File output = folder.newFile(file);

		Node<Integer> x = new Node<Integer>(2);
		x.next = null;

		StackMethods.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();

	}

	@Test
	public void testReverse3() throws IOException {
		String file = "output2.txt";
		File output = folder.newFile(file);

		Node<Integer> x = new Node<Integer>(2);
		x.next = new Node<Integer>(-3);
		x.next.next = new Node<Integer>(17);
		x.next.next.next = null;

		StackMethods.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "17", "-3", "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();
	}

	@Test
	public void testReverse4() throws IOException {
		String file = "output3.txt";
		File output = folder.newFile(file);

		Node<Integer> x = new Node<Integer>(2);
		x.next = new Node<Integer>(-3);
		x.next.next = new Node<Integer>(17);
		x.next.next.next = new Node<Integer>(0);
		x.next.next.next.next = null;

		StackMethods.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "0", "17", "-3", "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();
	}

	@Test
	public void testReverse5() throws IOException {
		String filename = "output4.txt";
		File output = folder.newFile(filename);

		Node<Integer> x = new Node<Integer>(2);
		x.next = new Node<Integer>(-3);
		x.next.next = new Node<Integer>(17);
		x.next.next.next = new Node<Integer>(0);
		x.next.next.next.next = new Node<Integer>(27);
		x.next.next.next.next.next = null;

		StackMethods.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "27", "0", "17", "-3", "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();
	}
}
