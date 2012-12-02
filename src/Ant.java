import java.util.Random;


public class Ant {
	int numberOfPoints = 0;
	private Permutation permutation_;

	public Ant(int numberOfElements, int numberOfValues, int pK){
		permutation_ = new Permutation(numberOfElements, numberOfValues, pK);

	}
	public void generatePermutation(CollectionPointInformation cPI){

		permutation_.genEmptyPermutation();
		for(int z = 0; z < permutation_.getPK(); z++){
			generatePoint(cPI);
		}
		numberOfPoints = 0;
	}
	public void generatePoint(CollectionPointInformation cPI){
		Random rand = new Random();
		double randDouble = rand.nextDouble();
		boolean b = false;
		for(int i = 0; i < 16 && b == false; i++){
			for(int j =0 ; j < 30 && b == false; j++){
			/*	if(permutation_.checkPer(j, i)){
					if(j == 29){
						if(i == 15) break;
						i++;
						j = 0;
					}
					else{
					j++;
					}
				}*/
				if(cPI.getPointsInformation(i, j).getProbability() >= randDouble){
					if(permutation_.isLegal(i, j)){
						permutation_.addPoint(i, j);
						b = true;
						//cPI.updateProbability(i,j,permutation_,numberOfPoints++);
					}
					else{
						b = true;
						generatePoint(cPI);
					}
				}

			}

		}

	}
	public Permutation getPermutation(){
		return permutation_;
	}
}
