import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sun.accessibility.internal.resources.accessibility;


public class GenerationNeighborhood{

	private static Permutation gen(int alg, int bag, Permutation permutation, LinkedList<Permutation> tabuList, double bestResult, Matrix matrix){
		Permutation permutationPrim = permutation.clone();
		Permutation permutationPrim2 = permutation.clone();
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 30; j++){
				if(permutation.isLegal(alg, bag, i, j) && !permutation.checkPer(j, i)){
					permutationPrim.switchVal(alg, bag, i, j);
					if(MeanValueCalculator.calculate(matrix, permutationPrim) < bestResult){
						permutationPrim2 = permutationPrim.clone();
						bestResult = MeanValueCalculator.calculate(matrix, permutationPrim2);
						permutationPrim = permutation.clone();
					}
					else{
						permutationPrim = permutation.clone();
					}
				}
			}
		}
		return permutationPrim2;
	}

	public static Permutation generateNeighborhood(Permutation permutation, LinkedList<Permutation> tabuList, double bestResult, Matrix matrix){
		Permutation permutationPrim = permutation.clone();
		Permutation permutationPrim2 = permutation.clone();
		for(int i = 0; i < 16; i++){
			if(permutation.getPermutation().get(i).size() < 1){
			}
			else{
				for(int j: permutation.getPermutation().get(i)){
					permutationPrim = gen(i, j, permutation, tabuList, bestResult, matrix);
					if(MeanValueCalculator.calculate(matrix, permutationPrim) < MeanValueCalculator.calculate(matrix, permutationPrim2)){
						permutationPrim2 = permutationPrim.clone();
					}
					else{
						permutationPrim = permutationPrim2.clone();
					}
				}
			}
		}


		return permutationPrim;
	}
}


