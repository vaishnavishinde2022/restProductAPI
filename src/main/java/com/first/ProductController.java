package com.first;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
 * bellow class can handle the HTTP Status code.Means this will generate proper
 * HTTP status code for client.
 */
@RestController
public class ProductController
{
	@Autowired
	ProductService obj;
	
	/**@GetMapping("/product")
   public String msg()
   {
	   return "product";
   }**/
	
	@GetMapping("/products")
	/*
	 * ResponseEntity represents the whole HTTP response:status code,header,and body.
	 */
	public ResponseEntity <ArrayList<Product>> getAllProducts()
	{
		ArrayList<Product> arrayList=obj.getAllProducts();
		
		if(arrayList.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(arrayList));
	}//getAllProducts
	
	
	//To get one product
	@GetMapping("/product/{id}")
	
	public ResponseEntity<Product> getProduct(@PathVariable("id")int id)
	{
		Product productObj=null;
		try
		{
		 productObj=obj.getProduct(id);
		
		
	/**	if(productObj==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(productObj));**/
		
		}//try
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{

			if(productObj==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			return ResponseEntity.of(Optional.of(productObj));
			
		}//finally
		
	}//getProduct
	
	//To add product
	
	@PostMapping("/add")
	
	public ResponseEntity<Product> addProduct(@RequestBody Product proObj)
	{
		Product proObj1=null;
		
		try
		{
		 proObj1=obj.addProduct(proObj);
		 return ResponseEntity.of(Optional.of(proObj1));
		}//try
		
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}//catch
		
			
	}//addProduct
	
	@DeleteMapping("/product/{id}")
	
	public  ResponseEntity<Object> deleteProduct(@PathVariable("id")int id)
	{
		try
		{
			obj.deleteProduct(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}//try
		
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}//deleteProduct
	
	@PutMapping("/product/{id}")
	
	public ResponseEntity<Object> update(@RequestBody Product proObj,@PathVariable("id")int id)
	{
		try
		{
			obj.update(proObj,id);
			return ResponseEntity.ok().body(proObj);
		}//try
		
		catch(Exception e)
		{

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
