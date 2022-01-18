import java.util.HashMap;

public final class Cell
{
    public int x, y;
    public HashMap<String, String> hm;
    public String[] _LIST_;

    public Cell() { }

    public void setX(int i) { this.x = i; }

    public void setY(int i) { this.y = i; }

    public void setText(HashMap<String, String> hm) { this.hm = hm; }
    
    public void list(String[] s) { this._LIST_ = s; }
}
