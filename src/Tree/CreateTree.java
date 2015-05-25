package Tree;
import java.util.Stack;
import java.util.StringTokenizer;
public class CreateTree {
	private String Expression;
	private Stack<String> Postfixs;
	private String toPostfix;
	private LinkedBinaryTree<String> tree= new LinkedBinaryTree<String>();
	public CreateTree(String e){
		Expression = e;
		toStack.OrderIt(e);
		toPostfix= Postfix.convertToPostfix(Expression);
		int end=0;
		Postfixs= new Stack<String>();
		int b;
		for(b=0;b<toPostfix.length();b++){
			if(toPostfix.charAt(b)==' '&&b!=end){
				Postfixs.push(toPostfix.substring(end, b));
				end=b+1;
			}
		}
		Postfixs.push(toPostfix.substring(end, b));
		System.out.print("||"+toPostfix+"||");
		String temp=Postfixs.pop();
		tree.addRoot(temp);
		Position<String> p= tree.root();
		String Previoustemp=tree.root.getElement();
		while(!Postfixs.isEmpty()){	
			temp=Postfixs.pop();
				if(isOperator(Previoustemp.charAt(0))){
					if(Character.isDigit(temp.charAt(0))||Character.isLetter(temp.charAt(0))){
						tree.addRight(p, temp);
						p=tree.right(p);
					}
					else{
						tree.addLeft(p, temp);
						p=tree.left(p);
					}
				}
				else{
					if(Character.isDigit(temp.charAt(0))||Character.toLowerCase(temp.charAt(0))=='x'){
						tree.addLeft(p, temp);
						p=tree.left(p);
					}
					else{
						tree.addRight(p, temp);
						p=tree.right(p);	
					}
			}
			Previoustemp=temp;		
		}
		if(isOperator(Previoustemp.charAt(0))){
			if(Character.isDigit(temp.charAt(0))||Character.toLowerCase(temp.charAt(0))=='x'){
				tree.addRight(p, temp);
				p=tree.right(p);
			}
			else{
				tree.addLeft(p, temp);
				p=tree.left(p);
			}
		}
		
		else{
			if(Character.isDigit(temp.charAt(0))||Character.toLowerCase(temp.charAt(0))=='x'){
				tree.addLeft(p, temp);
				p=tree.left(p);
			}
			else{
				tree.addRight(p, temp);
				p=tree.right(p);
			}
		}
	}
	public LinkedBinaryTree<String> getTree(){
		return tree;
	}
		public static boolean isOperator(char element)
		{
		    if(element == '*' || element == '-' || element == '/' || element == '+')
		        return true;
		    else
		        return false;
		}
	

	public Stack<String> getPostfix(){
		return Postfixs;
	}
	
	private Stack<String> Postfixs(String expression2) {
		infixtoPostfix fa= new infixtoPostfix(expression2);
		String inPostfix= fa.toPostfix(expression2);
		StringTokenizer next = new StringTokenizer(inPostfix," ");
		String line= next.nextToken();
		while(next.hasMoreTokens()){
			Postfixs.push(line);
			line= next.nextToken();	
		}
		return Postfixs;
	}
	
}