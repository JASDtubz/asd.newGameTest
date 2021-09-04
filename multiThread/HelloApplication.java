import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloApplication extends Application
{
    public boolean b = true;

    public static void main(String[] a) { launch(a); }

    @Override
    public void start(Stage s)
    {
        Scene scene = new Scene(new BorderPane(), 800, 600);
        scene.setOnKeyPressed(e -> System.out.println("MOKNEE"));
        s.setScene(scene);
        s.setOnCloseRequest(e -> System.exit(0));
        s.show();

        Runnable r = new Tick();
        Thread t = new Thread(r);
        t.start();
    }
}

class Tick implements Runnable
{
    @Override
    public void run()
    {
        HelloApplication ha = new HelloApplication();
        int i = 0;

        while (ha.b)
        {
            long l = System.currentTimeMillis();
            boolean b = true;
            while (b)
            {
                if (System.currentTimeMillis() - l > 1000)
                {
                    b = false;
                    System.out.println(i);
                    i++;
                }
            }
        }
    }
}
