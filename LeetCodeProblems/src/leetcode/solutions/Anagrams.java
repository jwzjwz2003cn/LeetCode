package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams implements ISolution {

	/**
	 * for each str
	 * 1. convert to charArray and sort
	 * 2. add to HashMap<K,V> where K is sorted String from charArray and V is List<String>
	 * 3. do the same for all the strings
	 * 4. combine all the hashmap solutions to one list
	 * @param strs
	 * @return
	 */
	public List<String> anagrams(String[] strs){
		
		List<String> retList = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str: strs){
			char[] cArray = str.toCharArray();
			Arrays.sort(cArray);
			String sortedStr = String.valueOf(cArray);
			if (map.containsKey(sortedStr)){
				map.get(sortedStr).add(str);
			} else {
				List<String> newList = new ArrayList<String>();
				newList.add(str);
				map.put(sortedStr,newList);
			}
		}
		for (Entry<String, List<String>> e: map.entrySet()){
			if (e.getValue().size() > 1)
				retList.addAll(e.getValue());
		}
		return retList;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		String[] strs = {"cca", "aca", "cac", "bab", "abb"};
		System.out.println(anagrams(strs));
		
	}
}
