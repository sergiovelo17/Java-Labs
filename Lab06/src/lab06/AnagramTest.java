package lab06;

public class AnagramTest{
	public static void main(String args[]) {
		System.out.println(AnagramUtil.sort("Velikopoljski"));
		System.out.println(AnagramUtil.sort(""));
		System.out.println(AnagramUtil.areAnagrams("Sergio", "Velikopoljski"));
		System.out.println(AnagramUtil.areAnagrams("racecar", "carreca"));
		String[] s1 = {"joy","ski","fed","cat"};
		String[] s2 = {"racecar","wow","oww","carrace","raaccer","ccerraa"};
		String[] s3 = AnagramUtil.getLargestAnagramGroup(s2);
		AnagramUtil.stringTo(s3);
		String[] s4 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		AnagramUtil.stringTo(s4);
	}
}