package cursoUdemyNelio.jdbc5.src.application;

import cursoUdemyNelio.jdbc5.src.db.DB;

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println(rowsAffected);
            DB.closeStatement(preparedSt);
            DB.closeConnection();
        }

    }
}
