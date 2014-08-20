package ht3;

import java.util.Scanner;

public class HashFunction3{
	WordList [] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public String[][] elementsToAdd = {
   		{ "ace", "Very good" },
	    { "act", "Take action" },
        { "add", "Join (something) to something else" },
        { "age", "Grow old" },
        { "ago", "Before the present" },
        { "aid", "Help, assist, or support" },
        { "aim", "Point or direct" },
        { "air", "Invisible gaseous substance" },
        { "all", "Used to refer to the whole quantity" },
        { "amp", "Unit of measure for the strength of an electrical current" },
        { "and", "Used to connect words" }, { "ant", "A small insect" },
        { "any", "Used to refer to one or some of a thing" },
        { "ape", "A large primate" },
        { "apt", "Appropriate or suitable in the circumstances" },
        { "arc", "A part of the circumference of a curve" },
        { "are", "Unit of measure, equal to 100 square meters" },
        { "ark", "The ship built by Noah" },
        { "arm", "Two upper limbs of the human body" },
	    { "art", "Expression or application of human creative skill" },
	    { "ash", "Powdery residue left after the burning" },
        { "ask", "Say something in order to obtain information" },
        { "asp", "Small southern European viper" },
	    { "ass", "Hoofed mammal" },
        { "ate", "To put (food) into the mouth and swallow it" },
        { "atm", "Unit of pressure" },
        { "awe", "A feeling of reverential respect" },
        { "axe", "Edge tool with a heavy bladed head" },
        { "aye", "An affirmative answer" } };
	
	public int hashString(String sourceWord){
		int hashKeyValue = 0;
		for (int i=0; i<sourceWord.length();i++){
			int charCode = sourceWord.charAt(i) - 96;
			int temp = hashKeyValue;
		    hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;
		    System.out.println("Hash Key Value " + temp + " * 27 +  CharCode " + charCode + " % arraySize " + arraySize + "= " + hashKeyValue);
		}
	System.out.println();
	return hashKeyValue;
	}

	HashFunction3(int size){
		arraySize = size;
		theArray = new WordList[size];
		for (int i = 0; i < arraySize; i++){
			theArray[i] = new WordList();
			
		}
		addTheArray(elementsToAdd);
	}
	
	public void insert(Word newWord){
		
		String sourceWord = newWord.theWord;
		int hashKey = hashString(sourceWord);
		
		theArray[hashKey].insert(newWord, hashKey);
	}
	
	public void addTheArray(String[][] elementsToAdd){
		for(int i=0; i<elementsToAdd.length; i++){
			String word = elementsToAdd[i][0];
			String definition = elementsToAdd[i][1];
			
			Word newWord = new Word(word, definition);
			
			insert(newWord);
		}
	}
	
	public Word find(String wordToFind){
		
		int hashKey = hashString(wordToFind);
		Word theWord = theArray[hashKey].find(hashKey, wordToFind);
		
		return theWord;
	}
	
	public void displayTheArray(){
		for(int i = 0; i < arraySize; i++){
			System.out.println("theArray Index: " + i);
			theArray[i].displayWordList();
		}
	}


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
	
	public Word firstWord = null;
	
	public void insert(Word newWord, int hashKey){
		Word previous = null;
		Word current = firstWord;
		
		newWord.Key = hashKey;
		
		while(current != null && newWord.Key > current.Key){
			previous = current;
			current = current.next;
			}
		
		if(previous == null){
			firstWord = newWord;
		}
		else
			previous.next = newWord;
	    	newWord.next = current;
		
	}
	
	public void displayWordList(){
		Word current = firstWord;
		while (current != null){
			System.out.println(current);
			current = current.next;
		}
	}
	
	public Word find(int hashKey, String wordToFind){
		Word current = firstWord;
		while(current != null && current.Key <= hashKey){
			if(current.theWord.equals(wordToFind)){
				return current;
			}
			current = current.next;
			
		}
	return null;
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		HashFunction3 wordHashTable = new HashFunction3(11);
		
		String wordLookUp = "a";
		
		while(!wordLookUp.equalsIgnoreCase("x")){
			System.out.println(": ");
			
			wordLookUp = input.nextLine();
			
			System.out.println(wordHashTable.find(wordLookUp));
		}
		
		wordHashTable.displayTheArray();
		
	
	}

	
}