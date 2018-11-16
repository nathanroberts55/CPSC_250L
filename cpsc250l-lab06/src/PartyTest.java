import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class PartyTest {
	private static String ALEKS_SYNTEK = "Aleks Syntek";
	private static String ALEX_LORA = "Alex Lora";
	private static String BELINDA = "Belinda";
	private static String DAVID_BISBAL = "David Bisbal";
	private static String ENRIQUE_IGLESIAS = "Enrique Iglesias";
	private static String FRANCO_DE_VITA = "Franco de Vita";
	private static String GLORIA_ESTEFAN = "Gloria Estefan";
	private static String JESSE = "Jesse";
	private static String KANY_GARCIA = "Kany Garcia";
	private static String LAURA_PAUSINI = "Laura Pausini";
	private static String LU = "Lu";
	private static String LUIS_MIGUEL = "Luis Miguel";
	private static String MANA = "Mana";
	private static String MIGUEL_RIOS = "Miguel Rios";
	private static String NATALIA_LAFOURCADE = "Natalia LaFourcade";
	private static String PATXI_ANDION = "Patxi Andion";
	
	@Rule
	public Timeout globalTimeout= new Timeout(2, TimeUnit.SECONDS);
	
	@Test
	public void testReflection() {
		Class<?> cls = Party.class;
		Field[] fields = cls.getDeclaredFields();

		for (Field f : fields) {
			if (!f.isSynthetic()) {
				assertTrue("Field \"" + f.getName() + "\" should be private", Modifier.isPrivate(f.getModifiers()));
				assertFalse("Field \"" + f.getName() + "\" can't be static", Modifier.isStatic(f.getModifiers()));
			}
		}

		Method[] methods = cls.getDeclaredMethods();
		Class<?>[] params = null;
		Class<?> returnType = null;
		
		for (Method m : methods) {
			if (!m.isSynthetic()) {
				switch (m.getName()) {
				case "Party":
					params = new Class<?>[] {};
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					break;
				case "addInvited":
					params = new Class<?>[] {Person.class};
					returnType = void.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "addRSVP":
					params = new Class<?>[] {Person.class, boolean.class};
					returnType = void.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "getInvited":
					params = new Class<?>[] {};
					returnType = ArrayList.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "getRSVP":
					params = new Class<?>[] {boolean.class};
					returnType = ArrayList.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "equals":
					params = new Class<?>[] {Object.class};
					returnType = boolean.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				default:
					assertTrue("Method \"" + m.getName() + "\" must be private", Modifier.isPrivate(m.getModifiers()));
				}
			}
		}
	}

	@Test
	public void testPartyIsNotAPerson() {
		Object object = new Party();
		assertFalse("Incorrect result", object instanceof Person);
	}

	@Test
	public void testAddInvitedListIsEmpty() {
		Party party = new Party();
		ArrayList<Person> list = party.getInvited();
		assertEquals("Incorrect result", 0, list.size());
	}

	@Test
	public void testAddInvitedWith2Invited() {
		Party party = new Party();
		Person a = new Person(new String(ALEKS_SYNTEK));
		Person b = new Person(new String(DAVID_BISBAL));

		Person a1 = new Person(new String(ALEKS_SYNTEK));
		Person b1 = new Person(new String(DAVID_BISBAL));

		party.addInvited(a);
		party.addInvited(b);

		ArrayList<Person> list = party.getInvited();
		assertEquals("Invite not added correctly", 2, list.size());
		assertTrue("Invite not added correctly", list.contains(a1));
		assertTrue("Invite not added correctly", list.contains(b1));
	}

	@Test
	public void testAddInvitedWithDuplicatedNames() {
		Party party = new Party();
		Person a = new Person(new String(ALEX_LORA));
		Person b = new Person(new String(ENRIQUE_IGLESIAS));
		Person c = new Person(new String(ALEX_LORA));

		Person a1 = new Person(new String(ALEX_LORA));
		Person b1 = new Person(new String(ENRIQUE_IGLESIAS));

		party.addInvited(a);
		party.addInvited(b);
		party.addInvited(c);

		ArrayList<Person> list = party.getInvited();
		assertEquals("Invite not added correctly", 2, list.size());
		assertTrue("Invite not added correctly", list.contains(a1));
		assertTrue("Invite not added correctly", list.contains(b1));
	}

	@Test
	public void testGetInvitedListIsACopy() {
		Party party = new Party();
		Person a = new Person(new String(GLORIA_ESTEFAN));
		Person b = new Person(new String(FRANCO_DE_VITA));

		Person a1 = new Person(new String(GLORIA_ESTEFAN));
		Person b1 = new Person(new String(FRANCO_DE_VITA));

		party.addInvited(a);
		party.addInvited(b);

		ArrayList<Person> list = party.getInvited();
		assertEquals("Invite not added correctly", 2, list.size());
		assertTrue("Invite not added correctly", list.contains(a1));
		assertTrue("Invite not added correctly", list.contains(b1));

		list.clear();

		list = party.getInvited();
		assertEquals("getInvited does not return copy of list", 2, list.size());
		assertTrue("getInvited does not return copy of list", list.contains(a1));
		assertTrue("getInvited does not return copy of list", list.contains(b1));
	}

	@Test
	public void testAddInvitedModifyNamesAfterAdded() {
		Party party = new Party();
		Person a = new Person(new String(KANY_GARCIA));
		Person b = new Person(new String(LAURA_PAUSINI));

		Person a1 = new Person(new String(KANY_GARCIA));
		Person b1 = new Person(new String(LAURA_PAUSINI));

		party.addInvited(a);
		party.addInvited(b);

		a.setName(new String(LUIS_MIGUEL));
		b.setName(new String(LU));

		ArrayList<Person> list;

		list = party.getInvited();
		assertEquals("Invite not added correctly", 2, list.size());
		assertTrue("addInvited does not add copy of Person to list", list.contains(a1));
		assertTrue("addInvited result", list.contains(b1));
	}

	@Test
	public void testGetInvitedModifyNamesReturned() {
		Party party = new Party();
		Person a = new Person(new String(KANY_GARCIA));
		Person b = new Person(new String(LAURA_PAUSINI));

		party.addInvited(a);
		party.addInvited(b);

		ArrayList<Person> list = party.getInvited();
		assertEquals(2, list.size());
		for (Person p : list) {
			p.setName(new String(MIGUEL_RIOS));
		}

		list = party.getInvited();
		assertEquals("Invite not added correctly", 2, list.size());
		assertTrue("getInvited does not return copy of Person to list", list.contains(a));
		assertTrue("getInvited does not return copy of Person to list", list.contains(b));
	}

	@Test
	public void testGetInvitedSorted() {
		Party party = new Party();
		Person a = new Person(new String(LAURA_PAUSINI));
		Person b = new Person(new String(BELINDA));
		Person c = new Person(new String(KANY_GARCIA));
		Person d = new Person(new String(JESSE));

		party.addInvited(a);
		party.addInvited(b);
		party.addInvited(c);
		party.addInvited(d);

		ArrayList<Person> list = party.getInvited();
		assertEquals("Invite not added correctly", 4, list.size());

		Collections.sort(list);

		assertEquals("List should be sortable using Person.compareTo", 0, list.indexOf(b));
		assertEquals("List should be sortable using Person.compareTo", 1, list.indexOf(d));
		assertEquals("List should be sortable using Person.compareTo", 2, list.indexOf(c));
		assertEquals("List should be sortable using Person.compareTo", 3, list.indexOf(a));
	}

	@Test
	public void testGetRSVPAddingInvitedAndNotInvited() {
		// RSVP Yes
		Party party = new Party();
		Person a = new Person(new String(NATALIA_LAFOURCADE));
		Person b = new Person(new String(MANA));
		Person c = new Person(new String(PATXI_ANDION));

		party.addInvited(a);
		party.addInvited(b);

		party.addRSVP(b, true);
		party.addRSVP(c, true);

		ArrayList<Person> list = party.getRSVP(true);
		assertEquals("Person not invited cannot RSVP", 1, list.size());
		assertTrue("Only person invited can RSVP", list.contains(b));

		list = party.getRSVP(false);
		assertEquals("RSVP yes should not RSVP no", 0, list.size());

		// RSVP No
		party = new Party();
		a = new Person(new String(NATALIA_LAFOURCADE));
		b = new Person(new String(MANA));
		c = new Person(new String(PATXI_ANDION));

		party.addInvited(a);
		party.addInvited(b);

		party.addRSVP(b, false);
		party.addRSVP(c, false);

		list = party.getRSVP(false);
		assertEquals("Person not invited cannot RSVP", 1, list.size());
		assertTrue("Only person invited can RSVP", list.contains(b));

		list = party.getRSVP(true);
		assertEquals("RSVP no should not RSVP yes", 0, list.size());
	}

	@Test
	public void testGetRSVPAddingRSVPTwice() {
		// RSVP Yes
		Party party = new Party();
		Person a = new Person(new String(KANY_GARCIA));
		Person b = new Person(new String(LAURA_PAUSINI));

		party.addInvited(a);
		party.addInvited(b);

		party.addRSVP(a, true);
		party.addRSVP(a, true);

		ArrayList<Person> list = party.getRSVP(true);
		assertEquals("Person cannot RSVP yes twice", 1, list.size());

		list = party.getRSVP(false);
		assertEquals("RSVP yes should not RSVP no", 0, list.size());

		// RSVP No
		party = new Party();
		a = new Person(new String(KANY_GARCIA));
		b = new Person(new String(LAURA_PAUSINI));

		party.addInvited(a);
		party.addInvited(b);

		party.addRSVP(a, false);
		party.addRSVP(a, false);

		list = party.getRSVP(false);
		assertEquals("Person cannot RSVP no twice", 1, list.size());

		list = party.getRSVP(true);
		assertEquals("RSVP no should not RSVP yes", 0, list.size());
	}

	@Test
	public void testGetRSVPListIsACopy() {
		// RSVP yes
		Party party = new Party();
		Person a = new Person(new String(GLORIA_ESTEFAN));
		Person b = new Person(new String(FRANCO_DE_VITA));

		party.addInvited(a);
		party.addInvited(b);

		party.addRSVP(a, true);

		ArrayList<Person> list;

		list = party.getRSVP(true);
		assertEquals("RSVP not added correctly", 1, list.size());
		assertTrue("RSVP not added correctly", list.contains(a));

		list.clear();

		list = party.getRSVP(true);
		assertEquals("getRSVP does return a copy of the list", 1, list.size());
		assertTrue("getRSVP does return a copy of the list", list.contains(a));

		// RSVP no
		party = new Party();
		a = new Person(new String(GLORIA_ESTEFAN));
		b = new Person(new String(FRANCO_DE_VITA));

		party.addInvited(a);
		party.addInvited(b);

		party.addRSVP(a, false);

		list = party.getRSVP(false);
		assertEquals("RSVP not added correctly", 1, list.size());
		assertTrue("RSVP not added correctly", list.contains(a));

		list.clear();

		list = party.getRSVP(false);
		assertEquals("getRSVP does return a copy of the list", 1, list.size());
		assertTrue("getRSVP does return a copy of the list", list.contains(a));
	}

	@Test
	public void testAddRSVPModifyNamesAfterAdded() {
		// RSVP yes
		Party party = new Party();
		Person a1 = new Person(new String(KANY_GARCIA));
		Person a2 = new Person(new String(KANY_GARCIA));

		party.addInvited(a1);
		party.addRSVP(a1, true);

		a1.setName(new String(LUIS_MIGUEL));

		ArrayList<Person> list = party.getRSVP(true);
		assertEquals("RSVP not added correctly", 1, list.size());
		assertTrue("addRSVP does not add copy of Person to list", list.contains(a2));

		// RSVP no
		party = new Party();
		a1 = new Person(new String(KANY_GARCIA));
		a2 = new Person(new String(KANY_GARCIA));

		party.addInvited(a1);
		party.addRSVP(a1, false);

		a1.setName(new String(LUIS_MIGUEL));

		list = party.getRSVP(false);
		assertEquals("RSVP not added correctly", 1, list.size());
		assertTrue("addRSVP does not add copy of Person to list", list.contains(a2));
	}

	@Test
	public void testGetRSVPModifyNamesReturned() {
		// RSVP yes
		Party party = new Party();
		Person a = new Person(new String(KANY_GARCIA));

		party.addInvited(a);
		party.addRSVP(a, true);

		ArrayList<Person> list;

		list = party.getRSVP(true);
		assertEquals("RSVP not added correctly", 1, list.size());
		for (Person p : list) {
			p.setName(new String(MIGUEL_RIOS));
		}

		list = party.getRSVP(true);
		assertEquals("RSVP not added correctly", 1, list.size());
		assertTrue("getRSVP does not return deep copy of Persons in list", list.contains(a));

		// RSVP No
		party = new Party();
		a = new Person(new String(KANY_GARCIA));

		party.addInvited(a);
		party.addRSVP(a, false);

		list = party.getRSVP(false);
		assertEquals("RSVP not added correctly", 1, list.size());
		for (Person p : list) {
			p.setName(new String(MIGUEL_RIOS));
		}

		list = party.getRSVP(false);
		assertEquals("RSVP not added correctly", 1, list.size());
		assertTrue("getRSVP does not return deep copy of Persons in list", list.contains(a));

	}

	@Test
	public void testRSVPYesAndNo() {
		Party party = new Party();
		Person a = new Person(ALEKS_SYNTEK);
		Person b = new Person(ALEX_LORA);
		Person c = new Person(BELINDA);
		Person d = new Person(DAVID_BISBAL);
		Person e = new Person(ENRIQUE_IGLESIAS);

		party.addInvited(a);
		party.addInvited(b);
		party.addInvited(c);
		party.addInvited(d);
		party.addInvited(e);

		party.addRSVP(a, true);
		party.addRSVP(b, true);
		party.addRSVP(c, false);
		party.addRSVP(d, false);

		ArrayList<Person> list;
		list = party.getRSVP(true);
		assertEquals("RSVP yes not added correctly", 2, list.size());
		assertTrue("RSVP yes not added correctly", list.contains(a));
		assertTrue("RSVP yes not added correctly", list.contains(b));

		list = party.getRSVP(false);
		assertEquals("RSVP no not added correctly", 2, list.size());
		assertTrue("RSVP no not added correctly", list.contains(c));
		assertTrue("RSVP no not added correctly", list.contains(d));
	}

	@Test
	public void testRSVPYesAndNoSwitch() {
		Party party = new Party();
		Person a = new Person(ALEKS_SYNTEK);
		Person b = new Person(ALEX_LORA);
		Person c = new Person(BELINDA);
		Person d = new Person(DAVID_BISBAL);
		Person e = new Person(ENRIQUE_IGLESIAS);

		party.addInvited(a);
		party.addInvited(b);
		party.addInvited(c);
		party.addInvited(d);
		party.addInvited(e);

		// intial RSVP
		party.addRSVP(a, true);
		party.addRSVP(b, true);
		party.addRSVP(c, false);

		// final RSVP
		party.addRSVP(d, false);
		party.addRSVP(a, false);
		party.addRSVP(b, false);
		party.addRSVP(c, true);

		ArrayList<Person> list;
		list = party.getRSVP(true);
		assertEquals("RSVP yes not switched correctly", 1, list.size());
		assertTrue("RSVP yes not switched correctly", list.contains(c));

		list = party.getRSVP(false);
		assertEquals("RSVP no not switched correctly", 3, list.size());
		assertTrue("RSVP no not switched correctly", list.contains(a));
		assertTrue("RSVP no not switched correctly", list.contains(b));
		assertTrue("RSVP no not added correctly", list.contains(d));
	}

	@Test
	public void testEqualsNoRSVP() {

		Party party1 = new Party();
		Party party2 = new Party();

		// party is equal to itself
		assertTrue("Party is equal to itself", party1.equals(party1));

		// party is equal to equivalent
		assertTrue("Party is equal to equivalent party, no invited", party1.equals(party2));

		Person a = new Person(new String(GLORIA_ESTEFAN));
		Person b = new Person(new String(FRANCO_DE_VITA));
		Person c = new Person(new String(GLORIA_ESTEFAN));
		Person d = new Person(new String(FRANCO_DE_VITA));

		party1.addInvited(a);
		party1.addInvited(b);
		party2.addInvited(d);
		party2.addInvited(c);

		assertTrue("Party is equal to equivalent party, 2 invited", party1.equals(party2));

	}

	@Test
	public void testNotEqualsNoRSVP() {

		Party party1 = new Party();
		Party party2 = new Party();

		// party not equal to null
		assertFalse("Party no equal to null", party1.equals(null));

		// party not equal to other object
		assertFalse("Party no equal to other object", party1.equals(PATXI_ANDION));

		// party with invited is not equal to party without invited

		Person a = new Person(new String(GLORIA_ESTEFAN));
		Person b = new Person(new String(FRANCO_DE_VITA));

		party1.addInvited(a);
		party1.addInvited(b);

		assertFalse("Party not equal to different party", party1.equals(party2));

		// party not equal to another parter with fewer invitees
		party2.addInvited(a);
		assertFalse("Party not equal to different party", party1.equals(party2));

		// party not equal to another party with different invitees
		party2 = new Party();

		Person c = new Person(new String(NATALIA_LAFOURCADE));
		Person d = new Person(new String(PATXI_ANDION));
		party2.addInvited(c);
		party2.addInvited(d);

		assertFalse("Party not equal to different party", party1.equals(party2));

	}

	@Test
	public void testEqualsRSVP() {
		Party party1 = new Party();
		Party party2 = new Party();

		Person a = new Person(ALEKS_SYNTEK);
		Person b = new Person(ALEX_LORA);
		Person c = new Person(BELINDA);
		Person d = new Person(DAVID_BISBAL);
		Person e = new Person(ENRIQUE_IGLESIAS);

		party1.addInvited(a);
		party1.addInvited(b);
		party1.addInvited(c);
		party1.addInvited(d);
		party1.addInvited(e);

		party1.addRSVP(a, true);
		party1.addRSVP(b, true);
		party1.addRSVP(c, false);
		party1.addRSVP(d, false);

		party2.addInvited(c);
		party2.addInvited(d);
		party2.addInvited(a);
		party2.addInvited(b);
		party2.addInvited(e);

		party2.addRSVP(b, true);
		party2.addRSVP(a, true);
		party2.addRSVP(d, false);
		party2.addRSVP(c, false);

		assertTrue("Party is equal to equivalent party with RSVP", party1.equals(party2));

	}

	@Test
	public void testNotEqualsRSVP() {
		Party party1 = new Party();
		Party party2 = new Party();

		Person a = new Person(ALEKS_SYNTEK);
		Person b = new Person(ALEX_LORA);
		Person c = new Person(BELINDA);
		Person d = new Person(DAVID_BISBAL);
		Person e = new Person(ENRIQUE_IGLESIAS);

		party1.addInvited(a);
		party1.addInvited(b);
		party1.addInvited(c);
		party1.addInvited(d);
		party1.addInvited(e);

		party2.addInvited(c);
		party2.addInvited(d);
		party2.addInvited(a);
		party2.addInvited(b);
		party2.addInvited(e);

		party1.addRSVP(a, true);
		party1.addRSVP(b, true);
		party1.addRSVP(c, false);
		party1.addRSVP(d, false);

		party2.addRSVP(e, true);
		party2.addRSVP(d, true);
		party2.addRSVP(c, false);
		party2.addRSVP(b, false);

		assertFalse("Party is not equal to party with different RSVP", party1.equals(party2));

	}

}
