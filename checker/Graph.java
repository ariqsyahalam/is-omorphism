package checker;
import java.util.*;

public class Graph {

    String name;
    ArrayList<Vertex> vertexList;
    ArrayList<Edge> edgeList;

    public Graph(String name, ArrayList<Vertex> vertexList, ArrayList<Edge> edgeList) {
        this.name = name;
        this.vertexList = vertexList;
        this.edgeList = edgeList;
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

    public ArrayList<Edge> getEdgeList() {
        return this.edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertexList) {
            sb.append(v.toString() + " ");
        }
        sb.append("\n");
        for (Edge e : edgeList) {
            sb.append(e.toString() + " // ");
        }

        return sb.toString();
    }

}
