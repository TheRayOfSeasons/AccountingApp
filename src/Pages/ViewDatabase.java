package Pages;

import Java.DatabaseHandler;
import Java.Events;
import Java.Initialize;
import Java.Scenes;
import Objects.CashRecieptAEntry;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewDatabase extends DatabaseHandler
{
    private VBox
        mainLayout,
        tableHolder;

    private Button
        checkTransactions,
        backToPrimary,
        backToMain;

    private TableView<CashRecieptAEntry> table;

    public ViewDatabase () {}

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
        Initialize.StandardVBOX(mainLayout);
    }

    private void SetupContents ()
    {
        table = Tables.Primary();
        tableHolder = new VBox(20);
        Initialize.StandardVBOX(tableHolder);
        tableHolder.getChildren().addAll(table);

        HBox tableButtonSection = new HBox(20);
        Initialize.StandardHBOX(tableButtonSection);

        backToMain = new Button();
        backToMain.setText("Return to Main");
        backToMain.setOnAction(event -> Events.SwitchSceneTo(Scenes.MainMenuLayout()));

        checkTransactions = new Button();
        checkTransactions.setText("Check Transactions");
        checkTransactions.setOnAction(event -> ChangeTable(Tables.Transactions()));

        backToPrimary = new Button();
        backToPrimary.setText("Back to Main Lists");
        backToPrimary.setOnAction(event -> ChangeTable(Tables.Primary()));

        tableButtonSection.getChildren().addAll(backToMain, checkTransactions, backToPrimary);

        mainLayout.getChildren().addAll(tableHolder, tableButtonSection);
    }

    private void ChangeTable (TableView tb)
    {
        tableHolder.getChildren().remove(0);
        tableHolder.getChildren().addAll(tb);

        System.out.println(table.getSelectionModel().getSelectedItem());
    }



}
