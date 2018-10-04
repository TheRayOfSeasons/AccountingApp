package Objects;

import Java.Initialize;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Credit
{
    public TextField
            accountNumber,
            creditValue,
            typeOfLoanNo;
    public GridPane gridPane;
    public VBox layout;
    public ComboBox accountTitle;

    private String currentSelected = "";

    public Credit()
    {
        SetupCredit();
    }

    private void SetupCredit()
    {
        Label accountTitleText = new Label();
        accountTitleText.setText("Account Name");
        GridPane.setConstraints(accountTitleText, 0, 1);

        accountTitle = new ComboBox();
        accountTitle.getItems().addAll(
                "Cash On Hand",
                "Loans Receivable",
                "Savings Deposit",
                "Time Deposit",
                "Sundry Accounts"
        );
        accountTitle.getSelectionModel().selectFirst();

        layout = new VBox(20);
        Initialize.StandardVBOX(layout);
        layout.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
            + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
            + "-fx-border-radius: 5;" + "-fx-border-color: gray;");

        gridPane = new GridPane();
        gridPane.getChildren().addAll(accountTitleText, accountTitle);
        layout.getChildren().addAll(gridPane, CashOnHandLayout());

        accountTitle.setOnAction(event ->
                layout.getChildren().add(SetCreditForm(accountTitle.getSelectionModel().getSelectedItem().toString())));

        GridPane.setConstraints(accountTitle, 1, 1);

    }

    private GridPane SetCreditForm (String accountTitle)
    {
        layout.getChildren().remove(1);
        GridPane creditLayout = new GridPane();
        Initialize.StandardGridPane(creditLayout);

        if (accountTitle == "Cash On Hand")
        {
            creditLayout = CashOnHandLayout();
        }
        else if (accountTitle == "Loans Receivable")
        {
            creditLayout = LoansReceivableLayout();
        }
        else
        {
            creditLayout = BasicLayout();
        }

        return creditLayout;
    }

    private GridPane CashOnHandLayout ()
    {
        GridPane creditLayout = new GridPane();

        Label creditText = new Label();
        creditText.setText("Credit   ");
        GridPane.setConstraints(creditText,0, 0);

        creditValue = new TextField();
        GridPane.setConstraints(creditValue,1, 0);

        creditLayout.getChildren().addAll(creditText, creditValue);

        return creditLayout;
    }

    private GridPane LoansReceivableLayout ()
    {
        GridPane creditLayout = new GridPane();

        Label typeOfLoanText = new Label();
        typeOfLoanText.setText("Type Of Loan");

        Label accountNumberText = new Label();
        accountNumberText.setText("Account No.");

        Label creditText = new Label();
        creditText.setText("Credit");

        typeOfLoanNo = new TextField();
        accountNumber = new TextField();
        creditValue = new TextField();

        Label[] labels = {typeOfLoanText, accountNumberText, creditText};
        TextField[] textFields = {typeOfLoanNo, accountNumber, creditValue};

        for (int i = 0; i < 3; i++)
        {
            GridPane.setConstraints(labels[i], 0, i);
            GridPane.setConstraints(textFields[i], 1, i);
        }

        creditLayout.getChildren().addAll(labels);
        creditLayout.getChildren().addAll(textFields);

        return creditLayout;
    }

    private GridPane BasicLayout ()
    {
        GridPane creditLayout = new GridPane();

        Label accountNumberText = new Label();
        accountNumberText.setText("Account No.");

        Label creditText = new Label();
        creditText.setText("Credit");

        accountNumber = new TextField();
        creditValue = new TextField();

        Label[] labels = {accountNumberText, creditText};
        TextField[] textFields = {accountNumber, creditValue};

        for (int i = 0; i < 2; i++)
        {
            GridPane.setConstraints(labels[i], 0, i);
            GridPane.setConstraints(textFields[i], 1, i);
        }

        creditLayout.getChildren().addAll(labels);
        creditLayout.getChildren().addAll(textFields);

        return creditLayout;
    }
}
