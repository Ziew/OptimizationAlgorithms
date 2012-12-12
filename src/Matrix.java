import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Matrix {
	private double[][] matrix_ = new double[16][30];

	public void loadMatrixFromFile(String path) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(path));
		for (int row = 0; row < 16; row++){
			for (int column = 0; column < 30; column++){
				matrix_[row][column] = scanner.nextInt();
			}
		}
	}

	public double getValue(int column, int row){

		return matrix_[column][row];

	}
}
