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
	private double bestResult_;
	private Matrix matrix_;
	private int pK_;

	public AntColonyOptimizationAlgorithms(int pK ,int numberOfElements, int numberOfValues, int numberOfAnts,double p, int numberOfIteration, Matrix matrix,  double betha ){
		numberOfElements_ = numberOfElements;
		numberOfValues_ = numberOfValues;
		cPI_ = new CollectionPointInformation();
		numberOfAnts_= numberOfAnts;
		matrix_ = matrix;
		numberOfIteration_ = numberOfIteration;
		cPF_ = new CalculateProbabilityFeromon(matrix_, cPI_, betha, p );
		observators_.add(new NewPermutationObserver());
		observators_.add(new NewResultObserver());
		pK_ = pK;
		permutation_ = new Permutation(numberOfElements, numberOfValues, pK);

	}

	public void calculate() {
		for(int i = 0 ; i < numberOfAnts_ ; i++){
			ants_.add(new Ant(numberOfElements_, numberOfValues_, pK_));
		}
		for(int j = 0; j < numberOfIteration_ ; j++){
			for(int i = 0; i < numberOfAnts_; i++){
				ants_.get(i).generatePermutation(cPI_);
				cPF_.calculateProbability();
				permutation_ = ants_.get(i).getPermutation().clone();
				bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
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


	public double getBestResult() {

		return bestResult_;
	}




	public void notifyall() {
		for(IObservator o : observators_){
			o.notif(this);
		}

	}




}
