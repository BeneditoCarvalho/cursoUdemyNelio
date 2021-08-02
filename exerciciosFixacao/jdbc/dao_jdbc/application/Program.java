package cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.application;

import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.DaoFactory;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.SellerDao;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.entities.Department;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.entities.Seller;

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

        for (Seller s: sellerList){
            System.out.println(s);
        }
    }
}
