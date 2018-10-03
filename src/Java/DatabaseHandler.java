package Java;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class DatabaseHandler
{
    private static Connection conn = null;
    private static Statement stmt = null;

    //Tables
    private static String
        CashReceiptA = "CASHRECEIPT_A",
        CashOnHandA = "CASHONHAND_A",
        LoansReceivableA = "LOANSRECEIVABLE_A",
        SundryAccountsA = "SUNDRYACCOUNTS_A";

    //Columns
    private static String
        uuid = "UUID",
        date = "\"DATE\"",
        particular = "PARTICULAR",
        referenceNo = "REFERENCE_NO",
        debit = "DEBIT",
        credit = "CREDIT",
        typeOfLoanNo = "TYPE_OF_LOAN_NO",
        accountNo = "ACCOUNT_NO";

    public static void InitiateDatabase ()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rayla\\IdeaProjects\\AccountingApp\\sql\\sampleDB.sqlite");
            System.out.println("Opened database successfully");
            stmt = conn.createStatement();
            String sql =
                    "CREATE TABLE IF NOT EXISTS " + CashReceiptA +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    date + "          DATE   NOT NULL, " +
                    particular + "    TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL);" +

                    "CREATE TABLE IF NOT EXISTS " + CashOnHandA +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL, " +
                    debit + "         INTEGER, " +
                    credit + "        INTEGER);" +

                    "CREATE TABLE IF NOT EXISTS " + LoansReceivableA +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL, " +
                    typeOfLoanNo + "  TEXT, " +
                    accountNo + "     TEXT, " +
                    credit + "        INTEGER);" +

                    "CREATE TABLE IF NOT EXISTS " + SundryAccountsA +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL, " +
                    accountNo + "     TEXT, " +
                    debit + "         INTEGER, " +
                    credit + "        INTEGER);";

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

        AddDataCashReceiptA();
//        AddData();
    }
    public static void AddDataCashReceiptA ()
    {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO " + CashReceiptA +
                    " (" + uuid + ", " + date + ", " + particular + ", " + referenceNo + ")" +
                    " VALUES (" +
                    "\"" + UUID.randomUUID().toString() + "\"" + ", " +
                    "\"" + GetCurrentDate() + "\"" + ", " +
                    "\"Particular Sample\", " +
                    "\"10340\");";
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Date GetCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        LocalDate localDate = LocalDate.now();
        return Date.valueOf(localDate);
    }
}
