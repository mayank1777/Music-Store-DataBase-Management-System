import java.lang.*;
import java.util.*;

public class OrderDetails {
    int OrderId;
    String AlbumID;
    int Quantity;
    int Subtotal;

    public int  getOrderID() {
        return OrderId;
    }
     public String  getAlbumID() {
        return AlbumID;
    }

    public int getQuantity() {
        return Quantity;
    }
    public int getSubtotal(){
        return Subtotal;
    }
}