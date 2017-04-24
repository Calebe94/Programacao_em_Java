package controller;
import data.*;
import java.util.*;
public class Pieces {
	private ArrayList<Piece> PiecesRegistred;
	private ArrayList<Piece> PiecesSelected;
	public Pieces(ArrayList<Piece> registred){
		this.PiecesRegistred = new ArrayList<Piece>();
		this.PiecesSelected  = new ArrayList<Piece>();
		this.PiecesRegistred = registred;
	}
	public ArrayList<Piece> getPiecesRegistred() {
		return PiecesRegistred;
	}
	public void setPiecesRegistred(ArrayList<Piece> piecesRegistred) {
		PiecesRegistred = piecesRegistred;
	}
	public ArrayList<Piece> getPiecesSelected() {
		return PiecesSelected;
	}
	public void setPiecesSelected(Car car) {
		String carModel;
		Piece aux;
		carModel = car.getModel();
		
		for(int index = 0; index < this.PiecesRegistred.size();index++){
			aux = this.PiecesRegistred.get(index);
			if(aux.getCarModel() == carModel){
				this.PiecesSelected.add(aux);
			}
		}
	}
}
