package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

	public PerfectSquares() {
		// TODO Auto-generated constructor stub
	}

	public int numSquares(int n) {

		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> array = new ArrayList<>();
	    HashSet<Integer> visited = new HashSet<>();

			int countPs = 1;
			int k = 1;
			int perfectSquare = 1;
	        if(perfectSquare==n){
	return countPs;
	        }
	        

			while(perfectSquare < n){
				perfectSquare = k * k;
				if (perfectSquare == n) {
					return countPs;
				} else {
					if (perfectSquare<=n) {
	                    System.out.println("perfectSquare "+perfectSquare);
	                    System.out.println("n "+n);
						array.add(perfectSquare);
					}
				}
				k++;
			}
			int sum;
			countPs++;
			for(int i =0; i<array.size();i++) {
				for(int j=0;j<array.size();j++) {
					sum = array.get(i)+array.get(j);
					if(sum==n) {
						return countPs;
					}else if (sum<n){
	                    visited.add(sum);
						queue.offer(sum);
					}
					
				}
			}
			int size, sumFromQueue;
			while(!queue.isEmpty())
			{
				size = queue.size();
				countPs++;
				while(size>0)
				{
					sumFromQueue = queue.poll();
					size--;
					for (int x=0;x<array.size();x++) {
						sum = array.get(x)+sumFromQueue;
						if(sum==n) {
							return countPs;
						}
						if (sum<n && !visited.contains(sum)) {
	                        visited.add(sum);
							queue.offer(sum);
						}
						
						
					}
					
				}
				
			}
	        return 0;

		}

}
