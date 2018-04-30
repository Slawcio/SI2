package lab1;

import java.util.LinkedList;

import lab1.HetmanForwardChecking.Leaf;

public class HetmanBacktracking extends Utils{
		
	private Leaf root;
	private int time;
	private long returns;
	
	class Leaf{
		Leaf father;
		boolean state = true;
		LinkedList<Leaf> children = new LinkedList<Leaf>();
		int solution;
		
		public Leaf(int solution) {
			this.solution = solution;
		}
		
		int getSolution() {
			return solution;
		}
	}

	public Result start(int size) {
		n = size;
		root = new Leaf(0);
		row = new boolean[n];
		up = new boolean[2*n - 1];
		down = new boolean[2*n - 1];
		solution = new int[n];
		solve2(root);
		return new Result(time, returns, size);
	}
	
	
	public void solve(Leaf current) {
		int y = 0;
		boolean isEmpty = false;
		startTime = System.currentTimeMillis();
	//	long returns = 0;
		do {
			if(!possible(current.solution, y) || !current.state) {
				remove(current.solution, y);
				current = current.father;
				if(!current.children.isEmpty()) {
				current.children.getFirst().father = null;
				current.children.removeFirst();
				}
				remove(current.solution, y - 1);
				isEmpty = current.children.isEmpty();
				if(current.equals(root) && isEmpty) {
					remove(current.solution, 0);
					current.solution++;
				//	put(current.solution, 0);
				}	else if(isEmpty) {
					current.state = false;
				}
				returns++;
				y--;
			} else {
				put(current.solution, y);
				if(current.children.isEmpty() && y < n)
					createDomain(current, y + 1);
				current = current.children.getFirst();
				y++;
			}
		} while(y < n);
		endTime = System.currentTimeMillis();
		time = (int) (endTime - startTime);
		print(current, returns);
	}
	
	public void solve2(Leaf current) {
		int y = 0;
		boolean isEmpty = false;
		startTime = System.currentTimeMillis();
		put(root.solution, 0);
		while(y < n - 1) {
			if(current.children.isEmpty() && current.state)
				createDomain(current, y + 1);
			if(current.children.isEmpty()) {
				remove(current.solution, y);
				current = current.father;
				current.children.getFirst().father = null;
				current.children.removeFirst();
				isEmpty = current.children.isEmpty();
				if(current.equals(root) && isEmpty) {
					remove(current.solution, 0);
					current.solution++;
					put(current.solution, 0);
				}	else if(isEmpty) {
					current.state = false;
				}
				returns++;
				y--;
			} else {
				if(possible(current.children.getFirst().solution, y + 1)) {
				current = current.children.getFirst();
				put(current.solution, y + 1);
				y++;
				} else {
					current.children.getFirst().father = null;
					current.children.removeFirst();
					returns++;
					if(current.children.isEmpty()) {
						current.state = false;
					}
				}
			}
		}
		endTime = System.currentTimeMillis();
		time = (int) (endTime - startTime);
	//	print(current, returns);
	}
	
	private void print(Leaf current, long returns) {
		int i = 0;
		long timeOfCal = endTime - startTime;
		System.out.println(""
				+ "Time of calculation: " + timeOfCal + " ms \n"
				+ "returns: " + returns + "	\n");
		while(current.father != null) {
			solution[i] = current.solution;
			i++;
			current = current.father;
		}
		solution[i] = current.solution;
	//	print(solution);
		System.out.println();
	}
	
	private boolean check() {
		for(int i = 0; i < row.length; i++) {
			if(!row[i]) return false;
		}
		return true;
	}
	
	void createDomain(Leaf l, int y) {
		Leaf temp;
		for(int i = 0; i < n; i++) {
				temp = new Leaf(i);
				temp.father = l;
				l.children.add(temp);
			}
		}
}
	
	
	

