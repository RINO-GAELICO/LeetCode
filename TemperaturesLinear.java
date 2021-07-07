package leetCode;

import java.util.Stack;

public class TemperaturesLinear {

	public TemperaturesLinear() {
		// TODO Auto-generated constructor stub
	}

	public int[] dailyTemperatures(int[] temperatures) {

		Stack<Integer> stack = new Stack<>();
		int[] distance;
		distance = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {

			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ) {

				int diff = i - stack.peek();
				distance[stack.pop()] = diff;

			}

			stack.push(i);

		}
		while (!stack.isEmpty()) {
			distance[stack.pop()] = 0;
		}
        return distance;

	}

}
