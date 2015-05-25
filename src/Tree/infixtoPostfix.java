package Tree;

import java.util.Stack;

public class infixtoPostfix extends Stack {
	private static String expression;
	private static Stack<Character> stack = new Stack<Character>();
	public infixtoPostfix(String expression2) {
		expression=expression2;
	}
	public static String toPostfix(String Expression){
		String input = "";
	    String output = "";
	    char character = ' ';
	    char nextCharacter = ' ';
	    for(int x = 0; x < expression.length(); x++)
	    {
	        character = expression.charAt(x);

	        if(isOperator(character))
	        {
	        	while(!stack.empty() && precedence(stack.peek())>= precedence(character))
	                output += stack.pop() + " ";
	            stack.push(character);
	        }   
	        else if(character == '(')
	        {
	            stack.push(character);
	        }
	        else if(character == ')')
	        {
	            while(!stack.peek().equals('('))
	                output += stack.pop() + " ";
	            stack.pop();
	        }
	        else
	        {
	            if(Character.isDigit(character) && (x + 1) < expression.length() && Character.isDigit(expression.charAt(x+1)))
	            {
	                output += character;
	            }
	            else if(Character.isDigit(character))
	            {
	                output += character + " ";
	            }   
	            else
	            {
	                output += character;
	            }
	        }
	    }//End of for

	    while(!stack.empty())
	    {
	        output += stack.pop() + " ";
	    }
	    
	    return output;
	}
	public static int precedence(char operator)
	{
	    if(operator == '+' || operator =='-')
	        return 1;
	    else if(operator == '*' || operator == '/')
	        return 2;
	    else
	        return 0;
	}
	public static boolean isOperator(char element)
	{
	    if(element == '*' || element == '-' || element == '/' || element == '+')
	        return true;
	    else
	        return false;
	}
}
