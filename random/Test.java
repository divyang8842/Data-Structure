package random;

public class Test {
	
	/*
	 * Complete the function below.
	 */
	public static void main(String[] args)
	{
		String []arr={"aqc"};
		System.out.println(strengthenPasswords(arr));
	}
	
	    static String[] strengthenPasswords(String[] passwords) {
	        int slen = passwords.length;
	        String[] output = new String[slen];
	       
	        for(int n=0;n<slen;n++)
	        {
	            int newValue = 0;
	            int len=passwords[n].length();
	            char[] chars = new char[len+1];
	            int j=0;
	            for(int i=0;i<len;i++)
	            {
	                if(passwords[n].charAt(i)=='s' || passwords[n].charAt(i)=='S'){
	                    chars[j]='5';
	                }else{
	                	chars[j] = passwords[n].charAt(i);
	                }
	                if(len>1 && len%2==1 && i==(len-1)/2)
		            {
	                	if(Character.isDigit(chars[i])&& Integer.parseInt(String.valueOf(passwords[n].charAt(i))) > 4){
		                	chars[++j] = 0;
		                }
		            }	
	                j++;
	            }
	            
	            if(len>1 && len%2==1 && Character.isDigit(chars[(len-1)/2]))
	            {
	                newValue = Integer.parseInt(String.valueOf(chars[(len-1)/2]))*2;
	                if(newValue>9){
	                	chars[(len-1)/2] = Character.forDigit(newValue/10, 10);
	                	chars[(len-1)/2 +1] = Character.forDigit(newValue%10, 10);
	                }else{
	                    chars[(len-1)/2] = Character.forDigit(newValue, 10);
	                }
	            }
	            
	            
	            
	            if(len%2==0)
	            {
	                char c=chars[0];
	                
	                chars[0]=chars[len-1];
	                
	                if(Character.isUpperCase(chars[0]))
	                   chars[0]=Character.toLowerCase(chars[0]);
	                else if(Character.isLowerCase(chars[0]))
	                   chars[0]=Character.toUpperCase(chars[0]);
	                
	                chars[len-1]=c;
	                
	                if(Character.isUpperCase(chars[len-1]))
	                   chars[len-1]=Character.toLowerCase(chars[len-1]);
	                else if(Character.isLowerCase(chars[len-1]))
	                   chars[len-1]=Character.toUpperCase(chars[len-1]);
	            }
	            String str = String.valueOf(chars);
	            output[n]=str.trim();
	            if(str.toLowerCase().contains("nextcapital"))
	            {
	                int startIndex = str.toLowerCase().indexOf("next");
	                String result = str.substring(0,startIndex);
	                result += new StringBuilder(str.substring(startIndex,startIndex+4)).reverse().toString();
	                result += str.substring(startIndex+4,len);
	                output[n]=result.trim();
	            }
	            
	        }
	        
	        for(int i=0;i<output.length;i++)
	        {
	        	System.out.println(output[i]);
	        }
	        
	        return output;
	    }
	    
}
