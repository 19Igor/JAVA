package product;

import java.util.ArrayList;

public class Car implements Product {
	private ProductType productType;
	private int serialNumber;
	private ArrayList<Product> parts;
	public Car(ProductType _productType, int _serialNumber, Product one, Product two, Product three){
		productType = _productType;
		serialNumber = _serialNumber;
		parts = new ArrayList<Product>();
		
		parts.add(one);
		parts.add(two);
		parts.add(three);
	}
	
	@Override
	public ArrayList<Product> getParts() {
		return parts;
	}
	
	@Override
	public ProductType getProductType() {
		return productType;
	}
	
	@Override
	public int getSerial() {
		return serialNumber;
	}
}
