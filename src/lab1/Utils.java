package lab1;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Utils {
	protected int[][] chessboard;
	protected boolean[] row;
	protected boolean[] up;
	protected boolean[] down;
	protected long startTime;
	protected long endTime;
	protected int[] solution;
	protected int n;
	protected LinkedList<Integer> domain;
	
	protected void fillDomain() {
		domain = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			domain.add(i);
		}
	}
	
	protected void drawHetman() {
		for(int i = 0; i < n; i++) {
			int random = drawSolution(domain.size());
			solution[i] = domain.get(random);
			domain.remove(random);
		}
	}
	
	protected boolean test(int[] r) {
		for(int i = 0; i < r.length; i++) {
			if(possible(i, r[i]))
			put(i, r[i]);
				else
			{
					return false;
					}
		}
		return true;
	}
	
	protected void clear() {
		for(int i = 0; i < up.length; i++) {
			up[i] = false;
			down[i] = false;
		}
		for(int i = 0; i < row.length; i++) {
			row[i] = false;
		}
		for(int i = 0; i < solution.length; i++) {
			solution[i] = 0;
		}
	}
	
	protected int drawSolution(int size) {
		if(size > 1)
		return ThreadLocalRandom.current().nextInt(0, size);
		else
			return 0;
	}
	
	protected boolean possible(int r, int c) {
		 
			return !row[r] && !up[r+c] && !down[r-c+n-1];
	}
	
	void print(int[] test) {
		chessboard = new int[n][n];
		for(int i = 0; i < n; i++) {
			chessboard[i][test[i]] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(chessboard[i][j] + " ");
			}
			System.out.println("");
		}
	//	System.out.println("\n time: " + (endTime-startTime) + " ms \n");
		System.out.println("");
	}
	
	protected void put(int r, int c) {
		row[r] = up[r+c] = down[r-c+n-1] = true;
	}
	
	protected void remove(int r, int c) {
		row[r] = up[r+c] = down[r-c+n-1] = false;
	}
}
