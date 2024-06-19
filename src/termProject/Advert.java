package termProject;

public class Advert implements IEntity {
	private int id;
	private int userId;
	private int modelYear;
	private int mileage;
	private int motorPower;
	private int price;
	private String category;
	private String vehicleTable;
	private String advertTitle;
	private String brandName;
	private String modelName;
	private String color;
	private String gear;
	private String advertImagePath;
	
	public Advert() {
		
	}
	
	public Advert(int id,int userId,String advertTitle,String category,String vehicleTable,String brandName,String modelName,int modelYear,int mileage,String color,String gear,int motorPower,String advertImagePath,int price) {
		this.id = id;
		this.userId = userId;
		this.advertTitle = advertTitle;
		this.category = category;
		this.vehicleTable = vehicleTable;
		this.brandName = brandName;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.mileage = mileage;
		this.color = color;
		this.gear = gear;
		this.motorPower = motorPower;
		this.advertImagePath = advertImagePath;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getMotorPower() {
		return motorPower;
	}
	public void setMotorPower(int motorPower) {
		this.motorPower = motorPower;
	}
	public String getAdvertTitle() {
		return advertTitle;
	}
	public void setAdvertTitle(String advertTitle) {
		this.advertTitle = advertTitle;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVehicleTable() {
		return vehicleTable;
	}
	public void setVehicleTable(String vehicleTable) {
		this.vehicleTable = vehicleTable;
	}
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public String getAdvertImagePath() {
		return advertImagePath;
	}
	public void setAdvertImagePath(String advertImagePath) {
		this.advertImagePath = advertImagePath;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
}

