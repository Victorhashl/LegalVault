package legalVault;

import java.io.FileReader;
import java.sql.Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

public class DBInitializer
{
    public static void main(String[] args) throws Exception
    {
        Connection connection = Connector.getConnection();
        if (Config.dropOnStart) clearDB(connection);
        if (connection.createStatement().executeQuery("SHOW DATABASES LIKE \"legal_vault\"").next())
        {
            initializeDB(Connector.getDBConnection());
            return;
        }

        connection.createStatement().executeUpdate("CREATE DATABASE IF NOT EXISTS legal_vault");
        connection = Connector.getDBConnection();
        initializeDB(connection);
        initializeData(connection);
    }

    private static void initializeDB(Connection conn) throws Exception
    {
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setSendFullScript(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.runScript(new FileReader(Config.DDLPath));
    }

    private static void initializeData(Connection conn) throws Exception
    {
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setSendFullScript(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.runScript(new FileReader(Config.DMLPath));
    }

    public static void clearDB(Connection connection) throws Exception
    {
        connection.createStatement().executeUpdate("DROP DATABASE IF EXISTS legal_vault");
    }
}
