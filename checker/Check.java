package checker;

import java.util.*;

public class Check {

  public static boolean checkVertex(Graph g, Graph h) {
    System.out.printf("=== STEP 1 ===%n");
    System.out.printf("Mengecek jumlah vertex graf %s dan %s%n", g.name, h.name);
    System.out.printf("Vertex graf %s : %s%n", g.name, g.getVertexList());
    System.out.printf("Vertex graf %s : %s%n", h.name, h.getVertexList());
    System.out.printf("graf %s memiliki sebanyak %d%n", g.name, g.getVertexList().size());
    System.out.printf("graf %s memiliki sebanyak %d%n", h.name, h.getVertexList().size());

    if (g.getVertexList().size() != h.getVertexList().size()) {
      System.out.printf("out : Jumlah Vertex berbeda%n%n");
      return false;
    }
    System.out.printf("out : Jumlah Vertex sama%n%n");
    return true;
  }

  public static boolean checkEdge(Graph g, Graph h) {
    System.out.printf("=== STEP 2 ===%n");
    System.out.printf("Mengecek jumlah Edge graf %s dan %s%n", g.name, h.name);
    System.out.printf("Edge graf %s : %s%n", g.name, g.getEdgeList());
    System.out.printf("Edge graf %s : %s%n", h.name, h.getEdgeList());
    System.out.printf("graf %s memiliki sebanyak %d%n", g.name, g.getEdgeList().size());
    System.out.printf("graf %s memiliki sebanyak %d%n", h.name, h.getEdgeList().size());

    if (g.getEdgeList().size() != h.getEdgeList().size()) {
      System.out.printf("out : Jumlah Edge berbeda%n%n");
      return false;
    }
    System.out.printf("out : Jumlah Edge sama%n%n");
    return true;
  }

  public static boolean checkDegree(Graph g, Graph h) {
    int countVertex = g.vertexList.size();

    int[] arrG = new int[countVertex + 1];
    int[] arrH = new int[countVertex + 1];

    for (int i = 0; i < countVertex; i++) {
      arrG[g.vertexList.get(i).degree]++;
      arrH[h.vertexList.get(i).degree]++;
    }

    int[] index = new int[arrG.length];
    for (int i = 0; i < arrG.length; i++) {
      index[i] = i;
    }

    System.out.printf("=== STEP 3 ===%n");
    System.out.printf("Menecek jumlah Derajat setiap Vertex graf %s dan %s%n", g.name, h.name);
    System.out.printf("Tabel Derajat :%n");
    System.out.printf("%s => n derajat%n", Arrays.toString(index));
    System.out.printf("%s => Vertex dengan n derajat Graf %s%n", Arrays.toString(arrG), g.name);
    System.out.printf("%s => Vertex dengan n derajat Graf %s%n", Arrays.toString(arrH), h.name);

    for (int i = 0; i < countVertex; i++) {
      if (arrG[i] != arrH[i]) {
        System.out.println("out : Jumlah Derajat berbeda");
        return false;
      }
    }
    System.out.printf("out : Jumlah Derajat kedua graf sama%n%n");
    return true;
  }

  public static boolean checkMaxDegree(Graph g, Graph h) {
    Collections.sort(g.vertexList, Collections.reverseOrder());
    Collections.sort(h.vertexList, Collections.reverseOrder());
    int maxDegree = g.vertexList.get(0).degree;
    int gCount = 0;
    int hCount = 0;
    int count = 0;

    System.out.printf("=== STEP 4 ===%n");
    System.out.printf("Mengecek Derajat dari setiap tetangga Vertex dengan derajat Terbesar%n", g.name, h.name);
    System.out.printf("%s -> ururtan terbesar hingga terkecil Vertex graf %s%n", g.vertexList, g.name);
    System.out.printf("%s -> ururtan terbesar hingga terkecil Vertex graf %s%n", h.vertexList, h.name);
    System.out.printf("Derajat Vertex terbesar adalah %d%n", maxDegree);

    for (int i = 0; i < h.vertexList.size(); i++) {
      if (h.vertexList.get(i).degree == maxDegree) {
        gCount++;

        for (int j = 0; j < h.vertexList.size(); j++) {
          if (h.vertexList.get(j).degree == maxDegree) {
            hCount++;

            if (equalsVertex(g.vertexList.get(i).adjectionTo, h.vertexList.get(j).adjectionTo)) {
              count++;
            }
          }
        }
      }
    }

    if (gCount == Math.pow(count, 0.5) && Math.pow(hCount, 0.5) == Math.pow(count, 0.5)) {
      System.out.printf("out : derajat dari setiap tetangga Vertex derajat Terbesar sama%n", g.name, h.name);
      return true;
    }

    System.out.println("out : Vertex derajat terbesar tidak memiliki fungsi bijektif");
    return false;
  }

  public static boolean equalsVertex(ArrayList<Vertex> v, ArrayList<Vertex> w) {
    Collections.sort(v, Collections.reverseOrder());
    Collections.sort(w, Collections.reverseOrder());

    for (int i = 0; i < v.size(); i++) {
      if (v.get(i).degree != w.get(i).degree) {
        return false;
      }
    }
    return true;
  }
}
