package application;

public class BruteForceCipher {
	
	
	public static String decrypt(String ciphertext, int key) {
	    StringBuilder plaintext = new StringBuilder();
	    
	    for (int i = 0; i < ciphertext.length(); i++) {
	        char c = ciphertext.charAt(i);
	        
	        if (c >= 'a' && c <= 'z') {
	            char decrypted = (char)((c - 'a' - key + 26) % 26 + 'a');
	            plaintext.append(decrypted);
	        }
	        else if (c >= 'A' && c <= 'Z') {
	            char decrypted = (char)((c - 'A' - key + 26) % 26 + 'A');
	            plaintext.append(decrypted);
	        }
	        else {
	            plaintext.append(c); 
	        }
	    }
	    
	    return plaintext.toString();
	}
	


}
