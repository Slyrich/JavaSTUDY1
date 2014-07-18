package hastable;

import java.util.Scanner;

public class HashFunction3{
	WordList [] theArray;
	int arraySize;
	
	public int hashString(String sourceWord){
		int hashKeyValue = 0;
		for (int i=0; i<sourceWord.length();i++){
			int charCode = sourceWord.charAt(i) - 96;
			int temp = hashKeyValue;
		    hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;
		    System.out.println("Hash Key Value " + temp + " * 27" + " CharCode " + charCode + "= " + hashKeyValue);
		}
	System.out.println();
	return hashKeyValue;
	}
	
class Word {
	public String theWord;
	public String definition;
	public int Key;
	public Word next;
	
	public Word(String theWord, String definition){
		this.theWord = theWord;
		this.definition = definition;
		
	}
	
	public String toString(){
		return theWord + " : " + definition;
	}
}


class WordList{

}
}