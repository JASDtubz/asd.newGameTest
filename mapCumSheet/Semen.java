import java.util.HashMap;

public class Semen
{
    public String name;
    public int xMin, yMin, xMax, yMax;
    private HashMap<Integer, Sperm> hm;

    public Semen(HashMap<Integer, Sperm> hm) { this.hm = hm; }

    public void setName(String s) { this.name = s; }
    
    public void setXMin(String s) { this.xMin = Integer.parseInt(s); }
    
    public void setYMin(String s) { this.yMin = Integer.parseInt(s); }
    
    public void setXMax(String s) { this.xMax = Integer.parseInt(s); }
    
    public void setYMax(String s) { this.yMax = Integer.parseInt(s); }
}

class Thing
{
    public Thing() { }
}
