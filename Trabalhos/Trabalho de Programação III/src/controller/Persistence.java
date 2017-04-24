package controller;

import java.io.File;

import data.*;
import java.io.File;
//import controller.*;
import java.util.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class Persistence {
	private static final String fileServices = "/home/calebe/workspace_neon/Trabalho/Services.md";
	private static final String fileCars     = "/home/calebe/workspace_neon/Trabalho/Cars.md";
	private static final String filePieces   = "/home/calebe/workspace_neon/Trabalho/Pieces.md";
	
	//private Cars cars;
	//private Services services;
	//private Pieces   pieces;
	private Register cars;
	private Register pieces;
	private Register services;
	
	private Scanner service_import_file;
	private Scanner car_import_file;
	private Scanner pieces_import_file;
	
	private PrintWriter service_export_file; 
	private PrintWriter car_export_file;
	private PrintWriter pieces_export_file;
	
	
	public Persistence(){
		this.cars     = new Register();
		this.pieces   = new Register();
		this.services = new Register();
	}
	
	public Register getCars() {
		return this.cars;
	}

	public void setCars(Register car) {
		this.cars = car;
	}

	public Register getPieces() {
		return this.pieces;
	}

	public void setPieces(Register pieces) {
		this.pieces = pieces;
	}

	public Register getServices() {
		return this.services;
	}

	public void setServices(Register services) {
		this.services = services;
	}
	public void Import(){
		this.cars     = this.import_cars();
		this.services = this.import_services();
	}
	
	public void export_services(Register services){
		try{
			this.service_export_file = new PrintWriter(this.getfileServices());
		}
		catch(Exception e){
			
		}
		int index = 0,limit = services.getServicesRegistred().size();
		for (index = 0; index < limit;index++){
			ArrayList<Service> aux = services.getServicesRegistred();
			String name = aux.get(index).getServiceName();
			double value = aux.get(index).getValuePerHour();
			this.service_export_file.println(name+":"+value);
		}
		this.service_export_file.close();
	}
	
	public void export_cars(Register cars){
		try{
			this.car_export_file = new PrintWriter(this.getfileCars());
		}
		catch(Exception e){
			
		}
		int index = 0,limit = cars.getCarsRegistred().size();
		for (index = 0; index < limit;index++){
			ArrayList<Car> aux = cars.getCarsRegistred();
			
			String name  = aux.get(index).getName();
			String model = aux.get(index).getModel();
			int year = aux.get(index).getYear();
			this.car_export_file.println(name+":"+model+":"+year);
		}
		this.car_export_file.close();
	}
	
	public void export_pieces(Register pieces){
		try{
			this.pieces_export_file = new PrintWriter(this.getfilePieces());
		}
		catch(Exception e){
			
		}
		int index = 0,limit = pieces.getCarsRegistred().size();
		for (index = 0; index < limit;index++){
			ArrayList<Piece> aux = pieces.getPiecesRegistred();
			String model = aux.get(index).getCarModel();
			String name  = aux.get(index).getName();
			Float value  = aux.get(index).getValue();
			int initial  = aux.get(index).getInitialYear();
			int _final    = aux.get(index).getFinalYear();
			this.pieces_export_file.println(name+":"+model+":"+initial+":"+_final+":"+value);
		}
		this.car_export_file.close();
	}
	
	public Register import_services(){
		Register aux = new Register();
		try{
			this.service_import_file = new Scanner(new File(this.getfileServices()));
		}
		catch(Exception e){
		}
		while(this.service_import_file.hasNext() == true){
			String readData = this.service_import_file.nextLine();
			String[] values = readData.split(":");
			aux.service(values[0],Float.parseFloat(values[1]));
		}
		this.service_import_file.close();
		//this.services = aux;
		return aux;
	}
	
	public Register import_cars(){
		Register aux = new Register();
		try{
			this.car_import_file = new Scanner(new File(this.getfileCars()));
		}
		catch(Exception e){
		}
		while(this.car_import_file.hasNext() == true){
			String readData = this.car_import_file.nextLine();
			String[] values = readData.split(":");
			aux.car(values[0], values[1], Integer.parseInt(values[2]));
		}
		this.service_import_file.close();
		//this.cars = aux;
		return aux;
	}

	public Register import_pieces(){
		Register aux = new Register();
		try{
			this.pieces_import_file = new Scanner(new File(this.getfilePieces()));
		}
		catch(Exception e){
			System.out.println("Arquivo:"+this.getfilePieces()+" Não Existe!");
		}
		while(this.pieces_import_file.hasNext() == true){
			String readData = this.pieces_import_file.nextLine();
			String[] values = readData.split(":");
			//aux.car(values[0], values[1], Integer.parseInt(values[2]));
			aux.piece(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Float.parseFloat(values[4]));
		}
		this.service_import_file.close();
		//this.pieces = aux;
		return aux;
	}

	private String getfileServices() {
		return fileServices;
	}
	private String getfilePieces() {
		return filePieces;
	}
	private String getfileCars() {
		return fileCars;
	}
}
