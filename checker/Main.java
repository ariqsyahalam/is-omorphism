package checker;

public class Main {

	public static void main(String[] args) {
		Graph g1 = IOHelper.getGraph("./src/graph-1.txt");
		Graph h1 = IOHelper.getGraph("./src/graph-2.txt");

		Graph g2 = IOHelper.getGraph("./src/test1.txt");
		Graph h2 = IOHelper.getGraph("./src/test2.txt");

		Graph g3 = IOHelper.getGraph("./src/g.txt");
		Graph h3 = IOHelper.getGraph("./src/h.txt");

		checking(g1, h1);
		checking(g2, h2);
		checking(g3, h3);
	}

	public static void checking(Graph g, Graph h) {
		System.out.printf("%n%nMengecek isomorfisme graf %s dan %s%n", g.name, h.name);
		if (Check.checkVertex(g, h) && Check.checkEdge(g, h) && Check.checkDegree(g, h) && Check.checkMaxDegree(g, h)) {
			System.out.println("\nGraf kemungkinan Isomorfik");
		} else {
			System.out.println("\nGraf bukan Isomorfik");
		}
		System.out.println("===============");
	}
}
