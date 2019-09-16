package passignment2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class utilitiesTest {

	@Test
	void testCountByMake() {
		ArrayList<Car> cars = read.generateList();
		assertEquals(19, utilities.countByMake(cars, "HOLDEN"));
	}

	@Test
	void testAverageYearOfMake() {
		ArrayList<Car> cars = read.generateList();
		assertEquals(2004.76, utilities.averageYearOfMake(cars, "HONDA"), 0.02);
	}

	@Test
	void testCountByYear() {
		ArrayList<Car> cars = read.generateList();
		assertEquals(2, utilities.countByYear(cars, 1971));
	}

}
