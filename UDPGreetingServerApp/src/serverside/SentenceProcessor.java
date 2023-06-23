package serverside;

public class SentenceProcessor {
	
	private int size = 65535;
	
	private String sentence;
	
	
	public SentenceProcessor(byte[] byteData) {
		
		this.sentence = new String(byteData);
	}
	
	public String getSentence() {
		
		return sentence;
	}
	
	/**
	 * This method convert value into an array of byte
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {
		
		byte[] outData = new byte[size];
		
		String stringValue = Integer.valueOf(value).toString();
		
        outData = stringValue.getBytes();
        
        return outData;
	}
	
	/**
	 * This method count the number of characters in a sentence
	 * @return
	 */
	public int countCharacters() {
		
        int index = 0;
        char currentChar = sentence.charAt(index);
        while (currentChar != '\0') {
        	
        	currentChar = sentence.charAt(index++);
        }
        

        return index - 1;
	}
	
	/*
	 * This method count the number of vowels in a sentence
	 * @return
	 */
	public int countVowels() {
		
		int counter = 0;
		 
        // Convert the sentence to lowercase
        sentence = sentence.toLowerCase();

        for (int index = 0; index < sentence.length(); index++) {
        	
            char currentCharacter = sentence.charAt(index);

            // Check if the character is a vowel
            if (currentCharacter == 'a' || currentCharacter == 'e' ||
            		currentCharacter == 'i' || currentCharacter == 'o' || 
            		currentCharacter == 'u') {
            	counter ++;
            }
        }

        return counter;
	}
	
	/*
	 * This method count the number of consonants in a sentence
	 * @return
	 */
	public int countConsonants() {
		
		// Declare variable
		int counter = 0;
		
        // Convert the sentence to lowercase
        sentence = sentence.toLowerCase();

        // Loop through each character in the sentence
        for (int index = 0; index < sentence.length(); index++) {
        	
            char currentCharacter = sentence.charAt(index);

            // Check if the character is a letter
            if(currentCharacter >= 'a' && currentCharacter <= 'z') {
            	
            	// Check if the character is consonant
            	if (currentCharacter != 'a' && currentCharacter != 'e' &&
                		currentCharacter != 'i' && currentCharacter != 'o' && 
                		currentCharacter != 'u') {
            		
            		// Increment if currentCharacter is consonant
                	counter ++;
                }
            	
            }
        }

        return counter;
	}
	
	/*
	 * This method count the number of punctuations in a sentence
	 * @return
	 */
	public int countPunctuations() {
		
		// Declare variable
		int counter = 0;
		String punctuations = ".?!,:;-[]{}()`/\"'"; 
		boolean result = false;

        // Loop through each character in the sentence
        for (int index = 0; index < sentence.length(); index++) {
        	
            char currentCharacter = sentence.charAt(index);

            // Check if the character is a punctuation
            result = punctuations.contains(String.valueOf(currentCharacter));
            
            if(result) {
            	
            	// Increment if currentCharacter is consonant
            	counter ++;
            	
            }
        }

        return counter;
		
	}
}
