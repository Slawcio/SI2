package lab1;

import java.util.ArrayList;

public class Main {
	
	public final static int N = 32;
	public final static int Latin = 16;
	
	public static void main(String[] args) {
		Hetman hetman = new Hetman();
		HetmanBacktracking back = new HetmanBacktracking();
		HetmanForwardChecking forward = new HetmanForwardChecking();
		LatinSquareForwardChecking LSFC = new LatinSquareForwardChecking();
		LatinSquareBacktracking LSB = new LatinSquareBacktracking();
		
		ArrayList<Result> results = new ArrayList<Result>();
//		hetman.solve(N);
		for(int i = 4; i < N; i++) {
		//	System.out.println("Size: " + i);
		//	results.add(forward.start(i));
		}
	//	CSV.writeFile("HetmanF.csv", results);
		
		for(int i = 4; i < N; i++) {
		//	System.out.println("Size: " + i);
			results.add(back.start(i));
		}
		CSV.writeFile("HetmanB1.csv", results);
		System.out.println("Done");
//		LSFC.start(Latin);
		
//		LSB.start(Latin);
	}

}
