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
            s = new Sperm();
            str = scan.nextLine();
            line++;
            
            if (!str.equals("}"))
                sb.append(str);
            else
            {
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
                        ArrayList<Integer> r = new ArrayList<>();
                        ArrayList<Integer> g = new ArrayList<>();
                        ArrayList<Integer> b = new ArrayList<>();
                        ArrayList<Integer> x = new ArrayList<>();
                        ArrayList<Integer> y = new ArrayList<>();
                        ArrayList<Integer> l = new ArrayList<>();
                        ArrayList<Integer> h = new ArrayList<>();
                        int i0 = 0;
                        
                        while (b1)
                        {
                            try
                            {
                                r.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("R error at " + line); }

                            try
                            {
                                g.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("G error at " + line); }

                            try
                            {
                                b.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("B error at " + line); }

                            try
                            {
                                x.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("X error at " + line); }

                            try
                            {
                                y.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("Y error at " + line); }

                            try
                            {
                                l.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))));
                                sb.delete(0, sb.indexOf(",") + 1);
                            }
                            catch (Exception ignored) { System.out.println("L error at " + line); }

                            try
                            {
                                h.add(Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(">"))));
                                sb.delete(0, sb.indexOf(">") + 1);
                            }
                            catch (Exception ignored) { System.out.println("H error at " + line); }
                            
                            s.setTexture(i0, r.toArray(), g.toArray(), b.toArray(), x.toArray(), y.toArray(), l.toArray(), h.toArray());
                            i0++;
                                
                            if (!sb.indexOf(0).equals(","))
                                b1 = false;

                        }
                        
                        if (sb.indexOf(1).equals("]"))
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
        boolean b = true;

        while (b)
            try { sb.deleteCharAt(i); }
            catch (Exception ignored) { b = false; }

        return sb.toString();
    }
}
