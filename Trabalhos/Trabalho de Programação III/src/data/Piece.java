package data;
//import java.util.*;
public class Piece {
	private String strName = new String();
	private String strCarModel = new String();
	private int intInitialYear;
	private int intFinalYear;
	private float floatValue;
	
	public Piece(String name, String car, int yearInitial, int yearFinal, float value){
		this.strName = name;
		this.strCarModel = car;
		this.intInitialYear = yearInitial;
		this.intFinalYear = yearFinal;
		this.floatValue = value;
	}
	public String getName() {
		return strName;
	}
	public void setName(String strName) {
		this.strName = strName;
	}
	public String getCarModel() {
		return strCarModel;
	}
	public void setCarModel(String strCarModel) {
		this.strCarModel = strCarModel;
	}
	public int getInitialYear() {
		//ArrayList<Integer> years = new ArrayList<Integer>();
		//years.add(this.intFinalYear);
		//years.add(this.intInitialYear);
		return this.intInitialYear;
	}
	public int getFinalYear() {
		return this.intFinalYear;
	}
	public void setYear(int initialYear, int finalYear) {
		this.intInitialYear = initialYear;
		this.intFinalYear   = finalYear;
	}
	public float getValue() {
		return floatValue;
	}
	public void setValue(float floatValue) {
		this.floatValue = floatValue;
	}
}
