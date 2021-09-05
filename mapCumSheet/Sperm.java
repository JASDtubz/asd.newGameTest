import java.util.ArrayList;

public class Sperm
{
    public String name;
    public boolean collision;
    public ArrayList<Texture> texture = new ArrayList<>();

    public Sperm() { }

    public void setName(String s) { this.name = s; }

    public void setCollision(boolean b) { this.collision = b; }

    public void setTexture(int r, int b, int g, int x, int y, int l, int h)
    {
        texture.add(new Texture(r, g, b, x, y, l, h));
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
