import java.util.*;

public class Lotion
{
    public Lotion() { }

    public HashMap<Integer, Sperm> execute()
    {
        Sperm s;
        Scanner scan = new Scanner(Objects.requireNonNull(Lotion.class.getResourceAsStream("testicle/egg.cum")));
        HashMap<Integer, Sperm> hm = new HashMap<>();
        String str;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int line = 0;

        while (scan.hasNextLine())
        {
            str = scan.nextLine();
            line++;

            if (!str.equals("}"))
                sb.append(str);
            else
            {
                s = new Sperm();
                boolean bool = true;

                while (bool)
                    try { sb.deleteCharAt(sb.indexOf(" ")); }
                    catch (Exception ignored) { bool = false; }

                try { sb.deleteCharAt(sb.indexOf("{")); }
                catch (Exception ignored) { System.out.println("No open curly bracket found at " + line); }

                try
                {
                    sb.delete(0, sb.indexOf(":"));
                    bool = true;
                }
                catch (Exception ignored) { System.out.println("No name found at " + line); }

                if (bool)
                {
                    try { sb.deleteCharAt(sb.indexOf(":")); }
                    catch (Exception ignored) { System.out.println("No colon found at " + line); }

                    try { s.setName(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))); }
                    catch (Exception ignored) { System.out.println("No comma found at " + line); }

                    sb.delete(0, sb.indexOf("c"));
                    bool = false;
                }

                try
                {
                    sb.delete(sb.indexOf("collidable"), sb.indexOf(":"));
                    bool = true;
                }
                catch (Exception ignored) { System.out.println("No collidable found at " + line); }

                if (bool)
                {
                    try { sb.deleteCharAt(sb.indexOf(":")); }
                    catch (Exception ignored) { System.out.println("No colon found at " + line); }

                    s.setCollision(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")).equals("true"));
                    sb.delete(0, sb.indexOf("s"));
                    bool = false;
                }

                try
                {
                    sb.delete(sb.indexOf("state"), sb.indexOf(":"));
                    bool = true;
                }
                catch (Exception ignored) { System.out.println("No state found at " + line); }

                if (bool)
                {
                    boolean b0 = true;

                    while (b0)
                    {
                        boolean b1 = true;
                        ArrayList<Short> r = new ArrayList<>();
                        ArrayList<Short> g = new ArrayList<>();
                        ArrayList<Short> b = new ArrayList<>();
                        ArrayList<Short> x = new ArrayList<>();
                        ArrayList<Short> y = new ArrayList<>();
                        ArrayList<Short> l = new ArrayList<>();
                        ArrayList<Short> h = new ArrayList<>();

                        while (b1)
                        {
                            try { sb.delete(0, sb.indexOf("<") + 1); }
                            catch (Exception ignored) { System.out.println("No texture found at " + line); }

                            try
                            {
                                r.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("R error at " + line); }

                            try
                            {
                                g.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("G error at " + line); }

                            try
                            {
                                b.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("B error at " + line); }

                            try
                            {
                                x.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("X error at " + line); }

                            try
                            {
                                y.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("Y error at " + line); }

                            try
                            {
                                l.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("L error at " + line); }

                            try
                            {
                                h.add(Short.parseShort(this.get(new StringBuilder(sb.toString()), sb.indexOf(">"))));
                                sb.delete(0, sb.indexOf(">") + 1);
                            }
                            catch (Exception ignored) { System.out.println("H error at " + line); }

                            if (sb.indexOf(")") == 0)
                            {
                                s.setTexture(r.size(), this.getList(r), this.getList(g), this.getList(b),
                                    this.getList(x), this.getList(y), this.getList(l), this.getList(h));
                                b1 = false;
                            }

                        }

                        if (sb.indexOf("]") == 1)
                            b0 = false;
                    }
                }

                hm.put(i, s);
                i++;
            }
        }

        return hm;
    }

    private String get(StringBuilder sb, int i)
    {
        sb.delete(i, sb.length());

        return sb.toString();
    }

    private short[] getList(ArrayList<Short> al)
    {
        short[] ii = new short[al.size()];

        for (byte i = 0; i < ii.length; i++)
            ii[i] = al.get(i);

        return ii;
    }
}
