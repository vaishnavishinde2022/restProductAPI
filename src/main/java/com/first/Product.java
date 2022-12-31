package com.first;


public class Product 
{
	
	private int Productid;
	private String Productname;
	private int ProductPrice;
	private String ProductDescription;
	
	public Product(int productid, String productname, int productPrice, String productDescription) 
	{
		super();
		Productid = productid;
		Productname = productname;
		ProductPrice = productPrice;
		ProductDescription = productDescription;
	}
	
  public Product()
  {
		super();
		// TODO Auto-generated constructor stub
	}

public int getProductid()
  {
		return Productid;
	}
	public void setProductid(int productid) 
	{
		Productid = productid;
	}
	
	
	public String getProductname() 
	{
		return Productname;
	}
	public void setProductname(String productname)
	{
		Productname = productname;
	}
	
	
	public int getProductPrice() 
	{
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) 
	{
		ProductPrice = productPrice;
	}
	
	
	public String getProductDescription() 
	{
		return ProductDescription;
	}
	public void setProductDescription(String productDescription)
	{
		ProductDescription = productDescription;
	}
	
	@Override
	public String toString() {
		return "Product [Productid=" + Productid + ", Productname=" + Productname + ", ProductPrice=" + ProductPrice
				+ ", ProductDescription=" + ProductDescription + "]";
	}

  
  
  
}
