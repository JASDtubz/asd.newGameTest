import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Lotion l = new Lotion();
        HashMap<String, Sperm> hm = l.execute();
        Tissue t = new Tissue();
        HashMap<String, Semen> hm_ = t.execute();

        int i = hm.get("thing1").texture.size();
//        System.out.println(hm.get(0).name);
//        System.out.println(hm.get(0).collision);
//        System.out.println(hm.get(0).texture.get(0)[0].r);
//        System.out.println(hm.get(0).texture.get(0)[0].g);
//        System.out.println(hm.get(0).texture.get(0)[0].b);
//        System.out.println(hm.get(0).texture.get(0)[0].x);
//        System.out.println(hm.get(0).texture.get(0)[0].y);
//        System.out.println(hm.get(0).texture.get(0)[0].l);
//        System.out.println(hm.get(0).texture.get(0)[0].h);
//        System.out.println(hm.get(0).texture.get(0)[1].r);
//        System.out.println(hm.get(0).texture.get(1)[0].r);
//        System.out.println(hm.get(1).texture.get(0)[0].r);

        System.out.println(hm_.get("intro").name);
        System.out.println(hm_.get("intro").xMin);
        System.out.println(hm_.get("intro").yMin);
        System.out.println(hm_.get("intro").xMax);
        System.out.println(hm_.get("intro").yMax);

        System.out.println(hm_.get("intro").hm.get("thing1").x);
        System.out.println(hm_.get("intro").hm.get("thing1").y);

        System.out.println(hm_.get("intro").hm.get("thing1").hm.get("start1"));
        System.out.println(hm_.get("intro").hm.get("thing1").hm.get("start2"));
        System.out.println(hm_.get("intro").hm.get("thing1").hm.get("start3"));
        System.out.println(hm_.get("intro").hm.get("thing1").hm.get("start4"));

        System.out.println(hm_.get("intro").hm.get("thing2").x);
        System.out.println(hm_.get("intro").hm.get("thing2").y);

        System.out.println(hm_.get("test").xMin);
    }
}
