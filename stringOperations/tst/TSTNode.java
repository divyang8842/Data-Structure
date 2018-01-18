package stringOperations.tst;

public class TSTNode {
	private char cData;
	private boolean b_is_End_Of_String;
	private TSTNode eq;
	private TSTNode right;
	private TSTNode left;
	
	public char getcData() {
		return cData;
	}
	public void setcData(char cData) {
		this.cData = cData;
	}
	public boolean isB_is_End_Of_String() {
		return b_is_End_Of_String;
	}
	public void setB_is_End_Of_String(boolean b_is_End_Of_String) {
		this.b_is_End_Of_String = b_is_End_Of_String;
	}
	public TSTNode getEq() {
		return eq;
	}
	public void setEq(TSTNode eq) {
		this.eq = eq;
	}
	public TSTNode getright() {
		return right;
	}
	public void setright(TSTNode right) {
		this.right = right;
	}
	public TSTNode getleft() {
		return left;
	}
	public void setleft(TSTNode left) {
		this.left = left;
	}
}
