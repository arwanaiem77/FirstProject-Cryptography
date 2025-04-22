package application;

import java.util.Random;

public class ShiftCipher {
	
	
	 public int seed() {
	    	Random rand =new Random();
	    	 int key;
	    	  key=rand.nextInt(26);
	    	        
	    	    return key;

	 }

	 public  String encrypt(String plaintext, int key) {
		 StringBuilder ciphertext = new StringBuilder();

		 for(int i=0; i<plaintext.length(); i++) {

			 if(plaintext.charAt(i) >= 'a' && plaintext.charAt(i) <= 'z') {
				 char ch = (char)(((plaintext.charAt(i) - 'a' + key + 26) % 26) + 'a');
				 ciphertext.append(ch);
			 }
			 else if(plaintext.charAt(i) >= 'A' && plaintext.charAt(i) <= 'Z') {
				 char ch = (char)(((plaintext.charAt(i) - 'A' + key + 26) % 26) + 'A');
				 ciphertext.append(ch);
			 }
			 else {
				 ciphertext.append(plaintext.charAt(i)); 
			 }
		 }

		 return ciphertext.toString();
	 }

	 public String decrypt(String ciphertext, int key) {
		    StringBuilder plaintext = new StringBuilder();

		    for(int i=0; i<ciphertext.length(); i++) {
		        char current = ciphertext.charAt(i);
		        
		        if(current >= 'a' && current <= 'z') {
		            int shifted = (current - 'a' - key + 26) % 26;
		            char ch = (char)(shifted + 'a');
		            plaintext.append(ch);
		        }
		        else if(current >= 'A' && current <= 'Z') {
		            int shifted = (current - 'A' - key + 26) % 26;
		            char ch = (char)(shifted + 'A');
		            plaintext.append(ch);
		        }
		        else {
		            plaintext.append(current); 
		        }
		    }

		    return plaintext.toString();
		}

	    
	}


