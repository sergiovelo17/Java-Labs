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
	}
}
