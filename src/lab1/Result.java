package lab1;

public class Result {
	private int time;
	private long returns;
	private int iteration;
	Result(int time, long returns, int iteration){
		this.time = time;
		this.returns = returns;
		this.iteration = iteration;
	}
	
	int getTime() {
		return time;
	}
	
	long getReturns() {
		return returns;
	}
	
	int getIteration() {
		return iteration;
	}
}
