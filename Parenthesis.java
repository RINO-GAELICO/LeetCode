package leetCode;

import java.util.Stack;

public class Parenthesis {

	public Parenthesis() {
		// TODO Auto-generated constructor stub
	}

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (!stack.isEmpty()) {

				char compare = stack.pop();
				if (c == ')' && compare != '(') {
					return false;
				} else if (c == ']' && compare != '[') {
					return false;
				} else if (c == '}' && compare != '{') {
					return false;
				}

			} else {
				return false;
			}

		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

}
