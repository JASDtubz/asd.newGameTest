import java.util.*;

public class Tissue
{
    public Tissue() { }

    public HashMap<String, Map> execute(HashMap<Integer, Entity> entity)
    {
        Scanner scan = new Scanner(Objects.requireNonNull(Tissue.class.getResourceAsStream("testicle/condom.came")));
        HashMap<String, Map> hm = new HashMap<>();
        String str;
        StringBuilder sb = new StringBuilder();
        String string = "";
        int line = 0;

        while (scan.hasNextLine())
        {
            str = scan.nextLine();
            line++;

            if (!str.equals("}"))
                sb.append(str);
            else
            {
                Map s = new Map(entity);
                boolean b = true;

                while (b)
                    try { sb.deleteCharAt(sb.indexOf(" ")); }
                    catch (Exception ignored) { b = false; }

                try
                {
                    sb.delete(0, sb.indexOf(":") + 1);
                    b = true;
                }
                catch (Exception ignored) { System.out.println("No name found at " + line); }

                if (b)
                {
                    try
                    {
                        s.setName(this.get(new StringBuilder(sb.toString()), sb.indexOf(",")));
                        string = s.name;
                    }
                    catch (Exception ignored) { System.out.println("No comma found at " + line); }


                }
            }
        }

        return hm;
    }

    public String get(StringBuilder sb, int i)
    {
        sb.delete(i, sb.length());

        return sb.toString();
    }
}
