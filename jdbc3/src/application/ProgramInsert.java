package cursoUdemyNelio.jdbc3.src.application;

import cursoUdemyNelio.jdbc3.src.db.DB;
import cursoUdemyNelio.jdbc3.src.db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramInsert {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement preparedSt = null;

        try {
            connection = DB.getConnection();
            preparedSt = connection.prepareStatement("INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedSt.setString(1, "Barack Obama");
            preparedSt.setString(2, "obama@gmail.com");
            preparedSt.setDate(3, new Date(sdf.parse("11/02/1950").getTime()));
            preparedSt.setDouble(4, 20000);
            preparedSt.setInt(5, 4);

            int rowsAffected = preparedSt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = preparedSt.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id: " + id);
                }
            } else {
                System.out.println("No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(preparedSt);
            DB.closeConnection();
        }

    }
}
