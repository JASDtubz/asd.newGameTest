import javafx.application.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class HelloApplication extends Application
{
    int x = 400;
    int y = 300;

    Canvas canvas = new Canvas();
    GraphicsContext gc = this.canvas.getGraphicsContext2D();
    Scene scene;
    Stage stage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage s)
    {
        this.canvas.setWidth(800);
        this.canvas.setHeight(600);

        this.redraw();

        StackPane sp = new StackPane();
        sp.getChildren().add(this.canvas);

        this.scene = new Scene(sp, 800, 600);
        this.scene.setOnKeyPressed(e -> this.update(e.getCode()));

        this.stage = s;
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void update(KeyCode kc)
    {
        switch (kc)
        {
            case W:
                this.y -= 100;
                break;
            case A:
                this.x -= 100;
                break;
            case S:
                this.y += 100;
                break;
            case D:
                this.x += 100;
                break;
        }

        this.redraw();
    }

    public void redraw()
    {
        this.gc.setFill(Color.BLACK);
        this.gc.fillRect(0, 0, 800, 600);
        this.gc.setFill(Color.RED);
        this.gc.fillOval(this.x - 25, this.y - 25, 50, 50);
    }
}
