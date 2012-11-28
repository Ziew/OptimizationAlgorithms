
public class NewPermutationObserver implements IObservator {

	
	public void notif(IOptimizationAlgorithms io) {
		System.out.print("NewPermutationOberserver:");
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < io.getPermutation().getPermutation().get(i).size(); j++)
			System.out.print("{" + i + " " + io.getPermutation().getPermutation().get(i).get(j) + "} ");
		}
		System.out.println();
		
	}

}
