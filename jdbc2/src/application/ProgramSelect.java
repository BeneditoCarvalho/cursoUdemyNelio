package cursoUdemyNelio.jdbc2.src.application;

import cursoUdemyNelio.jdbc2.src.db.DB;
import cursoUdemyNelio.jdbc2.src.db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramSelect {
    public static void main(String[] args) {

        Connection connection;
        Statement statement;
        ResultSet result;

        try {
            connection = DB.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("select * from seller");

            while (result.next()) {
                System.out.println(result.getInt("Id") + ", " + result.getString("Name"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        DB.closeConnection();
        DB.closeStatement(statement);
        DB.closeResultSet(result);

    }


}
