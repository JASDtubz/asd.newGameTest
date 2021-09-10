import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Lotion l = new Lotion();
        HashMap<Integer, Sperm> hm = l.execute();
        System.out.println(hm.get(0).name);
        System.out.println(hm.get(0).collision);
        System.out.println(hm.get(0).texture.get(0)[0].r);
        System.out.println(hm.get(0).texture.get(0)[1].r);
        System.out.println(hm.get(0).texture.get(1)[0].r);
        System.out.println(hm.get(1).texture.get(0)[0].r);
    }
}
