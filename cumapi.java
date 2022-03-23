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
import javafx.scene.image.Image;
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
    Button bCC;
    Button bCM;
    Button bMC;
    CheckBox collision;
    ChoiceBox<String> choiceC;
    ChoiceBox<String> choiceM;
    ChoiceBox<String> cbCell;
    HBox hbTfC;
    HBox hbTfM;
    HBox hbXMin;
    HBox hbYMin;
    HBox hbXMax;
    HBox hbYMax;
    HBox hbCC;
    HBox hbCM;
    HBox hbMC;
    Label l;
    Scene scene;
    TextField tfC;
    TextField tfM;
    TextField xMin;
    TextField yMin;
    TextField xMax;
    TextField yMax;
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
        this.choiceC.setOnAction(q -> this.setChars());

        this.bCC = new Button("Add Cell");
        this.bCC.setOnAction(q -> this.addCell());

        this.hbCC = new HBox();
        this.hbCC.getChildren().addAll(this.choiceC, this.bCC);

        this.choiceM = new ChoiceBox<>();
        this.choiceM.getItems().addAll(this.hmt.get("_LIST_")._LIST_);
        this.choiceM.setOnAction(q -> this.updateMaps());

        this.bCM = new Button("Add Map");
        this.bCM.setOnAction(q -> this.addMap());

        this.hbCM = new HBox();
        this.hbCM.getChildren().addAll(this.choiceM, this.bCM);

        this.tfC = new TextField();
        this.tfC.setOnKeyPressed(q -> this.updateChars());
        this.tfC.setDisable(true);

        this.hbTfC = new HBox();
        this.hbTfC.getChildren().addAll(new Label("Name"), this.tfC);

        this.tfM = new TextField();
        this.tfM.setDisable(true);

        this.hbTfM = new HBox();
        this.hbTfM.getChildren().addAll(new Label("Name"), this.tfM);

        this.collision = new CheckBox("Collision");
        this.collision.setDisable(true);

        ChoiceBox<String> cbState = new ChoiceBox<>();

        this.xMin = new TextField();
        this.xMin.setDisable(true);
        this.xMin.setOnAction(q -> this.checkInt());

        this.hbXMin = new HBox();
        this.hbXMin.getChildren().addAll(new Label("Xmin"), this.xMin);

        this.yMin = new TextField();
        this.yMin.setDisable(true);
        this.yMin.setOnAction(q -> this.checkInt());

        this.hbYMin = new HBox();
        this.hbYMin.getChildren().addAll(new Label("Ymin"), this.yMin);

        this.xMax = new TextField();
        this.xMax.setDisable(true);
        this.xMax.setOnAction(q -> this.checkInt());

        this.hbXMax = new HBox();
        this.hbXMax.getChildren().addAll(new Label("Xmax"), this.xMax);

        this.yMax = new TextField();
        this.yMax.setDisable(true);
        this.yMax.setOnAction(q -> this.checkInt());

        this.hbYMax = new HBox();
        this.hbYMax.getChildren().addAll(new Label("Ymax"), this.yMax);

        this.cbCell = new ChoiceBox<>();
        this.cbCell.setDisable(true);

        this.bMC = new Button("Add Cell");
        this.bMC.setOnAction(q -> this.addCellToMap());

        this.hbMC = new HBox();
        this.hbMC.getChildren().addAll(this.cbCell, this.bMC);

        this.vbC = new VBox();
        this.vbC.getChildren().addAll(this.hbCC, this.hbTfC, this.collision);

        this.vbM = new VBox();
        this.vbM.getChildren().addAll(
            this.hbCM, this.hbTfM, this.hbXMin, this.hbYMin, this.hbXMax, this.hbYMax, this.hbMC
        );

        Button up = new Button("↑");
        Button down = new Button("↓");
        Button right = new Button("→");
        Button left = new Button("←");
        Button plus = new Button("+");
        Button minus = new Button("-");

        up.setPrefSize(50, 50);
        down.setPrefSize(50, 50);
        right.setPrefSize(50, 50);
        left.setPrefSize(50, 50);
        plus.setPrefSize(50, 50);
        minus.setPrefSize(50, 50);

        VBox leftCont = new VBox();
        leftCont.getChildren().addAll(up, left, down);

        VBox rightCont = new VBox();
        rightCont.getChildren().addAll(plus, right, minus);

        HBox control = new HBox();
        control.getChildren().addAll(leftCont, rightCont);

        BorderPane charEdit = new BorderPane();
        charEdit.setLeft(control);
        charEdit.setRight(this.vbC);

        BorderPane mapEdit = new BorderPane();
        mapEdit.setRight(this.vbM);

        Button chars = new Button("Object");
        Button map = new Button("Map");
        Button save = new Button("Save");

        chars.setOnAction(q -> this.bp.setCenter(charEdit));
        map.setOnAction(q -> this.bp.setCenter(mapEdit));

        ToolBar tb = new ToolBar(chars, map, save);

        this.l.setText("");

        this.bp = new BorderPane();
        this.bp.setTop(tb);
        this.bp.setCenter(charEdit);
        this.bp.setBottom(this.l);
        this.scene = new Scene(this.bp, 854, 480);

        s.hide();
        s.setTitle("Character and Map Creator");
        s.getIcons().add(new Image("file:src/main/resources/loshun_upsized.png"));
        s.setScene(this.scene);
        s.show();
    }

    public void setChars()
    {
        String s = this.choiceC.getValue();

        this.tfC.setDisable(false);
        this.tfC.setText(s);

        this.collision.setDisable(false);
        this.collision.setSelected(this.hml.get(s).collision);
    }

    public void updateChars()
    {
        
    }

    public void updateMaps()
    {
        String s = this.choiceM.getValue();

        this.tfM.setDisable(false);
        this.tfM.setText(s);

        this.xMin.setDisable(false);
        this.xMin.setText(String.valueOf(this.hmt.get(s).xMin));

        this.yMin.setDisable(false);
        this.yMin.setText(String.valueOf(this.hmt.get(s).yMin));

        this.xMax.setDisable(false);
        this.xMax.setText(String.valueOf(this.hmt.get(s).xMax));

        this.yMax.setDisable(false);
        this.yMax.setText(String.valueOf(this.hmt.get(s).yMax));

        this.cbCell.setDisable(false);
        this.cbCell.getItems().setAll(this.hmt.get(s).hm.get("_LIST_")._LIST_);
    }

    public void checkInt()
    {
        String s = this.choiceM.getValue();
        this.l.setText("");

        try { this.hmt.get(s).xMax = Integer.parseInt(this.xMin.getText()); }
        catch (Exception ignore) { this.l.setText(" Xmin is not a number. "); }

        try { this.hmt.get(s).yMin = Integer.parseInt(this.yMin.getText()); }
        catch (Exception ignore) { this.l.setText(this.l.getText() + " Ymin is not a number. "); }

        try { this.hmt.get(s).xMax = Integer.parseInt(this.xMax.getText()); }
        catch (Exception ignore) { this.l.setText(this.l.getText() + " Xmax is not a number. "); }

        try { this.hmt.get(s).yMax = Integer.parseInt(this.yMax.getText()); }
        catch (Exception ignore) { this.l.setText(this.l.getText() + " Ymax is not a number. "); }
    }

    public void addCell()
    {
        Sperm s = new Sperm();
        s.setCollision(false);

        int i = 0;
        String str;

        while (true)
        {
            if (this.hml.containsKey("Cell" + i)) { i++; }
            else
            {
                str = "Cell" + i;
                this.hml.put(str, s);
                break;
            }
        }

        String[] ss = new String[this.hml.get("_LIST_")._LIST_.length + 1];
        System.arraycopy(this.hml.get("_LIST_")._LIST_, 0, ss, 0, this.hml.get("_LIST_")._LIST_.length);
        ss[this.hml.get("_LIST_")._LIST_.length] = str;
        this.hml.get("_LIST_")._LIST_ = new String[ss.length];
        System.arraycopy(ss, 0, this.hml.get("_LIST_")._LIST_, 0, ss.length);

        this.choiceC.setValue(str);
        this.choiceC.getItems().setAll(this.hml.get("_LIST_")._LIST_);
        this.updateChars();
    }

    public void addMap()
    {

    }

    public void addCellToMap()
    {

    }

    public void save()
    {

    }
}
