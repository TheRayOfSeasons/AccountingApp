package Objects;

public class CreditTitles
{
    public static String
            Cash_On_Hand = "Cash_on_Hand",
            Loans_Receivable = "Loans_Receivable",
            Savings_Deposit = "Savings_Deposit",
            Time_Deposit = "Time_Deposit",
            INT_INC = "INT_INC",
            Sundry_Accounts = "Sundry_Accounts";

    public static String[] GetAll()
    {
        return new String[]
                {
                        Cash_On_Hand,
                        Loans_Receivable,
                        Savings_Deposit,
                        Time_Deposit,
                        INT_INC,
                        Sundry_Accounts
                };
    }
}
