package lab06;

import java.util.ArrayList;

public class AnagramUtil{

	static OrderStrings order = new OrderStrings();
	
	public static String sort(String inputString) {
		if(inputString == null || inputString == "") {
			return null;
		}
		inputString = inputString.toLowerCase();
		char[] outArray = inputString.toCharArray();
		for(int i = 1; i < outArray.length; i++) {
			int j = i-1;
			char key = outArray[i];
			while(j >= 0 && outArray[j] >= key) {
				outArray[j+1] = outArray[j];
				j--;
			}
			outArray[j+1] = key;
		}
		return new String(outArray);
	}
	
	public static boolean areAnagrams(String string1, String string2) {
		if(AnagramUtil.sort(string1).compareTo(AnagramUtil.sort(string2)) == 0) {
			return true;
		}
		return false;
	}
	
	public static void insertionSort(String[] inputList) {
		for(int i = 0; i < inputList.length; i++) {
			int j = i-1;
			String key = inputList[i];
			while(j >= 0 && order.compare(AnagramUtil.sort(inputList[j]), AnagramUtil.sort(key)) > 0) {
				inputList[j+1] = inputList[j];
				j--;
			}
			inputList[j+1] = key;
		}
	}
	public static void stringTo(String[] inputList) {
		for(int i = 0; i < inputList.length; i++) {
			System.out.print(inputList[i]+ " ");
		}
		System.out.print("\n");
	}
	public static String[] getLargestAnagramGroup(String[] inputList) {
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> longest = new ArrayList<String>();
        String[] longestFinal = {}; 

		AnagramUtil.stringTo(inputList);
		AnagramUtil.insertionSort(inputList);
		AnagramUtil.stringTo(inputList);
	
		for(int i = 0; i < inputList.length; i++) {
			temp.add(inputList[i]);
			for(int j = i+1; j < inputList.length; j++) {
				if(AnagramUtil.areAnagrams(inputList[i], inputList[j])) {
				temp.add(inputList[j]);
				}
			}
			if(temp.size() > longestFinal.length) {
				longestFinal = temp.toArray(longestFinal);
			}
			temp.clear();
		}
		return longestFinal;
	}
}