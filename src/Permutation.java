import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Permutation {
	private Map<Integer,Integer> permutation_ = new HashMap<Integer, Integer>(); 
	private Integer numberOfElements_;
	private Integer numberOfValues_;


	public Permutation(Integer numberOfElements, Integer numberOfValues){
		numberOfElements_ = numberOfElements;
		numberOfValues_ = numberOfValues;
	}

	public void genPermutation(){
		for(int i = 0 ; i < numberOfElements_; i++){
			permutation_.put(i, 0);
		}
	}

	public void switchValues(){
		Random rand = new Random();
		int x = rand.nextInt(numberOfElements_);
		int y = rand.nextInt(numberOfValues_);
		while(permutation_.get(x) == y){
			x = rand.nextInt(numberOfElements_);
			y = rand.nextInt(numberOfValues_);
		}
		permutation_.put(x, y);

	}
	
	public void switchValues(int i, int j){
		permutation_.put(i, j);

	}
	
	
	public int[] getValuesFromElement(){
		int[] values = new int[getNumberOfElements()];
		for(int i = 0; i < values.length ; i++){
			try{
			values[i] = permutation_.get(i);
			}
			catch(Exception e){
				System.out.println(i);
			}
		}
		return values;
	}

	public Integer getNumberOfElements(){
		return numberOfElements_;
	}

	public Integer getNumberOfValues(){
		return numberOfValues_;
	}
	
	public void switchPermutation(Map<Integer,Integer> permutation){
		permutation_.putAll(permutation);
	}
	
	public Map<Integer, Integer> getPermutation(){
		return permutation_;
	}

}
