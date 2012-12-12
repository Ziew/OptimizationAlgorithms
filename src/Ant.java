import java.util.Random;


public class Ant {
	private Permutation permutation_;

	public Ant(int numberOfElements, int numberOfValues, int pK){
		permutation_ = new Permutation(numberOfElements, numberOfValues, pK);
	}

	public void generatePermutation(CollectionPointInformation cPI){
		permutation_.genEmptyPermutation();
		for(int z = 0; z < permutation_.getPK(); z++){
			int[] point = new int[2];
			do{
				point = generatePoint(cPI);
				
			}while(!permutation_.isLegal(point[0], point[1]));
			permutation_.addPoint(point[0], point[1]);
			cPI.updateProbability(point[0], point[1],permutation_);
		}
	}

	public int[] generatePoint(CollectionPointInformation cPI){
		int[] point = new int[2];
		Random rand = new Random();
		double randDouble = rand.nextDouble();
		for(int i = 0; i < 16; i++){
			for(int j =0 ; j < 30; j++){
				if(permutation_.checkPer(j, i))
				{
					if(i==15 & j == 29){
						generatePoint(cPI);
					}
					continue;
				}
				if(cPI.getPointsInformation(i, j).getProbability() >= randDouble){
					point[0] = i;
					point[1] = j;
					return point;
				}
			}
		}
		return point;
	}

	public Permutation getPermutation(){
		return permutation_;
	}
}
