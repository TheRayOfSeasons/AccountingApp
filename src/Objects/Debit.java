package Objects;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Debit
{
    public TextField accountNumber, value;
    public GridPane layout;

    public Debit()
    {
        SetupDebit();
    }

    private void SetupDebit ()
    {
        Label accountNumberText = new Label();
        accountNumberText.setText("Account No.");
        GridPane.setConstraints(accountNumberText, 0, 0);

        Label debitText = new Label();
        debitText.setText("Debit");
        GridPane.setConstraints(debitText, 0, 1);

        accountNumber = new TextField();
        GridPane.setConstraints(accountNumber, 1, 0);

        value = new TextField();
        GridPane.setConstraints(value, 1, 1);

        layout = new GridPane();
        layout.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: gray;");
        layout.getChildren().addAll(accountNumberText, accountNumber, debitText, value);
    }
}
