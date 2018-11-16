import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayListMethods {

private static void noDuplicates(ArrayList<Integer> addingTo,ArrayList<Integer> iterateOver) {
    for(Integer num:iterateOver){
        if(addingTo.indexOf(num) == -1) {
            addingTo.add(num);
        }
    }
}
	
	public static void doReverse(ArrayList<Integer>anArrayList){
		Collections.reverse(anArrayList);
	}
	public static ArrayList<Integer> getUnion(ArrayList<Integer> list1, 
			ArrayList<Integer> list2){
		ArrayList<Integer> list3 = new ArrayList<Integer>(list1.size() + list2.size());
		noDuplicates(list3,list1);
		noDuplicates(list3,list2);
		if (!(list1.isEmpty())) {
			for (int i = 0; i < list1.size(); i++) {
				if (!(list3.contains(list1.get(i)))) {
					list3.add(list1.get(i));
				}
			}
		}
		if (!(list2.isEmpty())) {
			for (int i = 0; i < list2.size(); i++) {
				if (!(list3.contains(list2.get(i)))) {
					list3.add(list2.get(i));
				}
			}
		}
		return list3;
	}
	public static ArrayList<Double> getIntersection(
			ArrayList<Double> list1, ArrayList<Double> list2){
		ArrayList<Double> list3 = new ArrayList<Double> (list1.size() > list2.size() ?list1.size():list2.size());
		
		
		if (!(list1.isEmpty())) {
			for (int i = 0; i < list1.size(); i++) {
				if (list2.contains(list1.get(i))) {
					list3.add(list1.get(i));
				}
			}
		}
		
		
		Set<Double> list5 = new LinkedHashSet<>(list3);
		list3.clear();
		list3.addAll(list5);
		
		
		return list3;
		
	}
	public static ArrayList<String> getDifference(
			ArrayList<String> list1, ArrayList<String> list2){
		ArrayList<String> list3 = new ArrayList<String> (list1.size());
				
		
		if (!(list1.isEmpty())) {
			for (int i = 0; i < list1.size(); i++) {
				if (!(list2.contains(list1.get(i)))) {
					list3.add(list1.get(i));
				}
			}
		}
		if (!(list2.isEmpty())) {
			for (int i = 0; i < list2.size(); i++) {
				if (!(list1.contains(list2.get(i)))) {
					list3.add(list2.get(i));
				}
			}
		}
		
		Set<String> list5 = new LinkedHashSet<>(list3);
		list3.clear();
		list3.addAll(list5);
		
		
		return list3;
		
	}

}

