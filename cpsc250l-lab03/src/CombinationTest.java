import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class CombinationTest {
	@Test
	public void testReflection() {
		Class<?> iClass  = Combination.class;
		Field[]  iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
	}

	@Test
	public void testGetNumbers() {
		Combination a        = new Combination( 7, 6, 1 );
		int[]       expected = { 7, 6, 1 };
		int[]       actual   = a.getNumbers();

		assertArrayEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testNumbersAreWithinRange() {
		Combination a = new Combination( 0, 9, 1 );
		assertTrue( "Incorrect result", a.isWithinRange( 9 ));
	}
	@Test
	public void testNumbersAreNotWithinRange() {
		Combination a = new Combination( 0, 5, -9 );
		assertFalse( "Incorrect result", a.isWithinRange( 20 ));

		Combination b = new Combination( -1, 1, 2 );
		assertFalse( "Incorrect result", b.isWithinRange( 3 ));

		Combination c = new Combination( 2, 99, 3 );
		assertFalse( "Incorrect result", c.isWithinRange( 3 ));
	}

}
