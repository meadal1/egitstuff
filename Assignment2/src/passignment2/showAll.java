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

public class showAll extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Car> cars;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public showAll() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 661, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllNewZealand = new JLabel("All New Zealand Car Registrations");
		lblAllNewZealand.setBounds(5, 5, 635, 14);
		contentPane.add(lblAllNewZealand);
		cars = read.generateList();
		Object[][] rowData = new Object[cars.size()][];
		fill(rowData);
		contentPane.add(createTable(rowData));
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSortBy.setBounds(412, 30, 66, 25);
		contentPane.add(lblSortBy);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Make");
		comboBox.addItem("Model");
		comboBox.addItem("Year");
		comboBox.addItem("Colour");
		comboBox.setBounds(488, 34, 75, 20);
		contentPane.add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object selected = comboBox.getSelectedItem();
				if(selected == "Make") {
					Collections.sort(cars, Car.MakeComparator);
					Object[][] rowData = new Object[cars.size()][];
					fill(rowData);
					contentPane.remove(scrollPane);
					contentPane.add(createTable(rowData));
				}
				if(selected == "Model") {
					Collections.sort(cars, Car.ModelComparator);
					Object[][] rowData = new Object[cars.size()][];
					fill(rowData);
					contentPane.remove(scrollPane);
					contentPane.add(createTable(rowData));
				}
				if(selected == "Year") {
					Collections.sort(cars, Car.YearComparator);
					Object[][] rowData = new Object[cars.size()][];
					fill(rowData);
					contentPane.remove(scrollPane);
					contentPane.add(createTable(rowData));
				}
				if(selected == "Colour") {
					Collections.sort(cars, Car.ColourComparator);
					Object[][] rowData = new Object[cars.size()][];
					fill(rowData);
					contentPane.remove(scrollPane);
					contentPane.add(createTable(rowData));
				}
			}
		});
		btnSubmit.setBounds(474, 421, 89, 23);
		contentPane.add(btnSubmit);
	}
	
	public Object[][] fill(Object[][] rowData) {
		int count = 0;
		for(Car c : cars) {
			rowData[count] = new String[4];
			rowData[count][0] = c.getMake();
			rowData[count][1] = c.getModel();
			rowData[count][2] = String.valueOf(c.getCarYear());
			rowData[count][3] = c.getColour();
			count++;
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
