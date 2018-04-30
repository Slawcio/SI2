package lab1;

import java.util.ArrayList;
import java.util.LinkedList;

public class LatinSquareBacktracking{
	
	private ArrayList<ArrayList<Field>> square;
	private Field start;
	private ArrayList<boolean[]> column;
	private ArrayList<boolean[]> row;
	private int n;
	private int iterations;

	class Field{
		
		private int v, x, y;
		private LinkedList<Field> children;
		private Field father;
		private boolean state = true;
		
		Field(int x, int y){
			this.x = x;
			this.y = y;
			children = new LinkedList<Field>();
		}
	}
	
	public void start(int n){
		square = new ArrayList<ArrayList<Field>>();
		column = new ArrayList<boolean[]>();
		row = new ArrayList<boolean[]>();
		this.n = n;
		iterations = n * n - 1;
		for(int i = 0; i < n; i++) {
			column.add(new boolean[n]);
			row.add(new boolean[n]);
		}
		start = new Field(0, 0);
		start.v = 0;
		put(start);
		start(start);
	}
	
	private void start(Field field) {
		int counter = 0;
		int x = 1;
		int y = 0;
		boolean isEmpty = false;
		long startTime = System.currentTimeMillis();
		int returns = 0;
		while(counter < iterations) {
			if(field.children.isEmpty() && field.state)
				createDomain(field, x, y);
			if(field.children.isEmpty()) {
				remove(field);
				field = field.father;
				field.children.getFirst().father = null;
				field.children.removeFirst();
				isEmpty = field.children.isEmpty();
				if(field.equals(start) && isEmpty) {
					remove(field);
					field.v++;
					put(field);
				}	else if(isEmpty) {
					field.state = false;
				}
				returns++;
				if(x != 0) {
					x--;
				} else {
					x = n - 1;
					y--;
				}
				counter--;
			} else {
				if(ifPossible(field.children.getFirst().x, field.children.getFirst().y, field.children.getFirst().v)) {
					field = field.children.getFirst();
					put(field);
					if(x < n - 1) {
						x++;
					} else {
						x = 0;
						y++;
					}
					counter++;
				} else {
					field.children.getFirst().father = null;
					field.children.removeFirst();
					returns++;
					if(field.children.isEmpty()) {
						field.state = false;
					}
				}
				
			}
		}
		long endTime = System.currentTimeMillis();
		print(field, endTime - startTime, returns);
	}
	
	private void print(Field field, long time, int returns) {
		System.out.println("Time: " + time + " ms \n" +
							"Returns: " + returns + "\n");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
		//		System.out.print(field.v + " ");
		//		field = field.father;
			}
			System.out.println();
		}
	}
	
	private void createDomain(Field field, int x, int y) {
		for(int i = 0; i < n; i++) {
				Field temp = new Field(x, y);
				temp.father = field;
				temp.v = i;
				field.children.add(temp);
				
		}
	}
	
	private void put(Field field) {
		column.get(field.v)[field.x] = true;
		row.get(field.v)[field.y] = true;
	}
	
	private void remove(Field field) {
		column.get(field.v)[field.x] = false;
		row.get(field.v)[field.y] = false;
	}
	
	boolean ifPossible(int x, int y, int v) {
		if(!column.get(v)[x] && !row.get(v)[y]) {
			return true;
		}
		return false;
	}
	
	
}
