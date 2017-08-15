package threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
	public static void main(String[] atf) {
		double[] data = new double[10000001];
		for (int i = 0; i < data.length; i++)
			data[i] = (double) i;

		ForkJoinPool forkJoinPool =new ForkJoinPool(1);
		Act act = new Act(0, data.length-1, data);
		System.out.println(forkJoinPool.getParallelism());
		long begin = System.nanoTime();
		forkJoinPool.invoke(act);
		/*try {
			Thread.sleep(1500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}*/
		long end = System.nanoTime();
		/*for (int i = 0; i < data.length; i++)
			System.out.println(data[i] );*/
		System.out.println("begin : "+ begin+" End : "+ end+ " end-begin : " + (end-begin));
	}
}

class Act extends RecursiveTask<Double> {

	int begin;
	int end;
	double[] data;
	final int threashold = 1000;

	public Act(int begin, int end, double[] data) {
		this.begin = begin;
		this.end = end;
		this.data = data;
	}

	@Override
	protected Double compute() {
		/*		System.out.println("Pool " + Act.getPool());
		//System.out.println(begin+ " "+end );
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}	
*/		if (end - begin <= threashold) {
			for (int i = begin; i <= end; i++) {
				data[i] = Math.sqrt(data[i]);
			}
		} else {
			int mid = (end - begin) / 2;
			invokeAll(new Act(begin, begin+mid, data), new Act(begin+mid + 1, end, data));
		}
		return null;
	}
}