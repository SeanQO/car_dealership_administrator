package model;
public interface Gasoline {
	public final static String PREMIUM = "Premium";
	public final static String REGULAR = "Regular";
	public final static String DIESEL = "Diesel";
	
	public abstract double getTankCapacity();
	
	public abstract String getGasType();
	
	public abstract double getGasConsumption();


}