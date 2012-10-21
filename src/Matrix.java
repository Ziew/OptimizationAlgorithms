import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Matrix {
	private float[][] matrix_ = new float[16][30];
	
	public void loadMatrixFromFile(String path) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(path));
		for (int row = 0; row < 30; row++){
			for (int column = 0; column < 16; column++){
				matrix_[column][row] = scanner.nextFloat();
			}
		}
	}
	
	public float getValue(int column, int row){
		return matrix_[column][row];
	}
}
