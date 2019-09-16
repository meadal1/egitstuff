package passignment2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class showAll extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Car> cars;
	private ArrayList<Car> newList;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showAll frame = new showAll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public showAll() {
		newList = new ArrayList<Car>();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 661, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(506, 81, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(506, 117, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(507, 153, 109, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(507, 189, 109, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAllNewZealand = new JLabel("All New Zealand Car Registrations");
		lblAllNewZealand.setBounds(5, 5, 635, 14);
		contentPane.add(lblAllNewZealand);
		cars = read.generateList();
		Object[][] rowData = new Object[cars.size()][];
		fill(rowData);
		contentPane.add(createTable(rowData));
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSortBy.setBounds(370, 30, 66, 25);
		contentPane.add(lblSortBy);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Make");
		comboBox.addItem("Model");
		comboBox.addItem("Year");
		comboBox.addItem("Colour");
		comboBox.setBounds(506, 34, 110, 20);
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
						System.out.println("EMPTYFAKA");
						Collections.sort(cars, Car.MakeComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						System.out.println("NOTEMPTY");
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
						System.out.println("EMPTYFAKA");
						Collections.sort(cars, Car.ModelComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						System.out.println("NOTEMPTY");
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
						System.out.println("EMPTYFAKA");
						Collections.sort(cars, Car.YearComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						System.out.println("NOTEMPTY");
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
						System.out.println("EMPTYFAKA");
						Collections.sort(cars, Car.ColourComparator);
						Object[][] rowData = new Object[cars.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
					else {
						System.out.println("NOTEMPTY");
						Collections.sort(newList, Car.ColourComparator);
						Object[][] rowData = new Object[newList.size()][];
						fill(rowData);
						contentPane.remove(scrollPane);
						contentPane.add(createTable(rowData));
					}
				}
			}
		});
		btnSubmit.setBounds(446, 287, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblSearchByMake = new JLabel("Search by Make");
		lblSearchByMake.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByMake.setBounds(370, 78, 127, 25);
		contentPane.add(lblSearchByMake);
		
		JLabel lblSearchByModel = new JLabel("Search by Model");
		lblSearchByModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByModel.setBounds(370, 114, 127, 25);
		contentPane.add(lblSearchByModel);
		
		JLabel lblSearchByYear = new JLabel("Search by Year");
		lblSearchByYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByYear.setBounds(370, 150, 127, 25);
		contentPane.add(lblSearchByYear);
		
		JLabel lblSearchByColour = new JLabel("Search by Colour");
		lblSearchByColour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchByColour.setBounds(370, 186, 127, 25);
		contentPane.add(lblSearchByColour);
		

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
		scrollPane.setBounds(5, 19, 318, 485);
		return scrollPane;
	}
}
