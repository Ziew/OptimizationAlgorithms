
public class PointInformation {
	private int column_;
	private int rows_;
	private double probability_;
	private double feromon_;
	
	public PointInformation(double probability ,int column, int rows, double feromon){
		probability_ = probability;
		column_ = column;
		rows_ = rows;
		feromon_ = feromon;
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
	
	public double getFeromon(){
		return feromon_;
	}
	
	public void setProbability(double probability){
		probability_ = probability;
	}
	
	public void setFeromon(double d){
		feromon_ = d;
	}
}
