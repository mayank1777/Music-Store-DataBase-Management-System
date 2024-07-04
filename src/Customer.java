import java.lang.*;
import java.util.*;

public class Customer {
    // Attributes
    int CustomerID;
    String CustomerName;
    String CustomerEmail;
    String CustomerPhone;
    String CustomerAddr;

    // Default Constructor
    public Customer() {

    }

    // Contructor
    public Customer(int CustomerID, String CustomerName, String CustomerEmail, String CustomerPhone,
            String CustomerAddr) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPhone = CustomerPhone;
        this.CustomerAddr = CustomerAddr;

    }

    // Methods
    public int getCusID() {
        return CustomerID;
    }

    public String getCusName() {
        return CustomerName;
    }

    public String getCusEmail() {
        return CustomerEmail;
    }

    public String getCusPhone() {
        return CustomerPhone;
    }

    public String getCusAddr() {
        return CustomerAddr;
    }

    public void setCusID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCusName(String Name) {
        this.CustomerName = Name;
    }

    public void setCusEmail(String NewEmail) {
        this.CustomerEmail = NewEmail;
    }

    public void setCusPhone(String NewPhone) {
        this.CustomerPhone = NewPhone;
    }

    public void setCusAdd(String NewAddr) {
        this.CustomerAddr = NewAddr;
    }

}