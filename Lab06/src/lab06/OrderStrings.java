package lab06;

import java.util.Comparator;

class OrderStrings implements Comparator<String>{
	 public int compare(String a, String b) 
	    { 
		 return a.compareTo(b);
	    } 
}