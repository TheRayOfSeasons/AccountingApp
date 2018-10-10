package Java;

import Objects.CreditTitles;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Float.parseFloat;

@SuppressWarnings("Duplicates")
public class DatabaseHandler extends FillForm
{
    private static Connection conn = null;

    //Tables
    private static String
        CashReceiptA = "CASHRECEIPT_A",
        CashOnHandA = CreditTitles.Cash_On_Hand,
        LoansReceivableA = CreditTitles.Loans_Receivable,
        SavingsDepositA = CreditTitles.Savings_Deposit,
        TimeDepositA = CreditTitles.Time_Deposit,
        IntInc_A = CreditTitles.INT_INC,
        SundryAccountsA = CreditTitles.Sundry_Accounts;

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

    public static String uuidData;

    public static void NewUUID ()
    {
        uuidData = UUID.randomUUID().toString();
    }

    private static Date GetCurrentDate()
    {
        LocalDate localDate = LocalDate.now();
        return Date.valueOf(localDate);
    }

    public static void InitiateDatabase ()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:sql\\sampleDB.sqlite");
            System.out.println("Opened database successfully");
            Statement stmt = conn.createStatement();
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

                    "CREATE TABLE IF NOT EXISTS " + SavingsDepositA +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL, " +
                    accountNo + "     TEXT, " +
                    credit + "        INTEGER);" +

                    "CREATE TABLE IF NOT EXISTS " + TimeDepositA +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL, " +
                    accountNo + "     TEXT, " +
                    credit + "        INTEGER);" +

                    "CREATE TABLE IF NOT EXISTS " + IntInc_A +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    uuid + "          TEXT   NOT NULL, " +
                    referenceNo + "   TEXT   NOT NULL, " +
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
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");

        NewUUID();
    }

    public static List<String> GetDates ()
    {
        List<String> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + date + " " +
                    "FROM " + CashReceiptA + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static List<String> GetParticulars ()
    {
        List<String> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + particular + " " +
                    "FROM " + CashReceiptA + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static List<String> GetReferenceNo ()
    {
        List<String> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + referenceNo + " " +
                            "FROM " + CashReceiptA + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static List<String> GetTypeOfLoan ()
    {
        List<String> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + typeOfLoanNo + " " +
                            "FROM " + LoansReceivableA + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static List<String> GetAccountNo (String accountTitle)
    {
        List<String> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + accountNo + " " +
                            "FROM " + accountTitle + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static List<Float> GetCredits(String accountTitle)
    {
        List<Float> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + credit + " " +
                    "FROM " + accountTitle + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getFloat(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static List<Float> GetDebits (String accountTitle)
    {
        List<Float> contents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT " + debit + " " +
                            "FROM " + accountTitle + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
                contents.add(rs.getFloat(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void AddDataCashReceiptA (String particularData, String referenceNoData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + CashReceiptA +
                    " (" + uuid + ", " + date + ", " + particular + ", " + referenceNo + ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + GetCurrentDate() + "\"" + ", " +
                    "\"" + particularData + "\""  + ", " +
                    "\"" + referenceNoData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddDataCashOnHandA (String referenceNoData, float debitData, float creditData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + CashOnHandA +
                    " (" + uuid + ", " + referenceNo + ", " + debit + ", " + credit + ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + referenceNoData + "\"" + ", " +
                    "\"" + debitData + "\""  + ", " +
                    "\"" + creditData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddDataLoansRecievableA (String referenceNoData, String typeOfLoanData, String accountNoData, float creditData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + LoansReceivableA +
                    " (" + uuid + ", " + referenceNo + ", " + typeOfLoanNo + ", " + accountNo + ", " + credit +  ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + referenceNoData + "\"" + ", " +
                    "\"" + typeOfLoanData + "\""  + ", " +
                    "\"" + accountNoData + "\""  + ", " +
                    "\"" + creditData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddDataSavingsDepositA (String referenceNoData, String accountNoData, float creditData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + SavingsDepositA +
                    " (" + uuid + ", " + referenceNo + ", " + accountNo + ", " + credit + ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + referenceNoData + "\"" + ", " +
                    "\"" + accountNoData + "\""  + ", " +
                    "\"" + creditData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddDataTimeDepositA (String referenceNoData, String accountNoData, float creditData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + TimeDepositA +
                    " (" + uuid + ", " + referenceNo + ", " + accountNo + ", " + credit + ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + referenceNoData + "\"" + ", " +
                    "\"" + accountNoData + "\""  + ", " +
                    "\"" + creditData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddDataINTINCA (String referenceNoData, String accountNoData, float creditData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + IntInc_A +
                    " (" + uuid + ", " + referenceNo + ", " + accountNo + ", " + credit + ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + referenceNoData + "\"" + ", " +
                    "\"" + accountNoData + "\""  + ", " +
                    "\"" + creditData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddDataSundryAccountsA (String referenceNoData, String accountNoData, float debitData, float creditData)
    {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + SundryAccountsA +
                    " (" + uuid + ", " + referenceNo + ", " + accountNo + ", " + debit + ", " + credit + ")" +
                    " VALUES (" +
                    "\"" + uuidData + "\"" + ", " +
                    "\"" + referenceNoData + "\"" + ", " +
                    "\"" + accountNoData + "\""  + ", " +
                    "\"" + debitData + "\""  + ", " +
                    "\"" + creditData + "\""  + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
