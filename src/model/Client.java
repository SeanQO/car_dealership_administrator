package model;

public class Client extends Person {
	private static final long serialVersionUID = 1;
	
	private Seller sellerInCharge;
	
	public Client(String name, String lastname, String email, long id, long phoneNumber,
					Seller sellerInCharge) {
		super(name, lastname, email, id, phoneNumber);
		
		this.sellerInCharge = sellerInCharge;
		
	}
	
	public Seller getSellerInCharge(){
		
		return sellerInCharge;
	}
	
}
