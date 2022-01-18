import java.util.ArrayList;

public final class Sperm
{
    public boolean collision;
    public ArrayList<Texture[]> texture = new ArrayList<>();

    public Sperm() { }

    public void setCollision(boolean b) { this.collision = b; }

    public void setTexture(short[] r, short[] g, short[] b, short[] x, short[] y, short[] l, short[] h)
    {
        Texture[] t = new Texture[r.length];

        for (int i = 0; i < r.length; i++) { t[i] = new Texture(r[i], g[i], b[i], x[i], y[i], l[i], h[i]); }

        this.texture.add(t);
    }
}

final class Texture
{
    public final short r, b, g, x, y, l, h;

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
