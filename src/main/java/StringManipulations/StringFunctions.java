package StringManipulations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class StringFunctions {
	/*
	 * Check if string is palindrome or not -- Done Reverse a string without
	 * recursion - Done Finding a substring in a String with best space and time
	 * complexity. Find the next number containing the digits in a given
	 * string.(Both repeating and non repeating version) Reverse a string in
	 * batches of k characters each. Check whether a string is anagram of
	 * another string Find permutations of a string Find all the possible words
	 * from a given string given a dictionary(a list or set with all possible
	 * meaningful words). 1) Reverse a String with or wiithout recursion
	 * 
	 * 2) check if string is palindrome
	 * 
	 * 3) How to count occurrence of word in String Array Solution:- refer this
	 * link How to count occurrence of word in String Array
	 * 
	 * 4) Java program to compute all permutation of String Solution:- refer
	 * this link Java program to compute all permutation of String
	 * 
	 * 5) How to determine if String has all unique characters Solution:- refer
	 * this link How to determine if String has all unique characters
	 * 
	 * 6) Java Program to Find Lexicographically Smallest and Largest substring
	 * of Length K Solution:- Java Program to Find Lexicographically Smallest
	 * and Largest substring of Length K
	 * 
	 * 7) Check if String is Null or Empty
	 * 
	 * 8) Java program to break the string after certain length
	 * 
	 * A linked list is used to represent a string. Determine whether it's a
	 * palindrome or not, in O(n) time.
	 * 
	 * Given two strings, determine if they are anagrams.
	 * 
	 * Given two strings, a and b, determine if a is a rotation of b.
	 * 
	 * 
	 * 
	 */
	public static void main(String[] str) {
		
		System.out.println("All string can be made of in sequence ABC \n :" + getAnyPermutations( "ABC"));
		//System.out.println("All string can be made of in sequence ABCD \n :" + getAnyPermutations( "ABCD"));
/*		System.out.println("All string can be made of in sequence ABCDE \n :" + getAnyPermutations("ABCDE"));
		
		System.out.println("");
		System.out.println("All string can be made of in sequence ABC \n :" + getAnyPermutations("", "ABC"));
		System.out.println("All string can be made of in sequence ABCD \n :" + getAnyPermutations("", "ABCD"));
		System.out.println("All string can be made of in sequence ABCDE \n :" + getAnyPermutations("", "ABCDE"));
		
		
		System.out.println("All String can be made of ABC : " + getAllPermutations("ABC"));
		System.out.println("All String can be made of ABCD : " + getAllPermutations("ABCD"));
		System.out.println("All String can be made of ABCDEF : " + getAllPermutations("ABCDEF"));

		System.out.println("Count of AAB in AABAABB : " + countOfWordInAnString("AAB", "AABAABB"));
		System.out.println("Count of AA in AABAAABB : " + countOfWordInAnString("AA", "AABAAABB"));
		System.out.println("Count of A in AABAAABB : " + countOfWordInAnString("A", "AABAAABB"));

		System.out.println("Baba Baba Black Sheep : " + checkPalindrome("Baba Baba Black Sheep"));

		System.out.println("ABCDEDCBA : " + checkPalindrome("ABCDEDCBA"));
		System.out.println("ABCDEEDCBA : " + checkPalindrome("ABCDEEDCBA"));

		System.out.println("Blue is the sky" + " : reverseWords : " + reverseWords("Blue is the sky", false));

		System.out.println("Blue  is the     sky and     ..it goes black    sometimes." + " : \n reverseWords : "
				+ reverseWords("Blue  is the     sky and     ..it goes black    sometimes.", true));
		System.out.println("Blue  is the     sky and     ..it goes black    sometimes." + " : \n reverseWords : "
				+ reverseWords("Blue  is the     sky and     ..it goes black    sometimes.", false));
*/	}

	public static Set<String> getAnyPermutations(String s,String strInput) {
		Set<String> resultSet = new HashSet<>();
 		char[] inp = strInput.toCharArray();
		for(int i=0; i<inp.length; i++){
			String temp =s+String.valueOf(inp[i]);
			resultSet.add(temp);
			if(i+1<=inp.length)
				resultSet.addAll(getAnyPermutations(temp, String.valueOf(Arrays.copyOfRange(inp, i+1, inp.length))));
		}
		return resultSet; 
	}
	
	
	public static Set<String> getAnyPermutations(String strInput) {
	    Set<String> resultSet = new HashSet<>();
	    char[] inp = strInput.toCharArray();

	    for (int bitMask = 0; bitMask < (1 << inp.length); bitMask++) {
	        StringBuilder str = new StringBuilder();
	        for (int i = 0; i < inp.length; i++) {
	        	System.out.println("(1 << "+i+")) : " + (1 << i));
	        	System.out.println("("+bitMask+" & (1 << "+i+")) : " + (bitMask & (1 << i)));
	        	System.out.println(""); 
	            if ((bitMask & (1 << i)) != 0) {
	                str.append(inp[i]);
	            }
	        }

	        if (str.length() > 0) {
	            resultSet.add(str.toString());
	        }
	    }

	    return resultSet;
	}

	// Returns all possible strings in sequence
	public static Set<String> getAllPermutations(String strInput) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < strInput.length(); i++) {
			set.add(String.valueOf(strInput.charAt(i)));
			String temp = String.valueOf(strInput.charAt(i));
			for (int j = i + 1; j < strInput.length(); j++) {
				temp += String.valueOf(strInput.charAt(j));
				set.add(temp);

			}
		}
		return set;
	}

	public static int countOfWordInAnString(String word, String stringPassed) {
		int count = 0;
		char[] toArr = word.toCharArray();
		for (int x = 0; x < stringPassed.length(); x++) {
			count++;
			for (int i = 0; i < toArr.length; i++) {
				if (x + 1 > stringPassed.length() || toArr[i] != stringPassed.charAt(x + i)) {
					count--;
					break;
				}
			}
		}
		return count;
	}

	public static boolean checkPalindrome(String strToCheck) {
		for (int i = strToCheck.length() - 1, j = 0; i > j; i--, j++) {
			if (strToCheck.charAt(i) != strToCheck.charAt(j))
				return false;
		}
		return true;
	}

	// Reverse the words, e.g "Blue is the sky" returns "Sky the is Blue"
	public static String reverseWords(String str, boolean keepSpaces) {
		if (keepSpaces) {
			char spaceChar = ' ';
			str = " " + str;
			char[] charAr = str.toCharArray();
			StringBuilder builder = new StringBuilder();
			for (int i = charAr.length - 1; i >= 0; i--) {
				if ((charAr[i] == spaceChar)) {
					for (int y = i + 1; (y < charAr.length && charAr[y] != ' '); y++)
						builder.append(charAr[y]);
					builder.append(charAr[i]);
				}
			}
			return builder.toString().trim();
		}
		String[] strSplit = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int x = strSplit.length - 1; x >= 0; x--) {
			if (!strSplit[x].equals(" ") && !strSplit[x].equals("")) {
				builder.append(strSplit[x]);
				builder.append(" ");
			}
		}
		return builder.toString().trim();
	}

	public void findSubstrings(String subStr) {

	}
}
