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
    static int road = 500;
    static int[][] walls = {{ -1000, -1000 }, { -950, -1000 }, { 1000, -1000 }, { -950, 1000 }};

    static String text = "";
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
        if (!text.equals("") && kc == KeyCode.E)
            text = "";
        else if (text.equals(""))
            switch (kc)
            {
                case W:
                    if (player[1] != 50)
                        this.playerMove(false, -50);
                    else
                        this.everything(false, 50);
                    break;
                case A:
                    if (player[0] != 50)
                        this.playerMove(true, -50);
                    else
                        this.everything(true, 50);
                    break;
                case S:
                    if (player[1] != 500)
                        this.playerMove(false, 50);
                    else
                        this.everything(false, -50);
                    break;
                case D:
                    if (player[0] != 800)
                        this.playerMove(true, 50);
                    else
                        this.everything(true, -50);
                    break;
                case E:
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
                case R:
                    realPlayer[0] = 0;
                    realPlayer[1] = 0;
                    realScreen[0] = 0;
                    realScreen[1] = 0;
                    playerHead = 0;
                    player[0] = 400;
                    player[1] = 300;
                    portal[0] = 200;
                    portal[1] = 200;
                    box[0] = -500;
                    box[1] = -100;
                    road = 500;
                    walls[0][0] = -1000;
                    walls[0][1] = -1000;
                    walls[1][0] = -950;
                    walls[1][1] = -1000;
                    walls[2][0] = 1000;
                    walls[2][1] = -1000;
                    walls[3][0] = -950;
                    walls[3][1] = 1000;
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

        if (realScreen[1] <= 1 && realScreen[1] >= -10)
            this.greenRoad(realScreen[0] % 2 == 0);

        this.gc.setFill(Color.RED);

        switch (playerHead)
        {
            case 0:
                this.gc.fillRect(player[0], player[1] + 10, 50, 40);
                this.gc.setFill(Color.WHITE);
                this.gc.fillRect(player[0], player[1], 10, 10);
                this.gc.fillRect(player[0] + 40, player[1], 10, 10);
                this.gc.setFill(Color.YELLOW);
                this.gc.fillRect(player[0] + 20, player[1] + 10, 10, 10);
                this.gc.fillRect(player[0] + 10, player[1] + 20, 30, 20);
                break;
            case 1:
                this.gc.fillRect(player[0], player[1], 40, 50);
                this.gc.setFill(Color.WHITE);
                this.gc.fillRect(player[0] + 40, player[1], 10, 10);
                this.gc.fillRect(player[0] + 40, player[1] + 40, 10, 10);
                this.gc.setFill(Color.YELLOW);
                this.gc.fillRect(player[0] + 30, player[1] + 20, 10, 10);
                this.gc.fillRect(player[0] + 10, player[1] + 10, 20, 30);
                break;
            case 2:
                this.gc.fillRect(player[0], player[1], 50, 40);
                this.gc.setFill(Color.WHITE);
                this.gc.fillRect(player[0] + 40, player[1] + 40, 10, 10);
                this.gc.fillRect(player[0], player[1] + 40, 10, 10);
                this.gc.setFill(Color.YELLOW);
                this.gc.fillRect(player[0] + 20, player[1] + 30, 10, 10);
                this.gc.fillRect(player[0] + 10, player[1] + 10, 30, 20);
                break;
            case 3:
                this.gc.fillRect(player[0] + 10, player[1], 40, 50);
                this.gc.setFill(Color.WHITE);
                this.gc.fillRect(player[0], player[1] + 40, 10, 10);
                this.gc.fillRect(player[0], player[1], 10, 10);
                this.gc.setFill(Color.YELLOW);
                this.gc.fillRect(player[0] + 10, player[1] + 20, 10, 10);
                this.gc.fillRect(player[0] + 20, player[1] + 10, 20, 30);
        }

        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(portal[0], portal[1], 50, 50);
        this.gc.setFill(Color.DARKGREEN);
        this.gc.fillRect(box[0], box[1], 50, 50);
        this.gc.setFill(Color.GRAY);
        this.gc.fillRect(walls[0][0], walls[0][1], 50, 2050);
        this.gc.fillRect(walls[1][0], walls[1][1], 1950, 50);
        this.gc.fillRect(walls[2][0], walls[2][1], 50, 2050);
        this.gc.fillRect(walls[3][0], walls[3][1], 1950, 50);
        this.gc.setFill(Color.BLACK);
        this.gc.fillRect(0, 600, 900, 50);
        this.gc.setFill(Color.WHITE);
        this.gc.setFont(new Font("Courier", 32));
        this.gc.setLineWidth(2);
        this.gc.fillText(text, 0, 637);
        this.realCoords.setText("Real Coordinates " + realPlayer[0] + " " + realPlayer[1]);
        this.screenShift.setText("Screen Position " + realScreen[0] + " " + realScreen[1]);
        this.screenCoords.setText("Screen Coordinates " + player[0] + " " + player[1]);
        this.playerState.setText("Player State " + playerHead);
    }

    public void playerMove(boolean b, int i)
    {
        if (b)
        {
            playerHead = i > 0 ? 1 : 3;
            player[0] += i;

            if ((player[0] == box[0] && player[1] == box[1]) ||
                (player[0] == walls[0][0] || player[0] == walls[2][0]))
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

            if ((player[0] == box[0] && player[1] == box[1]) ||
                (player[1] == walls[1][1] || player[1] == walls[3][1]))
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
            playerHead = i > 0 ? 3 : 1;
            realScreen[0] += i > 0 ? -1 : 1;
            box[0] += i;
            portal[0] += i;

            for (int i_ = 0; i_ < walls.length; i_++)
                walls[i_][0] += i;

            if (player[0] == box[0] && player[1] == box[1] ||
                (player[0] == walls[0][0] || player[0] == walls[2][0]))
            {
                realScreen[0] -= i > 0 ? -1 : 1;
                box[0] -= i;
                portal[0] -= i;

                for (int i_ = 0; i_ < walls.length; i_++)
                    walls[i_][0] -= i;
            }
        }
        else
        {
            playerHead = i > 0 ? 0 : 2;
            realScreen[1] += i > 0 ? 1 : -1;
            box[1] += i;
            portal[1] += i;
            road += i;

            for (int i_ = 0; i_ < walls.length; i_++)
                walls[i_][1] += i;

            if (player[0] == box[0] && player[1] == box[1] ||
                (player[1] == walls[1][1] || player[1] == walls[3][1]))
            {
                realScreen[1] -= i > 0 ? 1 : -1;
                box[1] -= i;
                portal[1] -= i;
                road -= i;

                for (int i_ = 0; i_ < walls.length; i_++)
                    walls[i_][1] -= i;
            }
        }
    }

    public void blueLoop()
    {
        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(0, 0, 900, 650);
        this.gc.setFill(Color.RED);
        this.gc.fillRect(player[0], player[1], 50, 50);
    }

    public void greenRoad(boolean b)
    {
        if (b)
            this.gc.setFill(Color.GREEN);
        else
            this.gc.setFill(Color.LIME);

        for (int i = 0; i < 900; i += 20)
            for (int j = road; j < road + 50; j += 20)
                this.gc.fillRect(i, j, 10, 10);

        for (int i = 10; i < 900; i += 20)
            for (int j = road + 10; j < road + 50; j += 20)
                this.gc.fillRect(i, j, 10, 10);

        if (b)
            this.gc.setFill(Color.LIME);
        else
            this.gc.setFill(Color.GREEN);

        for (int i = 10; i < 900; i += 20)
            for (int j = road; j < road + 50; j += 20)
                this.gc.fillRect(i, j, 10, 10);

        for (int i = 0; i < 900; i += 20)
            for (int j = road + 10; j < road + 50; j += 20)
                this.gc.fillRect(i, j, 10, 10);
    }
}
