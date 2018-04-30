package lab1;

public class Hetman extends Utils{
	
	
	public int[][] solve(int size){
		n = size;
		chessboard = new int[n][n];
		row = new boolean[n];
		up = new boolean[2*n - 1];
		down = new boolean[2*n - 1];
		solution = new int[n];
		startTime = System.currentTimeMillis();
		fillDomain();
		drawHetman();
		while(!test(solution)) {
			clear();
			fillDomain();
			drawHetman();
		}
		endTime = System.currentTimeMillis();
		for(int i = 0; i < chessboard.length; i++) {
			for(int j = 0; j < chessboard.length; j++) {
				chessboard[i][j] = 0;
			}
		}
		print();
		
		return chessboard;
	}
	
	void print() {
		for(int i = 0; i < n; i++) {
			chessboard[i][solution[i]] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(chessboard[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\n time: " + (endTime-startTime) + " ms \n");
		System.out.println("");
	}
	
	void print(int[] test) {
		for(int i = 0; i < n; i++) {
			chessboard[i][test[i]] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(chessboard[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\n time: " + (endTime-startTime) + " ms \n");
		System.out.println("");
	}
	
}
