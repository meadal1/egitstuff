package passignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class read {
	

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<Car>();
		String csvFile = "regos.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplit = ",";
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while((line = br.readLine()) != null) {
				String[] carStuff = line.split(cvsSplit);
				System.out.println(carStuff.length);
				cars.add(new Car(carStuff[0], carStuff[1], Integer.parseInt(carStuff[2]), Integer.parseInt(carStuff[3]), 
						Integer.parseInt(carStuff[4]), Integer.parseInt(carStuff[5]), carStuff[6], carStuff[7], carStuff[8], 
						carStuff[9], carStuff[10], Integer.parseInt(carStuff[11]), carStuff[12]));
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!= null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
		
	
	}

}
