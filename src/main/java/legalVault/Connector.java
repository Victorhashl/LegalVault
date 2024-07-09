package legalVault;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector
{
    static Connection DBcon;
    static Connection con;

    static void initDBConnection(String dbURL, String dbUser, String dbPass) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        DBcon = DriverManager.getConnection(dbURL, dbUser, dbPass);
    }

    static void initConnection(String dbURL, String dbUser, String dbPass) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, dbUser, dbPass);
    }

    public static Connection getDBConnection() throws Exception
    {
        if (DBcon != null) return DBcon;
        initDBConnection(Config.dbURL, Config.dbUser, Config.dbPass);
        return DBcon;
    }

    public static Connection getConnection() throws Exception
    {
        if (con != null) return con;
        initConnection(Config.URL, Config.dbUser, Config.dbPass);
        return con;
    }
}