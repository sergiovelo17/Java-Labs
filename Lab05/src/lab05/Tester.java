package lab05;

public class Tester {

	public static void main(String[] args) {
		BinarySearchSet binarySet = new BinarySearchSet();
		
		if (binarySet.size() != 0)
		      System.err.println("TEST FAILED -- list should be empty");
		
		//System.out.println(binarySet.toString());
		binarySet.insert(2.0);
		binarySet.insert(34.0);
		binarySet.insert(19.0);
		binarySet.insert(11.0);
		
		if (binarySet.size() != 4 && binarySet.insert(11.0) != false)
		      System.err.println("TEST FAILED -- list should have four elements and not add another 11.0");

		binarySet.insert(14.5);
		binarySet.insert(14.0);
		binarySet.insert(20.0);
		binarySet.insert(13.0);
		binarySet.insert(18.0);
		
		if (binarySet.size() != 9 && binarySet.insert(12.0) != true)
		      System.err.println("TEST FAILED -- list should have nine elements and be able to add an additional value");
		
		System.out.println(binarySet.toString());
		//System.out.println(binarySet.toString());
		binarySet.clear();
		
		if (binarySet.size() != 0)
		      System.err.println("TEST FAILED -- list should have cleared all elements and have size of 0");
		
		System.out.println(binarySet.toString());
		
		double[] input = {12.0,45.2,12.1,9.4,21.0,12.0,15.6,1.0,31.1};
		BinarySearchSet assignmentSet = new BinarySearchSet(input);
		System.out.println(assignmentSet.toString());
		assignmentSet.remove(12.1);
		assignmentSet.remove(89.1);
		System.out.println(assignmentSet.toString());
		double[] containsThese = {9.0,31.2,54.3};
		double[] containsThose = {45.2,21.0,9.4};
		System.out.println(assignmentSet.contains(1.0));
		System.out.println(assignmentSet.containsAll(containsThese));
		System.out.println(assignmentSet.containsAll(containsThose));
	}
}
