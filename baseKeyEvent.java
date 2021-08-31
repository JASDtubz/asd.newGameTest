import javafx.application.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloApplication extends Application
{
    static int playerHead = 0;
    static int[] player = { 400, 300 };
    static int[] box = { -500, -100 };
    static int[] portal = { 200, 200 };
    static int[] realPlayer = { 0, 0 };
    static int[] realScreen = { 0, 0 };

    static String text;
    boolean blue = false;
    boolean info = false;
    boolean fullscreen = false;
    BorderPane bp;
    Canvas canvas = new Canvas();
    GraphicsContext gc = this.canvas.getGraphicsContext2D();
    VBox vb;
    Label realCoords = new Label("Real Coordinates 0 0");
    Label screenShift = new Label("Screen Position 0 0");
    Label screenCoords = new Label("Screen Coordinates 0 0");
    Label playerState = new Label("Player State 0");
    Scene scene;
    Stage stage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage s)
    {
        this.vb = new VBox();
        this.vb.getChildren().addAll(this.realCoords, this.screenShift, this.screenCoords, this.playerState);

        this.canvas.setWidth(900);
        this.canvas.setHeight(650);

        this.redraw();

        this.bp = new BorderPane();
        this.bp.setRight(this.canvas);

        this.scene = new Scene(this.bp, 900, 650);
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
                if (player[1] != 0)
                    playerMove(false, -50);
                break;
            case A:
                if (player[0] != 0)
                    playerMove(true, -50);
                break;
            case S:
                if (player[1] != 550)
                    playerMove(false, 50);
                break;
            case D:
                if (player[0] != 850)
                    playerMove(true, 50);
                break;
            case UP:
                if (player[1] != 550)
                    everything(false, 50);
                break;
            case LEFT:
                if (player[0] != 850)
                    everything(true, 50);
                break;
            case DOWN:
                if (player[1] != 0)
                    everything(false, -50);
                break;
            case RIGHT:
                if (player[0] != 0)
                    everything(true, -50);
                break;
            case Z:
                if ((player[0] == box[0] && player[1] == box[1] + 50 && playerHead == 0) ||
                    (player[0] == box[0] - 50 && player[1] == box[1] && playerHead == 1) ||
                    (player[0] == box[0] && player[1] == box[1] - 50 && playerHead == 2) ||
                    (player[0] == box[0] + 50 && player[1] == box[1] && playerHead == 3))
                        text = "An unmovable box.";
                else if ((player[0] == portal[0] && player[1] == portal[1] + 50 && playerHead == 0) ||
                    (player[0] == portal[0] - 50 && player[1] == portal[1] && playerHead == 1) ||
                    (player[0] == portal[0] && player[1] == portal[1] - 50 && playerHead == 2) ||
                    (player[0] == portal[0] + 50 && player[1] == portal[1] && playerHead == 3))
                        text = "A mysterious portal.";
                else if (player[0] == portal[0] && player[1] == portal[1])
                    this.blue = true;
                break;
            case F:
                if (!this.fullscreen)
                {
                    this.stage.setMaximized(true);
                    this.fullscreen = true;
                }
                else
                {
                    this.stage.setMaximized(false);
                    this.fullscreen = false;
                    this.bp.setLeft(new VBox());
                    this.info = false;
                }
                break;
            case ENTER:
                if (!this.info && this.fullscreen)
                {
                    this.bp.setLeft(this.vb);
                    this.info = true;
                }
                else if (this.info && this.fullscreen)
                {
                    this.bp.setLeft(new VBox());
                    this.info = false;
                }
                break;
            case SPACE:
                realPlayer[0] = 0;
                realPlayer[1] = 0;
                playerHead = 0;
                player[0] = 400;
                player[1] = 300;
                portal[0] = 200;
                portal[1] = 200;
                this.blue = false;
        }

        this.redraw();
    }

    public void redraw()
    {
        if (this.blue)
        {
            this.blueLoop();
            return;
        }

        this.gc.setFill(Color.BLACK);
        this.gc.fillRect(0, 0, 900, 600);
        this.gc.setFill(Color.RED);
        this.gc.fillRect(player[0], player[1], 50, 50);
        this.gc.setFill(Color.WHITE);

        double[] x = new double[3];
        double[] y = new double[3];

        switch (playerHead)
        {
            case 0:
                x[0] = player[0] + 25;
                x[1] = player[0] + 12;
                x[2] = player[0] + 37;
                y[0] = player[1];
                y[1] = player[1] + 12;
                y[2] = player[1] + 12;
                break;
            case 1:
                x[0] = player[0] + 50;
                x[1] = player[0] + 37;
                x[2] = player[0] + 37;
                y[0] = player[1] + 25;
                y[1] = player[1] + 12;
                y[2] = player[1] + 37;
                break;
            case 2:
                x[0] = player[0] + 25;
                x[1] = player[0] + 37;
                x[2] = player[0] + 12;
                y[0] = player[1] + 50;
                y[1] = player[1] + 37;
                y[2] = player[1] + 37;
                break;
            case 3:
                x[0] = player[0];
                x[1] = player[0] + 12;
                x[2] = player[0] + 12;
                y[0] = player[1] + 25;
                y[1] = player[1] + 37;
                y[2] = player[1] + 12;
        }

        this.gc.fillPolygon(x, y, 3);
        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(portal[0], portal[1], 50, 50);
        this.gc.setFill(Color.DARKGREEN);
        this.gc.fillRect(box[0], box[1], 50, 50);
        this.gc.setFill(Color.BLACK);
        this.gc.fillRect(0, 600, 900, 50);
        this.gc.setFill(Color.WHITE);
        this.gc.setFont(new Font("Arial", 50));
        this.gc.setLineWidth(2);
        this.gc.fillText(text, 0, 625);
        this.realCoords.setText("Real Coordinates " + realPlayer[0] + " " + realPlayer[1]);
        this.screenShift.setText("Screen Position " + realScreen[0] + " " + realScreen[1]);
        this.screenCoords.setText("Screen Coordinates " + player[0] + " " + player[1]);
        this.playerState.setText("Player State " + playerHead);

        text = "";
    }

    public void playerMove(boolean b, int i)
    {
        if (b)
        {
            playerHead = i > 0 ? 1 : 3;
            player[0] += i;

            if (player[0] == box[0] && player[1] == box[1])
            {
                player[0] -= i;
                return;
            }

            realPlayer[0] += i > 0 ? 1 : -1;
        }
        else
        {
            playerHead = i > 0 ? 2 : 0;
            player[1] += i;

            if (player[0] == box[0] && player[1] == box[1])
            {
                player[1] -= i;
                return;
            }

            realPlayer[1] += i > 0 ? -1 : 1;
        }
    }

    public void everything(boolean b, int i)
    {
        if (b)
        {
            realScreen[0] += i > 0 ? -1: 1;
            player[0] += i;
            box[0] += i;
            portal[0] += i;
        }
        else
        {
            realScreen[1] += i > 0 ? 1 : -1;
            player[1] += i;
            box[1] += i;
            portal[1] += i;
        }
    }

    public void blueLoop()
    {
        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(0, 0, 900, 650);
        this.gc.setFill(Color.RED);
        this.gc.fillRect(player[0], player[1], 50, 50);
    }
}
