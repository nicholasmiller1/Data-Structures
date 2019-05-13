import greenfoot.*;

public class Location extends Actor {
    private int x;
    private int y;
    
    public Location(int x, int y) {
        setImage("Dot.PNG");
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    public boolean equals( Location other ) {
        return x == other.getX() && y == other.getY();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
