import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class AntColonyOptimizationAlgorithms implements IOptimizationAlgorithms, IObservable {

	private LinkedList<IObservator> observators_ = new LinkedList<IObservator>();
	private LinkedList<Ant> ants_ = new LinkedList<Ant>();
	private CollectionPointInformation cPI_;
	private int numberOfElements_;
	private int numberOfValues_;
	private int numberOfAnts_;
	private Permutation permutation_;
	private int numberOfIteration_;
	private CalculateProbabilityFeromon cPF_;
	private float bestResult_;
	private Matrix matrix_;

	public AntColonyOptimizationAlgorithms(int numberOfElements, int numberOfValues, int numberOfAnts,double p, int numberOfIteration, Matrix matrix,  double betha ){
		numberOfElements_ = numberOfElements;
		numberOfValues_ = numberOfValues;
		cPI_ = new CollectionPointInformation(numberOfElements, numberOfValues);
		numberOfAnts_= numberOfAnts;
		matrix_ = matrix;
		numberOfIteration_ = numberOfIteration;
		cPF_ = new CalculateProbabilityFeromon(matrix_, cPI_, betha, numberOfElements_, numberOfValues_, p );
		observators_.add(new NewPermutationObserver());
		observators_.add(new NewResultObserver());
		
		permutation_ = new Permutation(numberOfElements, numberOfValues);

	}

	public void calculate() {
		for(int i = 0 ; i < numberOfAnts_ ; i++){
			ants_.add(new Ant(numberOfElements_, numberOfValues_));
		}
		for(int j = 0; j < numberOfIteration_ ; j++){
			for(int i = 0; i < numberOfAnts_; i++){
				ants_.get(i).generatePermutation(cPI_);
				permutation_.switchPermutation(ants_.get(i).getPermutation().getPermutation());
				System.out.println(i+1  + " mrowka");
				bestResult_ = MeanValueCalculator.calculate(matrix_, ants_.get(i).getPermutation());
				notifyall();
				
			}
			for(int z = 0 ; z < numberOfAnts_; z++){
			cPF_.calculateFeromon(ants_.get(z));
			}
			cPF_.calculateProbability();
			
		}
	}


	public Permutation getPermutation() {

		return permutation_;
	}


	public float getBestResult() {

		return bestResult_;
	}
	
	


	public void notifyall() {
		for(IObservator o : observators_){
			o.notif(this);
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		Matrix matrix = new Matrix();
		matrix.loadMatrixFromFile("test.txt");
		AntColonyOptimizationAlgorithms a = new AntColonyOptimizationAlgorithms(16, 30, 1000, 0.003, 75, matrix, 1.0);
		a.calculate();
	}


}
