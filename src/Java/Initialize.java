package Java;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Initialize
{
    public static void StandardVBOX (VBox layout)
    {
        layout.setPadding(new Insets(10, 10, 10, 10));
    }

    public static void StandardHBOX (HBox layout)
    {
        layout.setPadding(new Insets(10, 10, 10, 10));
    }

    public static void StandardGridPane(GridPane gridPane)
    {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
    }

    public static float StandardWindowMinHeight ()
    {
        return 600;
    }

    public static float StandardWindowMinWidth ()
    {
        return 750;
    }
}
