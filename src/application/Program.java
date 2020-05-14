package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Program {
    
    public static void main(String[] args) throws ParseException{
    
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthClient = sdf.parse(sc.nextLine());
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        Date moment = new Date();
        
        Order order = new Order(moment, OrderStatus.valueOf(status),new Client(clientName,clientEmail,birthClient));
       
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Pruduct Price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(quantity,price,new Product(name,price));
            order.getItems().add(orderItem);
        }
        
        System.out.println("\nORDER SUMARY:");
        System.out.println("Order Moment: " + sdf1.format(order.getMoment()));
        System.out.println("Order status: " + order.getOrderStatus());
        System.out.println("Client: " 
        + order.getClient().getName()
        + " (" + sdf.format(order.getClient().getBirthDate()) + ") - " 
        + order.getClient().getEmail());
        
        System.out.println("Order Items:");
        for (OrderItem c : order.getItems()){
            System.out.println(c.getProduct().getName() + ", $"
            + String.format("%.2f",c.getPrice()) + ", Quantity: "
            + c.getQuantity() + ", Subtotal: $" 
            + String.format("%.2f",c.subTotal()));
        }
        
        System.out.printf("Total Price: $%.2f\n",order.total());
        
        sc.close();
    }
    
}
