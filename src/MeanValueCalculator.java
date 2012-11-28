
public class MeanValueCalculator {
	
	public static double calculate(Matrix matrix, Permutation permutation){
		float averageValue = 0;
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < permutation.getPermutation().get(i).size(); j++)
			averageValue += matrix.getValue(i, permutation.getPermutation().get(i).get(j) );
		}
		return averageValue/permutation.getPK();
	}
}
