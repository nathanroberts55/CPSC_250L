import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArrayListMethodsTest {

	@Test
	public void testDoReverseEmpty() {
		ArrayList<Integer> actual;
		ArrayList<Integer> expected;

		actual = new ArrayList<Integer>(Arrays.asList(new Integer[] {}));
		expected = new ArrayList<Integer>(Arrays.asList(new Integer[] {}));
		ArrayListMethods.doReverse(actual);
		assertEquals("Incorrect result", expected.size(), actual.size());

	}

	@Test
	public void testDoReverse1() {
		ArrayList<Integer> actual;
		ArrayList<Integer> expected;

		actual = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1 }));
		expected = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1 }));
		ArrayListMethods.doReverse(actual);
		assertEquals("Incorrect result", expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			Integer e = expected.get(i);
			Integer a = actual.get(i);
			assertEquals("Incorrect result", e, a);
		}

	}

	@Test
	public void testDoReverse2() {
		ArrayList<Integer> actual;
		ArrayList<Integer> expected;

		actual = new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 1 }));
		expected = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 0 }));
		ArrayListMethods.doReverse(actual);
		assertEquals("Incorrect result", expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			Integer e = expected.get(i);
			Integer a = actual.get(i);
			assertEquals("Incorrect result", e, a);
		}

	}

	@Test
	public void testDoReverseMany() {
		ArrayList<Integer> actual;
		ArrayList<Integer> expected;

		actual = new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 39, 36, 56, 82, 78, 49, 67, 92, 45 }));
		expected = new ArrayList<Integer>(Arrays.asList(new Integer[] { 45, 92, 67, 49, 78, 82, 56, 36, 39, 2 }));
		ArrayListMethods.doReverse(actual);
		assertEquals("Incorrect result", expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			Integer e = expected.get(i);
			Integer a = actual.get(i);
			assertEquals("Incorrect result", e, a);
		}

		actual = new ArrayList<Integer>(
				Arrays.asList(new Integer[] { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 }));
		expected = new ArrayList<Integer>(
				Arrays.asList(new Integer[] { 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10 }));
		ArrayListMethods.doReverse(actual);
		assertEquals("Incorrect result", expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			Integer e = expected.get(i);
			Integer a = actual.get(i);
			assertEquals("Incorrect result", e, a);
		}
	}

	@Test
	public void testGetUnionWithEmptyListFirst() {
		Integer[] uno = {};
		Integer[] dos = { 21, -2, 42 };
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(uno));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(dos));

		ArrayList<Integer> actual = ArrayListMethods.getUnion(one, two);

		assertEquals("The number of elements is incorrect", 3, actual.size());
		assertTrue("The value -2 was not found in the result", actual.contains(-2));
		assertTrue("The value 21 was not found in the result", actual.contains(21));
		assertTrue("The value 42 was not found in the result", actual.contains(42));
	}

	@Test
	public void testGetUnionWithEmptyListSecond() {
		Integer[] uno = { 35, 49 };
		Integer[] dos = {};
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(uno));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(dos));

		ArrayList<Integer> actual = ArrayListMethods.getUnion(one, two);

		assertEquals("The number of elements is incorrect", 2, actual.size());
		assertTrue("The value 35 was not found in the result", actual.contains(35));
		assertTrue("The value 49 was not found in the result", actual.contains(49));
	}

	@Test
	public void testGetUnionWithNoDuplicates() {
		Integer[] uno = { 81, 11, 7, -9 };
		Integer[] dos = { 17, -61 };
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(uno));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(dos));

		ArrayList<Integer> actual = ArrayListMethods.getUnion(one, two);

		assertEquals("The number of elements is incorrect", 6, actual.size());
		assertTrue("The value -61 was not found in the result", actual.contains(-61));
		assertTrue("The value -9 was not found in the result", actual.contains(-9));
		assertTrue("The value 7 was not found in the result", actual.contains(7));
		assertTrue("The value 11 was not found in the result", actual.contains(11));
		assertTrue("The value 17 was not found in the result", actual.contains(17));
		assertTrue("The value 81 was not found in the result", actual.contains(81));
	}

	@Test
	public void testGetUnionWithAllDuplicates() {
		Integer[] uno = { 2, 2 };
		Integer[] dos = { 2, 2 };
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(uno));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(dos));

		ArrayList<Integer> actual = ArrayListMethods.getUnion(one, two);

		assertEquals("The number of elements is incorrect", 1, actual.size());
		assertTrue("The value 2 was not found in the result", actual.contains(2));
	}

	@Test
	public void testGetUnionWithDuplicates() {
		Integer[] uno = { 34, 5, -29 };
		Integer[] dos = { -4, -29, 5, -4 };
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(uno));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(dos));

		ArrayList<Integer> actual = ArrayListMethods.getUnion(one, two);

		assertEquals("The number of elements is incorrect", 4, actual.size());
		assertTrue("The value -29 was not found in the result", actual.contains(-29));
		assertTrue("The value -4 was not found in the result", actual.contains(-4));
		assertTrue("The value 5 was not found in the result", actual.contains(5));
		assertTrue("The value 34 was not found in the result", actual.contains(34));
	}

	@Test
	public void testGetIntersectionWithEmptyListFirst() {
		Double[] eins = {};
		Double[] zwei = { 21.0, -2.6, 42.81 };
		ArrayList<Double> one = new ArrayList<Double>(Arrays.asList(eins));
		ArrayList<Double> two = new ArrayList<Double>(Arrays.asList(zwei));

		ArrayList<Double> actual = ArrayListMethods.getIntersection(one, two);

		assertEquals("The number of elements is incorrect", 0, actual.size());
	}

	@Test
	public void testGetIntersectionWithEmptyListSecond() {
		Double[] eins = { 35.1, 49.0 };
		Double[] zwei = {};
		ArrayList<Double> one = new ArrayList<Double>(Arrays.asList(eins));
		ArrayList<Double> two = new ArrayList<Double>(Arrays.asList(zwei));

		ArrayList<Double> actual = ArrayListMethods.getIntersection(one, two);

		assertEquals("The number of elements is incorrect", 0, actual.size());
	}

	@Test
	public void testGetIntersectionWithNoDuplicates() {
		Double[] eins = { 81.8, 11.11, 17.1, -9.0 };
		Double[] zwei = { 17.2, -61.9 };
		ArrayList<Double> one = new ArrayList<Double>(Arrays.asList(eins));
		ArrayList<Double> two = new ArrayList<Double>(Arrays.asList(zwei));

		ArrayList<Double> actual = ArrayListMethods.getIntersection(one, two);

		assertEquals("The number of elements is incorrect", 0, actual.size());
	}

	@Test
	public void testGetIntersectionWithDuplicates() {
		Double[] eins = { -29.2, 34.4, 5.0, -29.2 };
		Double[] zwei = { -4.4, -29.2, 5.0, -4.4, -29.2 };
		ArrayList<Double> one = new ArrayList<Double>(Arrays.asList(eins));
		ArrayList<Double> two = new ArrayList<Double>(Arrays.asList(zwei));

		ArrayList<Double> actual = ArrayListMethods.getIntersection(one, two);

		assertEquals("The number of elements is incorrect", 2, actual.size());
		assertTrue("The value -29.2 was not found in the result", actual.contains(-29.2));
		assertTrue("The value 5.0 was not found in the result", actual.contains(5.0));
	}

	@Test
	public void testGetDifferenceWithEmptyListFirst() {
		String[] un = {};
		String[] duex = { "yoda", "qui-gon" };
		ArrayList<String> one = new ArrayList<String>(Arrays.asList(un));
		ArrayList<String> two = new ArrayList<String>(Arrays.asList(duex));

		ArrayList<String> actual = ArrayListMethods.getDifference(one, two);

		assertEquals("The number of elements is incorrect", 2, actual.size());
		assertTrue("The value \"yoda\" was not found in the result", actual.contains("yoda"));
		assertTrue("The value \"qui-gon\" was not found in the result", actual.contains("qui-gon"));
	}

	@Test
	public void testGetDifferenceWithEmptyListSecond() {
		String[] un = { "luke", "leah", "han" };
		String[] duex = {};
		ArrayList<String> one = new ArrayList<String>(Arrays.asList(un));
		ArrayList<String> two = new ArrayList<String>(Arrays.asList(duex));

		ArrayList<String> actual = ArrayListMethods.getDifference(one, two);

		assertEquals("The number of elements is incorrect", 3, actual.size());
		assertTrue("The value \"luke\" was not found in the result", actual.contains("luke"));
		assertTrue("The value \"leah\" was not found in the result", actual.contains("leah"));
		assertTrue("The value \"han\" was not found in the result", actual.contains("han"));
	}

	@Test
	public void testGetDifferenceWithNoOverlap() {
		String[] un = { "obi-wan", "jar-jar", "anakin" };
		String[] duex = { "r2-d2", "c-3po" };
		ArrayList<String> one = new ArrayList<String>(Arrays.asList(un));
		ArrayList<String> two = new ArrayList<String>(Arrays.asList(duex));

		ArrayList<String> actual = ArrayListMethods.getDifference(one, two);

		assertEquals("The number of elements is incorrect", 5, actual.size());
		assertTrue("The value \"obi-wan\" was not found in the result", actual.contains("obi-wan"));
		assertTrue("The value \"jar-jar\" was not found in the result", actual.contains("jar-jar"));
		assertTrue("The value \"anakin\" was not found in the result", actual.contains("anakin"));
		assertTrue("The value \"r2-d2\" was not found in the result", actual.contains("r2-d2"));
		assertTrue("The value \"c-3po\" was not found in the result", actual.contains("c-3po"));
	}

	@Test
	public void testGetDifferenceWithOverlapAndDuplicates() {
		String[] un = { "palpatine", "dooku", "vader", "sidius" };
		String[] duex = { "padme", "vader", "sidius", "ackbar", "padme" };
		ArrayList<String> one = new ArrayList<String>(Arrays.asList(un));
		ArrayList<String> two = new ArrayList<String>(Arrays.asList(duex));

		ArrayList<String> actual = ArrayListMethods.getDifference(one, two);

		assertEquals("The number of elements is incorrect", 4, actual.size());
		assertTrue("The value \"ackbar\" was not found in the result", actual.contains("ackbar"));
		assertTrue("The value \"dooku\" was not found in the result", actual.contains("dooku"));
		assertTrue("The value \"padme\" was not found in the result", actual.contains("padme"));
		assertTrue("The value \"palpatine\" was not found in the result", actual.contains("palpatine"));
	}
}
