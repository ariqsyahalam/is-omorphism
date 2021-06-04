package checker;

import java.util.*;

public class Vertex implements Comparable<Vertex> {
    String name;
    Integer degree;
    ArrayList<Vertex> adjectionTo = new ArrayList<Vertex>();

    public Vertex(String name) {
        this.name = name;
        this.degree = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return this.degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex v) {
        return this.degree - v.degree;
    }

}