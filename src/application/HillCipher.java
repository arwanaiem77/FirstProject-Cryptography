package application;

import java.util.Random;

public class HillCipher {
   private int[] alphaArr = new int[26];
//    private int blockSize;
    String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//
    public HillCipher() {
    	for (int i = 0; i < 26; i++) {
    		alphaArr[i] = i;
    	}
    }
//    public String seed() {
//    	Random rand =new Random();
//    	String key;
//
//    	StringBuilder str = new StringBuilder();
//    	for(int i = 0; i < 9; i++) {
//    		str.append(alph.charAt(rand.nextInt(26)));
//    	}
//    	key = str.toString();
//    	return key;
//
//    }
//
//    
    public String encrypt(String plaintext, String key) {
		return key;
//    	plaintext=plaintext.toUpperCase();
//    	  blockSize = (int) Math.sqrt(key.length());
//          double[][] keyMatrix = new double[blockSize][blockSize];
//          int index = 0;
//          for (int row = 0; row < blockSize; row++) {
//        	  for (int col = 0; col < blockSize; col++) {
//        		  keyMatrix[row][col] = alphaArr[key.charAt(index) - 'A'];
//        		  index++;
        	  }
//          }
//          if (plaintext.length() % blockSize != 0) {
//        	  int filer = blockSize - (plaintext.length() % blockSize);
//        	  StringBuilder strPt=new StringBuilder(plaintext);
//        	  for(int i=0;i<filer;i++) {
//        		  strPt.append('X');
//        	  }
//        	  plaintext=strPt.toString();
//          }
//
//        StringBuilder ciphertext = new StringBuilder();
//        
//        for (int i = 0; i < plaintext.length(); ) {
//            StringBuilder block = new StringBuilder();
//            for (int j = 0; j < blockSize && i < plaintext.length(); j++) {
//                block.append(plaintext.charAt(i));
//                i++;
//            }
//            double[] encryptedB = new double[blockSize];
//            
//            for (int row = 0; row < blockSize; row++) {
//                for (int k = 0; k < blockSize; k++) {
//                	encryptedB[row] += keyMatrix[row][k] * alphaArr[block.charAt(k) - 'A'];
//                }
//                encryptedB[row] = encryptedB[row] % 26;
//            }
//            
//            char[] encrypted = new char[blockSize];
//            for (int f = 0; f < blockSize; f++) {
//                encrypted[f] = (char) (encryptedB[f] + 'A');
//            }
//            ciphertext.append(encryptedB);
//        }
//        
//        return ciphertext.toString();
//    }
//    
   public String decrypt(String ciphertext, String key) {
	return key;
//        blockSize = (int) Math.sqrt(key.length());
//        double[][] keyM = new double[blockSize][blockSize];
//  
//        int index = 0;
//        for (int row = 0; row < blockSize; row++) {
//            for (int col = 0; col < blockSize; col++) {
//            	keyM[row][col] = alphaArr[key.charAt(index) - 'A'];
//                index++;
//            }
//        }
//        double[][] invKey = calculateInverse(keyM);        
//        StringBuilder plaintext = new StringBuilder();      
//      
//        
//        return plaintext.toString();
   }
//    
//   
//    
//    private double[][] calculateInverse(double[][] keyMatrix) {
//        double[][] inverse = new double[blockSize][blockSize];
//        
//        if (blockSize == 2) {
//            double determinant = (keyMatrix[0][0] * keyMatrix[1][1])-(keyMatrix[0][1] * keyMatrix[1][0]);
//        
//            
//         
//            
//            inverse[0][0] = keyMatrix[1][1];
//            inverse[0][1] = -keyMatrix[0][1];
//            inverse[1][0] = -keyMatrix[1][0];
//            inverse[1][1] = keyMatrix[0][0];
//
//    
//        else if(blockSize == 3) {
//
//        	double determinant =  keyMatrix[0][0] * (keyMatrix[1][1] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][1]) -
//        			keyMatrix[0][1] * (keyMatrix[1][0] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][0]) +
//        			keyMatrix[0][2] * (keyMatrix[1][0] * keyMatrix[2][1] - keyMatrix[1][1] * keyMatrix[2][0]);
//        	determinant =determinant%26;
//        
//            double[][] adjugate = new double[3][3];
//            adjugate[0][0] = +(keyMatrix[1][1] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][1]);
//            adjugate[0][1] = -(keyMatrix[1][0] * keyMatrix[2][2] - keyMatrix[1][2] * keyMatrix[2][0]);
//            adjugate[0][2] = +(keyMatrix[1][0] * keyMatrix[2][1] - keyMatrix[1][1] * keyMatrix[2][0]);
//            
//            adjugate[1][0] = -(keyMatrix[0][1] * keyMatrix[2][2] - keyMatrix[0][2] * keyMatrix[2][1]);
//            adjugate[1][1] = +(keyMatrix[0][0] * keyMatrix[2][2] - keyMatrix[0][2] * keyMatrix[2][0]);
//            adjugate[1][2] = -(keyMatrix[0][0] * keyMatrix[2][1] - keyMatrix[0][1] * keyMatrix[2][0]);
//            
//            adjugate[2][0] = +(keyMatrix[0][1] * keyMatrix[1][2] - keyMatrix[0][2] * keyMatrix[1][1]);
//            adjugate[2][1] = -(keyMatrix[0][0] * keyMatrix[1][2] - keyMatrix[0][2] * keyMatrix[1][0]);
//            adjugate[2][2] = +(keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]);
//            
//        
//            }
//        	
//
//        
//
//        return inverse;
//    }
//
// 
//    
//
//
}
