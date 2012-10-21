
public class MeanValueCalculator {
	
	public static float calculate(Matrix matrix, Permutation permutation){
		float averageValue = 0;
		for(int i = 0; i < permutation.getValuesFromElement().length; i++){
			averageValue += matrix.getValue(i, permutation.getValuesFromElement()[i] );
		}
		return averageValue/permutation.getValuesFromElement().length;
	}
}
