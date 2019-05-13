import greenfoot.*;

public class Edge implements Comparable<Edge> {
    private Location vertex1;
    private Location vertex2;

    public Edge( Location vertex1, Location vertex2 ) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
    
    public Location getVertex1() {
        return vertex1;
    }
    
    public Location getVertex2() {
        return vertex2;
    }
    
    public double getDistance() {
        return Math.sqrt( Math.pow( vertex1.getX() - vertex2.getX(), 2 ) + Math.pow( vertex1.getY() - vertex2.getY(), 2 ) );
    }
    
    public int compareTo( Edge other ) {
        return ( (int) this.getDistance() ) - ( (int) other.getDistance() );
    }
    
    public void show( World w ) {
        GreenfootImage bg = w.getBackground();
        bg.setColor( Color.ORANGE );
        bg.drawLine( vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY() );
    }
}
