package cursoUdemyNelio.jdbc3.src.application;

import cursoUdemyNelio.jdbc3.src.db.DB;
import cursoUdemyNelio.jdbc3.src.db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramInsert {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection;
        PreparedStatement preparedSt = null;

        try {
            connection = DB.getConnection();
            preparedSt = connection.prepareStatement("INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedSt.setString(1, "Benedito");
            preparedSt.setString(2, "bene@gmail.com");
            preparedSt.setDate(3, new Date(sdf.parse("23/08/1978").getTime()));
            preparedSt.setDouble(4, 5000);
            preparedSt.setInt(5, 4);

            int rowsAffected = preparedSt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = preparedSt.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {

                System.out.println("No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(preparedSt);
            DB.closeConnection();
        }

    }
}
