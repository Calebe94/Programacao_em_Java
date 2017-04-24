package data;

public class Service {
	private String strServiceName = new String();
	private double floatValuePerHour;
	public Service(String service, double value){
		this.strServiceName = service;
		this.floatValuePerHour = value;
	}
	public String getServiceName() {
		return strServiceName;
	}
	public void setServiceName(String strServiceName) {
		this.strServiceName = strServiceName;
	}
	public double getValuePerHour() {
		return floatValuePerHour;
	}
	public void setValuePerHour(float floatValuePerHour) {
		this.floatValuePerHour = floatValuePerHour;
	}
}
