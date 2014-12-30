package ArraysNStrings;

import java.util.HashMap;

public class HashTable{
	public static HashMap<Integer, String> map(String[] student){
		HashMap<Integer, String> Class = new HashMap<Integer, String>();
		int i = 1;
		for(String s : student){
			Class.put(i, s);
			i++;
		} 
		return Class;	
	}
	
	public static void main(String[] args){
		String[] student = {"zhangsan", "lisi", "wangermazi"};
		for(int i = 1; i <= map(student).size(); i++){
			System.out.println(i + " " + map(student).get(i));
		}
	}

}
