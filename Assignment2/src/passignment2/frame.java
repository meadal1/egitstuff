package passignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneMain;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JTable table;
	private ArrayList<Car> cars;
	private ArrayList<Car> newList;
	private ArrayList<Car> carSingle;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewZealandMotor;
	private JLabel lblGraphs;
	private JLabel lblNewLabel;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private int singleCount;
	private JLabel lblNewZealandIndividual;
	private JTextPane txtpnThisTabAllows;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frame() {
		carSingle = new ArrayList<Car>();
		carSingle = read.generateList();
		singleCount = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 607);
		contentPaneMain = new JPanel();
		contentPaneMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMain.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPaneMain);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPaneMain.add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		lblNewZealandMotor = new JLabel("New Zealand Motor Vehicle Registrations");
		lblNewZealandMotor.setBounds(71, 11, 513, 32);
		lblNewZealandMotor.setFont(new Font("Verdana", Font.PLAIN, 25));
		panel.add(lblNewZealandMotor);
		
		contentPane = new JPanel();
		showAll();
		tabbedPane.addTab("View All Registrations", null, contentPane, null);
		
		JTextPane txtpnHello = new JTextPane();
		txtpnHello.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnHello.setBackground(Color.LIGHT_GRAY);
		txtpnHello.setText("This tab shows all of the current registrations. You can use the options below to either sort the results or search for specific results.");
		txtpnHello.setBounds(372, 72, 240, 70);
		contentPane.add(txtpnHello);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("View Individual Registrations", null, panel_3, null);
		panel_3.setLayout(null);
		textField_4 = new JTextField();
		textField_4.setBounds(167, 75, 156, 20);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(167, 114, 156, 20);
		panel_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(167, 153, 156, 20);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(167, 192, 156, 20);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(167, 231, 156, 20);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(167, 270, 156, 20);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(167, 309, 156, 20);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(167, 348, 156, 20);
		panel_3.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(167, 387, 156, 20);
		panel_3.add(textField_12);
		
		showSingle(singleCount);
		
		lblNewLabel = new JLabel("Make");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 69, 72, 28);
		panel_3.add(lblNewLabel);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModel.setBounds(39, 108, 72, 28);
		panel_3.add(lblModel);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(39, 147, 72, 28);
		panel_3.add(lblYear);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColour.setBounds(39, 186, 72, 28);
		panel_3.add(lblColour);
		
		JLabel lblBodyType = new JLabel("Body Type");
		lblBodyType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBodyType.setBounds(39, 225, 72, 28);
		panel_3.add(lblBodyType);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(39, 342, 72, 28);
		panel_3.add(lblLocation);
		
		JLabel lblEngineSize = new JLabel("Engine Size");
		lblEngineSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEngineSize.setBounds(39, 264, 72, 28);
		panel_3.add(lblEngineSize);
		
		JLabel lblFuelType = new JLabel("Fuel Type");
		lblFuelType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuelType.setBounds(39, 303, 72, 28);
		panel_3.add(lblFuelType);
		
		JLabel lblCountryOfOrigin = new JLabel("Country of Origin");
		lblCountryOfOrigin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountryOfOrigin.setBounds(39, 381, 120, 28);
		panel_3.add(lblCountryOfOrigin);
		
		
		JButton btnPreviousEntry = new JButton("Previous Entry");
		btnPreviousEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(singleCount > 0) {
					singleCount--;
					showSingle(singleCount);
				}
			}
		});
		btnPreviousEntry.setBounds(56, 455, 103, 28);
		panel_3.add(btnPreviousEntry);
		
		JButton btnNextEntry = new JButton("Next Entry");
		btnNextEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(singleCount < cars.size()) {
					singleCount++;
					showSingle(singleCount);
				}
			}
		});
		btnNextEntry.setBounds(202, 455, 103, 28);
		panel_3.add(btnNextEntry);
		
		lblNewZealandIndividual = new JLabel("New Zealand Individual Registrations");
		lblNewZealandIndividual.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblNewZealandIndividual.setBounds(92, 11, 466, 25);
		panel_3.add(lblNewZealandIndividual);
		
		txtpnThisTabAllows = new JTextPane();
		txtpnThisTabAllows.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnThisTabAllows.setBackground(Color.LIGHT_GRAY);
		txtpnThisTabAllows.setText("This tab allows you to view details of each individual registration. You can use the next and previous buttons to move through the list.");
		txtpnThisTabAllows.setBounds(405, 75, 209, 70);
		panel_3.add(txtpnThisTabAllows);
		
		
		panel_2 = new JPanel();
		tabbedPane.addTab("View Graphs", null, panel_2, null);
		
		lblGraphs = new JLabel("Graphs");
		lblGraphs.setFont(new Font("Verdana", Font.PLAIN, 25));
		panel_2.add(lblGraphs);
	}
	
	public void showAll() {
		newList = new ArrayList<Car>();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(508, 329, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(508, 365, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(509, 401, 109, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(509, 437, 109, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAllNewZealand = new JLabel("All New Zealand Car Registrations");
		lblAllNewZealand.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblAllNewZealand.setBounds(115, 7, 441, 33);
		contentPane.add(lblAllNewZealand);
		cars = read.generateList();
		Object[][] rowData = new Object[cars.size()][];
		fill(rowData);
		contentPane.add(createTable(rowData));
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSortBy.setBounds(372, 278, 66, 25);
		contentPane.add(lblSortBy);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Make");
		comboBox.addItem("Model");
		comboBox.addItem("Year");
		comboBox.addItem("Colour");
		comboBox.setBounds(508, 282, 110, 20);
		contentPane.add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newList = new ArrayList<Car>();
				if(!textField.getText().equals("")) {
					for(Car c : cars) {
						if(textField.getText().equals(c.getMake())) {
							if((!newList.contains(c)) && (textField_1.getText().equals(c.getModel()) || textField_1.getText().equals("")) && 
									(textField_2.getText().equals("") ||Integer.parseInt(textField_2.getText()) == c.getCarYear()) &&
									(textField_3.getText() == c.getColour() || textField_3.getText().equals(""))) {
								newList.add(c);
							}
						}
					}
				}
				
				if(!textField_1.getText().equals("")) {
					for(Car c : cars) {
						if(c.getModel().equals(textField_1.getText())) {
							if((!newList.contains(c)) && (textField.getText().equals(c.getMake()) || textField.getText().equals("")) && 
									(textField_2.getText().equals("") || Integer.parseInt(textField_2.getText()) == c.getCarYear()) &&
									(textField_3.getText().equals(c.getColour()) || textField_3.getText().equals(""))) {
								newList.add(c);
							}
						}
					}
				}
				if(!textField_2.getText().equals("")) {
					for(Car c : cars) {
						if(c.getCarYear() == Integer.parseInt(textField_2.getText())) {
							if((!newList.contains(c)) && (textField_1.getText().equals(c.getModel()) || textField_1.getText().equals("")) && 
									(textField.getText().equals(c.getMake()) || textField.getText().equals("")) &&
									(textField_3.getText().equals(c.getColour()) || textField_3.getText().equals(""))) {
								newList.add(c);
							}
						}
					}
				}
				if(!textField_3.getText().equals("")) {
					for(Car c : cars) {
						if(c.getColour().equals(textField_3.getText())) {
							if((!newList.contains(c)) && (textField_1.getText().equals(c.getModel()) || textField_1.getText().equals("")) && 
									(textField_2.getText().equals("") || Integer.parseInt(textField_2.getText()) == c.getCarYear() ) &&
									(textField.getText().equals(c.getMake()) || textField.getText().equals(""))) {
								newList.add(c);
							}
						}
					}
				}
				Object selected = comboBox.getSelectedItem();
				if(selected == "Make") {
					if(newList.isEmpty() && (!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals(""))) {
						Object[][] rowData = new Object[1][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else if(newList.isEmpty()) {
						Collections.sort(cars, Car.MakeComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						Collections.sort(newList, Car.MakeComparator);
						Object[][] rowData = new Object[newList.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					
				}
				if(selected == "Model") {
					if(newList.isEmpty() && (!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals(""))) {
						Object[][] rowData = new Object[1][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else if(newList.isEmpty()) {
						Collections.sort(cars, Car.ModelComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						Collections.sort(newList, Car.ModelComparator);
						Object[][] rowData = new Object[newList.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
				}
				if(selected == "Year") {
					if(newList.isEmpty() && (!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals(""))) {
						Object[][] rowData = new Object[1][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else if(newList.isEmpty()) {
						Collections.sort(cars, Car.YearComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						Collections.sort(newList, Car.YearComparator);
						Object[][] rowData = new Object[newList.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
				}
				if(selected == "Colour") {
					if(newList.isEmpty() && (!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals(""))) {
						Object[][] rowData = new Object[1][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else if(newList.isEmpty()) {
						Collections.sort(cars, Car.ColourComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						Collections.sort(newList, Car.ColourComparator);
						Object[][] rowData = new Object[newList.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
				}
			}
		});
		btnSubmit.setBounds(447, 481, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblSearchByMake = new JLabel("Search by Make");
		lblSearchByMake.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByMake.setBounds(372, 326, 127, 25);
		contentPane.add(lblSearchByMake);
		
		JLabel lblSearchByModel = new JLabel("Search by Model");
		lblSearchByModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByModel.setBounds(372, 362, 127, 25);
		contentPane.add(lblSearchByModel);
		
		JLabel lblSearchByYear = new JLabel("Search by Year");
		lblSearchByYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByYear.setBounds(372, 398, 127, 25);
		contentPane.add(lblSearchByYear);
		
		JLabel lblSearchByColour = new JLabel("Search by Colour");
		lblSearchByColour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByColour.setBounds(372, 434, 127, 25);
		contentPane.add(lblSearchByColour);
	}
	
	public void showSingle(int num) {
		textField_4.setText(carSingle.get(num).getMake());
		textField_5.setText(carSingle.get(num).getModel());
		textField_6.setText(String.valueOf(carSingle.get(num).getCarYear()));
		textField_7.setText(carSingle.get(num).getColour());
		textField_8.setText(carSingle.get(num).getBodyType());
		textField_9.setText(String.valueOf(carSingle.get(num).getEngineSize()));
		textField_10.setText(carSingle.get(num).getFuel());
		textField_11.setText(carSingle.get(num).getLocation());
		textField_12.setText(carSingle.get(num).getOriginalCountry());
	}
	
	public Object[][] fill(Object[][] rowData) {
		int count = 0;
		if(newList.isEmpty() && (!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals(""))) {
			rowData[0] = new String[4];
			rowData[0][0] = "NO";
			rowData[0][1] = "RESULTS";
			rowData[0][2] = "TRY";
			rowData[0][3] = "AGAIN";
			}
		else if(newList.isEmpty())  {
			for(Car c : cars) {
				rowData[count] = new String[4];
				rowData[count][0] = c.getMake();
				rowData[count][1] = c.getModel();
				rowData[count][2] = String.valueOf(c.getCarYear());
				rowData[count][3] = c.getColour();
				count++;
			}
		}

		else {
			for(Car c : newList) {
				rowData[count] = new String[4];
				rowData[count][0] = c.getMake();
				rowData[count][1] = c.getModel();
				rowData[count][2] = String.valueOf(c.getCarYear());
				rowData[count][3] = c.getColour();
				count++;
			}
		}
		return rowData;
	}
	
	public JScrollPane createTable(Object[][] rowData) {
		Object columnNames[] = {"Make", "Model", "Year", "Colour"};
		table = new JTable(rowData, columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 44, 318, 460);
		return scrollPane;
	}
}
