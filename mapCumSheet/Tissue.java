import java.util.*;

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
                catch (Exception ignored) { System.err.println("No name found at " + line); }

                if (b)
                {
                    try
                    {
                        s.setName(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                        string = s.name;
                    }
                    catch (Exception ignored) { System.err.println("No comma found at " + line); }
                    
                    b = false;
                }
                
                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { System.err.println("No minimum x found at " + line); }
                
                if (b)
                {
                    try { s.setXMin(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))); }
                    catch (Exception ignored) { System.out.println("Getting minimum x error found at " + line); }
                    
                    b = false;
                }
                
                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { System.err.println("No minimum y found at " + line); }
                
                if (b)
                {
                    try { s.setYMin(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))); }
                    catch (Exception ignored) { System.err.println("No minimum y value found at " + line); }
                    
                    b = false;
                }
                
                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { System.err.println("No maximum x found at " + line); }
                
                if (b)
                {
                    try { s.setXMax(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))); }
                    catch (Exception ignored) { System.err.println("No maximum x value found at " + line); }
                    
                    b = false;
                }
                
                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { System.err.println("No maximum y found at " + line); }
                
                if (b)
                {
                    try { s.setYMax(this.get(new StringBuilder(sb.toString()), sb.indexOf(","))); }
                    catch (Exception ignored) { System.err.println("No maximum y value found at " + line); }
                    
                    b = false;
                }
            }
        }

        return hm;
    }

    private String get(StringBuilder sb, int i)
    {
        sb.delete(i, sb.length());

        return sb.toString();
    }
}
