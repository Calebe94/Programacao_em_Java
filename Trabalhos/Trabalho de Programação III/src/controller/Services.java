package controller;

import data.*;
import java.util.*;

public class Services {
	private ArrayList<Service> serviceRegistred;
	private ArrayList<Service> serviceSelected;
	
	public Services(ArrayList<Service> registred){
		this.serviceRegistred = new ArrayList<>();
		this.serviceSelected  = new ArrayList<>();
		this.serviceRegistred = registred;
	}

	public ArrayList<Service> getServiceRegistred() {
		return serviceRegistred;
	}

	public void setServiceRegistred(ArrayList<Service> serviceRegistred) {
		this.serviceRegistred = serviceRegistred;
	}

	public ArrayList<Service> getServiceSelected() {
		return serviceSelected;
	}

	public void setServiceSelected(Service serviceSelected) {
		this.serviceSelected.add(serviceSelected);
	}
	
}
