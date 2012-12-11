import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class CollectionPointInformation {
	private LinkedList<PointInformation> pI = new LinkedList<PointInformation>();
	private int g;
	private int h;

	public CollectionPointInformation(){
		generate();
	}

	public PointInformation getPointsInformation(int column, int rows){
		return pI.get(column*30+rows);
	}

	public void generate(){
		pI.clear();
		double d = 1.0;
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 30; j++){
				pI.add(new PointInformation( (d++) *(1.0/480.0), i, j, 0.1));
			}
		}
	}
	public CollectionPointInformation clone(){
		CollectionPointInformation c = new CollectionPointInformation();
		c.pI.clear();
		for(int i = 0; i < pI.size(); i++){
			c.pI.add(pI.get(i).clone());
		}
		return c;
	}

	public void updateProbability(int a, int b, Permutation perm) {

		double prob = getProbabilityFromPoint(a, b);
		CollectionPointInformation cPI = this.clone();
		cPI.getPointsInformation(a, b).setProbability(0);

		for(int i = 0; i < 16; i ++){
			for(int j = 0; j < 30; j++){
				if(!perm.checkPer(j, i)){
					setProbability(i, j, prob, cPI);
					cPI.g = i;
					cPI.h = j;
				}
			}
		}
		pI.clear();
		for(int i = 0; i < cPI.pI.size(); i++){
			pI.add(cPI.pI.get(i).clone());
		}
	}



	private double getProbabilityFromPoint(int a, int b){
		int x = a; 
		int y = b;
		double prob = getPointsInformation(x, y).getProbability();

		if(x == 0 && y == 0){
			return prob;
		}
		if(y == 0){
			x--; y = 29;
		}
		else{
			y--;
		}
		while(getPointsInformation(x, y).getProbability() == 0){
			if(x == 0 && y == 0){
				break;
			}
			if( y == 0){
				x--; y = 29;
			}
			else{
				y--;
			}
		}
		prob = prob - getPointsInformation(x, y).getProbability();
		return prob;
	}

	private void setProbability(int i, int j, double prob, CollectionPointInformation cPI){

		if(i == 0 && j == 0){
			cPI.getPointsInformation(i, j).setProbability(getPointsInformation(i, j).getProbability()+ (prob*getPointsInformation(i, j).getProbability()/(1.0-prob)));
		}
		else{

			cPI.getPointsInformation(i, j).setProbability(getProbabilityFromPoint(i, j) +(prob*getProbabilityFromPoint(i, j)/(1.0-prob)) + cPI.getPointsInformation(cPI.g, cPI.h).getProbability());
		}
	}
}
