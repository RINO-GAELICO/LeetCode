package leetCode;

public class Temperatures {

	public Temperatures() {
		// TODO Auto-generated constructor stub
	}

	public int[] dailyTemperatures(int[] temperatures) {

		int[] wait;
		wait = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = (temperatures.length - 1); i > (-1); i--) {

			stack.push(temperatures[i]);
		}

		while (!stack.isEmpty()) {

			for (int j = 0; j < temperatures.length; j++) {

				int temp = stack.pop();

				if (j != temperatures.length - 1) {

					wait[j] = 1;
					int indexWarmer = j + 1;

					while (indexWarmer < temperatures.length && temp >= temperatures[indexWarmer]) {

						wait[j] += 1;
						indexWarmer++;

					}
					if (indexWarmer == temperatures.length && temp >= temperatures[temperatures.length - 1]) {
						wait[j] = 0;
					}

				} else {
					wait[j] = 0;
				}

			}
		}
		return wait;

	}

}
