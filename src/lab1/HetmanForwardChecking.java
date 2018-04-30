package lab1;

import java.util.LinkedList;

public class HetmanForwardChecking extends Utils{
		
	private Leaf root;
	private Leaf current;
	private int time;
	private long returns;
//	private int y = 0;
	
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
		row = new boolean[n];
		up = new boolean[2*n - 1];
		down = new boolean[2*n - 1];
		solution = new int[n];
		if(n % 2 == 0) {
			current = root = new Leaf(1);
		} else
		current = root = new Leaf(0);
		put(current.solution, 0);
		solve();
		return new Result(time, returns, size);
	}
	
	public void solve() {
		int y = 0;
		boolean isEmpty = false;
		startTime = System.currentTimeMillis();
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
				current = current.children.getFirst();
				put(current.solution, y + 1);
				y++;
			}
		}
		endTime = System.currentTimeMillis();
		time = (int) (endTime - startTime);
		print(current, returns);
	}
	
	private void print(Leaf current, long returns2) {
		int i = 0;
		long timeOfCal = endTime - startTime;
		System.out.println(""
				+ "Time of calculation: " + timeOfCal + " ms \n"
				+ "returns: " + returns2 + "	\n");
		while(current.father != null) {
			solution[i] = current.solution;
			i++;
			current = current.father;
		}
		solution[i] = current.solution;
	//	print(solution);
	}
	
	void createDomain(Leaf l, int y) {
		Leaf temp;
		for(int i = 0; i < n; i++) {
			if(possible(i, y)) {
				temp = new Leaf(i);
				temp.father = l;
				l.children.add(temp);
			}
		}
	}
	
	
	
}
