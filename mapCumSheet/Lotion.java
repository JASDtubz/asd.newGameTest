import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Lotion
{
    public Lotion()
    {
    }

    public HashMap execute()
    {
        Sperm s = new Sperm();
        Scanner scan = new Scanner(Objects.requireNonNull(Lotion.class.getResourceAsStream("testicle/egg.cum")));
        HashMap<Integer, Sperm> hm = new HashMap<>();
        String str0;
        String get = "";
        StringBuilder str1 = new StringBuilder("");
        int i = 0;
        int line = 0;

        while (scan.hasNextLine())
        {
            str0 = scan.nextLine();
            line++;

            if (!str0.equals("}"))
                str1.append(str0);
            else
            {
                boolean b = true;
                int i_ = 0;

                while (b)
                    try
                    {
                        i_ = str1.indexOf(" ");
                        str1.deleteCharAt(i_);
                    }
                    catch (Exception ignored) { b = false; }

                try
                {
                    i_ = str1.indexOf("{");
                    str1.deleteCharAt(i_);
                }
                catch (Exception ignored) { }

                try
                {
                    i_ = str1.indexOf("name");
                    str1 = this.remove(str1, i_, str1.indexOf("e"));
                    b = true;
                }
                catch (Exception ignored) { System.out.println("No name found at " + line); }

                if (b)
                {
                    try
                    {
                        i_ = str1.indexOf(":");
                        str1.deleteCharAt(i_);
                    }
                    catch (Exception ignored) { System.out.println("No colon found at " + line); }

                    i_ = str1.indexOf(",");
                    s.setName(this.get(new StringBuilder(str1.toString()), i_));
                    b = false;
                }
            }
        }

        return hm;
    }

    public StringBuilder remove(StringBuilder sb, int x, int y)
    {
        StringBuilder sb_ = sb;

        for (int i = y; x <= y; i--)
            sb_.deleteCharAt(i);

        return sb_;
    }

    public String get(StringBuilder sb, int i)
    {
        boolean b = true;

        while (b)
            try { sb.deleteCharAt(i); }
            catch (Exception ignored) { b = false; }

        return sb.toString();
    }
}
