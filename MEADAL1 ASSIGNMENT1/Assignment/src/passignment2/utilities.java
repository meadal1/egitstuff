package passignment2;

import java.util.ArrayList;

public class utilities {
	public static int countByMake(ArrayList<Car> cars, String make) {
		int count = 0;
		for(Car c : cars) {
			if(c.getMake().equals(make)) {
				count++;
			}
		}
		return count;
	}
	public static float averageYearOfMake(ArrayList<Car> cars, String make) {
		float total = 0;
		int count = 0;
		for(Car c : cars) {
			if(c.getMake().equals(make)) {
				total += c.getCarYear();
				count++;
			}
		}
		total /= count;
		return total;
	}
	public static int countByYear(ArrayList<Car> cars, int year) {
		int count = 0;
		for(Car c : cars) {
			if(c.getCarYear() == year) {
				count++;
			}
		}
		return count;
	}
	
}
