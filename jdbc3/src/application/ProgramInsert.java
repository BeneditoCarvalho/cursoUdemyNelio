package cursoUdemyNelio.jdbc3.src.application;

import cursoUdemyNelio.jdbc2.src.db.DbException;
import cursoUdemyNelio.jdbc3.src.db.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramInsert {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection;
        PreparedStatement preparedSt;

        try {
            connection = DB.getConnection();
            preparedSt = connection.prepareStatement("INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)");

            preparedSt.setString(1, "Benedito");
            preparedSt.setString(2, "bene@gmail.com");
            preparedSt.setDate(3, new Date(sdf.parse("23/08/1978").getTime()));
            preparedSt.setDouble(4, 5000);
            preparedSt.setInt(5, 4);

            int rowsAffected = preparedSt.executeUpdate();

            System.out.println("Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}
