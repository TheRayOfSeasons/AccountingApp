package Pages;

import Java.*;
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
import javafx.scene.layout.HBox;
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
            amountText;

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

    private HBox
        headerLayer,
        hboxLayerBottom;

    private VBox
        mainLayout;

    public OfficialReceipt() {}

    public Scene GetScene ()
    {
        InitializeLayouts();
        SetupHeaderLayer();
        SetupTopLayer();
        SetupBottomLayer();

        mainLayout.getChildren().addAll(headerLayer, gridLayerTop, hboxLayerBottom);
        Scene scene = new Scene(mainLayout, 750, 500);
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
        Initialize.StandardGridPane(gridLayerTop);

        headerLayer = new HBox(20);
        Initialize.StandardHBOX(headerLayer);

        hboxLayerBottom = new HBox(20);
        Initialize.StandardHBOX(headerLayer);
        hboxLayerBottom.setAlignment(Pos.BOTTOM_RIGHT);
    }

    private void SetupHeaderLayer ()
    {
        Label label = new Label();
        label.setText("Official Receipt");
        label.setStyle("-fx-font-size: 20");

        headerLayer.getChildren().addAll(label);
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

    private void SetupBottomLayer ()
    {
        Button nextScene = new Button();
        nextScene.setText("Next");
        nextScene.setOnAction(e -> NextMenu());

        hboxLayerBottom.getChildren().addAll(nextScene);
    }

    private void InitializeLabels ()
    {
        payeeText = new Label();
        addressText = new Label();
        bussinessStyleText = new Label();
        priorityNumText = new Label();
        tinText = new Label();
        accountNumText = new Label();
        amountText = new Label();

        payeeText.setText("Payee ");
        addressText.setText("Address ");
        bussinessStyleText.setText("Bus. Style ");
        priorityNumText.setText("OSCA/PWD ID No.");
        tinText.setText("TIN ");
        accountNumText.setText("Account No. ");
        amountText.setText("Amount");
    }

    private void InitializeTextFields ()
    {
        payeeField = new TextField();
        addressField = new TextField();
        bussinessStyleField = new TextField();
        priorityNumField = new TextField();
        tinField = new TextField();
        accountNumField = new TextField();
        amountField = new TextField();

        for (TextField textField : new TextField[]{priorityNumField, tinField, accountNumField, amountField})
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    accountNumField.setText(newValue.replaceAll("[^\\d]", ""));
                    AlertBox.NumOnly();
                }
            });
    }

//    private void something (ObservableValue<? extends String> observable, String oldValue, String newValue)

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
                    tinText,accountNumText, amountText
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
