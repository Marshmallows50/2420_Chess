package Chess;

import edu.princeton.cs.algs4.*;

/**
 *  //TODO update this doc comment
 *  The {@code SymbolGraph} class represents an undirected graph, where the
 *  vertex names are arbitrary strings.
 *  By providing mappings between string vertex names and integers,
 *  it serves as a wrapper around the
 *  {@link Graph} data type, which assumes the vertex names are integers
 *  between 0 and <em>V</em> - 1.
 *  It also supports initializing a symbol graph from a file.
 *  <p>
 *  This implementation uses an {@link ST} to map from strings to integers,
 *  an array to map from integers to strings, and a {@link Graph} to store
 *  the underlying graph.
 *  The <em>indexOf</em> and <em>contains</em> operations take time
 *  proportional to log <em>V</em>, where <em>V</em> is the number of vertices.
 *  The <em>nameOf</em> operation takes constant time.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Gabriel Perillo
 */
public class TileSymbolGraph {
    // TODO update doc comment
    public ST<Tile, Integer> st;  // tile -> index
    private Tile[] keys;           // index  -> tile
    private ST<String, Tile> nameST; // tile.name -> tile
    private Graph graph;             // the underlying graph

    /**
     * Initializes a graph from a file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by the attributes of the vertex,
     * which is then followed by a list of the names
     * of the vertices adjacent to that vertex, separated by the delimiter.
     * @param filename the name of the file
     * @param delimiter the delimiter between fields
     */
    public TileSymbolGraph(String filename, String delimiter) {
        st = new ST<Tile, Integer>();
        nameST = new ST<String, Tile>();

        // First pass builds the index by reading strings to associate
        // distinct strings with a Tile. Also creates tile objects to associate
        // distinct Tiles with an index.
        In in = new In(filename);
        while (!in.isEmpty()){
            String[] a = in.readLine().split(delimiter);
            for (int i =0; i<4; i++) { // only the first 4 columns are Tile attributes
                Tile t = new Tile(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]), a[3]);
                if (!st.contains(t)) {
                    st.put(t, st.size());
                    nameST.put(t.getName(), t);
                }
            }
        }
//        while (!in.isEmpty()) {
//            String[] a = in.readLine().split(delimiter);
//            for (int i = 0; i < a.length; i++) {
//                if (!st.contains(a[i]))
//                    st.put(a[i], st.size());
//            }
//        }

        // inverted index to get string keys in an array
        keys = new Tile[st.size()];
        for (Tile tile : st.keys()) {
            keys[st.get(tile)] = tile;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        graph = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            String[] o = a[a.length -1].split(" "); // get array of vertices from main array.
            int v = st.get(nameST.get(a[0])); // get name of first vertex on line. uses array "a"
            for (String s : o) {
                try {
                    int w = st.get(nameST.get(s));
                    graph.addEdge(v, w);
                }
                catch (IllegalArgumentException ignored){}

            }
        }
    }

    /**
     * Does the graph contain the vertex named {@code s}?
     * @param s the name of a vertex
     * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
     */
    public boolean contains(String s) {
        return st.contains(nameST.get(s));
    }

    /**
     * Does the graph contain the vertex with Tile {@code t}?
     * @param t the Tile object
     * @return {@code true} if {@code t} is a vertex, and {@code false} otherwise
     */
    public boolean contains(Tile t) {
        return st.contains(t);
    }

    /**
     * Returns the integer associated with the vertex named {@code s}.
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     */
    public int indexOf(String s) {
        return st.get(nameST.get(s));
    }

    /**
     * Returns the integer associated with Tile {@code s}.
     * @param t the Tile object
     * @return the integer (between 0 and <em>V</em> - 1) associated with Tile {@code t}
     */
    public int indexOf(Tile t) {
        return st.get(t);
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     * @param  v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @return the name of the vertex associated with the integer {@code v}
     */
    public String nameOf(int v) {
        validateVertex(v);
        return keys[v].getName();
    }

    /**
     * Returns the Tile of the vertex associated with the integer {@code v}.
     * @param  v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @return the Tile of the vertex associated with the integer {@code v}
     */
    public Tile tileOf(int v) {
        validateVertex(v);
        return keys[v];
    }

    /**
     * Returns the Tile of the vertex associated with the integer {@code v}.
     * @param  s the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @return the Tile of the vertex associated with the integer {@code v}
     */
    public Tile tileOf(String s) {
        //TODO update doc comment
        return nameST.get(s);
    }

    /**
     * Returns the graph associated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     */
    public Graph graph() {
        return graph;
    }

    /**
     * Returns the Keys associated with the symbol graph. It is the client's responsibility
     * not to mutate the Array.
     * @return the Keys associated with the symbol graph
     */
    public Tile[] getKeys() {
        return keys;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}



