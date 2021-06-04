package checker;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class IOHelper {
  public static Graph getGraph(String fileName) {
    ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
    ArrayList<Edge> edgeList = new ArrayList<Edge>();
    Graph result = null;

    try {
      File myFile = new File(fileName);
      Scanner myReader = new Scanner(myFile);
      String graphName = myReader.nextLine();
      String[] vertexSplit = myReader.nextLine().split(",");
      for (String s : vertexSplit) {
        vertexList.add(new Vertex(s));
      }
      while (myReader.hasNextLine()) {
        String[] edgeSplit = myReader.nextLine().split("-");
        Vertex v = getVertex(edgeSplit[0], vertexList);
        Vertex w = getVertex(edgeSplit[1], vertexList);
        edgeList.add(new Edge(Arrays.toString(edgeSplit), v, w));
      }
      myReader.close();
      result = new Graph(graphName, vertexList, edgeList);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static Vertex getVertex(String name, ArrayList<Vertex> arr) {
    for (Vertex v : arr) {
      if (v.name.equals(name)) {
        return v;
      }
    }
    return null;
  }
}