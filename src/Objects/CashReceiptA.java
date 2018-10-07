package Objects;

public class CashReceiptA
{
    public static String
            Payee,
            Address,
            BusinessStyle,
            PriorityNumber,
            TIN,
            AccountNumber,
            Particular,
            ReferenceNo;

    public static float
            Amount;

    public CashReceiptA () {}

    public boolean isFull ()
    {
        if (Amount == 0) {
            System.out.println("Amount is empty");
            return false;
        }

        for (String s : GetAllStringValues())
        {
            if (s == null)
                return false;
        }

        return true;
    }

    public String[] GetAllStringValues ()
    {
        return new String[] {Payee, Address, BusinessStyle, PriorityNumber, TIN, AccountNumber, Particular, ReferenceNo};
    }
}
