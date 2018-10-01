package Java;

import java.sql.*;

public class DatabaseHandler
{
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void InitiateDatabase ()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rayla\\IdeaProjects\\AccountingApp\\sql\\sampleDB.sqlite");
            System.out.println("Opened database successfully");
            stmt = conn.createStatement();
            String sql =
                    "CREATE TABLE IF NOT EXISTS CASHRECEIPT_A " +
                    "(ID INT PRIMARY KEY     NOT NULL, " +
                    " \"DATE\"        DATE   NOT NULL, " +
                    " PARTICULAR      TEXT   NOT NULL, " +
                    " REFERENCE_NO    TEXT   NOT NULL);" +

                    "CREATE TABLE IF NOT EXISTS CASHONHAND_A" +
                    "(ID INT PRIMARY KEY     NOT NULL, " +
                    " REFERENCE_NO    TEXT   NOT NULL, " +
                    " DEBIT           INTEGER, " +
                    " CREDIT          INTEGER);" +

                    "CREATE TABLE IF NOT EXISTS LOANSRECEIVABLE_A" +
                    "(ID INT PRIMARY KEY     NOT NULL, " +
                    " REFERENCE_NO    TEXT   NOT NULL, " +
                    " TYPE_OF_LOAN_NO TEXT, " +
                    " ACCOUNT_NO      TEXT, " +
                    " CREDIT          INTEGER);" +

                    "CREATE TABLE IF NOT EXISTS SUNDRYACCOUNTS_A" +
                    "(ID INT PRIMARY KEY     NOT NULL, " +
                    " REFERENCE_NO    TEXT   NOT NULL, " +
                    " ACCOUNT_NO      TEXT, " +
                    " DEBIT           INTEGER, " +
                    " CREDIT          INTEGER);";

//            "CREATE TABLE IF NOT EXISTS OFFICIAL_RECEIPT " +
//                    "(ID INT PRIMARY KEY     NOT NULL, " +
//                    " PAYEE           TEXT   NOT NULL, " +
//                    " ADDRESS         TEXT   NOT NULL, " +
//                    " BUSINESS_STYLE  TEXT, " +
//                    " PRIORITY_NO TEXT, " +
//                    " TIN             TEXT, " +
//                    " ACCOUNT_NO  TEXT, " +
//                    " AMOUNT          INTEGER)";

            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");

//        AddData();
    }

    public static void AddData ()
    {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO TESTTABLE " +
                    "VALUES (\"1\",\"Ray\", 20, \"wer\", \"10000\")";
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
