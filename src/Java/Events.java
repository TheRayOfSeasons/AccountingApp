package Java;

import Objects.Credit;
import Objects.Debit;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Events
{
    public static Button
        debitButton,
        creditButton;

    public static Stage stage;

    public static void wow()
    {
        System.out.println("WOW");
    }

    public static void RepositionLabel (Label label, int column, int row)
    {
        GridPane.setConstraints(label, column, row);
    }

    //Debit Functions
    public static void AddDebit (List<Debit> debits, VBox debitLayout)
    {
        Debit debit = new Debit();
        debits.add(debit);
        debitLayout.getChildren().add(debit.layout);

        if (debits.size() > 1)
            ToggleRemoveDebitButton(true);

        for (Debit d : debits)
            System.out.println("A debit has been added.");
    }

    public static void RemoveDebit (List<Debit> debits, VBox debitLayout)
    {
        if (debits.size() > 1)
        {
            debitLayout.getChildren().remove(debits.get(debits.size() - 1).layout);
            debits.remove(debits.size() - 1);
            System.out.println("A debit has been removed.");

            if (debits.size() <= 1)
                ToggleRemoveDebitButton(false);
        }
    }

    public static void ToggleRemoveDebitButton (boolean toggle)
    {
        debitButton.setDisable(!toggle);
    }

    //Credit Functions
    public static void AddCredit (List<Credit> credits, VBox creditLayout)
    {
        Credit credit = new Credit();
        credits.add(credit);
        creditLayout.getChildren().add(credit.layout);

        if (credits.size() > 1)
            ToggleRemoveCreditButton(true);

        for (Credit c : credits)
            System.out.println("A credit has been added.");
    }

    public static void RemoveCredit (List<Credit> credits, VBox creditLayout)
    {
        if (credits.size() > 1)
        {
            creditLayout.getChildren().remove(credits.get(credits.size() - 1).layout);
            credits.remove(credits.size() - 1);
            System.out.println("A credit has been removed.");

            if (credits.size() <= 1)
                ToggleRemoveCreditButton(false);
        }
    }

    public static void ToggleRemoveCreditButton (boolean toggle)
    {
        creditButton.setDisable(!toggle);
    }

    public static void InitializeStandardMainVBOX (VBox layout)
    {
        layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
    }

    public static void InitializeStandardGridPane(GridPane gridPane)
    {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
    }



    public static void PrintReceipt ()
    {
        //TODO make CashReceipt and OR object
    }

    public static void SwitchSceneTo (Scene scene)
    {
        stage.setScene(scene);
    }
}
