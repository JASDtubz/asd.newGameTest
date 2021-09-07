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
        
        while (scan.hasNextLine())  //Scans cum file
        {
            s = new Sperm();
            str = scan.nextLine();
            line++;
            
            if (!str.equals("}"))   //scans until {
                sb.append(str);
            else
            {
                boolean bool = true;
                
                while (bool)    //clears whitespace
                    try { sb.deleteCharAt(sb.indexOf(" ")); }
                    catch (Exception ignored) { bool = false; }

                try { sb.deleteCharAt(sb.indexOf("{")); }   //checks for syntax
                catch (Exception ignored) { System.out.println("No open curly bracket found at " + line); }

                try     //checks for syntax
                {
                    sb.delete(0, sb.indexOf(":"));
                    bool = true;
                }
                catch (Exception ignored) { System.out.println("No name found at " + line); }

                if (bool)   //sets name of map object
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
                    try { sb.delete(sb.indexOf(":"), sb.indexOf("[")); }
                    catch (Exception ignored) { System.out.println("No colon or open bracket found at " + line); }

                    boolean b0 = true;

                    while (b0)
                    {
                        int r = 0;
                        int g = 0;
                        int b = 0;
                        int x = 0;
                        int y = 0;
                        int l = 0;
                        int h = 0;

                        try { sb.delete(0, sb.indexOf("<") + 1); }
                        catch (Exception ignored){ System.out.println("Incorrect syntax at " + line); }

                        try
                        {
                            r = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                            sb.delete(0, sb.indexOf(",") + 1);
                        }
                        catch (Exception ignored) { System.out.println("R error at " + line); }

                        try
                        {
                            g = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                            sb.delete(0, sb.indexOf(",") + 1);
                        }
                        catch (Exception ignored) { System.out.println("G error at " + line); }

                        try
                        {
                            b = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                            sb.delete(0, sb.indexOf(",") + 1);
                        }
                        catch (Exception ignored) { System.out.println("B error at " + line); }

                        try
                        {
                            x = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                            sb.delete(0, sb.indexOf(",") + 1);
                        }
                        catch (Exception ignored) { System.out.println("X error at " + line); }

                        try
                        {
                            y = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                            sb.delete(0, sb.indexOf(",") + 1);
                        }
                        catch (Exception ignored) { System.out.println("Y error at " + line); }

                        try
                        {
                            l = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                            sb.delete(0, sb.indexOf(",") + 1);
                        }
                        catch (Exception ignored) { System.out.println("L error at " + line); }

                        try
                        {
                            h = Integer.parseInt(this.get(new StringBuilder(sb.toString()), sb.indexOf(">")));
                            sb.delete(0, sb.indexOf(">") + 1);
                        }
                        catch (Exception ignored) { System.out.println("H error at " + line); }

                        sb.delete(0, sb.indexOf(")") + 1);
                        s.setTexture(r, b, g, x, y, l, h);

                        if (!this.get(new StringBuilder(sb.toString()), 1).equals(","))
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
