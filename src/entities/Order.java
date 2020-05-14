
package entities;

import entities.enums.OrderStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.Client;

/**
 *
 * @author Roberto
 */
public class Order {
    
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;
    
    public Order(){
    }
    
    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }
    
    public void setMoment(Date moment){
        this.moment = moment;
    }
    
    public Date getMoment(){
        return moment;
    }
    
    public void setOrderStatus(OrderStatus status){
        this.status = status;
    }
    
    public OrderStatus getOrderStatus(){
        return status;
    }
    
    public List<OrderItem> getItems(){
        return items;
    }
    
    public void addItem(OrderItem item){
        items.add(item);
    }
    
    public void removeItem(OrderItem item){
        items.remove(item);
    }
    
    public void setClient(Client client){
        this.client = client;
    }
    
    public Client getClient(){
        return client;
    }
    
   public Double total(){
       Double sum = 0.0;
       for (OrderItem c : items){
           sum += c.subTotal();
       }
       return sum;
   }
}
