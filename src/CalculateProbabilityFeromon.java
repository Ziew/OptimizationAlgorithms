
public class CalculateProbabilityFeromon {

	private Matrix matrix_;
	private CollectionPointInformation cPI_;
	private double alpha_;
	private double betha_;
	private int numberOfElements_;
	private int numberOfValues_;
	private double p_;

	public CalculateProbabilityFeromon(Matrix matrix, CollectionPointInformation cPI, double alpha, double betha,int numberOfElement, int numberOfValues, double p){
		numberOfElements_ = numberOfElement;
		matrix_ = matrix;
		cPI_ = cPI;
		alpha_ = alpha;
		betha_ = betha;
		p_ = p;
		numberOfValues_ = numberOfValues;
	}

	public void calculateProbability(){


		for (int i = 0; i < numberOfElements_; i++){
			double denominator = 0;

			for(int z = 0 ; z < numberOfValues_; z++){
				denominator += (Math.pow(cPI_.getPointsInformation(i, z).getFeromon(),betha_));

			}
			for(int j = 0; j < numberOfValues_; j++){
				double counter;



				counter = ( Math.pow(cPI_.getPointsInformation(i, j).getFeromon(),betha_));

				if(j == 0){

					cPI_.getPointsInformation(i, j).setProbability(counter/denominator);

				}
				else{

					cPI_.getPointsInformation(i, j).setProbability(cPI_.getPointsInformation(i, j-1).getProbability() +  (counter/denominator));

				}
			}
		}
	}

	public void calculateFeromon(Ant ant){
		for (int i = 0; i < numberOfElements_; i++){
			for(int j = 0; j < numberOfValues_ ; j++){
				if(j == ant.getPermutation().getPermutation().get(i)){
					cPI_.getPointsInformation(i, ant.getPermutation().getPermutation().get(i)).setFeromon(((1 - p_)*cPI_.getPointsInformation(i, ant.getPermutation().getPermutation().get(i)).getFeromon()) + 1.0/(double)matrix_.getValue(i, ant.getPermutation().getPermutation().get(i)));
				}
				else{
					cPI_.getPointsInformation(i, j).setFeromon((1 - p_)*cPI_.getPointsInformation(i, j).getFeromon());
				}
			}



		}
	}
}
