package passignment2;

public class Car implements Comparable<Car>{
	private String bodyType;
	private int engineSize;
	private int nzRegoYear;
	private int nzRegoMonth;
	private int vehicleWeight;
	private String make;
	private String model;
	private String colour;
	private String fuel;
	private String originalCountry;
	private String location;
	private int carYear;
	private String vin;
	
	public Car(String colour, String bodyType, int engineSize, int nzRegoYear, int nzRegoMonth, int vehicleWeight, String make, String model,
	String fuel, String originalCountry, String location, int carYear, String vin) {
		this.colour = colour;
		this.bodyType = bodyType;
		this.engineSize = engineSize;
		this.nzRegoYear = nzRegoYear;
		this.nzRegoMonth = nzRegoMonth;
		this.vehicleWeight = vehicleWeight;
		this.make = make;
		this.model = model;
		this.originalCountry = originalCountry;
		this.location = location;
		this.carYear = carYear;
		this.vin = vin;
		this.fuel = fuel;
		
	}
	
	@Override
	public int compareTo(Car arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return make + " " + model;
	}
	
	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public int getNzRegoYear() {
		return nzRegoYear;
	}

	public void setNzRegoYear(int nzRegoYear) {
		this.nzRegoYear = nzRegoYear;
	}

	public int getNzRegoMonth() {
		return nzRegoMonth;
	}

	public void setNzRegoMonth(int nzRegoMonth) {
		this.nzRegoMonth = nzRegoMonth;
	}

	public int getVehicleWeight() {
		return vehicleWeight;
	}

	public void setVehicleWeight(int vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getOriginalCountry() {
		return originalCountry;
	}

	public void setOriginalCountry(String originalCountry) {
		this.originalCountry = originalCountry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
}
