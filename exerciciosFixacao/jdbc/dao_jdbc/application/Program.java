package cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.application;

import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.DaoFactory;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.SellerDao;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.entities.Department;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST #1: seller findById ====");
        Seller seller = sellerDao.findById(5);
        System.out.println(seller);

        System.out.println("\n==== TEST #2: seller findByDepartment ====");
        Department department = new Department(1, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);

        for (Seller s : sellerList) {
            System.out.println(s);
        }

        System.out.println("\n==== TEST #3: seller findAll ====");
        sellerList = sellerDao.findAll();

        for (Seller s : sellerList) {
            System.out.println(s);
        }

        System.out.println("\n==== TEST #4: seller insertSeller ====");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(seller1);

        System.out.println(seller1.getId());

        System.out.println("\n==== TEST #5: seller updateSeller ====");
        Seller seller2 = new Seller(13, "Joao Bobao", "joao@gmail.com", new Date(), 10000.0, department);
        sellerDao.update(seller2);

        System.out.println("Update Complete!");

    }

}




