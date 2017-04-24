package controller;

import data.*;
import java.util.*;

public class Register {
	private ArrayList<Car> carRegister;
	private ArrayList<Service> serviceRegister;
	private ArrayList<Piece> pieceRegister;
	public Register(){
		this.carRegister 	 = new ArrayList<Car>();
		this.serviceRegister = new ArrayList<Service>();
		this.pieceRegister   = new ArrayList<Piece>();
	}
	public void car(String name, String model, int year){
		this.carRegister.add(new Car(name, model, year));
	}
	public void service(String name, double value){
		this.serviceRegister.add(new Service(name, value));
	}
	public void piece(String name, String model, int yearInitial, int yearFinal,float value){
		this.pieceRegister.add(new Piece(name, model, yearInitial, yearFinal, value));
	}
	public ArrayList<Car> getCarsRegistred(){
		return this.carRegister;
	}
	public ArrayList<Service> getServicesRegistred(){
		return this.serviceRegister;
	}
	public ArrayList<Piece> getPiecesRegistred(){
		return this.pieceRegister;
	}
	
	public int getPieceRegistredSize(){
		return this.pieceRegister.size();
	}
	public String getPieceRegistredName(int index){
		return this.pieceRegister.get(index).getName();
	}
	public String getPieceRegistredModel(int index){
		return this.pieceRegister.get(index).getCarModel();
	}
	public int getServicesRegistredSize(){
		return this.serviceRegister.size();
	}
	public String getServiceRegistredName(int index){
		return this.serviceRegister.get(index).getServiceName();
	}
	public int getCarsRegistredSize(){
		return this.carRegister.size();
	}
	public String getCarsRegistredName(int index){
		return this.carRegister.get(index).getName();
	}
}
