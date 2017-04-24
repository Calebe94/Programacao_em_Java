package data;
public class Car {
	private String strName = new String();
	private String strModel = new String();
	private int intYear;
	
	public Car(String name, String model,int year){
    	this.strName = name;
    	this.strModel = model;
    	this.intYear = year;
    }
	public String getName() {
		return strName;
	}
	public void setName(String strName) {
		this.strName = strName;
	}
	public String getModel() {
		return strModel;
	}
	public void setModel(String strModel) {
		this.strModel = strModel;
	}
	public int getYear() {
		return intYear;
	}
	public void setYear(int intYear) {
		this.intYear = intYear;
	}
}
