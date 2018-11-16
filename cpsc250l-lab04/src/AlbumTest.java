import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class AlbumTest {
	@Rule
	public Timeout globalTimeout = new Timeout(10, TimeUnit.SECONDS);

	@Test
	public void testReflection() {
		Class<?> cClass = Album.class;
		Field[] cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue("Field \"" + f.getName() + "\" should be private", Modifier.isPrivate(f.getModifiers()));
				assertFalse("Field \"" + f.getName() + "\" can't be static", Modifier.isStatic(f.getModifiers()));
			}
		}
	}

	@Test
	public void testCompareLessThan() {
		String band1 = "Bon Jovi";
		String album1 = "New Jersey";
		int runtime1 = 3462;
		Album thing1 = new Album(band1, album1, runtime1);

		String band2 = "Sesame Street";
		String album2 = "The Adventures of Elmo in Grouchland";
		int runtime2 = 2187;
		Album thing2 = new Album(band2, album2, runtime2);

		int actual = thing1.compareTo(thing2);

		assertTrue("compareTo returned >= 0 when it should return < 0", actual < 0);
	}

	@Test
	public void testCompareEqualTo() {
		String band1 = "Sesame Street";
		String album1 = "The Adventures of Elmo in Grouchland";
		int runtime1 = 2187;
		Album thing1 = new Album(band1, album1, runtime1);

		String band2 = "Sesame Street";
		String album2 = "The Adventures of Elmo in Grouchland";
		int runtime2 = 2187;
		Album thing2 = new Album(band2, album2, runtime2);

		int actual = thing1.compareTo(thing2);

		assertTrue("compareTo returned != 0 when it should return 0", actual == 0);
	}

	@Test
	public void testCompareGreaterThan() {
		String band1 = "Sesame Street";
		String album1 = "The Adventures of Elmo in Grouchland";
		int runtime1 = 2187;
		Album thing1 = new Album(band1, album1, runtime1);

		String band2 = "Sesame Street";
		String album2 = "Elmopalooza!";
		int runtime2 = 1883;
		Album thing2 = new Album(band2, album2, runtime2);

		int actual = thing1.compareTo(thing2);

		assertTrue("compareTo returned <= 0 when it should return > 0", actual > 0);
	}

	@Test
	public void testGetName() {
		String expected = "An album has no name.";
		Album noname = new Album(expected, "", 0);
		String actual = noname.getName();

		assertEquals("getName does not return the correct Album name.", expected, actual);
	}

	@Test
	public void testGetAuthor() {
		String expected = "A band has no name.";
		Album noname = new Album("", expected, 0);
		String actual = noname.getAuthor();

		assertEquals("getAuthor does not return the correct Album author.", expected, actual);
	}

	@Test
	public void testGetLength() {
		int expected = 1337;
		Album noname = new Album("", "", expected);
		int actual = noname.getLength();

		assertEquals("getLength does not return the correct Album length.", expected, actual);
	}
}
