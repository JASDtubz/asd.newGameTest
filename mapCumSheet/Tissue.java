import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.err;

public class Tissue
{
    public Tissue() { }

    public HashMap<String, Semen> execute(HashMap<Integer, Sperm> sperm)
    {
        Scanner scan = new Scanner(Objects.requireNonNull(Tissue.class.getResourceAsStream("testicle/condom.came")));
        HashMap<String, Semen> hm = new HashMap<>();
        String str;
        StringBuilder sb = new StringBuilder();
        String string = "";
        int line = 0;

        while (scan.hasNextLine())
        {
            str = scan.nextLine();
            line++;

            if (!str.equals("}")) { sb.append(str); }
            else
            {
                Semen s = new Semen(sperm);
                boolean b = true;

                while (b)
                {
                    try { sb.deleteCharAt(sb.indexOf(" ")); }
                    catch (Exception ignored) { b = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No name found at " + line); }

                if (b)
                {
                    try
                    {
                        s.setName(sb.substring(0, sb.indexOf(",")));
                        string = s.name;
                    }
                    catch (Exception ignored) { err.println("No comma found at " + line); }
                    finally { b = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No minimum x found at " + line); }

                if (b)
                {
                    try { s.setXMin(parseInt(sb.substring(0, sb.indexOf(",")))); }
                    catch (Exception ignored) { err.println("No minimum x value found at " + line); }
                    finally { b = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No minimum y found at " + line); }

                if (b)
                {
                    try { s.setYMin(parseInt(sb.substring(0, sb.indexOf(",")))); }
                    catch (Exception ignored) { err.println("No minimum y value found at " + line); }
                    finally { b = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No maximum x found at " + line); }

                if (b)
                {
                    try { s.setXMax(parseInt(sb.substring(0, sb.indexOf(",")))); }
                    catch (Exception ignored) { err.println("No maximum x value found at " + line); }
                    finally { b = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No maximum y found at " + line); }

                if (b)
                {
                    try { s.setYMax(parseInt(sb.substring(0, sb.indexOf(",")))); }
                    catch (Exception ignored) { err.println("No maximum y value found at " + line); }
                    finally { b = false; }
                }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No sperm found at " + line); }

                if (b)
                {
                    boolean b0 = true;
                    ArrayList<Cell> al = new ArrayList<>();

                    while (b0)
                    {
                        boolean b1 = false;
                        Cell c = new Cell();

                        try
                        {
                            sb.delete(0, sb.indexOf(":") + 1);
                            b1 = true;
                        }
                        catch (Exception ignored) { err.println("No x found at " + line); }

                        if (b1)
                        {
                            try { c.setX(parseInt(sb.substring(0, sb.indexOf(",")))); }
                            catch (Exception ignored) { err.println("No x value found at " + line); }
                            finally { b1 = false; }
                        }

                        try
                        {
                            sb.delete(0, sb.indexOf(":") + 1);
                            b1 = true;
                        }
                        catch (Exception ignored) { err.println("No y found at " + line); }

                        if (b1)
                        {
                            try { c.setY(parseInt(sb.substring(0, sb.indexOf(",")))); }
                            catch (Exception ignored) { err.println("No y value found at " + line); }
                        }
                        
                        b1 = true;

                        while (b1)
                        {
                            HashMap<String, String[]> hms = new HashMap<>();
                            String str0 = "";
                            boolean b2 = false;

                            try
                            {
                                sb.delete(0, sb.indexOf(":") + 1);
                                b2 = true;
                            }
                            catch (Exception ignored) { err.println("No id found at " + line); }
                            
                            if (b2)
                            {
                                try { str0 = sb.substring(0, sb.indexOf("<")); }
                                catch (Exception ignored) { err.println("No id value found at " + line); }
                            }

                            while (b2)
                            {
                                ArrayList<String> als = new ArrayList<>();


                            }

                        }
                    }
                }
            }
        }

        return hm;
    }
}

public String fixString(StringBuilder sb)
{
    boolean b = true;
    
    while (b)
    {
        try { sb.replace(sb.indexOf("_"), sb.indexOf("_"), " "); }
        catch (Exception ignored) { b = false; }
    }
    
    while (!b)
    {
        try { sb.replace(sb.indexOf("`"), sb.indexOf("`"), ","); }
        catch (Exception ignored) { b = true; }
    }
    
    return sb;
}
