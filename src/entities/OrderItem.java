package entities;

import entities.Product;
/**
 *
 * @author Roberto
 */
public class OrderItem {
    
    private Product product;
    private Integer quantity;
    private Double price;
    
    public OrderItem(){
    }
    
    public OrderItem(Integer quantity, Double price, Product product){
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }
    
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setProduct(Product product){
        this.product = product;
    }
    
    public Product getProduct(){
        return product;
    }          
            
    public Double subTotal(){
        return quantity * price;
    }
        
}
