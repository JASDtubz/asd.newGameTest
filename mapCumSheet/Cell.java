import java.util.HashMap;

public class Cell
{
    public int x, y;
    public HashMap<String, String> hm;

    public Cell() { }

    public void setX(int i) { this.x = i; }

    public void setY(int i) { this.y = i; }

    public void setText(HashMap<String, String> hm) { this.hm = hm; }
}
