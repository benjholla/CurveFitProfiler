package trendlines;

public class PolynomialTrendline extends OLSTrendline {
	final int degree;

	public PolynomialTrendline(int degree) {
		if (degree < 0){
			throw new IllegalArgumentException("The degree of the polynomial must not be negative");
		}
		this.degree = degree;
	}
	
	public int getDegree(){
		return degree;
	}

	@Override
	protected double[] xVector(double x) { // {1, x, x*x, x*x*x, ...}
		double[] poly = new double[degree + 1];
		double xi = 1;
		for (int i = 0; i <= degree; i++) {
			poly[i] = xi;
			xi *= x;
		}
		return poly;
	}

	@Override
	protected boolean logY() {
		return false;
	}
}