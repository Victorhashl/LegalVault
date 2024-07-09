package legalVault;

public class Config
{
    public static String dbURL = "jdbc:mysql://localhost:3306/legal_vault";
    public static String URL = "jdbc:mysql://localhost:3306";
    public static String dbUser = "root";
    public static String dbPass = "password";
    public static String DDLPath = "src/main/resources/sql_queries/DDL_queries.sql";
    public static String DMLPath = "src/main/resources/sql_queries/DML_queries.sql";
    public static boolean dropOnStart = true;
}