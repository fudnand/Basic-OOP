
public class Integration {

	public static void main(String[] args) {
		System.out.println(integrate(0, Math.PI / 2, 10000, new IF(){

			@Override
			public double evaluate(double x) {
				return Math.cos(x);
			}
			
		}));
		
		System.out.println(integrate(0, 1, 10000, new IF(){

			@Override
			public double evaluate(double x) {
				return x * x;
			}
			
		}));
		
	}
	static double integrate(double a, double b, int numPts, IF f){
		double sum = 0;
		
		double delta = (b - a) / numPts;
		for(int i = 0; i<numPts; i++){
			double pt = a + i *delta;
			sum += f.evaluate(pt) * delta;
			
		}
		
		return sum;
	}

}

interface IF{
	double evaluate(double x);
	
}