
public class PointInformation {
	private int column_;
	private int rows_;
	private double probability_ = 0.0;
	private double feromon_;

	public PointInformation(double probability ,int column, int rows, double feromon){
		if(probability_ > 1 || probability_ < 0)
		{
			System.out.println("WTF??");
		}
		probability_ = probability;
		column_ = column;
		rows_ = rows;
		feromon_ = feromon;
	}

	public PointInformation clone(){
		PointInformation p = new PointInformation(probability_, column_, rows_, feromon_);
		return p;
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
		if(probability < 0){
			System.out.println("Minusowa wartosc, wynosi ona " + probability);
		}else{
			probability_ = probability;
		}
	}

	public void setFeromon(double d){
		feromon_ = d;
	}
}
