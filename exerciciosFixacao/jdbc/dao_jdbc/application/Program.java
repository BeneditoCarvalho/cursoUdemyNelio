package cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.application;

import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.DaoFactory;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.SellerDao;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST #1: seller findById ====");
        Seller seller = sellerDao.findById(5);
        System.out.println(seller);

    }
}
