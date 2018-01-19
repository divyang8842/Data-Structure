package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Problems {
	public void sortRoyalNames(String nameAry[]){
		Arrays.sort(nameAry,compare);
	}
	
	Comparator<String> compare=  new Comparator<String>() {

		@Override
		public int compare(String str1, String str2) {
			String name1[] =  str1.split(" ");
			String name2[] =  str2.split(" ");
			if(name1[0].compareTo(name2[0])==0){
				if(name1.length>1 && name2.length>1){
					return romanToDecimal(name1[1]) - romanToDecimal(name2[1]);
				}else if(name1.length==1){
					return 1;
				}else{
					return -1;
				}
			}
			return name1[0].compareTo(name2[0]);
		}
	};
	
    int romanToDecimal(String str)
    {
        int res = 0;
 
        for (int i=0; i<str.length(); i++)
        {
            int s1 = value(str.charAt(i));
 
            if (i+1 <str.length())
            {
                int s2 = value(str.charAt(i+1));
 
                if (s1 >= s2)
                {
                    res = res + s1;
                }
                else
                {
                    res = res + s2 - s1;
                    i++; 
                }
            }
            else
            {
                res = res + s1;
                i++;
            }
        }
 
        return res;
    }
    
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    
    public void printArry(String[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
    
    public void printLL(LinkedList dataLL){
		int nLength =  dataLL.size();
		for(int i=0;i<nLength;i++){
			System.out.print(dataLL.get(i)+" ");
		}
		System.out.println(" ");
	}
    
    
	public void AddLinkedList(LinkedList<Integer> AddedLinkedList,LinkedList<Integer> LL1,int nPos1,LinkedList<Integer> LL2,int nPos2,int nCarry){
		if(nPos1<0 && nPos2<0){
			nPos1 = LL1.size()-1;
			nPos2 = LL2.size()-1;
		}
		if(AddedLinkedList == null){
			AddedLinkedList = new LinkedList<Integer>();
		}
		int nData = 0;
		int nSum = 0;
		
		if(nPos1>=0 && nPos2>=0){
			nSum = LL1.get(nPos1)+LL2.get(nPos2)+nCarry;
			nCarry = nSum/10;
			nData = nSum%10;
			nPos1--;
			nPos2--;
		}else if(nPos1>=0){
			nSum = LL1.get(nPos1)+nCarry;
			nCarry = nSum/10;
			nData  = nSum%10;
			nPos1--;
		}else if(nPos2>=0){
			nSum = LL1.get(nPos2)+nCarry;
			nCarry = nSum/10;
			nData  = nSum%10;
			nPos2--;
		}else{
			return;
		}
		
		if(nPos1 >=0 || nPos2>=0){
			AddLinkedList(AddedLinkedList, LL1, nPos1, LL2, nPos2, nCarry);
		}else if(nCarry>0){
			AddedLinkedList.add(nCarry);
		}
		
		AddedLinkedList.add(nData);
	}
	
	
	
    
    public static void main(String str[]){
    	Problems obj = new Problems();
    	/*String names[]={"Richard V","Henry VI","Edward II","Richard XXV","Henry IX","Edward LII"};
    	obj.sortRoyalNames(names);
    	obj.printArry(names);
    	*/
    	LinkedList<Integer> LL1 = new LinkedList<Integer>();
    	LL1.add(1);
    	LL1.add(9);
    	
    	LinkedList<Integer> LL2 = new LinkedList<Integer>();
    	LL2.add(8);
    	LL2.add(1);
    	
    	LinkedList<Integer> LLAdd = new LinkedList<Integer>();
    	obj.AddLinkedList(LLAdd, LL1, -1, LL2, -1, 0);
    	obj.printLL(LLAdd);
    }
	
}
