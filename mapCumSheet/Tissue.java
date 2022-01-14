import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.err;
import static java.util.Objects.requireNonNull;

public class Tissue
{
    public Tissue() { }

    public HashMap<String, Semen> execute()
    {
        Scanner scan = new Scanner(requireNonNull(Tissue.class.getResourceAsStream("testicle/condom.came")));
        HashMap<String, Semen> hm = new HashMap<>();
        String str = "";
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
                Semen s = new Semen();
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

                //Checks Sperm
                try
                {
                    sb.delete(0, sb.indexOf("[") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No sperm found at " + line); }

                /*
                        TODO create Cell here
                    TODO add Cell
                        create Cell Objects here
                    TODO in Cell add Cell Objects
                        create text here
                    TODO in Cell Objects add text
                    TODO return List of Cells
                 */


                if (b)
                {
                    HashMap<String, Cell> hmc = new HashMap<>();
                    boolean b0 = true;

                    //  Cell Loop
                    while (b0)
                    {
                        Cell c = new Cell();
                        String ctr = "";
                        HashMap<String, String> hms = new HashMap<>();
                        boolean b1 = false;

                        try
                        {
                            ctr = sb.substring(0, sb.indexOf(":"));
                            sb.delete(0, sb.indexOf("(") + 1);
                            sb.delete(0, sb.indexOf(":") + 1);
                            b1 = true;
                        }
                        catch (Exception ignored) { err.println("No name found at " + line); }

                        if (b1)
                        {
                            try { c.setX(parseInt(sb.substring(0, sb.indexOf(",")))); }
                            catch (Exception ignored) { err.println("No x value at " + line); }
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
                            catch (Exception ignored) { err.println("No y value at " + line); }
                            //Redundant finally statement
                        }

                        b1 = true;

                        //  String Loop
                        while (b1)
                        {
                            String stringName = "";
                            String text = "";
                            boolean b2 = false;

                            try
                            {
                                sb.delete(0, sb.indexOf(":") + 1);
                                b2 = true;
                            }
                            catch (Exception ignored) { err.println("No name found at " + line); }

                            if (b2)
                            {
                                try { stringName = sb.substring(0, sb.indexOf("<")); }
                                catch (Exception ignored) { err.println("No name value at " + line); }
                                finally { b2 = false; }
                            }

                            System.out.println(sb);
                            System.out.println(stringName);
                            System.exit(0);

                            try
                            {
                                sb.delete(0, sb.indexOf("<") + 1);
                                b2 = true;
                            }
                            catch (Exception ignored) { err.println("No text found at " + line); }

                            if (b2)
                            {
                                try { text = sb.substring(0, sb.indexOf(">")); }
                                catch (Exception ignored) { err.println("No text value at " + line); }
                                finally { b2 = false; }
                            }

                            sb.delete(0, sb.indexOf(">") + 1);

                            if (!sb.substring(0, 1).equals(",")) { b1 = false; }

                            hms.put(stringName, text);
                        }

                        c.setText(hms);
                        hmc.put(ctr, c);


                    }

                    s.addCells(hmc);
                }

                hm.put(string, s);
















                //Gets Sperm
                if (b)
                {
                    HashMap<String, String[]> hms = new HashMap<>();        //For text
                    ArrayList<Cell> al = new ArrayList<>();                 //For Cell list
                    boolean b0 = true;

                    //Gets Sperm                                            add Cell
                    while (b0)
                    {
                        boolean b1 = false;
                        Cell c = new Cell();

                        //Checks x
                        try
                        {
                            sb.delete(0, sb.indexOf(":") + 1);
                            b1 = true;
                        }
                        catch (Exception ignored) { err.println("No x found at " + line); }

                        //Gets x
                        if (b1)
                        {
                            try { c.setX(parseInt(sb.substring(0, sb.indexOf(",")))); }
                            catch (Exception ignored) { err.println("No x value found at " + line); }
                            finally { b1 = false; }
                        }

                        //Checks y
                        try
                        {
                            sb.delete(0, sb.indexOf(":") + 1);
                            b1 = true;
                        }
                        catch (Exception ignored) { err.println("No y found at " + line); }

                        //Gets y
                        if (b1)
                        {
                            try { c.setY(parseInt(sb.substring(0, sb.indexOf(",")))); }
                            catch (Exception ignored) { err.println("No y value found at " + line); }
                        }

                        b1 = true;

                        //Checks id box                                     Cell Objects
                        while (b1)
                        {
                            ArrayList<String> als = new ArrayList<>();
                            String str0 = "";
                            boolean b2 = false;

                            //Checks id
                            try
                            {
                                sb.delete(0, sb.indexOf(":") + 1);
                                b2 = true;
                            }
                            catch (Exception ignored) { err.println("No id found at " + line); }

                            //Gets id
                            if (b2)
                            {
                                try { str0 = sb.substring(0, sb.indexOf("<")); }
                                catch (Exception ignored) { err.println("No id value found at " + line); }
                            }

                            //Checks strings                                text
                            while (b2)
                            {
                                boolean b3 = false;

                                //Checks string
                                try
                                {
                                    sb.delete(0, sb.indexOf("<") + 1);
                                    b3 = true;
                                }
                                catch (Exception ignored)
                                {
                                    try
                                    {
                                        sb.delete(0, sb.indexOf(",") + 1);
                                        b3 = true;
                                    }
                                    catch (Exception ignored0) { err.println("No string found at " + line); }
                                }

                                //Gets string
                                if (b3)
                                {
                                    try { als.add(this.fixString(new StringBuilder(sb.substring(0, sb.indexOf("$b"))))); }
                                    catch (Exception ignored) { err.println("No string value found at " + line); }
                                    finally { sb.delete(0, sb.indexOf("$b") + 2); }
                                }

                                //Checks comma
                                if (sb.indexOf(">") == 0) { b2 = false; }
                            }

                            hms.put(str0, this.getList(als));

                            //Checks comma too
                            if (sb.indexOf("]") == 1) { b1 = false; }
                        }

                        //c.setText(hms);
                        al.add(c);
                    }

                    //s.addCell();
                }
            }
        }

        return hm;
    }

    public String[] getList(ArrayList<String> al)
    {
        String[] ss = new String[al.size()];

        for (int i = 0; i < al.size(); i++) { ss[i] = al.get(i); }

        return ss;
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

        return sb.toString();
    }
}
