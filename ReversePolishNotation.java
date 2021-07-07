package leetCode;
import java.util.Stack;

public class ReversePolishNotation {

	public ReversePolishNotation() {
		// TODO Auto-generated constructor stub
	}
	
public int evalRPN(String[] tokens) {
	
Stack<String> stack = new Stack<>();
	
	for(int i=0; i< tokens.length;i++) {
		if(tokens[i].equals("+"))
		{
            
			stack.push(""+(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
		}
		else if(tokens[i].equals("-")) {
            
			String secondToken = stack.pop();
			stack.push(""+(Integer.parseInt(stack.pop())-Integer.parseInt(secondToken)));
			
		}
		else if(tokens[i].equals("*")) {
            
            stack.push(""+(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
			
			
		}else if(tokens[i].equals("/")) {
            
			String secondToken = stack.pop();
			stack.push(""+(Integer.parseInt(stack.pop())/Integer.parseInt(secondToken)));
			
		}else{
            
            stack.push(tokens[i]);
        }
        
		
	}
	return Integer.parseInt(stack.pop());
        
    }
        
    }


