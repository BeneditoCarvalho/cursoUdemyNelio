package cursoUdemyNelio.jdbc5.src.application;

import cursoUdemyNelio.jdbc5.src.db.DB;
import cursoUdemyNelio.jdbc5.src.db.DbException;

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
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            connection.commit();

            System.out.println(rowsAffected);

        } catch (
                SQLException e) {
            try {
                connection.rollback();
                throw new DbException(e.getMessage());
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }

}
