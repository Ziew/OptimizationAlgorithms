
public class NewResultObserver implements IObservator {

	
	public void notif(IOptimizationAlgorithms io) {
		System.out.println("NewResultObserver: " + io.getBestResult());
		
	}

}
