package lab06;

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
}