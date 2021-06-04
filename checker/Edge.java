package checker;

import java.util.*;

public class Edge {

    String name;
    ArrayList<Vertex> vertexList;

    public Edge(String name, Vertex v, Vertex w) {
        this.name = name;
        vertexList = new ArrayList<Vertex>(2);

        v.degree++;
        w.degree++;

        v.adjectionTo.add(w);
        w.adjectionTo.add(v);
        
        vertexList.add(v);
        vertexList.add(w);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vertex> getVertexList() {
        return this.vertexList;
    }

    public void setVertexList(ArrayList<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    @Override
    public String toString() {
        return String.format("%s-%s", this.vertexList.get(0), this.vertexList.get(1));
    }

}
