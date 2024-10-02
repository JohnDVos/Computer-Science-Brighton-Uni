package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  John Vos
 * @version 1.0
 */

public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;

  	/*method that overwrites basket class.*/
  	public boolean add (Product pr){
  		for(Product item : this) {
  		/*checks if item being added already in basket.
  		 * if already in basket, ++ to item in basket.*/
		  if(item.getProductNum().equals(pr.getProductNum())) {		
			  int qty = item.getQuantity();
			  item.setQuantity(qty++);
			  return true;
		  }
	  }
	  return super.add(pr);					//else, new item added.*/
  }
  
  	/*sorts items in basket*/
  	public void sort() {
  		Collections.sort(this, new Comparator<Product>() {
  			public int compare(Product o1, Product o2) {
  				if(o1.getProductNum().equals(o2.getProductNum()))
  					return 0;
  				return o1.getProductNum().compareTo(o2.getProductNum());
  			}
  		});
  	}
  	
  	/*extends getDetails() from basket.
  	 *sort algorithm implemented before displaying details.*/
  	public String getDetails() {
  		this.sort();
  		return super.getDetails();
  	}
  
}
