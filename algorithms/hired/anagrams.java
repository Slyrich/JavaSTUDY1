package hired;

public class anagrams {
    public static void check_anagrams(String[] firstWords, String[] secondWords) {

        

        for(int k = 0; k < firstWords.length; k++){
            String in1 = firstWords[k];
            String in2 = secondWords[k];
            char[] input1 = in1.toCharArray();
            char[] input2 = in2.toCharArray();
            int[] record = new int[256];
            
            if(input1.length != input2.length){ 
                System.out.println('0');
                return;// Write your code here
                }
            
        for(char c : input1){
            record[c]++;
        }
        
        for(char c :input2){
            if (record[c] == 0){
               System.out.println("0");
               return;
            }
            record[c]--;
        }
        
        System.out.println("1");
   
        }        
        // To print results to the standard output you can use System.out.println()
        // Example: System.out.println("Hello world!");
        
    }
	public static void main(String[] args){
	String[] firstWords = {"cinema", "host", "aba", "train"};
	String[] secondWords = {"iceman", "shot", "bab", "rain"};
	check_anagrams(firstWords, secondWords);
	}
}