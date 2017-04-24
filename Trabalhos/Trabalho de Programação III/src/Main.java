/* Ideia:
 * Estou Criando 2 pacotes, 1 contem os dados dos carros, serviços e de peças. E o outro pacote irá conter funções de manipulação de arquivos
 * e etc, ou seja, um Pacote de controle dos dados.
 * Para facilitar, vou adicionar um método nesse ultimo pacote para que eu possa adicionar os carros em lista para facilitar na hora de exportar;
 * Ou, indicarei cada carro com um ID. ( Mas isso não surtirá efeito algum na hora de importar/exportar)
 *
 * 
 * */
import view.*;
//import java.util.ArrayList;
import java.awt.EventQueue;
//import java.text.DecimalFormat;
//import controller.*;
//import data.*;
public class Main{

	public static void main(String[] args) {
		//JFrame frame;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estimate window = new Estimate();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("FINAL !");
				}
			}
		});
		/*
		Persistence arquivo = new Persistence();

		Register services = arquivo.import_services();
		Register cars     = arquivo.import_cars();
		//Register pieces   = arquivo.import_pieces();

		int limit = services.getServicesRegistred().size();
		for (int index = 0; index < limit;index++){
			ArrayList<Service> aux = services.getServicesRegistred();
			String name = aux.get(index).getServiceName();
			double value = aux.get(index).getValuePerHour();
			DecimalFormat valuePrice = new DecimalFormat();
			valuePrice.setMaximumFractionDigits(3);
			System.out.println(name+"\t:\t"+valuePrice.format(value));
		}
		
		limit = cars.getCarsRegistred().size();
		for (int index = 0; index < limit;index++){
			ArrayList<Car> aux = cars.getCarsRegistred();
			String name  = aux.get(index).getName();
			String model = aux.get(index).getModel();
			int year     = aux.get(index).getYear();
			System.out.println(name+"\t:\t"+model+"\t:\t"+year);
		}
	*/	
	}
}
