public class CalculateProbability {

	private Matrix matrix_;
	private CollectionPointInformation cPI_;
	private double alpha_;
	private double betha_;
	private int numberOfElements_;
	private int numberOfValues_;
	private double p_;

	public CalculateProbability(Matrix matrix, CollectionPointInformation cPI, double alpha, double betha,int numberOfElement, int numberOfValues, double p){
		numberOfElements_ = numberOfElement;
		matrix_ = matrix;
		cPI_ = cPI;
		alpha_ = alpha;
		betha_ = betha;
		p_ = p;
		numberOfValues_ = numberOfValues;
	}

	public void calculateProbability(){

		double counter;
		double denominator = 0;
		for (int i = 0; i < numberOfElements_; i++){
			for(int j = 0; j < numberOfValues_; j++){

				for(int z = 0 ; i < numberOfValues_; z++){

					denominator = denominator + (Math.pow(1/matrix_.getValue(i, z),alpha_) * Math.pow(cPI_.getPointsInformation(i, z).getFeromon(),betha_));
				}
				counter = (Math.pow(1/matrix_.getValue(i, j),alpha_) * Math.pow(cPI_.getPointsInformation(i, j).getFeromon(),betha_));
				if(j == 0){
				cPI_.getPointsInformation(i, j).setProbability(counter/denominator);
				}
				else{
					cPI_.getPointsInformation(i, j).setProbability(cPI_.getPointsInformation(i, j-1).getProbability() +  (counter/denominator));
				}
			}
		}
	}

	public void calculateFeromon(){
		for (int i = 0; i < numberOfElements_; i++){
			for(int j = 0; j < numberOfValues_; j++){
				cPI_.getPointsInformation(i, j).setFeromon(((1 - p_)*cPI_.getPointsInformation(i, j).getFeromon()) + 1);



			}
		}
	}
}