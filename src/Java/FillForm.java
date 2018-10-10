package Java;

import Objects.*;

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
        if (cashReceiptA.isFull())
        {
            System.out.println(PrintReceiptA());
            InsertToDatabase();
        }
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
            if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Cash_On_Hand)
            {
                DatabaseHandler.AddDataCashOnHandA(
                        cashReceiptA.ReferenceNo,
                        0,
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Loans_Receivable)
            {
                DatabaseHandler.AddDataLoansRecievableA(
                        cashReceiptA.ReferenceNo,
                        c.typeOfLoanNo.getText(),
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Savings_Deposit)
            {
                DatabaseHandler.AddDataSavingsDepositA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Time_Deposit)
            {
                DatabaseHandler.AddDataTimeDepositA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.INT_INC)
            {
                DatabaseHandler.AddDataINTINCA(
                        cashReceiptA.ReferenceNo,
                        c.accountNumber.getText(),
                        Float.parseFloat(c.creditValue.getText()));
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Sundry_Accounts)
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

    public static String PrintReceiptA ()
    {
        StringBuilder details = new StringBuilder();
        
        if (cashReceiptA.isFull())
        {
            //TODO Implement insertion of data into database
            details.append("-----Official Receipt\n");

            details.append("Payee: " + cashReceiptA.Payee + "\n");
            details.append("Address: " + cashReceiptA.Address + "\n");
            details.append("Business Style: " + cashReceiptA.BusinessStyle + "\n");
            details.append("OSCA/PWD ID No: " + cashReceiptA.PriorityNumber + "\n");
            details.append("TIN: " + cashReceiptA.TIN + "\n");
            details.append("Account No: " + cashReceiptA.AccountNumber + "\n");
            details.append("Amount: " + cashReceiptA.Amount + "\n");

            int x = 1;
            details.append("\n-----Debits: " + "\n");
            for (Debit d: debits)
            {
                details.append("Debit " + x + ":" + "\n");
                details.append("Account number: " + d.accountNumber.getText()
                        + " | Amount Debited: " + d.value.getText() + "\n");

                x++;
            }

            int y = 1;
            details.append("\n-----Credits: " + "\n");
            for (Credit c: credits) {
                details.append("Credit " + y + ": " + "\n");

                details.append("Account Title: " + Events.GetCurrentItem(c.accountTitleBox) + "\n");
                if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Cash_On_Hand) {
                    details.append("Amount Credited: " + c.creditValue.getText() + "\n");
                } else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Loans_Receivable) {
                    details.append("Type of Loan No: " + c.typeOfLoanNo.getText()
                            + " | Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText() + "\n");
                } else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Savings_Deposit) {
                    details.append("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText() + "\n");
                } else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Time_Deposit) {
                    details.append("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText() + "\n");
                } else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.INT_INC) {
                    details.append("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText() + "\n");
                }else if (Events.GetCurrentItem(c.accountTitleBox) == CreditTitles.Sundry_Accounts) {
                    details.append("Account number: " + c.accountNumber.getText()
                            + " | Amount Credited: " + c.creditValue.getText() + "\n");
                }

                y++;
            }
        }

        return details.toString();
    }
}
