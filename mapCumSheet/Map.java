import java.util.HashMap;

public class Map
{
    public String name;
    private HashMap<Integer, Sperm> hm;
    private int[4] boundaries = []; // mpa boundaries [xMin, xMax, yMin, yMax]
    public Semen(HashMap<Integer, Sperm> hm) { this.hm = hm; }

    public void setName(String s) { this.name = s; }
}

class Thing
{
    public Thing() { }
}
