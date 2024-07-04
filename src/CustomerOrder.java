import java.lang.*;
import java.util.*;

public class CustomerOrder {
    int OrderId;//fk
    int CustomerId;//fk
    int TotalAmount;
    int AlbumId;

    public int getOrderID() {
        return OrderId;
    }

    public int getOrderCusID() {
        return CustomerId;
    }

    public int getOrderTotalAmount() {
        return TotalAmount;
    }

    public void printOrderDetails() {
        System.out.println("......Order Details......");
        System.out.println("OrderId: " + OrderId);
        System.out.println("CustomerID: " + CustomerId);
        System.out.println("AlbumID: " + AlbumId);
        System.out.println("TotalAmount: " + TotalAmount);
        System.out.println("........................");
    }
}