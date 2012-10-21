
public class NewPermutationObserver implements IObservator {

	
	public void notif(IOptimizationAlgorithms io) {
		System.out.print("NewPermutationOberserver:");
		for(int i = 0; i < io.getPermutation().getNumberOfElements(); i++){
			System.out.print("{" + i + " " + io.getPermutation().getPermutation().get(i) + "} ");
		}
		System.out.println();
		
	}

}
