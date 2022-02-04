import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.err;
import static java.util.Objects.requireNonNull;

public final class Tissue
{
    public Tissue() { }

    synchronized public HashMap<String, Semen> execute()
    {
        final Scanner scan = new Scanner(requireNonNull(Tissue.class.getResourceAsStream("testicle/condom.came")));
        HashMap<String, Semen> hm = new HashMap<>();
        String str;
        StringBuilder sb = new StringBuilder();
        String string = "";
        int line = 0;
        ArrayList<String> list = new ArrayList<>();
        Semen semen = new Semen();

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

                try
                {
                    sb.delete(0, sb.indexOf("[") + 1);
                    b = true;
                }
                catch (Exception ignored) { err.println("No sperm found at " + line); }

                if (b)
                {
                    HashMap<String, Cell> hmc = new HashMap<>();
                    ArrayList<String> als = new ArrayList<>();
                    Cell cell = new Cell();
                    boolean b0 = true;

                    while (b0)
                    {
                        Cell c = new Cell();
                        String ctr = "";
                        HashMap<String, String> hms = new HashMap<>();
                        boolean b1 = false;
                        ArrayList<String> list2 = new ArrayList<>();

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
                        }

                        b1 = true;

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
                            }

                            sb.delete(0, sb.indexOf(">") + 1);

                            if (!sb.substring(0, 1).equals(",")) { b1 = false; }

                            list2.add(stringName);
                            hms.put(stringName, text);
                        }

                        c.setText(hms);
                        c.list(this.getList(list2));
                        hmc.put(ctr, c);
                        als.add(ctr);

                        sb.delete(0, sb.indexOf(")") + 1);

                        if (!sb.substring(0, 1).equals(",")) { b0 = false; }
                        else { sb.delete(0, 1); }
                    }
                    
                    cell.list(this.getList(als));
                    hmc.put("_LIST_", cell);
                    s.addCells(hmc);
                }

                sb.delete(0, sb.length());
                hm.put(string, s);
                list.add(string);
            }
        }

        semen.list(this.getList(list));
        hm.put("_LIST_", semen);
        return hm;
    }

    private String[] getList(ArrayList<String> al)
    {
        String[] list = new String[al.size()];

        for (int i = 0; i < al.size(); i++) { list[i] = al.get(i); }

        return list;
    }
}
