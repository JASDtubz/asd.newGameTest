import java.util.HashMap;

public class Semen
{
    public String name;
    public int xMin, yMin, xMax, yMax;
    private HashMap<Integer, Sperm> hm;

    public Semen(HashMap<Integer, Sperm> hm) { this.hm = hm; }

    public void setName(String s) { this.name = s; }

    public void setXMin(int i) { this.xMin = i; }

    public void setYMin(int i) { this.yMin = i; }

    public void setXMax(int i) { this.xMax = i; }

    public void setYMax(int i) { this.yMax = i; }

    public void addCell(String s) { }
}
