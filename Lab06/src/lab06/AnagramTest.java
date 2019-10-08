package lab06;

public class AnagramTest{
	public static void main(String args[]) {
		System.out.println(AnagramUtil.sort("hello"));
		System.out.println(AnagramUtil.areAnagrams("hello", "HeoLL"));
		System.out.println(AnagramUtil.areAnagrams("hello", "whatsup"));
		String[] s1 = {"joy","ski","fed","cat"};
		AnagramUtil.insertionSort(s1);
	}
}