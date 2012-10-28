
public class PointInformation {
	private int column_;
	private int rows_;
	private double probability_;
	private float feromon_;
	
	public PointInformation(double probability ,int column, int rows){
		probability_ = probability;
		column_ = column;
		rows_ = rows;
	}
	
	public int getColumn(){
		return column_;
	}
	
	public int getRows(){
		return rows_;
	}
	
	public double getProbability(){
		return probability_;
	}
	
	public float getFeromon(){
		return feromon_;
	}
}
