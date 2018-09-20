package Pages;

import Java.Events;
import Java.Scenes;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OrR
{
    private Label
            payeeText,
            addressText,
            bussinessStyleText,
            priorityNumText,
            tinText,
            accountNumText,
            extraText;

    private TextField
            payeeField,
            addressField,
            bussinessStyleField,
            priorityNumField,
            tinField,
            accountNumField;

    private GridPane
        gridLayerTop;

    private VBox
        mainLayout;

    public OrR () {}

    public Scene GetScene ()
    {
        InitializeLayouts();
        SetupTopLayer();

        Button nextScene = new Button();
        nextScene.setText("Next");
        nextScene.setOnAction(e -> Events.SwitchSceneTo(Scenes.CashReceiptsRegisterLayout()));

        mainLayout.getChildren().addAll(gridLayerTop, nextScene);
        Scene scene = new Scene(mainLayout, 750, 450);
        return scene;
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

        gridLayerTop.getChildren().addAll(payeeText, addressText, bussinessStyleText,
                priorityNumText, tinText, accountNumText, extraText, payeeField, addressField, bussinessStyleField,
                priorityNumField, tinField, accountNumField);
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

        payeeText.setText("Payee ");
        addressText.setText("Address ");
        bussinessStyleText.setText("Bus. Style ");
        priorityNumText.setText("OSCA/PWD ID No.");
        tinText.setText("TIN ");
        accountNumText.setText("Account No. ");
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
    }

    private void ArrangeTopLayerContents ()
    {
        Label[] labels = {payeeText, addressText, bussinessStyleText, priorityNumText, tinText,accountNumText, extraText};
        TextField[] textFields = {payeeField, addressField, bussinessStyleField, priorityNumField, tinField, accountNumField};

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
}
