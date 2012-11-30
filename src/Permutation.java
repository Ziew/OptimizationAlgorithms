import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.sun.xml.internal.ws.api.server.Container;


public class Permutation implements Cloneable{
	private Map<Integer,LinkedList<Integer>> permutation_ = new HashMap<Integer, LinkedList<Integer>>(); 
	private Integer numberOfElements_;
	private Integer numberOfValues_;
	private Integer pK_;
	private LinkedList<Integer> tab = new LinkedList<Integer>();;

	public Permutation clone()
	{
		Permutation perm = new Permutation(numberOfElements_, numberOfValues_, pK_);
		for(int i = 0; i < 16; i++){
			perm.permutation_.put(i, new LinkedList<Integer>());
			for(int j = 0; j < permutation_.get(i).size(); j++){
				perm.permutation_.get(i).add(permutation_.get(i).get(j));
			}
		}
		for(int i = 0; i < tab.size(); i++){
			perm.tab.add(tab.get(i));
		}
		return perm;
	} 

	public Permutation(Integer numberOfElements, Integer numberOfValues, Integer pk){
		numberOfElements_ = numberOfElements;
		numberOfValues_ = numberOfValues;
		pK_ = pk;
	}


	public void genPermutation(){
		LinkedList<Integer> tabPrim = new LinkedList<Integer>();
		Random rand = new Random();
		for(int i = 0 ; i < 16 ; i++){
			permutation_.put(i, new LinkedList<Integer>());
		}

		for(int i = 0; i < numberOfElements_; i++){
			int prim = 0;
			for(int j = 0 ; j < 1 ; j++){
				prim = rand.nextInt(16);
				for(int z: tab){
					if(prim == z){
						i--;
					}
				}

			}
			tab.add(prim);
		}

		for(int i = 0 ; i < pK_; i++){
			int bag = rand.nextInt(30);
			int alg = tab.get(rand.nextInt(tab.size()));
			if(permutation_.get(alg).size() >= numberOfValues_ || checkPer(bag, alg)){
				i--;
			}
			else{
				permutation_.get(alg).add(bag);
				boolean onTheTabPrim = false;
				for(int j: tabPrim){
					if(alg == j){
						onTheTabPrim = true;
					}
				}
				if(!onTheTabPrim){
					tabPrim.add(alg);
				}
			}
		}
		tab = tabPrim;
		for(int i = 0; i < 16; i++){


			Collections.sort(permutation_.get(i));

		}

	}

	public void updateTab(int alg, int alg_){
		if(permutation_.get(alg).size() == 0){
			for(int i = 0 ; i < tab.size(); i++){
				if(tab.get(i) == alg){
					tab.remove(i);
				}
			}
		}
		boolean isOnTab = false;
		for(int i = 0 ; i < tab.size(); i++){
			if(tab.get(i) == alg_){
				isOnTab = true;
			}

		}
		if(!isOnTab){
			tab.add(alg_);
		}
	}

	public boolean checkPer(int bag,int alg){

		for(int j: permutation_.get(alg)){
			if(bag == j) {
				return true;
			}
		}
		return false;
	}



	public void switchValues(){
		Random rand = new Random();
		int alg = tab.get(rand.nextInt(tab.size()));
		int bag = permutation_.get(alg).get(rand.nextInt(permutation_.get(alg).size()));
		switchValues2(alg, bag);

	}


	private void switchValues2(int alg, int bag){
		Random rand = new Random();
		int alg_ = rand.nextInt(16);
		int bag_ = rand.nextInt(30);
		if(isLegal(alg, bag, alg_, bag_)){
			permutation_.get(alg_).add(bag_);
			permutation_.get(alg).remove(permutation_.get(alg).indexOf(bag));
			updateTab(alg, alg_);

		}
		else{

			switchValues2(alg, bag);
		}
	}

	public boolean isLegal(int alg, int bag,int alg_, int bag_){

		if(alg == alg_ && bag == bag_){

			return false;

		}
		if(alg == alg_){
			return true;
		}
		if(tab.size() == numberOfElements_){
			if(isOnTab(alg_) && permutation_.get(alg_).size() < numberOfValues_){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			if(permutation_.get(alg_).size() < numberOfValues_){
				return true;
			}
			return false;
		}
	}

public boolean isOnTab(int alg){
	for(int i: tab){
		if(i == alg){
			return true;
		}
	}
	return false;
}


public void switchVal(int alg, int bag, int alg_, int bag_){

	permutation_.get(alg).remove(permutation_.get(alg).indexOf(bag));
	permutation_.get(alg_).add(bag_);
	updateTab(alg, alg_);

	Collections.sort(permutation_.get(alg));
	Collections.sort(permutation_.get(alg_));
}


public Integer getNumberOfElements(){
	return numberOfElements_;
}

public Integer getNumberOfValues(){
	return numberOfValues_;
}

public void switchPermutation(Map<? extends Integer, ? extends LinkedList<Integer>> permutation){
	permutation_.putAll(permutation);
}

public Map<Integer, LinkedList<Integer>> getPermutation(){
	return permutation_;
}
public int getPK(){
	return pK_;
}
public LinkedList<Integer> getTab(){
	return tab;
}



}
