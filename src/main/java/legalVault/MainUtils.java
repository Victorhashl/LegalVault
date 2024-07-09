package legalVault;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainUtils
{
    private static final Connection connection;

    static {
        try {
            connection = Connector.getDBConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //JUDGES
    public static ResultSet getJudges(String condition) throws SQLException
    {
        return connection.createStatement().executeQuery(
                "SELECT * FROM"
                + " JUDGES JOIN PERSONS ON JUDGES.PERSON_ID = PERSONS.PERSON_ID JOIN COURTS ON JUDGES.COURT_ID = COURTS.COURT_ID"
                + " WHERE " + condition
        );
    }

    public static void createJudge(String firstName, String lastName, String mobNo, String address, String DOB, String courtId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(PERSON_ID) AS M FROM PERSONS");
        String personId = rs.next() ? Integer.toString(rs.getInt("m") + 1) : "1";
        stmt.executeUpdate(String.format("INSERT INTO PERSONS VALUE (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", personId, firstName, lastName, mobNo, address, DOB));
        rs = stmt.executeQuery("SELECT MAX(JUDGE_ID) AS M FROM JUDGES");
        String judgeId = rs.next() ? Integer.toString(rs.getInt("m") + 1): "1";
        stmt.executeUpdate(String.format("INSERT INTO JUDGES VALUE (\"%s\", \"%s\", \"%s\")", judgeId, personId, courtId));
        stmt.close();
    }

    public static void updateJudge(String judgeId, String firstName, String lastName, String mobNo, String address, String DOB, String courtId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT PERSON_ID FROM JUDGES WHERE JUDGE_ID = " + judgeId);
        if (!rs.next()) throw new SQLException("JUDGE_NOT_FOUND");
        stmt.executeUpdate(String.format("UPDATE PERSONS SET FIRST_NAME = \"%s\", LAST_NAME = \"%s\", MOB_NO = \"%s\", ADDRESS = \"%s\", DATE_OF_BIRTH = \"%s\" WHERE PERSON_ID = %s",
                firstName, lastName, mobNo, address, DOB, rs.getString("person_id")));
        stmt.executeUpdate("UPDATE JUDGES SET COURT_ID = " + courtId + " WHERE JUDGE_ID = " + judgeId);
    }

    public static void deleteJudge(String judgeId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT PERSON_ID FROM JUDGES WHERE JUDGE_ID = " + judgeId);
        if (!rs.next()) throw new SQLException("JUDGE_NOT_FOUND");
        String personID = rs.getString("person_id");
        stmt.executeUpdate("DELETE FROM JUDGES WHERE JUDGE_ID = " + judgeId);
        stmt.executeUpdate("DELETE FROM PERSONS WHERE PERSON_ID = " + personID);
    }


    // LAWYERS
    public static ResultSet getLawyers(String condition) throws SQLException
    {
        return connection.createStatement().executeQuery(
                "SELECT * FROM"
                        + " LAWYERS JOIN PERSONS ON LAWYERS.PERSON_ID = PERSONS.PERSON_ID JOIN COURTS ON LAWYERS.COURT_ID = COURTS.COURT_ID"
                        + " WHERE " + condition
        );
    }

    public static void createLawyer(String firstName, String lastName, String mobNo, String address, String DOB, String courtId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(PERSON_ID) AS M FROM PERSONS");
        String personId = rs.next() ? Integer.toString(rs.getInt("m") + 1) : "1";
        stmt.executeUpdate(String.format("INSERT INTO PERSONS VALUE (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", personId, firstName, lastName, mobNo, address, DOB));
        rs = stmt.executeQuery("SELECT MAX(LAWYER_ID) AS M FROM LAWYERS");
        String lawyerId = rs.next() ? Integer.toString(rs.getInt("m") + 1): "1";
        stmt.executeUpdate(String.format("INSERT INTO LAWYERS VALUE (\"%s\", \"%s\", \"%s\")", lawyerId, personId, courtId));
        stmt.close();
    }

    public static void updateLawyer(String lawyerId, String firstName, String lastName, String mobNo, String address, String DOB, String courtId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT PERSON_ID FROM LAWYERS WHERE LAWYER_ID = " + lawyerId);
        if (!rs.next()) throw new SQLException("LAWYER_NOT_FOUND");
        stmt.executeUpdate(String.format("UPDATE PERSONS SET FIRST_NAME = \"%s\", LAST_NAME = \"%s\", MOB_NO = \"%s\", ADDRESS = \"%s\", DATE_OF_BIRTH = \"%s\" WHERE PERSON_ID = %s",
                firstName, lastName, mobNo, address, DOB, rs.getString("person_id")));
        stmt.executeUpdate("UPDATE LAWYERS SET COURT_ID = " + courtId + " WHERE LAWYER_ID = " + lawyerId);
    }

    public static void deleteLawyer(String lawyerId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT PERSON_ID FROM LAWYERS WHERE LAWYER_ID = " + lawyerId);
        if (!rs.next()) throw new SQLException("LAWYER_NOT_FOUND");
        String personID = rs.getString("person_id");
        stmt.executeUpdate("DELETE FROM LAWYERS WHERE LAWYER_ID = " + lawyerId);
        stmt.executeUpdate("DELETE FROM PERSONS WHERE PERSON_ID = " + personID);
    }


    // WITNESSES
    public static ResultSet getWitnesses(String condition) throws SQLException
    {
        return connection.createStatement().executeQuery(
                "SELECT * FROM"
                        + " WITNESSES JOIN PERSONS ON WITNESSES.PERSON_ID = PERSONS.PERSON_ID JOIN CASES ON WITNESSES.CASE_ID = CASES.CASE_ID"
                        + " WHERE " + condition
        );
    }

    public static void createWitness(String firstName, String lastName, String mobNo, String address, String DOB, String caseId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(PERSON_ID) AS M FROM PERSONS");
        String personId = rs.next() ? Integer.toString(rs.getInt("m") + 1) : "1";
        stmt.executeUpdate(String.format("INSERT INTO PERSONS VALUE (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", personId, firstName, lastName, mobNo, address, DOB));
        rs = stmt.executeQuery("SELECT MAX(WITNESS_ID) AS M FROM WITNESSES");
        String witnessId = rs.next() ? Integer.toString(rs.getInt("m") + 1): "1";
        stmt.executeUpdate(String.format("INSERT INTO WITNESSES VALUE (\"%s\", \"%s\", \"%s\")", witnessId, personId, caseId));
        stmt.close();
    }

    public static void updateWitness(String witnessId, String firstName, String lastName, String mobNo, String address, String DOB, String caseId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT PERSON_ID FROM WITNESSES WHERE WITNESS_ID = " + witnessId);
        if (!rs.next()) throw new SQLException("WITNESS_NOT_FOUND");
        stmt.executeUpdate(String.format("UPDATE PERSONS SET FIRST_NAME = \"%s\", LAST_NAME = \"%s\", MOB_NO = \"%s\", ADDRESS = \"%s\", DATE_OF_BIRTH = \"%s\" WHERE PERSON_ID = %s",
                firstName, lastName, mobNo, address, DOB, rs.getString("person_id")));
        stmt.executeUpdate("UPDATE WITNESSES SET CASE_ID = " + caseId + " WHERE WITNESS_ID = " + witnessId);
    }

    public static void deleteWitness(String witnessId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT PERSON_ID FROM WITNESSES WHERE WITNESS_ID = " + witnessId);
        if (!rs.next()) throw new SQLException("WITNESS_NOT_FOUND");
        String personID = rs.getString("person_id");
        stmt.executeUpdate("DELETE FROM WITNESSES WHERE WITNESS_ID = " + witnessId);
        stmt.executeUpdate("DELETE FROM PERSONS WHERE PERSON_ID = " + personID);
    }


    // CASES
    public static ResultSet getCases(String condition) throws SQLException
    {
        return connection.createStatement().executeQuery(
                "SELECT * FROM"
                        + " CASES JOIN LAWYERS AS PROSECUTION_LAWYERS ON CASES.PROSECUTION_LAWYER_ID = PROSECUTION_LAWYERS.LAWYER_ID"
                        + " JOIN PERSONS AS PROSECUTION_PERSONS ON PROSECUTION_LAWYERS.PERSON_ID = PROSECUTION_PERSONS.PERSON_ID"
                        + " JOIN LAWYERS AS DEFENDING_LAWYERS ON CASES.DEFENDING_LAWYER_ID = DEFENDING_LAWYERS.LAWYER_ID"
                        + " JOIN PERSONS AS DEFENDING_PERSONS ON DEFENDING_LAWYERS.PERSON_ID = DEFENDING_PERSONS.PERSON_ID"
                        + " WHERE " + condition
        );
    }

    public static ResultSet getCaseCount(String condition) throws SQLException
    {
        return connection.createStatement().executeQuery(
                "SELECT COUNT(*) as C FROM"
                        + " CASES JOIN LAWYERS AS PROSECUTION_LAWYERS ON CASES.PROSECUTION_LAWYER_ID = PROSECUTION_LAWYERS.LAWYER_ID"
                        + " JOIN PERSONS AS PROSECUTION_PERSONS ON PROSECUTION_LAWYERS.PERSON_ID = PROSECUTION_PERSONS.PERSON_ID"
                        + " JOIN LAWYERS AS DEFENDING_LAWYERS ON CASES.DEFENDING_LAWYER_ID = DEFENDING_LAWYERS.LAWYER_ID"
                        + " JOIN PERSONS AS DEFENDING_PERSONS ON DEFENDING_LAWYERS.PERSON_ID = DEFENDING_PERSONS.PERSON_ID"
                        + " WHERE " + condition
        );
    }

    public static void createCase(String courtId, String prosecutionLawyerId, String defendingLawyerId, String judgeId, String offenseId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(CASE_ID) AS M FROM CASES");
        String caseId = rs.next() ? Integer.toString(rs.getInt("m") + 1) : "1";
        stmt.executeUpdate(String.format("INSERT INTO CASES VALUE (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"OPEN\", CURDATE(), NULL, NULL, \"%s\")", caseId, courtId, prosecutionLawyerId, defendingLawyerId, judgeId, offenseId));
    }

    public static void updateCase(String caseId, String prosecutionLawyerId, String defendingLawyerId, String judgeId, String caseStatus, String endDate, String nextHearing, String offenseId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CASES WHERE CASE_ID = " + caseId);
        if (!rs.next()) throw new SQLException("CASE_NOT_FOUND");
        stmt.executeUpdate(String.format("UPDATE CASES SET PROSECUTION_LAWYER_ID = \"%s\", DEFENDING_LAWYER_ID = \"%s\", JUDGE_ID = \"%s\", CASE_STATUS = \"%s\", END_DATE = %s, NEXT_HEARING = %s, OFFENSE_ID = \"%s\" WHERE CASE_ID = %s",
                prosecutionLawyerId, defendingLawyerId, judgeId, caseStatus, caseStatus.equalsIgnoreCase("closed") ? "\"" + endDate + "\"" : "NULL", caseStatus.equalsIgnoreCase("closed") ? "NULL" : "\"" + nextHearing + "\"", offenseId, caseId));
    }

    public static void deleteCase(String caseId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CASES WHERE CASE_ID = " + caseId);
        if (!rs.next()) throw new SQLException("CASE_NOT_FOUND");
        stmt.executeUpdate("DELETE FROM CASES WHERE CASE_ID = " + caseId);
    }


    // COURTS
    public static ResultSet getCourts(String condition) throws SQLException
    {
        return connection.createStatement().executeQuery("SELECT * FROM COURTS WHERE " + condition);
    }

    public static void createCourt(String address) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(COURT_ID) AS M FROM COURTS");
        String courtId = rs.next() ? Integer.toString(rs.getInt("m") + 1) : "1";
        stmt.executeUpdate(String.format("INSERT INTO COURTS VALUE (\"%s\", \"%s\")", courtId, address));
    }

    public static void updateCourt(String courtId, String address) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM COURTS WHERE COURT_ID = " + courtId);
        if (!rs.next()) throw new SQLException("COURT_NOT_FOUND");
        stmt.executeUpdate(String.format("UPDATE COURTS SET address = \"%s\" WHERE COURT_ID = %s", address, courtId));
    }

    public static void deleteCourt(String courtId) throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM COURTS WHERE COURT_ID = " + courtId);
        if (!rs.next()) throw new SQLException("COURT_NOT_FOUND");
        stmt.executeUpdate("DELETE FROM COURTS WHERE COURT_ID = " + courtId);
    }

    public static String getAvgTimeToResolve() throws SQLException
    {
        ResultSet resultSet = connection.createStatement().executeQuery(
                "select avg(datediff(end_date, start_date)) as average_time_to_resolve from cases where case_status='Closed'"
        );
        resultSet.next();
        return resultSet.getString("average_time_to_resolve");
    }


    // TESTING
    public static void main(String[] args) throws Exception
    {
        MainUtils.createLawyer("Jeffrey", "oadkzdvowo", "1010101010", "spkafpk", "1883-02-02", "7");
        System.out.println("LAW");
        ResultSet lawyers = MainUtils.getLawyers("first_name = \"jeffrey\"");
        lawyers.next();
        System.out.println(lawyers.getString("first_name"));
        MainUtils.deleteLawyer(lawyers.getString("lawyer_id"));
    }
}

