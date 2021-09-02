import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("C:\\Users\\asdje\\IdeaProjects\\dotCUMtest\\src\\thing.cum");
        Scanner s = new Scanner(f);
        StringBuilder sb = new StringBuilder();

        while (s.hasNextLine())
        {
            String str = s.nextLine();
            sb.append(str);
            System.out.println(str);
        }

        System.out.println(sb);

        boolean b = true;
        while (b)
        {
            int i = 0;
            try
            {
                i = sb.indexOf(" ");
                sb.deleteCharAt(i);
            }
            catch (Exception ignored)
            {
                b = false;
            }
        }

        System.out.println(sb);
    }
}
