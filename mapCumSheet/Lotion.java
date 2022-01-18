import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Short.parseShort;
import static java.lang.System.err;
import static java.util.Objects.requireNonNull;

public final class Lotion
{
    public Lotion() { }

    synchronized public HashMap<String, Sperm> execute()
    {
        final Scanner scan = new Scanner(requireNonNull(Lotion.class.getResourceAsStream("testicle/egg.cum")));
        HashMap<String, Sperm> hm = new HashMap<>();
        String str;
        StringBuilder sb = new StringBuilder();
        String string = "";
        int line = 0;
        ArrayList<String> list = new ArrayList<>();
        Sperm sperm = new Sperm();

        while (scan.hasNextLine())
        {
            str = scan.nextLine();
            line++;

            if (!str.equals("}")) { sb.append(str); }
            else
            {
                Sperm s = new Sperm();
                boolean bool = true;

                while (bool)
                {
                    try { sb.deleteCharAt(sb.indexOf(" ")); }
                    catch (Exception ignored) { bool = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    bool = true;
                }
                catch (Exception ignored) { err.println("No name found at " + line); }

                if (bool)
                {
                    try { string = sb.substring(0, sb.indexOf(",")); }
                    catch (Exception ignored) { err.println("No name value found at " + line); }
                    finally { bool = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    bool = true;
                }
                catch (Exception ignored) { err.println("No collidable found at " + line); }

                if (bool)
                {
                    try { s.setCollision(sb.substring(0, sb.indexOf(",")).equals("true")); }
                    catch (Exception ignored) { err.println("No collidable value found at " + line); }
                    finally { bool = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":"));
                    bool = true;
                }
                catch (Exception ignored) { err.println("No state found at " + line); }

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
                            try
                            {
                                sb.delete(0, sb.indexOf("<") + 1);
                                r.add(parseShort(sb.substring(0, sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                                g.add(parseShort(sb.substring(0, sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                                b.add(parseShort(sb.substring(0, sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                                x.add(parseShort(sb.substring(0, sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                                y.add(parseShort(sb.substring(0, sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                                l.add(parseShort(sb.substring(0, sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                                h.add(parseShort(sb.substring(0, sb.indexOf(">"))));
                                sb.delete(0, sb.indexOf(">") + 1);
                            }
                            catch (Exception ignored) { err.println("No texture value at " + line); }

                            if (sb.indexOf(")") == 0)
                            {
                                s.setTexture(
                                    this.getList(r), this.getList(g), this.getList(b), this.getList(x), this.getList(y),
                                    this.getList(l), this.getList(h)
                                );

                                b1 = false;
                            }
                        }

                        if (sb.indexOf("]") == 1) { b0 = false; }
                    }
                }

                sb.delete(0, sb.length());
                hm.put(string, s);
                list.add(string);
            }
        }

        sperm.list(this.getList2(list));
        hm.put("_LIST_", sperm);
        return hm;
    }

    synchronized private short[] getList(ArrayList<Short> al)
    {
        short[] ii = new short[al.size()];

        for (int i = 0; i < ii.length; i++) { ii[i] = al.get(i); }

        return ii;
    }

    synchronized private String[] getList2(ArrayList<String> al)
    {
        String[] list = new String[al.size()];

        for (int i = 0; i < al.size(); i++) { list[i] = al.get(i); }

        return list;
    }
}
