import java.util.ArrayList;

public class Sperm
{
    public String name;
    public boolean collision;
    public ArrayList<Texture[]> texture = new ArrayList<>();

    public Sperm() { }

    public void setName(String s) { this.name = s; }

    public void setCollision(boolean b) { this.collision = b; }

    public void setTexture(int i, int[] r, int[] g, int[] b, int[] x, int[] y, int[] l, int[] h)
    {
        Texture[] text = new Texture[i + 1]();
        
        for (int i_ = 0; i_ < i; i_++)
        {
            text[i_] = r[i_];
            text[i_] = g[i_];
            text[i_] = b[i_];
            text[i_] = x[i_];
            text[i_] = y[i_];
            text[i_] = l[i_];
            text[i_] = h[i_];
        }
        
        this.texture.add(text);
    }
}

class Texture
{
    public int r, b, g, x, y, l, h;

    public Texture(int r, int b, int g, int x, int y, int l, int h)
    {
        this.r = r;
        this.b = b;
        this.g = g;
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = h;
    }
}
