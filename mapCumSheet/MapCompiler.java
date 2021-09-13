import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class MapCompiler {

public static void main(String[] args) 
{
    ArrayList<String> lines = new ArrayList<>();
    try {
        FileReader fileReader = new FileReader("testicle\condom.came");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        String mapName;
        while ((line = bufferedReader.next()) != null)
        {
            Scanner lineScan = new Scanner(line);
            if (line.indexOf("name:") != -1) {
                line = line.substring(line.indexOf("name:"));
                line = str.replaceAll("[^a-zA-Z0-9]", "");
                mapName = line;
            }
            else if ()
            {
                
            }
        }
    } catch (Exception e) {
        //TODO: handle exception
    }
}
}