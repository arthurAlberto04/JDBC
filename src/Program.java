import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller1 = sellerDao.findById(3);
        System.out.println(seller1);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 4: seller Insert ===");
        Seller newSeller = new Seller(null, department, 4000.00, new Date(), "greg@gmail.com", "Greg");
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " +  newSeller.getId());

        System.out.println();
        System.out.println("=== TEST 5: seller Update ===");
        seller1 = sellerDao.findById(1);
        seller1.setName("Marta waine");
        sellerDao.update(seller1);
        System.out.println("Update complete");

        System.out.println();
        System.out.println("=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete complete");

        sc.close();
    }
}
