package Java;

import Objects.CashReceiptA;
import Objects.Credit;
import Objects.Debit;
import Objects.FieldHolder;

import java.util.ArrayList;
import java.util.List;

public class FillForm
{
    public static List<FieldHolder> OR, Register;

    //CashReceipt A variables
    public static CashReceiptA cashReceiptA;

    public static List<Debit> debits;
    public static List<Credit> credits;

    public static void BeginTranscript()
    {
        cashReceiptA = new CashReceiptA();
        OR = new ArrayList<>();
        Register = new ArrayList<>();

        OR.clear();
        Register.clear();
    }

    public static void Debits (List<Debit> debitList)
    {
        debits = debitList;
    }

    public static void Credits (List<Credit> creditList)
    {
        credits = creditList;
    }

    public static void CommitRecieptA()
    {
        PrintReceiptA();
        InsertToDatabase();
    }

    public static void InsertToDatabase()
    {
        DatabaseHandler.AddDataCashReceiptA(cashReceiptA.Particular, cashReceiptA.ReferenceNo);
        DatabaseHandler.AddDataCashOnHandA(cashReceiptA.ReferenceNo, cashReceiptA.Amount, 0);

        for (Debit d: debits)
        {
            DatabaseHandler.AddDataSundryAccountsA(
                    cashReceiptA.ReferenceNo,
                    d.accountNumber.getText(),
                    Float.parseFloat(d.value.getText()),
                    0);
        }

        for (Credit c: credits)
        {
            if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Cash_On_Hand.toString())
            {
                DatabaseHandler.AddDataCashOnHandA(
                        cashReceiptA.ReferenceNo,
                        0,
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Loans_Receivable.toString())
            {
                DatabaseHandler.AddDataLoansRecievableA(
                        cashReceiptA.ReferenceNo,
                        c.typeOfLoanNo.getText(),
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Savings_Deposit.toString())
            {
                DatabaseHandler.AddDataSavingsDepositA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Time_Deposit.toString())
            {
                DatabaseHandler.AddDataTimeDepositA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.INT_INC.toString())
            {
                DatabaseHandler.AddDataINTINCA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Sundry_Accounts.toString())
            {
                DatabaseHandler.AddDataSundryAccountsA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        0,
                        Float.parseFloat(c.creditValue.getText()));
            }
        }

        DatabaseHandler.NewUUID();
    }

    public static void PrintReceiptA ()
    {
        if (cashReceiptA.isFull())
        {
            //TODO Implement insertion of data into database
            System.out.println("-------------------------------");

            System.out.println("Payee: " + cashReceiptA.Payee);
            System.out.println("Address: " + cashReceiptA.Address);
            System.out.println("Business Style" + cashReceiptA.BusinessStyle);
            System.out.println("OSCA/PWD ID No: " + cashReceiptA.PriorityNumber);
            System.out.println("TIN" + cashReceiptA.TIN);
            System.out.println("Account No: " + cashReceiptA.AccountNumber);
            System.out.println("Amount: " + cashReceiptA.Amount);

            int x = 1;
            System.out.println("\n-----Debits: ");
            for (Debit d: debits)
            {
                System.out.println("Debit " + ++x + ":");
                System.out.println("Account number: " + d.accountNumber.getText()
                        + " | Amount Debited: " + d.value.getText());
            }

            int y = 1;
            System.out.println("\n-----Credits: ");
            for (Credit c: credits) {
                System.out.println("Credit " + ++y + ": ");

                System.out.println("Account Title: " + Events.GetCurrentItem(c.accountTitleBox));
                if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Cash_On_Hand.toString()) {
                    System.out.println("Amount Credited: " + c.creditValue.getText());
                } else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Loans_Receivable.toString()) {
                    System.out.println("Type of Loan No: " + c.typeOfLoanNo.getText()
                            + " | Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText());
                } else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Savings_Deposit.toString()) {
                    System.out.println("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText());
                } else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Time_Deposit.toString()) {
                    System.out.println("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText());
                } else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Sundry_Accounts.toString()) {
                    System.out.println("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText());
                }
            }
        }
    }


}
