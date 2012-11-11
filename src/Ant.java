import java.util.Random;


public class Ant {
	private Permutation permutation_;

	public Ant(int numberOfElements, int numberOfValues){
		permutation_ = new Permutation(numberOfElements, numberOfValues);

	}
	public void generatePermutation(CollectionPointInformation cPI){
		Random rand = new Random();
		for(int i = 0; i < permutation_.getNumberOfElements(); i++){
			double randDouble = rand.nextDouble();
			for(int j =0 ; j < permutation_.getNumberOfValues(); j++){
				if(cPI.getPointsInformation(i, j).getProbability() > randDouble){
					//System.out.println("{" + i + ", " + j +"}");
					//System.out.println(cPI.getPointsInformation(i, j).getProbability() + " " + randDouble);
					if(j == 0){
						permutation_.switchValues(i, j);
					}
					else{
						permutation_.switchValues(i, j-1);
					}
					break;
				}

			}

		}


	}
	public Permutation getPermutation(){
		return permutation_;
	}
}
