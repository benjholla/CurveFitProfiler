import loops.Loop1;
import loops.Loop2;
import loops.Loop3;
import loops.Loop4;
import trendlines.PolynomialTrendline;

public class CurveFitProfiler {

	private static final int NUM_DATA_POINTS = 100;
	private static final int MAX_TRENDLINE_POLYNOMIAL_ORDER = 5;
	
	public static void main(String[] args) {
		
		// loop 1
		double x[] = new double[NUM_DATA_POINTS];
		double y[] = new double[NUM_DATA_POINTS];
		for(int i=1; i<=NUM_DATA_POINTS; i++){
			x[i-1] = i;
			y[i-1] = Loop1.run(i);
		}
		System.out.println("Guessing: O(n^" + findBestFitOrder(x, y, MAX_TRENDLINE_POLYNOMIAL_ORDER) + ") for Loop 1");
		
		// loop 2
		x = new double[NUM_DATA_POINTS];
		y = new double[NUM_DATA_POINTS];
		for(int i=1; i<=NUM_DATA_POINTS; i++){
			x[i-1] = i;
			y[i-1] = Loop2.run(i);
		}
		System.out.println("Guessing: O(n^" + findBestFitOrder(x, y, MAX_TRENDLINE_POLYNOMIAL_ORDER) + ") for Loop 2");
		
		// loop 3
		x = new double[NUM_DATA_POINTS];
		y = new double[NUM_DATA_POINTS];
		for(int i=1; i<=NUM_DATA_POINTS; i++){
			x[i-1] = i;
			y[i-1] = Loop3.run(i);
		}
		System.out.println("Guessing: O(n^" + findBestFitOrder(x, y, MAX_TRENDLINE_POLYNOMIAL_ORDER) + ") for Loop 3");
		
		// loop 4
		x = new double[NUM_DATA_POINTS];
		y = new double[NUM_DATA_POINTS];
		for(int i=1; i<=NUM_DATA_POINTS; i++){
			x[i-1] = i;
			y[i-1] = Loop4.run(i);
		}
		System.out.println("Guessing: O(n^" + findBestFitOrder(x, y, MAX_TRENDLINE_POLYNOMIAL_ORDER) + ") for Loop 4");
		
	}
	
	private static int findBestFitOrder(double[] x, double[] y, int maxIterations){
		double bestFit = 0;
		int bestFitOrder = 1;
		int iterations = 1;
		do {
			PolynomialTrendline trendline = new PolynomialTrendline(iterations);
			trendline.setValues(x, y);
			double rSquared = trendline.getRSquared();
			if(bestFit >= rSquared){
				// increasing the polynomial order did not improve the fit
				break;
			} else {
				// bestFit < rSquared
				bestFit = rSquared;
				bestFitOrder = iterations;
			}
		} while(iterations++ < maxIterations);
		return bestFitOrder;
	}

}
