package Java;

import Objects.FieldHolder;

import java.util.ArrayList;
import java.util.List;

public class FillForm
{
    public static List<FieldHolder> OR, Register;


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

    public static void PrintRecieptA ()
    {
        for (FieldHolder fieldHolder : OR)
        {
            System.out.println(fieldHolder.fieldName + ": " + fieldHolder.content);
        }
        System.out.println("-------------------------\n");
        for (FieldHolder fieldHolder : Register)
        {
            System.out.println(fieldHolder.fieldName + ": " + fieldHolder.content);
        }
    }
}
