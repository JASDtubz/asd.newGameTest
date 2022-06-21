package main;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main extends Application
{
    private long time;

    public static void main(String[] q) { Application.launch(q); }

    @Override
    public void start(Stage stage)
    {
        this.time = System.currentTimeMillis();

        ImageView iv = new ImageView(new Image("file:loshun_upsized.png", 64D, 64D, true, true));
        ImageView iw = new ImageView(new Image("file:loshun_upsized.png", 64D, 64D, true, false));

        iv.setY(64D);

        iw.setX(256D);
        iw.setY(256D);

        iw.setOnMouseClicked(q -> this.playSound("soundfile.wav"));

        Pane p = new Pane(iv, iw);

        Scene scene = new Scene(p, 800, 600);
        scene.setOnKeyPressed(q -> this.move(q.getCode(), iw));

        stage.setScene(scene);
        stage.show();
    }

    private void playSound(String s)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new java.io.File(s));
            Clip c = AudioSystem.getClip();
            c.open(ais);
            c.loop(Clip.LOOP_CONTINUOUSLY);
            c.start();
        }
        catch (Exception ignore) { System.out.println("no"); }
    }

    private void move(KeyCode kc, ImageView iv)
    {
        if (System.currentTimeMillis() - this.time > 200)
        {
            TranslateTransition a = new TranslateTransition();
            a.setNode(iv);
            a.setDuration(Duration.millis(200D));

            switch (kc)
            {
                case W:
                    a.setByY(-64D);
                    break;
                case A:
                    a.setByX(-64D);
                    break;
                case S:
                    a.setByY(64D);
                    break;
                case D:
                    a.setByX(64D);
                    break;
            }

            a.play();
            this.time = System.currentTimeMillis();
        }
    }
}
