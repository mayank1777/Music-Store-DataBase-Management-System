import java.lang.*;
import java.util.*;

public interface User {
    // Cashier
    public void Add_customer(Customer customer);

    public void Order_Product(int AlbumId, int quantity);

    public void View_ProductList();

    public void View_CustomerList();

    // Manager
    public void Add_Album(Album album);

    public void Changing_Customer_Details(int customerid);

    public void Delete_Customer(int customerid);

}