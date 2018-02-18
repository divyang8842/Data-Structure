package random;

public class Test {
	
	/*
	 * Complete the function below.
	 */
	public static void main(String[] args)
	{
		String []arr={"a12345678910x5cnExTcapital1","aNExtCapital6x12345678912","neXtCapital9nextcapital","AneXtCapital9nextcapitalZ"};
		strengthenPasswords(arr);
	}
	static String[] strengthenPasswords(String[] passwords) {
		int nLength = passwords.length;
        
        for(int i=0;i<nLength;i++)
        {
        	int nPasLength = passwords[i].length();
        	boolean isMiddleDigit =  false;
        	boolean bEvenLength = false;
        	int nMiddle = Character.getNumericValue(passwords[i].charAt(nPasLength/2));
        	if(nPasLength%2 == 1){
        		if(Character.isDigit(passwords[i].charAt(nPasLength/2))){
        			isMiddleDigit = true;
        			if(nMiddle >4){
        				nPasLength++;
        				bEvenLength = true;
        			}
        		}
        	}else{
        		bEvenLength = true;
        	}
        	char[] cPassword = new char[nPasLength];
        	int nCharIndex = 0;
        	for(int j=0;j<nPasLength;j++,nCharIndex++){
        		if(isMiddleDigit && nPasLength/2 - 1 == j){
        			nMiddle = nMiddle*2;
        			if(nMiddle>9){
        				cPassword[j++] = '1';
        				cPassword[j] = Character.forDigit(nMiddle%10, 10);
        			}else{
        				cPassword[j] = Character.forDigit(nMiddle, 10);
        			}
        		}else{
        			cPassword[j] = passwords[i].charAt(nCharIndex);
        			if(Character.toLowerCase(cPassword[j]) == 's'){
        				cPassword[j] = '5';
        			}
        		}
        	}
        	if(bEvenLength){
        		char cTemp  = cPassword[nPasLength-1];
        		cPassword[nPasLength-1] =  cPassword[0];
        		cPassword[0] = cTemp;
        		if(Character.isUpperCase(cPassword[nPasLength-1])){
        			cPassword[nPasLength-1] =  Character.toLowerCase(cPassword[nPasLength-1]);
        		}else{
        			cPassword[nPasLength-1] = Character.toUpperCase(cPassword[nPasLength-1]);
        		}
        		
        		if(Character.isUpperCase(cPassword[0])){
        			cPassword[0] =  Character.toLowerCase(cPassword[0]);
        		}else{
        			cPassword[0] = Character.toUpperCase(cPassword[0]);
        		}
        	}
        	int nIndex = passwords[i].toLowerCase().indexOf("nextcapital"); 
        	if(nIndex>0 && nIndex< nPasLength - 11){
        		if(isMiddleDigit && bEvenLength && nIndex > nPasLength/2){
        			nIndex++;
        		}
        		char cTemp  = cPassword[nIndex];
        		cPassword[nIndex] = cPassword[nIndex+3];
        		cPassword[nIndex+3] = cTemp;
        		cTemp = cPassword[nIndex+1];
        		cPassword[nIndex+1] = cPassword[nIndex+2];
        		cPassword[nIndex+2] = cTemp;
        	}
        	passwords[i] = String.valueOf(cPassword);
        	System.out.println(passwords[i]);
        }
        return passwords;
	}
}
