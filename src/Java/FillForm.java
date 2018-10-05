package Java;

import Objects.Credit;
import Objects.Debit;
import Objects.FieldHolder;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

public class FillForm
{
    public static List<FieldHolder> OR, Register;
    public static List<Debit> debits;
    public static List<Credit> credits;

    public static void BeginTranscript()
    {
        OR = new ArrayList<>();
        Register = new ArrayList<>();

        OR.clear();
        Register.clear();
    }

    public static void AddORFields (FieldHolder fieldHolder)
    {
        OR.add(fieldHolder);
    }

    public static void AddRegisterFields (FieldHolder fieldHolder)
    {
        Register.add(fieldHolder);
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
    }

    public static void PrintReceiptA ()
    {
        //TODO Implement insertion of data into database
        System.out.println("-------------------------------");

        for (FieldHolder fieldHolder : OR)
        {
            System.out.println(fieldHolder.fieldName + ": " + fieldHolder.content);
        }
        System.out.println("-------------------------\n");
        for (FieldHolder fieldHolder : Register)
        {
            System.out.println(fieldHolder.fieldName + ": " + fieldHolder.content);
        }

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
        for (Credit c: credits)
        {
            System.out.println("Credit " + ++y + ": ");

            System.out.println("Account Title: " + Events.GetCurrentItem(c.accountTitleBox));
            if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Cash_On_Hand.toString())
            {
                System.out.println("Amount Credited: " + c.creditValue.getText());
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Loans_Receivable.toString())
            {
                System.out.println("Type of Loan No: " + c.typeOfLoanNo.getText()
                        + " | Account number: " + c.accountNumber.getText()
                        + " | Amount Credited: " + c.creditValue.getText());
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Savings_Deposit.toString())
            {
                System.out.println("Account number: " + c.accountNumber.getText()
                        + " | Amount Credited: " + c.creditValue.getText());
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Time_Deposit.toString())
            {
                System.out.println("Account number: " + c.accountNumber.getText()
                        + " | Amount Credited: " + c.creditValue.getText());
            }
            else if (Events.GetCurrentItem(c.accountTitleBox) == Credit.Titles.Sundry_Accounts.toString())
            {
                System.out.println("Account number: " + c.accountNumber.getText()
                        + " | Amount Credited: " + c.creditValue.getText());
            }
        }
    }


}
