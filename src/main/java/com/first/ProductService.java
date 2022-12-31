package com.first;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductService 
{
  static ArrayList<Product> arrayList=new ArrayList();
  
  static 
  {
	  arrayList.add(new Product(1,"pen",10,"Best"));
	  arrayList.add(new Product(2,"pencile",6,"Best"));
	  arrayList.add(new Product(3,"paper",10,"true"));
  }
   public ArrayList<Product> getAllProducts()
   {
	   return arrayList;
   }//getAllProducts
   
   public Product getProduct(int id)
   {
	   Product productObj=null;
		  
	   try
	   {
		   
	   productObj =(Product) arrayList.stream().filter(e->((Product) e).getProductid()==id).findFirst().get();
	   
	   }//try
	   
	   catch(Exception e)
	   {
		   //e.printStackTrace();
		   
	   }//catch
		   
	  return productObj;
	  
   }//getProduct
   
   public Product addProduct(Product proObj)
   {
	   arrayList.add(proObj);
	   
	   return proObj;
	   
   }//addProduct
   
   public String deleteProduct(int id)
   {
	   arrayList=(ArrayList) arrayList.stream().filter(cust->((Product) cust).getProductid()!=id).collect(Collectors.toList());
		  return "deleted";
	  
   }//deleteProduct
   
   public void update(Product proObj,int id)
   {
	   arrayList=(ArrayList<Product>) arrayList.stream().map(product1->{
			  if(((Product) product1).getProductid()==id)
			  {
				  ((Product) product1).setProductname(proObj.getProductname());
				  ((Product) product1).setProductPrice(proObj.getProductPrice()); 
				  
			  }
			  return product1;
		  }).collect(Collectors.toList());
   }
}
