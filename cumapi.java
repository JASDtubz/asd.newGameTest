package main;

import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

import main.engine.*;

public class Main extends Application
{
    Lotion lotion;
    HashMap<String, Sperm> hml;
    Tissue tissue;
    HashMap<String, Semen> hmt;

    BorderPane bp;
    CheckBox collision;
    ChoiceBox<String> choiceC;
    ChoiceBox<String> choiceM;
    HBox hbTfC;
    HBox hbTfM;
    Label l;
    Scene scene;
    TextField tfC;
    TextField tfM;
    VBox vbC;
    VBox vbM;

    public Main() { }

    public static void main(String[] q) { Application.launch(q); }

    @Override
    public void start(Stage s)
    {
        this.l = new Label("loading...");
        this.scene = new Scene(this.l);
        s.setScene(this.scene);
        s.show();

        Platform.runLater(() -> this.start2(s));
    }

    public void start2(Stage s)
    {
        this.lotion = new Lotion();
        this.hml = lotion.execute();
        this.tissue = new Tissue();
        this.hmt = tissue.execute();

        this.choiceC = new ChoiceBox<>();
        this.choiceC.getItems().addAll(this.hml.get("_LIST_")._LIST_);
        this.choiceC.setOnAction(q -> this.updateChars());

        this.choiceM = new ChoiceBox<>();
        this.choiceM.getItems().addAll(this.hmt.get("_LIST_")._LIST_);
        this.choiceM.setOnAction(q -> this.updateMaps());

        this.tfC = new TextField();
        this.tfC.setDisable(true);

        this.hbTfC = new HBox();
        this.hbTfC.getChildren().addAll(new Label("Name"), this.tfC);

        this.tfM = new TextField();
        this.tfM.setDisable(true);

        this.hbTfM = new HBox();
        this.hbTfM.getChildren().addAll(new Label("Name"), this.tfM);

        this.collision = new CheckBox("Collision");
        this.collision.setDisable(true);

        this.vbC = new VBox();
        this.vbC.getChildren().addAll(this.choiceC, this.hbTfC, this.collision);

        this.vbM = new VBox();

        Button chars = new Button("Object");
        Button map = new Button("Map");
        Button save = new Button("Save");

        chars.setOnAction(q -> this.bp.setRight(this.vbC));
        map.setOnAction(q -> this.bp.setRight(this.vbM));

        ToolBar tb = new ToolBar(chars, map, save);

        this.bp = new BorderPane();
        this.bp.setTop(tb);
        this.bp.setRight(this.vbC);
        this.scene = new Scene(this.bp, 854, 480);

        s.hide();
        s.setScene(this.scene);
        s.show();
    }

    public void updateChars()
    {
        String s = this.choiceC.getValue();

        this.tfC.setDisable(false);
        this.tfC.setText(s);

        this.collision.setDisable(false);
        this.collision.setSelected(this.hml.get(s).collision);
    }

    public void updateMaps()
    {
        String s = this.choiceM.getValue();

        this.tfM.setDisable(false);
        this.tfC.setText(s);
    }
}
