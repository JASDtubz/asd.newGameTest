import java.util.HashMap;

public class Semen
{
    public String name;
    private HashMap<Integer, Sperm> hm;

    public Semen(HashMap<Integer, Sperm> hm) { this.hm = hm; }

    public void setName(String s) { this.name = s; }
}

class Thing
{
    public Thing() { }
}
