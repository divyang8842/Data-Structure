package stringOperations.tst;

public class TST {
	private TSTNode root;
	
	public TSTNode InsertInTST(TSTNode root,String strWord, int nPosition){
		if(root==null){
			if(strWord.length()<=nPosition){
				return root;
			}
			root = new TSTNode();
			root.setcData(strWord.charAt(nPosition));
			root.setleft(null);
			root.setright(null);
			if(nPosition==strWord.length()-1){
				root.setB_is_End_Of_String(true);
				return root;
			}else{
				root.setEq(InsertInTST(root.getEq(), strWord, nPosition+1));
			}
		}else if(strWord.charAt(nPosition)>root.getcData()){
			root.setright(InsertInTST(root.getright(), strWord, nPosition));
		}else if(strWord.charAt(nPosition)==root.getcData()){
			if(strWord.length()<=nPosition){
				root.setEq(InsertInTST(root.getEq(), strWord, nPosition));
			}else{
				root.setB_is_End_Of_String(true);
			}
			
		}else{
			root.setleft(InsertInTST(root.getEq(), strWord, nPosition));
		}
		return root;
	}
	
	public boolean searchInTST(TSTNode root, String strWord,int nPosition){
		if(root!=null){
			if(strWord.charAt(nPosition)>root.getcData()){
				return searchInTST(root.getright(), strWord, nPosition+1);
			}else if(strWord.charAt(nPosition)<root.getcData()){
				return searchInTST(root.getleft(), strWord, nPosition+1);
			}else{
				if(nPosition == strWord.length() && root.isB_is_End_Of_String()){
					return true;
				}else{
					return searchInTST(root.getEq(), strWord, nPosition+1);
				}
			}
		}
		return false;
	}
}
