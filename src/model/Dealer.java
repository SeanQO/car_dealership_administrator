package model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import customException.DoubleRegistrationException;
import customException.EmptyDataException;


public abstract class Dealer implements Comparable<Dealer> {

	private Dealer nextDealer;
	private Dealer prevDealer;
	private Vehicle vehicleRoot;
	
	private String name;
	private Admin admin;
	private String adminName;
	private String adress;
	private double earnings;
	private int sales;
	private ArrayList<Client> clients;
	private ArrayList<Seller> sellers;

	public Dealer(String name, Admin admin, String adress) {
		this.name = name;
		this.admin = admin;
		this.adress = adress;
		earnings = 0;
		sales = 0;
		clients = new ArrayList<Client>();
		sellers = new ArrayList<Seller>();
		nextDealer = null;
		prevDealer = null;

		adminName = admin.getName();
	}

	public Dealer getNextDealer() {
		return nextDealer;
	}

	public void setNextDealer(Dealer nextDealer) {
		this.nextDealer = nextDealer;
	}

	public Dealer getPrevDealer() {
		return prevDealer;
	}

	public void setPrevDealer(Dealer prevDealer) {
		this.prevDealer = prevDealer;
	}

	public String getName() {
		return name;
	}

	public Admin getAdmin() {
		return admin;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdmin(Admin admin) {
		adminName = admin.getName();
		this.admin = admin;
	}

	public String getAdress() {
		return adress;
	}

	public double getEarnings() {
		return earnings;
	}

	public int getSales() {
		return sales;
	}

	public void addClient(Client client) throws DoubleRegistrationException {
		for(int i = 0;i<clients.size();i++) {
			if(clients.get(i).getId()==client.getId()) {
				String id = ""+clients.get(i).getId();
				throw new DoubleRegistrationException(id, "clients");
			}
			clients.add(client);
		}
	}

	public void removeClient(long id) {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getId() == id) {
				clients.remove(i);
			}
		}
	}

	public void addSeller(Seller seller) throws DoubleRegistrationException {
		for(int i = 0;i<sellers.size();i++) {
			if(sellers.get(i).getId()==seller.getId()) {
				String id = ""+sellers.get(i).getId();
				throw new DoubleRegistrationException(id, "sellers");
			}
			sellers.add(seller);
		}
	}

	public void removeSeller(long id) {
		for (int i = 0; i < sellers.size(); i++) {
			if (sellers.get(i).getId() == id) {
				sellers.remove(i);
			}
		}
	}

	public List<Vehicle> getVehicles() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if (vehicleRoot != null) {
			BSTtoListInOrder(vehicleRoot, vehicles);
		}
		return vehicles;
	}

	private void BSTtoListInOrder(Vehicle current, List<Vehicle> list) {
		if (current.getLeft() != null) {
			BSTtoListInOrder(current.getLeft(), list);
		}
		list.add(current);
		if (current.getRight() != null) {
			BSTtoListInOrder(current.getRight(), list);
		}

	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Seller> getSellers() {
		return sellers;
	}

	public Seller getSeller(long id) {
		for (Seller seller : sellers) {
			if (seller.getId() == id) {
				return seller;
			}

		}

		return null;
	}

	public ArrayList<Seller> getAvailableSellers() {
		ArrayList<Seller> availableSellers = new ArrayList<Seller>();

		for (Seller seller : sellers) {
			if (seller.getClients()[4] == null) {
				availableSellers.add(seller);

			}

		}

		return availableSellers;
	}

	public int compareTo(Dealer p) {
		int difference;
		if (this.name.equals(p.name)) {
			difference = this.name.compareTo(p.name);
		} else {
			difference = this.name.compareTo(p.name);
		}
		return difference;
	}

	public void exportClients(File file, String s) throws FileNotFoundException {
		ArrayList <Client>c;
		c = new ArrayList<Client>();
		PrintWriter pw =new PrintWriter(file);
		Collections.sort(clients);
		pw.write("Name,"+s+" lastname,"+s+ "Email,"+s+"id,"+s+"Phone number,"+s+"Seller in charge,"+s);
		for(int w=0;w<clients.size();w++) {
			long code=c.get(0).getId();
			pw.write(clients.get(w).getName()+s+ clients.get(w).getLastName()+s+clients.get(w).getEmail()+s+code+clients.get(w).getPhoneNumber()+s+clients.get(w).getSellerInCharge()+"\n");
		}
		pw.close();
	}
	
	/*public void importDataClients(File file) throws IOException {
		BufferedReader br =new BufferedReader(new FileReader(file));
		int count=0;
		String line=br.readLine();
		while(line!=null) {
			 if(count>0){
				 String [] parts=line.split(",");
				 long id = Long.parseLong(parts[3]);
				 long pn = Long.parseLong(parts[4]);
				 Client newClient = new Client(parts[0],parts[1],parts[2],id,pn,parts[5]);
				 addClient(newClient);
			 }
			 count++;
			 line=br.readLine();
		}
		br.close();
	}*/
	
	public void addVehicle(Vehicle vehicle) throws DoubleRegistrationException {

		if (searchVehicle(vehicle.getId()) != null) {
			throw new DoubleRegistrationException(vehicle.getId(), "Vehicle");
		}
		
		Vehicle current = vehicleRoot;

		boolean wasAdded = false;

		if (vehicleRoot != null) {
			while (!wasAdded) {
				if (current.compareTo(vehicle) < 0) {
					if (current.getLeft() == null) {
						current.setLeft(vehicle);
						vehicle.setHead(current);
						wasAdded = true;
					} else {
						current = current.getLeft();
					}
				} else {
					if (current.getRight() == null) {
						current.setRight(vehicle);
						vehicle.setHead(current);
						wasAdded = true;
					} else {
						current = current.getRight();
					}
				}
			}
		} else {
			vehicleRoot = vehicle;
		}
	}

	public void deleteVehicle(String id) {
		Vehicle nodo = searchVehicle(id);
		if (nodo != null) {
			if ((nodo.getLeft() == null || nodo.getRight() == null)
					&& !(nodo.getLeft() == null && nodo.getRight() == null)) { // Delete element with one child
				if (nodo == vehicleRoot) {
					if (nodo.getLeft() != null) {
						nodo.getLeft().setHead(null);
						vehicleRoot = nodo.getLeft();
					} else {
						nodo.getRight().setHead(null);
						vehicleRoot = nodo.getRight();
					}
				} else {
					if (nodo.getLeft() != null) {
						nodo.getLeft().setHead(nodo.getHead());
						if (nodo.getHead().getLeft() == nodo) {
							nodo.getHead().setLeft(nodo.getLeft());
						} else {
							nodo.getHead().setRight(nodo.getLeft());
						}
					} else {
						nodo.getRight().setHead(nodo.getHead());
						if (nodo.getHead().getLeft() == nodo) {
							nodo.getHead().setLeft(nodo.getRight());
						} else {
							nodo.getHead().setRight(nodo.getRight());
						}
					}
				}
			} else if (nodo.getLeft() == null && nodo.getRight() == null) { // Delete sheet
				if (nodo == vehicleRoot) {
					vehicleRoot = null;
				} else {
					if (nodo.getHead().getLeft() == nodo) {
						nodo.getHead().setLeft(null);
					} else {
						nodo.getHead().setRight(null);
					}
				}
			} else { // Delete element with both children
				Vehicle min = nodo.getRight().getMin();
				deleteVehicle(min.getId());
				min.setHead(nodo.getHead());
				min.setRight(nodo.getRight());
				min.setLeft(nodo.getLeft());
				nodo.getLeft().setHead(min);
				if (nodo.getRight() != null) {
					nodo.getRight().setHead(min);
				}
				if (nodo == vehicleRoot) {
					vehicleRoot = min;
				} else {
					if (nodo.getHead().getLeft() == nodo) {
						nodo.getHead().setLeft(min);
					} else {
						nodo.getHead().setRight(min);
					}
				}
			}
		}
	}

	public Vehicle searchVehicle(String id) {

		return searchVehicle(vehicleRoot, id);
	}

	private Vehicle searchVehicle(Vehicle nodo, String id) {
		if (nodo != null) {
			if (nodo.getId().compareTo(id) < 0) {
				return searchVehicle(nodo.getRight(), id);
			} else if (nodo.getId().compareTo(id) > 0) {
				return searchVehicle(nodo.getLeft(), id);
			} else {
				return nodo;
			}
		} else {
			return null;
		}
	}

}
