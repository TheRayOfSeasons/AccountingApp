package Pages;

import Java.AlertBox;
import Java.Events;
import Java.FillForm;
import Java.Scenes;
import Objects.FieldHolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OfficialReceipt
{
    private Label
            payeeText,
            addressText,
            bussinessStyleText,
            priorityNumText,
            tinText,
            accountNumText,
            amountText,
            extraText;

    private TextField
            payeeField,
            addressField,
            bussinessStyleField,
            priorityNumField,
            tinField,
            accountNumField,
            amountField;

    private GridPane
        gridLayerTop;

    private VBox
        mainLayout;

    public OfficialReceipt() {}

    public Scene GetScene ()
    {
        InitializeLayouts();
        SetupTopLayer();

        Label label = new Label();
        label.setText("Official Receipt");

        Button nextScene = new Button();
        nextScene.setText("Next");
        nextScene.setOnAction(e -> NextMenu());

        mainLayout.getChildren().addAll(label, gridLayerTop, nextScene);
        Scene scene = new Scene(mainLayout, 750, 450);
        return scene;
    }

    private void NextMenu ()
    {
        //if a field is empty, alert
        for (TextField textField: GetAllTextFields())
        {
            if (textField.getText() == null || textField.getText().trim().isEmpty())
            {
                AlertBox.Empty();
                return;
            }
        }

        FillForm.BeginTranscript();
        FillForm.AddORFields(new FieldHolder("Payee", payeeField.getText()));
        FillForm.AddORFields(new FieldHolder("Address", addressField.getText()));
        FillForm.AddORFields(new FieldHolder("Business Style", bussinessStyleField.getText()));
        FillForm.AddORFields(new FieldHolder("OSCA/PWD ID No.", priorityNumField.getText()));
        FillForm.AddORFields(new FieldHolder("TIN", tinField.getText()));
        FillForm.AddORFields(new FieldHolder("Account No.", accountNumField.getText()));
        FillForm.AddORFields(new FieldHolder("Amount", amountField.getText()));

        Events.SwitchSceneTo(Scenes.CashReceiptsRegisterLayout());
    }

    private void InitializeLayouts ()
    {
        mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(10, 10, 10, 10));

        gridLayerTop = new GridPane();
        Events.InitializeStandardGridPane(gridLayerTop);
    }

    private void SetupTopLayer ()
    {
        InitializeLabels();
        InitializeTextFields();
        ArrangeTopLayerContents();

        gridLayerTop.getChildren().addAll(GetAllLabels());
        gridLayerTop.getChildren().addAll(GetAllTextFields());

        gridLayerTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: gray;");
    }

    private void InitializeLabels ()
    {
        payeeText = new Label();
        addressText = new Label();
        bussinessStyleText = new Label();
        priorityNumText = new Label();
        tinText = new Label();
        accountNumText = new Label();
        extraText = new Label();
        amountText = new Label();

        payeeText.setText("Payee ");
        addressText.setText("Address ");
        bussinessStyleText.setText("Bus. Style ");
        priorityNumText.setText("OSCA/PWD ID No.");
        tinText.setText("TIN ");
        accountNumText.setText("Account No. ");
        amountText.setText("Amount");
        extraText.setText("wow");
    }

    private void InitializeTextFields ()
    {
        payeeField = new TextField();
        addressField = new TextField();
        bussinessStyleField = new TextField();
        priorityNumField = new TextField();
        tinField = new TextField();
        accountNumField = new TextField();
        accountNumField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d*")) {
                        accountNumField.setText(newValue.replaceAll("[^\\d]", ""));
                        AlertBox.NumOnly();
                    }
            }
        });
        amountField = new TextField();
    }

    private void ArrangeTopLayerContents ()
    {
        Label[] labels = GetAllLabels();
        TextField[] textFields = GetAllTextFields();

        for (int i = 0; i < labels.length; i++)
        {
            GridPane.setConstraints(labels[i], 0, i);
            GridPane.setMargin(labels[i], new Insets(7, 2, 7, 2));
        }

        for (int i = 0; i < textFields.length; i++)
        {
            textFields[i].setMinWidth(200);
            GridPane.setConstraints(textFields[i], 1, i);
            GridPane.setMargin(textFields[i], new Insets(7, 2, 7, 2));
        }
    }

    private Label[] GetAllLabels ()
    {
        return new Label[]
                {
                    payeeText, addressText, bussinessStyleText, priorityNumText,
                    tinText,accountNumText, amountText, extraText
                };
    }

    private TextField[] GetAllTextFields ()
    {
        return new TextField[]
                {
                    payeeField, addressField, bussinessStyleField,
                        priorityNumField, tinField, accountNumField, amountField
                };
    }
}
