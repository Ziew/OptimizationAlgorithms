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
			int j = 0;
			while(randDouble < cPI.getPointsInformation(i, j).getProbability()){
				j++;
			}
			permutation_.switchValues(i, j);
			
		}
	

	}
	public Permutation getPermutation(){
		return permutation_;
	}
}
