import java.util.ArrayList;

public class Party {

	private ArrayList<Person> invited = new ArrayList<Person>();
	private ArrayList<Person> yes = new ArrayList<Person>();
	private ArrayList<Person> no = new ArrayList<Person>();

	public void addInvited(Person p) {
		if (!(invited.contains(p))) {
			invited.add(p.copy());
		}
	}

	public ArrayList<Person> getInvited() {
		ArrayList<Person> invitedCopy = new ArrayList<Person>();

		for (int i = 0; i < invited.size(); i++) {
			Person thisGuy = new Person(invited.get(i).getName());
			invitedCopy.add(thisGuy);
		}

		return invitedCopy;
	}

	public void addRSVP(Person p, boolean accepted) {
		if (invited.contains(p) && accepted == true && !yes.contains(p)) {
			yes.add(p.copy());

			// while(no.contains(p)) {
			// no.remove(p);
			// }
		}

		if (invited.contains(p) && accepted == false && !no.contains(p)) {
			no.add(p.copy());

			// while(yes.contains(p)) {
			// yes.remove(p);
			// }
		}
	}

	public ArrayList<Person> getRSVP(boolean accepted) {
		ArrayList<Person> correctList = new ArrayList<Person>();

		if (accepted == true) {
			for (int i = 0; i < yes.size(); i++) {
				Person thisGuy = new Person(yes.get(i).getName());
				correctList.add(thisGuy);
			}
		} else {
			for (int i = 0; i < no.size(); i++) {

				Person thisGuy = new Person(no.get(i).getName());
				correctList.add(thisGuy);
			}
		}

		return correctList;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Party)) {
			return false;
		}

		Party newParty = (Party) o;

		if (this.yes.equals(newParty.getRSVP(true)) && this.no.equals(newParty.getRSVP(false))
				&& this.invited.equals(newParty.getInvited())) {
			return true;
		}

		return false;
	}

}
