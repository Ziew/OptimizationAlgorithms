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
	

}
