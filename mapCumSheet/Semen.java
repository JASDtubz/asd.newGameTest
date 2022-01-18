import java.util.HashMap;

public final class Semen
{
    public String name;
    public int xMin, yMin, xMax, yMax;
    public HashMap<String, Cell> hm;
    public String[] _LIST_;

    public Semen() { }

    public void setName(String s) { this.name = s; }

    public void setXMin(int i) { this.xMin = i; }

    public void setYMin(int i) { this.yMin = i; }

    public void setXMax(int i) { this.xMax = i; }

    public void setYMax(int i) { this.yMax = i; }

    public void addCells(HashMap<String, Cell> hm) { this.hm = hm; }
    
    public void list(String[] list) { this._LIST_ = list; }
}
