import java.util.ArrayList;

public class Sperm
{
    public String name;
    public boolean collision;
    public ArrayList<Texture[]> texture = new ArrayList<>();

    public Sperm() { }

    public void setName(String s) { this.name = s; }

    public void setCollision(boolean b) { this.collision = b; }

    public void setTexture(int i, short[] r, short[] g, short[] b, short[] x, short[] y, short[] l, short[] h)
    {
        Texture[] t = new Texture[i];

        for (byte i_ = 0; i_ < i; i_++) { t[i_] = new Texture(r[i_], g[i_], b[i_], x[i_], y[i_], l[i_], h[i_]); }

        this.texture.add(t);
    }
}

class Texture
{
    public short r, b, g, x, y, l, h;

    public Texture(short r, short b, short g, short x, short y, short l, short h)
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
