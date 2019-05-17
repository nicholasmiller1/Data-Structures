import greenfoot.*;
import java.util.*;

public class MyWorld extends World {
   private GreenfootImage bg;
   private List<Location> locations = new ArrayList<Location>();
    
   public MyWorld() {    
       super(961, 604, 1);
       setBackground("WorldMap.PNG");
   }
    
   public void createRandomLocations( int num ) {
       bg = getBackground();
       while ( num > 0 ) {
           int x = (int) (Math.random() * (getWidth()-1));
           int y = (int) (Math.random() * (getHeight()-1));
           while ( bg.getColorAt(x,y).equals( Color.WHITE ) ) {
              x = (int) (Math.random() * (getWidth()-1));
              y = (int) (Math.random() * (getHeight()-1));
           }
           Location l = new Location(x,y);
           locations.add(l);
           addObject(l,x,y);
           num--;
       }
   }
   
   public List<Edge> buildAllEdges() {
       List<Edge> edges = new ArrayList<Edge>();
       for ( int i = 0; i < locations.size(); i++ ) {
           for ( int j = 0; j < locations.size(); j++ ) {
              if ( !locations.get(i).equals( locations.get(j) ) ) {
                 Edge e = new Edge( locations.get(i), locations.get(j) );
                 edges.add(e);
              }
           }
       }
       drawEdges(edges);
       return edges;
   }
   
   public void drawEdges( List<Edge> edges ) {
       for ( int i = 0; i < edges.size(); i++ ) {
           edges.get(i).show(this);
       }
   }
}
