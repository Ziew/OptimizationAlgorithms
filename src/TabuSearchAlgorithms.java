import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


public class TabuSearchAlgorithms implements IOptimizationAlgorithms, IObservable{
	private LinkedList<IObservator> observators_ = new LinkedList<IObservator>();
	private Matrix matrix_;
	private Permutation permutation_;
	private int numberOfIteration_;
	private double bestResult_ =1000000.0;
	private int numberTabuList_;

	public TabuSearchAlgorithms(Matrix matrix, Permutation permutation, int numberOfIteration, int numberTabuList){
		matrix_ = matrix;
		permutation_ = permutation;
		numberOfIteration_ = numberOfIteration;
		observators_.add(new NewPermutationObserver());
		observators_.add(new NewResultObserver());
		numberTabuList_ = numberTabuList;
		permutation_.genPermutation();
		
	}

	public void calculate() {
		LinkedList<Permutation> tabuList = new LinkedList<Permutation>();
	
		bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
		for(int i = 0; i < numberOfIteration_; i++){
			permutation_ = GenerationNeighborhood.generateNeighborhood(permutation_, tabuList, bestResult_, matrix_);
			bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
			notifyall();
			if(tabuList.size() < numberTabuList_){
				tabuList.add(permutation_.clone());
			}
			else{
				tabuList.add(permutation_.clone());
				tabuList.removeFirst();
			}
		}
		try {
			PrintWriter printWriter = new PrintWriter(new File("wyniktabusearch.txt"));
			
			String string = new String();
			for(int z = 0; z < 16; z++){
				for(int j = 0; j < permutation_.getPermutation().get(z).size(); j++)
				string += "{" + z + " " + permutation_.getPermutation().get(z).get(j) + "} ";
			}
			string += " " + bestResult_;
			printWriter.print(string);
			printWriter.close();
		} catch (IOException e) {
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
