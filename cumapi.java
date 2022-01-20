import javafx.application.Application;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    static ChoiceBox<String> cb = new ChoiceBox<>();
    static BorderPane bp = new BorderPane();
    static Scene scene;

    public static void main(String[] q) { Application.launch(); }

    @Override
    public void start(Stage s)
    {
        String[] str = { "one", "two" };

        for (String string : str) { cb.getItems().add(string); }

        cb.getItems().add("three");
        cb.setOnAction(e -> event());
        cb.setValue(str[0]);

        bp.setRight(cb);
        scene = new Scene(bp, 854, 480);

        s.setScene(scene);
        s.show();
    }

    public void event()
    {
        System.out.println(cb.getValue());
    }
}
