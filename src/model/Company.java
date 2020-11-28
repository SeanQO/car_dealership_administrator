package model;

import java.util.ArrayList;
import java.util.List;

import customException.DoubleRegistrationException;
import customException.EmptyDataException;

public class Company {

	private String name;
	private int nit;
	private double totalEarnings;
	private int totalSales;

	private Admin principalAdmin;
	private Dealer firstDealer;
	private Vehicle vehicleRoot;

	public Company(String name, int nit, Admin principalAdmin) {
		this.name = name;
		this.nit = nit;
		totalEarnings = 0;
		totalSales = 0;
		this.principalAdmin = principalAdmin;
		firstDealer = null;
	}

	public String getName() {
		return name;
	}

	public int getNit() {
		return nit;
	}

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public Admin getPrincipalAdmin() {
		return principalAdmin;
	}

	public Dealer getFirstDealer() {
		return firstDealer;
	}

	public void setFirstDealer(Dealer firstDealer) {
		this.firstDealer = firstDealer;
	}

	public Vehicle getVehicleRoot() {
		return vehicleRoot;
	}

	public List<Vehicle> getEmployees() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if (vehicleRoot != null) {
			BSTtoListInOrder(vehicleRoot, vehicles);
		}
		return vehicles;
	}

	public List<Dealer> getDealers() {
		List<Dealer> dealers = new ArrayList<Dealer>();
		if (firstDealer != null) {
			Dealer current = firstDealer;
			do {
				dealers.add(current);
				current = current.getNextDealer();
			} while (current != firstDealer);
		}
		return dealers;
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

	
	public void addVehicle(String id, double totalSalePrice, String brand, double weight, String typeOfMotor,
			double topSpeed, int mileage, boolean used) throws DoubleRegistrationException, EmptyDataException {
		String emptyData = verifyFields(id, totalSalePrice, brand, weight, typeOfMotor, topSpeed, mileage, used);
		Vehicle vehicle = null;
		if (!emptyData.equals("")) {
			throw new EmptyDataException(emptyData);
		}

		if (searchVehicle(id) != null) {
			throw new DoubleRegistrationException(id, "Vehicle");
		}
		vehicle = new Vehicle(id, totalSalePrice, brand, weight, typeOfMotor, topSpeed, mileage, used);

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

	private String verifyFields(String id, double totalSalePrice, String brand, double weight, String typeOfMotor,
			double topSpeed, int mileage, boolean used) {
		String fields = "";
		if (id.equals("")) {
			fields = "Id ";
		}
		if (totalSalePrice == 0) {
			fields += "Name ";
		}
		if (brand.equals("")) {
			fields += "Lastname ";
		}
		if (weight == 0) {
			fields += "CelphoneNumber ";
		}
		if (typeOfMotor.equals("")) {
			fields += "Address ";
		}
		if (topSpeed == 0) {
			fields += "topSpedd";
		}
		if (mileage == 0) {
			fields += "mileage";
		}
		if (used) {
			fields += "used";
		}
		return fields;
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

	public void addCarDealer(CarDealer carDealer) {
		CarDealer newDealer = carDealer;
		addDealer(newDealer);

	}

	public void addMotorcycleDealer(MotorcycleDealer motorcycleDealer) {
		MotorcycleDealer newDealer = motorcycleDealer;
		addDealer(newDealer);

	}

	public void addVehicleDealer(VehicleDealer vehicleDealer) {
		VehicleDealer newDealer = vehicleDealer;
		addDealer(newDealer);

	}

	private void addDealer(Dealer c) {

		Dealer newDealer = c;

		// Case: Empty list.
		if (firstDealer == null) {
			firstDealer = newDealer;
			firstDealer.setNextDealer(newDealer);
			firstDealer.setPrevDealer(newDealer);
		}
		// Case: List with size: 1.
		else if (firstDealer == firstDealer.getNextDealer()) {
			firstDealer.setNextDealer(newDealer);
			firstDealer.setPrevDealer(newDealer);
			newDealer.setNextDealer(firstDealer);
			newDealer.setPrevDealer(firstDealer);
		}
		// Case: List with size >= 2.
		else {
			Dealer last = firstDealer.getPrevDealer();
			last.setNextDealer(newDealer);
			newDealer.setPrevDealer(last);
			newDealer.setNextDealer(firstDealer);
			firstDealer.setPrevDealer(newDealer);
		}
	}

	public Dealer searchDealer(String name) throws EmptyDataException {
		if (name == null || name.equals("")) {
			throw new EmptyDataException("name");
		}
		Dealer dealer = null;
		Dealer current = firstDealer;
		if (firstDealer != null) {
			do {
				current = current.getNextDealer();
			} while (current != firstDealer && !current.getName().equals(name));
			if (current.getName().equals(name)) {
				dealer = current;
			}
		}
		return dealer;
	}

	public void deleteDealer(Dealer dealer) throws EmptyDataException {

		// Case > 0
		if (firstDealer != null) {
			// Case 1: list size: 1.
			if (firstDealer == firstDealer.getNextDealer()) {
				firstDealer = null;
			}
			// Case 1: list size: 2.
			else if (dealer.getNextDealer().getNextDealer() == dealer) {
				firstDealer = dealer.getNextDealer();
				firstDealer.setNextDealer(null);
				firstDealer.setPrevDealer(null);
			}
			// Case 1: list size >= 3.
			else {
				Dealer prev = dealer.getPrevDealer();
				Dealer next = dealer.getNextDealer();

				prev.setNextDealer(next);
				next.setPrevDealer(prev);
				if (dealer == firstDealer) {
					firstDealer = dealer.getNextDealer();
				}
			}
		}
	}

	public void sortCByFullName() { // Bubble Sort
		if (firstDealer != null) {
			boolean thereWasSwap = true;

			while (thereWasSwap) {
				Dealer current = firstDealer;
				thereWasSwap = false;

				// Case: list >=2
				while (current.getNextDealer() != firstDealer) {
					if (current.getNextDealer().compareTo(current) < 0) {
						swap(current, current.getNextDealer());
						thereWasSwap = true;
					}
					current = current.getNextDealer();
				}
			}
		}
	}

	private void swap(Dealer c1, Dealer c2) {

		// Case: c1 is the first
		if (c1 == firstDealer) {
			firstDealer = c2;
		}
		// Case: c1 is the last
		else if (c2 == firstDealer) {
			firstDealer = c1;
		}

		// Case: list size: 3.
		else if (c1.getPrevDealer() == c2.getNextDealer()) {
			Dealer c3 = c1.getPrevDealer();
			c1.setNextDealer(c3);
			c1.setPrevDealer(c2);

			c2.setNextDealer(c1);
			c2.setPrevDealer(c3);

			c3.setNextDealer(c2);
			c3.setPrevDealer(c1);
		}
		// Case: list size >= 4.
		else {
			Dealer pc1 = c1.getPrevDealer();
			Dealer nc2 = c2.getNextDealer();

			pc1.setNextDealer(c2);

			c2.setPrevDealer(pc1);
			c2.setNextDealer(c1);

			c1.setPrevDealer(c2);
			c1.setNextDealer(nc2);
		}
	}
}
