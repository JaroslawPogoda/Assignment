package Tree;

import java.util.Stack;

public class toStack extends Stack<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4998040394402380469L;
	Stack<String>ans=new Stack<String>();
	String Infix="";
	public toStack(String e){
		Infix=e;
		String toOrder= OrderIt(e);
		ans=StuckUp(toOrder);
	}
	private Stack<String> StuckUp(String toOrder) {
		
		return null;
	}
	public static String OrderIt(String e) {
		@SuppressWarnings("unused")
		String as="";
		e=removeparant(e);
		int k=e.length();
		for(int b=0;b<k;b++){
			//System.out.print(b);
			if(isOperator(e.charAt(b))){
				//System.out.print(e.charAt(b)+" cc");
				//e=removeparant(e);
				if(isParant(e.charAt(b),e,b)){
					System.out.print(e.charAt(b)+"    bbb ");
					e=e.substring(0, b-1)+e.substring(b+1, k);
					
					k=e.length();
					b=0;
				}
			}
		}
		return null;
	}
	private static String removeparant(String e) {
		e=e.substring(1,e.length()-1);
		System.out.print(e);
		return e;
	}
	private static boolean isParant(char charAt,String e, int b) {
		boolean ans=true;
		int parant=0;
		for(int i =0;i<=b;i++){
			if(e.charAt(i)=='(')parant++;
			if(e.charAt(i)==')')parant--;
		}
		if(parant!=0){
			ans = false;
		}
		return ans;
	}
	private static boolean isOperator(char ch){
		return ch=='*'||ch=='/'||ch=='-'||ch=='+'||ch=='('||ch==')';
	}
	@SuppressWarnings("unused")
	private int presidence(char ch){
		int presidence = 0;
		switch(ch){
			case '+':
				presidence =1;
				break;
			case'-':
				presidence =2;
				break;
			case '/':
				presidence =3;
				break;
			case '*':
				presidence =4;
				break;
		}
		return presidence;
	}
	
	
}
