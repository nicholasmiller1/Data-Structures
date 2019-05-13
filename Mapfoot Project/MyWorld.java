import greenfoot.*;
import java.util.*;

public class MyWorld extends World {
    GreenfootImage bg = this.getBackground();
    List<Location> locations = new ArrayList<Location>();
    
    public MyWorld() {    
        super(961, 604, 1);
        setBackground("WorldMap.PNG");
    }
    
    public void createRandomLocations( int num ) {
        while ( num > 0 ) {
            int x = (int) (Math.random() * 962);
            int y = (int) (Math.random() * 605);
            while ( bg.getColorAt(x,y).equals( new Color(0,0,0) ) ) {
                x = (int) Math.random() * 962;
                y = (int) Math.random() * 605;
            }
            Location l = new Location(x,y);
            locations.add(l);
            addObject(l,x,y);
            num--;
        }
    }
}
