package cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao;

import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.db.DB;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.implem.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

}
