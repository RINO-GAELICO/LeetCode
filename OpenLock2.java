package leetCode;

import java.util.HashSet;
import java.util.Queue;

public class OpenLock2 {
	
	/*
	 * This is a very nice solution based on BFS that is based on the idea of levels. 
	 * What it mean a level is described at the end of the program in the comment next to the increment of the level.
	 */

	public OpenLock2() {
		// TODO Auto-generated constructor stub
	}

	public int openLock(String[] deadends, String target) {
		
		/*
		 * two hashsets to contain all the deadends and all already visited combinations
		 */
		HashSet<String> dead_ends = new HashSet<>(Arrays.asList(deadends));
		HashSet<String> visited = new HashSet<>();

		visited.add("0000"); // start with first combination

		Queue<String> queue = new LinkedList();// the queue that is fed with all the visited combinations
		/*
		 * we start form here and add 0000 to the queue
		 */
		queue.offer("0000");
		int level = 0; // level incremented every step of the graph..

		
		/*
		 * the while loop goes on until the queue is empty. Every combination that is not been visited and it is not a deadend is added to the queue
		 */
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			while (size > 0) {
				
				// we arm the lock-position wit the combination coming from the queue
				String lockPosition = queue.poll();
				
				// if we find the target we stop here
				if (lockPosition.equals(target)) {
					
					return level;
				}
				// if the combination armed is one of the deadend we jump to the next in queue
				if (dead_ends.contains(lockPosition)) {
					size--;
					continue;
				}

				StringBuilder sb = new StringBuilder(lockPosition);
				
				/*
				 * loop through each position of the 4 lock digits and add/subtract one from it. Each resulted combination is added to the queue.
				 */
				for (int i = 0; i < 4; i++) {

					char current_position = sb.charAt(i);
					/*
					 * s2 goes one forwards and s1 goes one backwards.
					 */
					String s1 = sb.substring(0, i) + (current_position == '9' ? 0 : current_position - '0' + 1)
							+ sb.substring(i + 1);
					String s2 = sb.substring(0, i) + (current_position == '0' ? 9 : current_position - '0' - 1)
							+ sb.substring(i + 1);
					/*
					 * checking if the combinations s1 and s2 are not deadend and are not already visited
					 */
					if (!visited.contains(s1) && !dead_ends.contains(s1)) {
						
						queue.offer(s1);
						visited.add(s1);
					}
					if (!visited.contains(s2) && !dead_ends.contains(s2)) {
						
						queue.offer(s2);
						visited.add(s2);
					}

					/*
					 * 
					 * THIS IS MY ATTEMPT THAT DID NOT GO VERY WELL.
					 * DONT KNOW WHY
					 * 
					 * char digit_char = sb.charAt(i); int
					 * number=Character.getNumericValue(digit_char);
					 * 
					 * int forward = (number==9) ? (forward=0) : (number+1); int backwards = (number
					 * ==0) ? (backwards=9) : (number-1);
					 * 
					 * 
					 * 
					 * digit_char = Character.forDigit(forward,10); StringBuilder sb_modified = new
					 * StringBuilder(sb); sb_modified.setCharAt(i, digit_char);
					 * 
					 * 
					 * if(!visited.contains(sb_modified.toString())&&
					 * !dead_ends.contains(sb_modified.toString())) { //
					 * System.out.println("INSIDE IF"); queue.offer(sb_modified.toString()); //
					 * System.out.println(sb_modified.toString());
					 * visited.add(sb_modified.toString()); }
					 * 
					 * StringBuilder sb_modified2 = new StringBuilder(sb); digit_char =
					 * Character.forDigit(backwards,10); sb_modified2.setCharAt(i, digit_char);
					 * 
					 * if(!visited.contains(sb_modified2.toString())&&
					 * !dead_ends.contains(sb_modified.toString())) { //
					 * System.out.println("INSIDE IF 2"); queue.offer(sb_modified2.toString()); //
					 * System.out.println(sb_modified2.toString());
					 * visited.add(sb_modified.toString()); }
					 * 
					 */

				}
				/*
				 * very nice trick to not get confused with the new elements added to the queue. 
				 * size is assigned with queue size at the beginning and it is decremented each iteration of the loop.
				 * 
				 */
				size--;

			}
			/*
			 * it increments by one at each 'level'
			 * level is each turn that we do of the wheel. 
			 * Basically we turn each digit simultaneously one forward and one backward (plus one and minus one).
			 * this change for each 4 digits on each combination coming from the queue represents a level.
			 */
			level++;
			

		}
		return -1;

	}

}
