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
            Greenfoot.delay(6);
        }
    }

    public List<Edge> buildRandomConnections( int n ) {
        if ( (locations.size() * (locations.size()-1))/2 <= n ) {
            return buildAllEdges();
        }
        else {
            List<Edge> edges = new ArrayList<Edge>();
            for ( int i = 0; i < n; i++ ) {
                Location loc1 = locations.get((int)(Math.random()*(locations.size())));
                Location loc2 = locations.get((int)(Math.random()*(locations.size())));
                while ( loc1.equals(loc2) || edges.contains( new Edge(loc1,loc2) ) ) {
                    loc1 = locations.get((int)(Math.random()*(locations.size())));
                    loc2 = locations.get((int)(Math.random()*(locations.size())));
                }
                Edge e = new Edge(loc1,loc2);
                edges.add(e);
            }
            drawEdges(edges);
            return edges;
        }
    }

    public List<Edge> PrimsAlgorithm() {
        List<Location> visited = new ArrayList<Location>();
        visited.add(locations.get(0));
        List<Location> unvisited = new ArrayList<Location>();
        unvisited = locations.subList(1,locations.size());
        List<Edge> edges = new ArrayList<Edge>();
        while ( !unvisited.isEmpty() ) {
            Edge shortestEdge = new Edge(visited.get(0), unvisited.get(0));
            for ( int i = 0; i < visited.size(); i++ ) {
                for ( int j = 0; j < unvisited.size(); j++ ) {
                    Edge e = new Edge( visited.get(i), unvisited.get(j) );
                    if ( shortestEdge.getDistance() > e.getDistance() ) {
                        shortestEdge = e;
                    }
                }
            }
            edges.add(shortestEdge);
            visited.add( shortestEdge.getVertex2() );
            unvisited.remove(shortestEdge.getVertex2());
        }
        drawEdges(edges);
        return edges;
    }
    
    public void clearEdges() {
        setBackground("WorldMap.PNG");
    }
    
    public void clearLocations() {
        locations.clear();
        removeObjects( getObjects(Location.class) );
        clearEdges();
    }
}
