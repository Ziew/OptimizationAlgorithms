import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class CollectionPointInformation {
	private LinkedList<PointInformation> pI = new LinkedList<PointInformation>();

	public CollectionPointInformation(){
		generate();
	}

	public PointInformation getPointsInformation(int column, int rows){

		return pI.get(column*30+rows);

	}

	private void generate(){
		double d = 1.0;
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 30; j++){
				pI.add(new PointInformation(d++ *(1.0/480.0), i, j, 0.1));
			}
		}
	}

	

	public void updateProbability(int a, int b, Permutation perm,int z) {
		double prob = getPointsInformation(a, b).getProbability();
		getPointsInformation(a, b).setProbability(0);
		for(int i = 0; i < 16; i ++){
			for(int j = 0; j < 30; j++){
				if(perm.checkPer(j, i)){
				}
				else{
					getPointsInformation(i, j).setProbability(getPointsInformation(i, j).getProbability() + prob/(480-z));
				}
			}
		}
		
	}
	
}
