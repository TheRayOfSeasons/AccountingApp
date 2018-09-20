package Objects;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Credit
{
    public TextField accountNumber, value;
    public GridPane layout;

    public Credit()
    {
        SetupCredit();
    }

    private void SetupCredit()
    {
        Label accountNumberText = new Label();
        accountNumberText.setText("Account No.");
        GridPane.setConstraints(accountNumberText, 0, 0);

        Label creditText = new Label();
        creditText.setText("Credit");
        GridPane.setConstraints(creditText, 0, 1);

        accountNumber = new TextField();
        GridPane.setConstraints(accountNumber, 1, 0);

        value = new TextField();
        GridPane.setConstraints(value, 1, 1);

        layout = new GridPane();
        layout.getChildren().addAll(accountNumberText, accountNumber, creditText, value);
    }
}
