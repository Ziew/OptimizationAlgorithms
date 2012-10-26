import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class GenerationNeighborhood{
	private float bestResult_;

	private Matrix matrix_;
	public GenerationNeighborhood( Matrix matrix){
		matrix_ = matrix;
	}

	public Permutation generateNeighborhood(Permutation permutation_){
		bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
		Permutation permutationPrim = new Permutation(permutation_.getNumberOfElements(), permutation_.getNumberOfValues());
		Permutation permutationPrim2 = new Permutation(permutation_.getNumberOfElements(), permutation_.getNumberOfValues());
		for(int i = 0; i < permutation_.getNumberOfElements(); i++){
			for(int j = 0; j < permutation_.getNumberOfValues(); j++){
				if(permutation_.getPermutation().get(i) == j){

				}
				else{

					permutationPrim.switchPermutation(permutation_.getPermutation());
					permutationPrim.switchValues(i, j);
					if(MeanValueCalculator.calculate(matrix_, permutationPrim) < bestResult_){
						permutationPrim2.switchPermutation(permutationPrim.getPermutation());

						bestResult_ = MeanValueCalculator.calculate(matrix_, permutationPrim2);
					}
					permutationPrim.switchPermutation(permutation_.getPermutation());
				}
			}
		}
		permutation_.switchPermutation(permutationPrim2.getPermutation());
		return permutation_;
	}

	public Permutation generateNeighborhood(Permutation permutation_, LinkedList<Permutation> tabuList){
		bestResult_ = MeanValueCalculator.calculate(matrix_, permutation_);
		Permutation permutationPrim = new Permutation(permutation_.getNumberOfElements(), permutation_.getNumberOfValues());
		Permutation permutationPrim2 = new Permutation(permutation_.getNumberOfElements(), permutation_.getNumberOfValues());
		boolean equals = false;
		for(int i = 0; i < permutation_.getNumberOfElements(); i++){
			for(int j = 0; j < permutation_.getNumberOfValues(); j++){
				if(permutation_.getPermutation().get(i) == j){

				}
				else{

					permutationPrim.switchPermutation(permutation_.getPermutation());
					permutationPrim.switchValues(i, j);
					if(MeanValueCalculator.calculate(matrix_, permutationPrim) < bestResult_){
						for(int index = 0 ; index < tabuList.size() ; index++){
							if(permutationPrim.getPermutation().equals(tabuList.get(index).getPermutation())){
								equals= true;
							}


						}
						if(equals == false){
							permutationPrim2.switchPermutation(permutationPrim.getPermutation());

							bestResult_ = MeanValueCalculator.calculate(matrix_, permutationPrim2);
							equals = false;
						}

					}
				}
			}
		}
		permutation_.switchPermutation(permutationPrim2.getPermutation());
		return permutation_;
	}





}


