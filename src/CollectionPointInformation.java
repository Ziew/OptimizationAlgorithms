import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class CollectionPointInformation {
	private Map<Integer,LinkedList<PointInformation>> pointsInformation = new HashMap<Integer, LinkedList<PointInformation>>();
	
	public CollectionPointInformation(int numberOfElements, int numberOfValues){
		generate(numberOfElements, numberOfValues);
	}
	
	public PointInformation getPointsInformation(int column, int rows){
		return pointsInformation.get(column).get(rows);
	}
	
	private void generate(int numberOfElement, int numberOfValues){
		for(int i = 0 ; i < numberOfElement ; i++){
			pointsInformation.put(i, new LinkedList<PointInformation>());
			for(int j = 0; j < numberOfValues ; j++){
				pointsInformation.get(i).add(new PointInformation(1/numberOfValues, i, j,1));
			}
		}
	}
}
