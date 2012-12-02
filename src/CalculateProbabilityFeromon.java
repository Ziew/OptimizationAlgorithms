
public class CalculateProbabilityFeromon {

	private Matrix matrix_;
	private CollectionPointInformation cPI_;
	private double betha_;
	private double p_;

	public CalculateProbabilityFeromon(Matrix matrix, CollectionPointInformation cPI, double betha, double p){
		matrix_ = matrix;
		cPI_ = cPI;
		betha_ = betha;
		p_ = p;
	}

	public void calculateProbability(){
		double denominator = 0;
		for(int i = 0; i < 16; i++){
			for(int j = 0 ; j < 30 ; j++){
				denominator = denominator + (Math.pow(cPI_.getPointsInformation(i, j).getFeromon(),betha_));
			}
		}

		double counter;
		for(int i = 0; i < 16; i++){
			for(int j = 0 ; j < 30 ; j++){
				counter = ( Math.pow(cPI_.getPointsInformation(i, j).getFeromon(),betha_));
				if(i == 0 && j == 0){
					cPI_.getPointsInformation(i, j).setProbability(counter/denominator);
				}
				else{

					cPI_.getPointsInformation(i, j).setProbability(cPI_.getPointsInformation(i, j-1).getProbability() +  (counter/denominator));
				}
			}
		}
	}

	public void calculateFeromon(Ant ant){
		boolean bo = false;
		for (int i = 0; i < 16; i++){
			for(int j = 0; j < 30 ; j++){
				for(int z :ant.getPermutation().getPermutation().get(i)){
					if(j == z){
						bo = true;
					}
				}
				if(bo){
					int b = ant.getPermutation().getPermutation().get(i).get(ant.getPermutation().getPermutation().get(i).indexOf(j));
					cPI_.getPointsInformation(i, b).setFeromon(((1 - p_)*cPI_.getPointsInformation(i, b).getFeromon() + (1.0/(double)matrix_.getValue(i, b))));
					bo = false;
				}
				else{
					cPI_.getPointsInformation(i, j).setFeromon((1 - p_)*cPI_.getPointsInformation(i, j).getFeromon());
				}
			}
		}
	}
}

