import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;


public class SimulatedAnnealing implements IOptimizationAlgorithms, IObservable {
	private LinkedList<IObservator> observators_ = new LinkedList<IObservator>();
	private Matrix matrix_;
	private Permutation permutation_;
	private double temperature_;
	private double n_;
	private int numberOfIteration_;
	private double bestResult_;
	
	public SimulatedAnnealing(Matrix matrix, Permutation permutation,double temperature, int numberOfIteration, double n){
		matrix_ = matrix;
		permutation_ = permutation;
		temperature_ = temperature;
		n_ = n;
		numberOfIteration_ = numberOfIteration;
		observators_.add(new NewPermutationObserver());
		observators_.add(new NewResultObserver());
		
	}
	public void calculate(){
		
		int i = 0;
		Random rand = new Random();
		permutation_.genPermutation();
		Permutation permutationPrim = permutation_.clone();
		
		double difference = 0.0;
		while(i++ < numberOfIteration_){
			permutationPrim.switchValues();
			
			difference = MeanValueCalculator.calculate(matrix_, permutationPrim) - MeanValueCalculator.calculate(matrix_, permutation_);
				System.out.println(difference);
			if(difference < 0){
				permutation_ = permutationPrim.clone();
				bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
				notifyall();
			}
			else{
				double x = rand.nextFloat();
				
				if(x < Math.exp(-(difference/temperature_))){
					System.out.println(Math.exp(-(difference/temperature_))+ "         " + x);
				permutation_ = permutationPrim.clone();
					bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
					notifyall();
				}
			}
			temperature_ = n_*temperature_;
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Matrix matrix = new Matrix();
		matrix.loadMatrixFromFile("test.txt");
		Permutation perm = new Permutation(5, 4, 10);
		
		SimulatedAnnealing s = new SimulatedAnnealing(matrix, perm, 1000, 2000, 0.9);
		s.calculate();
		
		
	}
	
	
	
	
	public Permutation getPermutation() {
		return permutation_;
	}
	
	public double getBestResult() {
		return bestResult_;
	}

	public void notifyall() {
		for(IObservator o : observators_){
			o.notif(this);
		}
		
	}

}
