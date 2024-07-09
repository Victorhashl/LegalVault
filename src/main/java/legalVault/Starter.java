package legalVault;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Starter
{
    static void initialize() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/legalvault", "root", "password");
    }

    public static void main(String[] args) throws Exception
    {
        DBInitializer.main(args);
        LoginFrontend.main(args);
    }
}