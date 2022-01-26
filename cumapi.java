import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    ChoiceBox<String> cb = new ChoiceBox();
    BorderPane bp = new BorderPane();
    Scene scene;

    public Main() { }
    
    public static void main(String[] q) { Application.launch(q); }

    @Override
    public void start(Stage s)
    {
        Label l = new Label("loading...");
        Scene temp = new Scene(l);
        
        s.setScene(temp);
        s.show();
        
        Lotion lotion = new Lotion();
        HashMap<String, Sperm> hml = lotion.execute();
        Tissue tissue = new Tissue();
        HashMap<String, Semen> hmt = tissue.execute();
        

        String[] str = { "one", "two" };

        for (String string : str) { this.cb.getItems().add(string); }

        this.cb.getItems().add("three");
        this.cb.setValue(str[0]);
        
        Button object = new Button("Object");
        Button map = new Button("Map");
        
        ToolBar tb = new ToolBar(object, map);

        this.bp.setTop(tb);
        this.bp.setRight(cb);
        this.scene = new Scene(bp, 854, 480);
        
        s.hide();
        s.setScene(this.scene);
        s.show();
    }
}
