
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class QueueMethodsTest {

	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	private Candy get(String name) {
		switch (name) {
		case "BLUE_RASPBERRY":
			return new Candy("Blue Raspberry");
		case "CHOCOLATE":
			return new Candy("Chocolate");
		case "COLA":
			return new Candy("Cola");
		case "GRAPE":
			return new Candy("Grape");
		case "GREEN_APPLE":
			return new Candy("Green Apple");
		case "LEMON":
			return new Candy("Lemon");
		case "ORANGE":
			return new Candy("Orange");
		case "PEPPERMINT":
			return new Candy("Peppermint");
		case "RASPBERRY":
			return new Candy("Raspberry");
		case "WATERMELON":
			return new Candy("Sour Watermelon");
		case "CHERRY":
			return new Candy("Cherry");
		default:
			throw new IllegalArgumentException();
		}
	}

	private static final int MONDAY = 0;
	private static final int TUESDAY = 1;
	private static final int WEDNESDAY = 2;
	private static final int THURSDAY = 3;
	private static final int FRIDAY = 4;
	private static final int SATURDAY = 5;
	private static final int SUNDAY = 6;

	private class QueueTest extends Queue<Candy> {
		public QueueTest(Candy... candy) {
			for (Candy c : candy) {
				enqueue(c);
			}
		}
	}

	@Test
	public void testReflection() {
		Class<?> iClass = QueueMethods.class;
		Field[] iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail("Class shouldn't have any fields [found: \"" + f.getName() + "\"]");
			}
		}
	}

	@Test
	public void testGetCandyNoCandy() {
		Queue<Candy> dispenser = new QueueTest();
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, FRIDAY);
		assertNotNull("\"getCandy\" returned a null queue", actual);
		assertTrue("Incorrect result", actual.isEmpty());
	}

	@Test
	public void testGetCandyMonday() {
		Queue<Candy> dispenser = new QueueTest(get("LEMON"), get("GREEN_APPLE"), get("BLUE_RASPBERRY"), get("ORANGE"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, MONDAY);
		Candy[] expected = { get("LEMON"), get("GREEN_APPLE"), get("BLUE_RASPBERRY"), get("ORANGE") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetCandyTuesday() {
		Queue<Candy> dispenser = new QueueTest(get("CHOCOLATE"), get("COLA"), get("PEPPERMINT"), get("BLUE_RASPBERRY"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, TUESDAY);
		Candy[] expected = { get("CHOCOLATE"), get("PEPPERMINT"), get("COLA"), get("BLUE_RASPBERRY") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetCandyWednesday() {
		Queue<Candy> dispenser = new QueueTest(get("GRAPE"), get("ORANGE"), get("WATERMELON"), get("RASPBERRY"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, WEDNESDAY);
		Candy[] expected = { get("GRAPE"), get("RASPBERRY"), get("ORANGE"), get("WATERMELON") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetCandyThursday() {
		Queue<Candy> dispenser = new QueueTest(get("COLA"), get("RASPBERRY"), get("WATERMELON"), get("ORANGE"),
				get("GREEN_APPLE"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, THURSDAY);
		Candy[] expected = { get("COLA"), get("GREEN_APPLE"), get("RASPBERRY"), get("ORANGE"), get("WATERMELON") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetCandyFriday() {
		Queue<Candy> dispenser = new QueueTest(get("BLUE_RASPBERRY"), get("GREEN_APPLE"), get("COLA"),
				get("BLUE_RASPBERRY"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, FRIDAY);
		Candy[] expected = { get("BLUE_RASPBERRY"), get("COLA"), get("BLUE_RASPBERRY"), get("GREEN_APPLE") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetCandySaturday() {
		Queue<Candy> dispenser = new QueueTest(get("LEMON"), get("GRAPE"), get("PEPPERMINT"), get("CHOCOLATE"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, SATURDAY);
		Candy[] expected = { get("LEMON"), get("CHOCOLATE"), get("PEPPERMINT"), get("GRAPE") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetCandySunday() {
		Queue<Candy> dispenser = new QueueTest(get("WATERMELON"), get("ORANGE"), get("GREEN_APPLE"),
				get("BLUE_RASPBERRY"), get("COLA"));
		Queue<Candy> actual = QueueMethods.getCandyOrder(dispenser, SUNDAY);
		Candy[] expected = { get("WATERMELON"), get("BLUE_RASPBERRY"), get("COLA"), get("ORANGE"), get("GREEN_APPLE") };
		assertNotNull("\"getCandy\" returned a null queue", actual);
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = actual.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetRemainingCandyEmpty() {
		Queue<Candy> dispenser = new Queue<Candy>();

		QueueMethods.getRemainingCandy(dispenser, get("WATERMELON"));

		assertTrue(dispenser.isEmpty());

	}

	@Test
	public void testGetRemainingCandy1of1() {
		Queue<Candy> dispenser = new QueueTest(get("WATERMELON"));

		QueueMethods.getRemainingCandy(dispenser, get("WATERMELON"));

		assertTrue(dispenser.isEmpty());

	}

	@Test
	public void testGetRemainingCandy2of2() {
		Queue<Candy> dispenser = new QueueTest(get("BLUE_RASPBERRY"), get("BLUE_RASPBERRY"));

		QueueMethods.getRemainingCandy(dispenser, get("BLUE_RASPBERRY"));

		assertTrue(dispenser.isEmpty());

	}

	@Test
	public void testGetRemainingCandy0of1() {
		Queue<Candy> dispenser = new QueueTest(get("BLUE_RASPBERRY"));

		QueueMethods.getRemainingCandy(dispenser, get("ORANGE"));

		Candy[] expected = { get("BLUE_RASPBERRY") };
		for (Candy exp : expected) {
			if (dispenser.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = dispenser.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!dispenser.isEmpty()) {
			fail("result had unexpected additional data");
		}

	}

	@Test
	public void testGetRemainingCandy0of4() {
		Queue<Candy> dispenser = new QueueTest(get("BLUE_RASPBERRY"), get("ORANGE"), get("CHERRY"), get("GRAPE"));

		QueueMethods.getRemainingCandy(dispenser, get("PEPPERMINT"));

		Candy[] expected = { get("BLUE_RASPBERRY"), get("ORANGE"), get("CHERRY"), get("GRAPE") };
		for (Candy exp : expected) {
			if (dispenser.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = dispenser.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!dispenser.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetRemainingCandy2of4() {
		Queue<Candy> dispenser = new QueueTest(get("ORANGE"), get("ORANGE"), get("CHERRY"), get("GRAPE"));

		QueueMethods.getRemainingCandy(dispenser, get("ORANGE"));

		Candy[] expected = { get("CHERRY"), get("GRAPE") };
		for (Candy exp : expected) {
			if (dispenser.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = dispenser.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!dispenser.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

	@Test
	public void testGetRemainingCandy3of5() {
		Queue<Candy> dispenser = new QueueTest(get("CHERRY"), get("BLUE_RASPBERRY"), get("CHERRY"), get("ORANGE"),
				get("CHERRY"));

		QueueMethods.getRemainingCandy(dispenser, get("CHERRY"));

		Candy[] expected = { get("BLUE_RASPBERRY"), get("ORANGE") };
		for (Candy exp : expected) {
			if (dispenser.isEmpty()) {
				fail("expected " + exp + "but results ended prematurely");
			}
			Candy act = dispenser.dequeue();
			assertEquals("Incorrect result", exp, act);
		}
		if (!dispenser.isEmpty()) {
			fail("result had unexpected additional data");
		}
	}

}
