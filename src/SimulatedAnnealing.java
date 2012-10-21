import java.util.Random;


public class SimulatedAnnealing {
	private Matrix matrix_;
	private Permutation permutation_;
	public SimulatedAnnealing(Matrix matrix, Permutation permutation){
		matrix_ = matrix;
		permutation_ = permutation;
	}
	public float simulatedAnnealing(int temperature, int L){
		int i = 0;
		Random rand = new Random();
		permutation_.genPermutation();
		Permutation permutationPrim = new Permutation(permutation_.getNumberOfElements(), permutation_.getNumberOfValues());
		permutationPrim.genPermutation();
		float difference = 0;
		while(i < L){
			permutationPrim.switchValues();
			difference = MeanValueCalculator.calculate(matrix_, permutationPrim) - MeanValueCalculator.calculate(matrix_, permutation_);
				
			if(difference < 0){
				permutation_.switchPermutation(permutationPrim.getPermutation());
			}
			else{
				double x = rand.nextDouble();
			}
		}
		
	}
	public static void main(String[] args){
		Random rand = new Random();
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextFloat());
	}
	
}
