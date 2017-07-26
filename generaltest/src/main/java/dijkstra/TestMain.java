package dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zain on 2017/4/25.
 */
public class TestMain {
    public static void main(String[] args) {
        List<Vertex> vertexs = new ArrayList<Vertex>();
        Vertex a = new Vertex("A", 0); //0表示起始点
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        vertexs.add(a);
        vertexs.add(b);
        vertexs.add(c);
        vertexs.add(d);
        vertexs.add(e);
        vertexs.add(f);
        int[][] edges = {
                {0, 7, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 14},
                {7, 0, 10, Integer.MAX_VALUE, 15, Integer.MAX_VALUE},
                {9, 10, 0, 11, Integer.MAX_VALUE, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 11, 0, 6, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 15, Integer.MAX_VALUE, 6, 0, 9},
                {14, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 9, 0}
        };

        Graph graph = new Graph(vertexs, edges);
        graph.printGraph();
        graph.search();
    }
}
