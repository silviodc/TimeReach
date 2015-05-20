package tue;

import tue.algorithms.TransitiveClosure;
import tue.data.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // small demo
        HashSet<Vertex> vertices = new HashSet<Vertex>();
        HashSet<Edge> edges = new HashSet<Edge>();

        Vertex[] vx = new Vertex[100];
        for (int i = 0; i < vx.length; i++) { vx[i] = new Vertex(i+1); }

        List<Snapshot> evolutionGraph = new ArrayList<Snapshot>();

        vertices.add(vx[0]);
        vertices.add(vx[1]);
        vertices.add(vx[2]);
        vertices.add(vx[3]);
        Edge e1 = new Edge(vx[0], vx[1]);
        edges.add(e1);
        edges.add(new Edge(vx[1], vx[3]));

        evolutionGraph.add(new Snapshot(1, vertices, edges));

        edges.remove(e1);
        edges.add(new Edge(vx[2], vx[3]));

        evolutionGraph.add(new Snapshot(2, vertices, edges));
        
    	System.out.println("Hello World bitches");

        RealVersionGraph in = new RealVersionGraph(evolutionGraph);
        Map<Edge, IntervalSet> execute = TransitiveClosure.execute(in);
    }
}
