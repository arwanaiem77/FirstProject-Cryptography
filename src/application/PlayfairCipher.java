package application;

import java.util.Random;

public class PlayfairCipher {
	
	public PlayfairCipher() {
	}
	
	   String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    public String seed() {
	    	Random rand =new Random();
	    	 String key;
	    	        StringBuilder str = new StringBuilder();
	    	        
	    	        for(int i = 0; i < rand.nextInt(15); i++) {
	    	            str.append(alph.charAt(rand.nextInt(26)));
	    	        }
	    	        key = str.toString();
	    	    return key;

	    }

	public static char[][]  keyWord(String key) {
		char[][] arr = new char[5][5];
		boolean[] used = new boolean[26]; 
		int row = 0, col = 0;
		key = key.toUpperCase().replace("J", "I"); 
		int e=0;
		while(e<key.length()&&row <5) {
			while (col < 5&&e<key.length()) {
				if(!used[key.charAt(e)-'A']) { // عشان الموقع تبعها ما يكون فاضي
					arr[row][col]=key.charAt(e);
					used[key.charAt(e)-'A']=true;
					col++;
				}
				e++;
			}
			col=0;
			row++;

		}
		int ch ='A';
		int f=0;
		row = 0;
		col = 0;
		boolean foundEmptyPos=false;
		for(row = 0; row < 5&&!foundEmptyPos; row++) {
			for(col = 0; col < 5&&!foundEmptyPos; col++) {
				if(arr[row][col] == 0) { 
					foundEmptyPos=true;
					row--;
					col--;
				}
			}
		}
		while(row < 5 && ch <= 'Z') {
			if(ch == 'J') {
				ch++;
				continue;
			}

			if(!used[ch-'A']) {
				arr[row][col] = (char)ch;
				col++;
				if(col >= 5) {
					col = 0;
					row++;
				}
			}
			ch++;
		}

	
		return arr;

	}
	
	
	public static StringBuilder encryption(StringBuilder pt,char[][] key) {
		for (int i=0;i<pt.length();i++) {
			if(pt.charAt(i)==' ') {
				pt.deleteCharAt(i);
			}
		}
		String st=pt.toString().toUpperCase();
		pt=new StringBuilder(st);
		int k=0;
		StringBuilder result =new StringBuilder();
		for(int i=0;i<pt.length();i++) {
			if (k==0) {
			if(i<pt.length()-1&&pt.charAt(i)==pt.charAt(i+1)) {
				result.append(pt.charAt(i));
				result.append('X');
				k++;
				continue;// عشان ما يحط الحرف 3 مرات
			}
			}
			result.append(pt.charAt(i));
		}
		if(result.length()%2!=0)
			result.append('X');
		StringBuilder ct =new StringBuilder();
		int row1=0,row2=0,col1=0,col2=0;

		for (int i=0;i<result.length();i+=2) {
			char a=result.charAt(i);
			char b=result.charAt(i+1);
			if(a=='J') 
				a='I';
			if(b=='J')
				b='I';
			
			for (int row =0;row<5;row++) { // to find the positions for the two characters
				for(int col=0;col<5;col++) {
					if(key[row][col]==a) {
						row1=row;
						col1=col;
					}
					if(key[row][col]==b) {
						row2=row;
						col2=col;
					}

				}
			}	
			if(row1!=row2&&col1!=col2) {
				ct.append(key[row1][col2]);
				ct.append(key[row2][col1]);
			}


			if(row1==row2) {
				if(col1==4) 
					ct.append(key[row1][0]);
				else
					ct.append(key[row1][col1+1]);
				if(col2==4) 
					ct.append(key[row2][0]);
				else
					ct.append(key[row2][col2+1]);
			}

			if(col1==col2) {
				if(row1==4) 
					ct.append(key[0][col1]);
				else
					ct.append(key[row1+1][col1]);
				if(row2==4) 
					ct.append(key[0][col2]);
				else 
					ct.append(key[row2+1][col2]);

			}	

		}
			return ct;
	}
	public static StringBuilder decryption(StringBuilder ct ,char[][] key) {
		StringBuilder pt =new StringBuilder();
		int row1=0,row2=0,col1=0,col2=0;
		for (int i=0;i<ct.length();i+=2) {
			char a=ct.charAt(i);
			char b=ct.charAt(i+1);
			if(a=='J') 
				a='I';
			if(b=='J')
				b='I';
			
			for (int row =0;row<5;row++) { // to find the positions for the two characters
				for(int col=0;col<5;col++) {
					if(key[row][col]==a) {
						row1=row;
						col1=col;
					}
					if(key[row][col]==b) {
						row2=row;
						col2=col;
					}

				}
			}	
			if(row1!=row2&&col1!=col2) {
				pt.append(key[row1][col2]);
				pt.append(key[row2][col1]);
			}


			if(row1==row2) {
				if(col1==0) 
					pt.append(key[row1][4]);
				else
					pt.append(key[row1][col1-1]);
				if(col2==0) 
					pt.append(key[row2][4]);
				else
					pt.append(key[row2][col2-1]);
			}

			if(col1==col2) {
				if(row1==0) 
					pt.append(key[4][col1]);
				else
					pt.append(key[row1-1][col1]);
				if(row2==0) 
					pt.append(key[4][col2]);
				else 
					pt.append(key[row2-1][col2]);

			}	

		}
		
		return pt;	
	}

	
	
	

}
