import java.io.FileNotFoundException;
import java.util.LinkedList;


public class TabuSearchAlgorithms implements IOptimizationAlgorithms, IObservable{
	private LinkedList<IObservator> observators_ = new LinkedList<IObservator>();
	private Matrix matrix_;
	private Permutation permutation_;
	private int numberOfIteration_;
	private float bestResult_;
	private int numberTabuList_;

	public TabuSearchAlgorithms(Matrix matrix, Permutation permutation, int numberOfIteration, int numberTabuList){
		matrix_ = matrix;
		permutation_ = permutation;
		numberOfIteration_ = numberOfIteration;
		observators_.add(new NewPermutationObserver());
		observators_.add(new NewResultObserver());
		numberTabuList_ = numberTabuList;
	}

	public void calculate() {
		permutation_.genPermutation();
		GenerationNeighborhood generationNeighborhood = new GenerationNeighborhood( matrix_);
		
		LinkedList<Permutation> tabuList = new LinkedList<Permutation>();
		boolean equals = false;
		Permutation permutationPrim = new Permutation(permutation_.getNumberOfElements(), permutation_.getNumberOfValues());
		permutationPrim.genPermutation();
		while(numberOfIteration_-- > 0){
			permutationPrim.switchPermutation(generationNeighborhood.generateNeighborhood(permutationPrim).getPermutation());
			for(int index = 0 ; index < tabuList.size() ; index++){
				if(permutationPrim.getPermutation().equals(tabuList.get(index).getPermutation())){
					equals= true;
				}
			}
			if(!equals){
				permutation_.switchPermutation(permutationPrim.getPermutation());
				bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
				tabuList.addFirst(permutation_);
				if(numberTabuList_ == tabuList.size()){
					tabuList.removeLast();
				}
				notifyall();
				
			}
			else{
				
				permutation_.switchPermutation(generationNeighborhood.generateNeighborhood(permutation_ ,tabuList).getPermutation());
				bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
				tabuList.addFirst(permutation_);
				if(numberTabuList_ == tabuList.size()){
					tabuList.removeLast();
				}
				notifyall();
				
			}


		}
	}

	public static void main(String[] args) throws FileNotFoundException{
		Matrix matrix  = new Matrix();
		matrix.loadMatrixFromFile("test.txt");
	
		Permutation perm = new Permutation(16, 30);
		TabuSearchAlgorithms t = new TabuSearchAlgorithms(matrix, perm, 17, 10);
		t.calculate();
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

}
