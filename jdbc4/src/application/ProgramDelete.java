package cursoUdemyNelio.jdbc4.src.application;

import cursoUdemyNelio.jdbc5.src.db.DB;
import cursoUdemyNelio.jdbc5.src.db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramDelete {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "delete from department where Id = ?";

            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
