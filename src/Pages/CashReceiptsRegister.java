package Pages;

import Java.Events;
import Objects.Credit;
import Objects.Debit;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class CashReceiptsRegister
{
    private Label
            particularText,
            referenceText;

    private TextField
            particularField,
            referenceField;

    private Button
            addCreditItem,
            addDebitItem,
            pruneCreditItem,
            pruneDebitItem;

    private List<Debit> debitItems;
    private List<Credit> creditItems;

    private VBox
            mainLayout,
            credits,
            debits;

    private GridPane
            gridLayerTop,
            gridLayerMid,
            debitButtons,
            creditButtons;

    public CashReceiptsRegister()
    {
        debitItems = new ArrayList<>();
        creditItems = new ArrayList<>();
    }

    public Scene GetScene()
    {
        //Populating scene
        InitializeLayouts();

        //Styles
        StyleLayouts();

        //Setup Layer Contents
        SetupParticularUI();
        SetupReferenceUI();
        SetupCredits();
        SetupDebits();

        Button debugButton = new Button();
        debugButton.setText("Debug");
        debugButton.setOnAction(e -> Debug());

        //Assemble Scene
        AssembleScene();

        //InitializeStandardGridPane debit and credit list
        InitializeDebitsAndCredits();

        //Packing up
        mainLayout.getChildren().addAll(gridLayerTop, gridLayerMid, debugButton);
        Scene scene = new Scene(mainLayout, 750, 450);
        return scene;
    }

    //Debit and Credit private methods
    private void Debug ()
    {
        System.out.println("-------------------------------");
        System.out.println("Particular: " + particularField.getText());
        System.out.println("Reference: " + referenceField.getText());

        int x = 1;
        System.out.println("\n-----Debits: ");
        for (Debit d: debitItems)
        {
            System.out.println("Debit " + x + ":");
            System.out.println("Account number: " + d.accountNumber.getText()
                    + " | Amount Debited: " + d.value.getText());
            x++;
        }

        int y = 1;
        System.out.println("\n-----Credits: ");
        for (Credit c: creditItems)
        {
            System.out.println("Credit " + y + ": ");
            System.out.println("Account number: " + c.accountNumber.getText()
                    + " | Amount Credited: " + c.value.getText());
        }
    }

    private void InitializeLayouts ()
    {
        mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(10, 10, 10, 10));

        //Top Layers
        gridLayerTop = new GridPane();
        Events.InitializeStandardGridPane(gridLayerTop);

        //Mid Layers
        gridLayerMid = new GridPane();
        Events.InitializeStandardGridPane(gridLayerMid);

        //Sub mid layers
        debitButtons = new GridPane();
        Events.InitializeStandardGridPane(debitButtons);
        GridPane.setConstraints(debitButtons, 0, 0);

        creditButtons = new GridPane();
        Events.InitializeStandardGridPane(creditButtons);
        GridPane.setConstraints(creditButtons, 1, 0);

        debits = new VBox(20);
        credits = new VBox(20);
        GridPane.setConstraints(debits, 0, 0);
        GridPane.setConstraints(credits, 1, 0);
    }

    private void StyleLayouts ()
    {
        debits.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: gray;");
        credits.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: gray;");
    }

    private void SetupParticularUI ()
    {
        particularText = new Label();
        particularText.setText("Payee");
        GridPane.setConstraints(particularText, 0, 0);
        GridPane.setMargin(particularText, new Insets(1, 1, 1, 1));

        particularField = new TextField();
        particularField.setMinWidth(400);
        GridPane.setConstraints(particularField, 1, 0);
    }

    private void SetupReferenceUI ()
    {
        referenceText = new Label();
        referenceText.setText("Reference No.");
        GridPane.setConstraints(referenceText, 0, 1);

        referenceField = new TextField();
        referenceField.setMinWidth(400);
        GridPane.setConstraints(referenceField, 1, 1);
    }

    private void SetupDebits ()
    {
        addDebitItem = new Button ();
        addDebitItem.setText("Add Debit Account");
        GridPane.setConstraints(addDebitItem, 0, 0);
        addDebitItem.setOnAction(e -> Events.AddDebit(debitItems, debits));

        pruneDebitItem = new Button();
        pruneDebitItem.setText("Remove Debit Account");
        GridPane.setConstraints(pruneDebitItem, 1, 0);
        pruneDebitItem.setOnAction(e -> Events.RemoveDebit(debitItems, debits));
        Events.debitButton = pruneDebitItem;
        Events.ToggleRemoveDebitButton(false);
    }

    private void SetupCredits ()
    {
        addCreditItem = new Button ();
        addCreditItem.setText("Add Credit account");
        GridPane.setConstraints(addCreditItem, 0, 0);
        addCreditItem.setOnAction(e -> Events.AddCredit(creditItems, credits));

        pruneCreditItem = new Button();
        pruneCreditItem.setText("Remove Credit Account");
        GridPane.setConstraints(pruneCreditItem, 1, 0);
        pruneCreditItem.setOnAction(e -> Events.RemoveCredit(creditItems, credits));
        Events.creditButton = pruneCreditItem;
        Events.ToggleRemoveCreditButton(false);
    }

    private void InitializeDebitsAndCredits()
    {
        Events.AddDebit(debitItems, debits);
        Events.AddCredit(creditItems, credits);
    }

    private void AssembleScene()
    {
        //Top Layer
        gridLayerTop.getChildren().addAll(particularText, particularField, referenceText, referenceField);

        //Button layer for Debit and Credit
        debitButtons.getChildren().addAll(addDebitItem, pruneDebitItem);
        creditButtons.getChildren().addAll(addCreditItem, pruneCreditItem);

        //Debit and Credit items beneath button layer
        debits.getChildren().add(debitButtons);
        credits.getChildren().add(creditButtons);

        gridLayerMid.getChildren().addAll(debits, credits);
    }
}