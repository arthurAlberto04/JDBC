import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args){
        Department obj = new Department(1, "Books");
        System.out.println(obj);
        Seller seller = new Seller(21, obj, 3000.00, new Date(), "bob@gmail.com", "bob");
        System.out.println(seller);
    }
}
