package view;

import data.*;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
public class Estimate {
	private float totalValue;
	private JFrame frame;
	private JTable ServicesTable;
	private JTable PiecesTable;
	private JTable SelectedServicesTable;
	private JTable PiecesSelectedTable;
	private JLabel TotalValueLabel;
	Persistence arquivo;

	Register services;
	Register cars;
	Register pieces;
	
	private void initData(){
		arquivo = new Persistence();
		services = arquivo.import_services();
		cars     = arquivo.import_cars();
		pieces   = arquivo.import_pieces();
	}
	
	public Estimate() {
		initData();
		initialize();
	}
	
	private void MainFrame(){
		setFrame(new JFrame("Orçamentos"));
		getFrame().setBounds(100, 100, 1024, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
	}
	
	private void setValue(int value){
		this.totalValue = value;
	}
	private float getValue(){
		return this.totalValue;
	}
	private void CarSelectComboBox(){
		JLabel SelectCarLabel = new JLabel("Selecione Um Carro:");
		SelectCarLabel.setBounds(12, 12, 160, 38);
		getFrame().getContentPane().add(SelectCarLabel);
		ArrayList<Car> ArrayCar = this.cars.getCarsRegistred();

		String[] CarrosString = new String[ArrayCar.size()];
		for(int index = 0 ; index < ArrayCar.size(); index++){
			CarrosString[index] = ArrayCar.get(index).getName();
		}
		JComboBox<String> comboBox = new JComboBox<String>(CarrosString);
		//JComboBox comboBox = new JComboBox(CarrosString);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				System.out.println("Item Selecionado:"+CarrosString[index]);
				setValue(index);
				System.out.println("Valor Total:"+getValue());
				updateTotalValue();
			}
		});
		comboBox.setBounds(12, 73, 160, 35);
		getFrame().getContentPane().add(comboBox);
	}
	
	private void ButtonCarRegister(){
		JButton CarRegisterButton = new JButton("Cadastrar Carro");
		CarRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CarRegister window = new CarRegister();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		CarRegisterButton.setBounds(12, 133, 160, 25);
		getFrame().getContentPane().add(CarRegisterButton);
	}
	
	private void ButtonServiceRegister(){
		JButton ServiceRegisterButton = new JButton("Cadastrar Serviço");
		ServiceRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ServiceRegister window = new ServiceRegister();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		ServiceRegisterButton.setBounds(12, 180, 160, 25);
		getFrame().getContentPane().add(ServiceRegisterButton);
	}
	
	private void ButtonPieceRegister(){
		JButton PieceRegisterButton = new JButton("Cadastrar Peça");
		PieceRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PieceRegister window = new PieceRegister();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		PieceRegisterButton.setBounds(12, 227, 160, 25);
		getFrame().getContentPane().add(PieceRegisterButton);
	}
	
	private void TableServices(){
		String[] column = {"Serviços","Valor por Hora"};
		String[][] line = {{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"}
		,{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"}};
		JScrollPane ServicesPane = new JScrollPane();


		ServicesPane.setBounds(194, 71, 283, 134);
		getFrame().getContentPane().add(ServicesPane);
		
		ServicesTable = new JTable(line,column);
		ServicesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Item Selecionado em Serviços:"+ServicesTable.getSelectedRow());
			}
		});
		ServicesPane.setViewportView(ServicesTable);
	}
	
	private void TableSelectedServices(){
		JScrollPane SelectedServicesPane = new JScrollPane();
		SelectedServicesPane.setBounds(194, 343, 283, 148);
		getFrame().getContentPane().add(SelectedServicesPane);
		

		String[] column2 = {"Serviço Selecionado","Valor por Hora"};
		String[][] line2 = {{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"}
		,{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"},{"Lanterna","32.00"}};

		SelectedServicesTable = new JTable(line2,column2);
		SelectedServicesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		SelectedServicesPane.setViewportView(SelectedServicesTable);
	}
	
	private void TablePieces(){
		JScrollPane PiecesPane = new JScrollPane();
		PiecesPane.setBounds(504, 71, 485, 134);
		getFrame().getContentPane().add(PiecesPane);
		
		
		String[] column1 = {"Peça","Modelo","Ano","Valor"};
		String[][] line1 = {{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"}};
		
		PiecesTable = new JTable(line1,column1);
		PiecesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		PiecesPane.setViewportView(PiecesTable);
		
	}
	
	private void TableSelectedPieces(){
		String[] column3 = {"Peça Selecionada","Modelo","Ano","Valor"};
		String[][] line3 = {{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},
				{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"},{"Lanterna","VW FOX","2014-2017","32.00"}};
		
		
		
		JScrollPane PiecesSelectedPane = new JScrollPane();
		PiecesSelectedPane.setBounds(504, 343, 485, 148);
		getFrame().getContentPane().add(PiecesSelectedPane);
		
		PiecesSelectedTable = new JTable(line3,column3);
		PiecesSelectedTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		PiecesSelectedPane.setViewportView(PiecesSelectedTable);
	}
	
	private void ButtonUnselectServices(){
		JButton UnselectServicesButton = new JButton("-");
		UnselectServicesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UnselectServicesButton.setBounds(284, 269, 49, 38);
		getFrame().getContentPane().add(UnselectServicesButton);
	}
	
	private void ButtonSelectServices(){
		JButton SelectServicesButton = new JButton("+");
		SelectServicesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		SelectServicesButton.setBounds(328, 269, 49, 38);
		getFrame().getContentPane().add(SelectServicesButton);
	}
	
	private void ButtonUnselectPieces(){
		JButton UnselectPiecesButton = new JButton("-");
		UnselectPiecesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UnselectPiecesButton.setBounds(674, 269, 49, 38);
		getFrame().getContentPane().add(UnselectPiecesButton);
	}
	
	private void ButtonSelectPieces(){
		JButton SelectPiecesButton = new JButton("+");
		SelectPiecesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SelectPiecesButton.setBounds(722, 269, 49, 38);
		getFrame().getContentPane().add(SelectPiecesButton);
	}
	
	private void LabelTotalValue(){
		String TotalValueString = "Valor Total do Orçamento:       R$"+getValue();
		TotalValueLabel = new JLabel(TotalValueString);
		TotalValueLabel.setBounds(504, 528, 485, 15);
		getFrame().getContentPane().add(TotalValueLabel);
	}
	
	private void updateTotalValue(){
		String TotalValueString = "Valor Total do Orçamento:       R$"+getValue();
		this.TotalValueLabel.setText(TotalValueString);
	}
	
	private void initialize() {
		
		MainFrame();
		
		CarSelectComboBox();
		
		ButtonCarRegister();
		
		ButtonServiceRegister();
		
		ButtonPieceRegister();
		
		TableServices();	
		
		TableSelectedServices();
		
		TablePieces();
		
		TableSelectedPieces();
		
		ButtonUnselectServices();
		
		ButtonSelectServices();
		
		ButtonUnselectPieces();
		
		ButtonSelectPieces();
		
		LabelTotalValue();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Fechou a Janela");
			}
		});
	}
}
