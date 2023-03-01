package cse360hw1task2;
//import java.util.Scanner;

/* Task 2 - Decryption of Vigenère cipher
 * @author Alireza Farhangi
 */
public class Task2 {
	public static void main(String[] args) {
		/*
		Scanner scan = new Scanner(System.in);
		// decryption testing by getting input from the user
		System.out.println("Please enter a ciphertext:");
		String TextDecrypted = scan.nextLine();
		System.out.println("Please enter a cipher key:");
		String cipherKeyDecrypt = scan.nextLine();
		System.out.println("plaintext: " + "\n" + decrypt(TextDecrypted , cipherKeyDecrypt));
		*/
		String cipherText = "zinf-f ehp dh!";
		String cipherKey = "SECURITY";
		String plainText = decrypt(cipherText, cipherKey);
	}
	/* decrypt --
	 * this function receives the cipherText and the cipherkey. It then uses the cipherkey to decrypt the message.
	 * @returns a string that contains the decrypted message.
	 */
	public static String decrypt(String cipherText, String cipherKey)
	{
		// stores the decrypted message
		String decryptedText = "";
		// stores the decrypted character
		char decryptedChar;
		// checks whether the character is upper letter or lower letter
		boolean isUpper;
		// stores the asci value of each character of the cipherText
		int asciValText = 0;
		// stores the asci value of each character of the cipherkey
		int asciValKey = 0;
		// stores the asci value of how much a character of the cipherText needs to be shifted 
		int asciValShift = 0;
		// stores the new asci value
		int newAsciVal = 0;
		// stores the number of iteration through the cipherkey 
		int count = 0;
		// stores the result of a subtraction
		int diff = 0;
		// loops through the ciphertext
		for(int i = 0; i < cipherText.length(); i++)
		{
			// checks whether the character is a letter of alphabet
			if(isAlphabet(cipherText.charAt(i)))
			{
				// gets the asci value of a character of the key
				asciValKey = cipherKey.charAt(count);
				// subtract 65 from the asci value to see how much the character of the cipherText needs to be shifted
				// A - Z asci values are 65 - 90
				asciValShift = cipherKey.charAt(count) - 65;
				// checks if a letter is an upper or lower letter
				isUpper = Character.isUpperCase(cipherText.charAt(i));
				// upper letter
				if(isUpper)
				{
					// gets the asci value
					asciValText = cipherText.charAt(i);
					// calculates the new asci value - it needs to be subtracted because it's decryption and it's moving backwards in alphabet
					newAsciVal = asciValText - asciValShift;
					// checks if the new asci value is less than 65 (A) which is the beginning of the alphabet
					if(newAsciVal < 65)
					{
						// subtracts it from 64 (one asci value before (A)) to see how much it has to go backward.
						// it then subtracts it from 90 (asci value of Z) to calculate the new asci value which it gives us the decrypted character
						diff = 64 - newAsciVal;
						newAsciVal = 90 - diff;
					}
					// converts the asci value to a character and adds it to the decryptedText
					decryptedChar = (char) newAsciVal;
					decryptedText += decryptedChar;
					// goes to the next character of the key
					count ++;
					
				}
				// lower letter
				else
				{
					// gets the asci value
					asciValText = cipherText.charAt(i);
					// calculates the new asci value - it needs to be subtracted because it's decryption and it's moving backwards in alphabet
					newAsciVal = asciValText - asciValShift;
					// checks if the new asci value is less than 97 (a) which is the beginning of the alphabet
					if(newAsciVal < 97)
					{
						// subtracts it from 96 (one asci value before (a)) to see how much it has to go backward.
						// it then subtracts it from 122 (asci value of z) to calculate the new asci value which it gives us the decrypted character
						diff = 96 - newAsciVal;
						newAsciVal = 122 - diff;
					}
					// converts the asci value to a character and adds it to the decryptedText which contains the decrypted text
					decryptedChar = (char) newAsciVal;
					decryptedText += decryptedChar;
					// goes to the next character of the key
					count ++;
					
				}
				// checks whether it's at the end of the cipherkey. If it's true, It sets the count to 0.
				if(count == cipherKey.length())
				{
					count = 0;
				}
			}
			// if a character of the cipherText is not a letter, it just simply adds it to the decrypted message and does nothing to it
			else
			{
				decryptedText += cipherText.charAt(i);
			}
		}
		// returns the decrypted text
		return decryptedText;
	}
	
	/* isAlphabet --
	 * checks if a character is an alphabet letter
	 * @returns true or false
	 */
	public static boolean isAlphabet(char character)
	{
		if((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
			return true;
		else
			return false;
	}
}
