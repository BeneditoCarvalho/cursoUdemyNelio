package cursoUdemyNelio.exerciciosFixacao.jdbc.jdbc4.src.application;

import cursoUdemyNelio.exerciciosFixacao.jdbc.jdbc4.src.db.DB;
import cursoUdemyNelio.exerciciosFixacao.jdbc.jdbc4.src.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramUpdate {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedSt = null;
        int rowsAffected = 0;

        try {
            String sql = "UPDATE seller SET BaseSalary = BaseSalary + ? "
                    + "WHERE"
                    + "(DepartmentId = ?)";

            connection = DB.getConnection();
            preparedSt = connection.prepareStatement(sql);

            preparedSt.setDouble(1, 25);
            preparedSt.setInt(2, 2);

            rowsAffected = preparedSt.executeUpdate();

            System.out.println("Done! Rows Affectedd: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(preparedSt);
            DB.closeConnection();
        }

    }
}
