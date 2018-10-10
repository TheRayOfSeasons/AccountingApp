package Pages;

import Java.Events;
import Java.Initialize;
import Java.Scenes;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.w3c.dom.events.Event;

public class MainMenu
{
    private VBox mainLayout;

    private Button
        cashRecieptA_Button,
        viewContents;

    private Label
        header;

    public MainMenu () {}

    public Scene GetScene ()
    {
        SetupLayouts();
        SetupContents();

        Scene scene = new Scene(mainLayout, Initialize.StandardWindowMinWidth(), Initialize.StandardWindowMinHeight());
        return scene;
    }

    private void SetupLayouts ()
    {
        mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        Initialize.StandardVBOX(mainLayout);
    }

    private void SetupContents ()
    {
        header = new Label();
        header.setText("Main Menu");
        header.setStyle("-fx-font-size: 20");

        cashRecieptA_Button = new Button();
        cashRecieptA_Button.setText("Begin Cash Receipt Transaction");
        cashRecieptA_Button.setOnAction(event -> Events.SwitchSceneTo(Scenes.ORLayout()));

        viewContents = new Button();
        viewContents.setText("View Database");
        viewContents.setOnAction(event -> Events.SwitchSceneTo(Scenes.ViewDatabaseLayout()));

        mainLayout.getChildren().addAll(header, cashRecieptA_Button, viewContents);
    }
}
