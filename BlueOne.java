/**
 * 
 */
package february;

import java.util.HashMap;

/**
 *  @author Phoenix
 *
 **/
public class BlueOne {

	/** TODO learn more about StringBuilder and develop a (more) efficient
	*      algorithm to count occurrences of alphabetic characters in a 
	*		string and char array.
	*/  
	public static void main(String[] args) {
		
		String string = "abc6^defghijkabcdefghijkabcdeffaac%ceeddhijklseyd@hi*tabcd5ep&op6lle%ar$#the@ard";
		String s1 = "xxxaaa";
		String s2 = "yyysssaxxasx";
		char[] array = string.toCharArray();
		s1.
		System.out.println(s3);
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(Character c : array) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
		
	}

}
