package Java;

import Pages.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Scenes
{
    public static Scene CashReceiptsRegisterLayout()
    {
        return new CashReceiptsRegister().GetScene();
    }

    public static Scene ORLayout()
    {
        return new OfficialReceipt().GetScene();
    }

    public static Scene ConfirmDataLayout() { return new ConfirmData().GetScene(); }

    public static Scene MainMenuLayout () { return new MainMenu().GetScene(); }

    public static Scene ViewDatabaseLayout () { return new ViewDatabase().GetScene(); }

    public static Scene testScene ()
    {
        Button button = new Button();
        button.setText("Submit");
        button.setOnAction(e -> Events.wow());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        return scene;
    }
}
