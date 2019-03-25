import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KonnerEL
 */
public class Graph {
    public int Adj[][];
    public int Weight[][];
    public Object objects[][];
    public int numberNodes;
    int Distance[];
    boolean visited[];
    Node[] vertexes; 
    public ArrayList<Node> path;
    ArrayList<Node> nodes;

    public Graph(int map[][]) {
        nodes = new ArrayList();
        Adj = new int[101][101];
        Weight = new int[101][101];
        Distance = new int[101];
        vertexes = new Node[101];
        visited = new boolean[101];
        numberNodes = 0;
    }
    
    public void loadGraph() {
        addNodes();
        addEdge(1, 2);
        addEdge(1, 11);
        addEdge(2, 3);
        addEdge(2, 12);
        addEdge(3, 4);
        addEdge(3, 13);
        addEdge(4, 5);
        addEdge(4, 14);
        addEdge(5, 6);
        addEdge(5, 15);
        addEdge(6, 7);
        addEdge(6, 16);
        addEdge(7, 8);
        addEdge(7, 17);
        addEdge(8, 9);
        addEdge(8, 18);
        addEdge(9, 10);
        addEdge(9, 19);
        addEdge(10, 20);
        addEdge(11, 12);
        addEdge(11, 21);
        addEdge(12, 13);
        addEdge(12, 22);
        addEdge(13, 14);
        addEdge(13, 23);
        addEdge(14, 15);
        addEdge(14, 24);
        addEdge(15, 16);
        addEdge(15, 25);
        addEdge(16, 17);
        addEdge(16, 26);
        addEdge(17, 18);
        addEdge(17, 27);
        addEdge(18, 19);
        addEdge(18, 28);
        addEdge(19, 20);
        addEdge(19, 29);
        addEdge(20, 30);
        addEdge(21, 22);
        addEdge(21, 31);
        addEdge(22, 23);
        addEdge(22, 32);
        addEdge(23, 24);
        addEdge(23, 33);
        addEdge(24, 25);
        addEdge(24, 34);
        addEdge(25, 26);
        addEdge(25, 35);
        addEdge(26, 27);
        addEdge(26, 36);
        addEdge(27, 28);
        addEdge(27, 37);
        addEdge(28, 29);
        addEdge(28, 38);
        addEdge(29, 30);
        addEdge(29, 39);
        addEdge(30, 40);
        addEdge(31, 22);
        addEdge(31, 41);
        addEdge(32, 33);
        addEdge(32, 42);
        addEdge(33, 34);
        addEdge(33, 43);
        addEdge(34, 35);
        addEdge(34, 44);
        addEdge(35, 36);
        addEdge(35, 45);
        addEdge(36, 37);
        addEdge(36, 46);
        addEdge(37, 38);
        addEdge(37, 47);
        addEdge(38, 39);
        addEdge(38, 48);
        addEdge(39, 40);
        addEdge(39, 49);
        addEdge(40, 41);
        addEdge(40, 50);
        addEdge(41, 42);
        addEdge(41, 51);
        addEdge(42, 43);
        addEdge(42, 52);
        addEdge(43, 44);
        addEdge(43, 53);
        addEdge(44, 45);
        addEdge(44, 54);
        addEdge(45, 46);
        addEdge(45, 55);
        addEdge(46, 47);
        addEdge(46, 56);
        addEdge(47, 48);
        addEdge(47, 57);
        addEdge(48, 49);
        addEdge(48, 58);
        addEdge(49, 50);
        addEdge(49, 59);
        addEdge(50, 60);
        addEdge(51, 52);
        addEdge(51, 61);
        addEdge(52, 53);
        addEdge(52, 62);
        addEdge(53, 54);
        addEdge(53, 63);
        addEdge(54, 55);
        addEdge(54, 64);
        addEdge(55, 56);
        addEdge(55, 65);
        addEdge(56, 57);
        addEdge(56, 66);
        addEdge(57, 58);
        addEdge(57, 67);
        addEdge(58, 59);
        addEdge(58, 68);
        addEdge(59, 60);
        addEdge(59, 69);
        addEdge(60, 70);
        addEdge(61, 62);
        addEdge(61, 71);
        addEdge(62, 63);
        addEdge(62, 72);
        addEdge(63, 64);
        addEdge(63, 73);
        addEdge(64, 65);
        addEdge(64, 74);
        addEdge(65, 66);
        addEdge(65, 75);
        addEdge(66, 67);
        addEdge(66, 76);
        addEdge(67, 68);
        addEdge(67, 77);
        addEdge(68, 69);
        addEdge(68, 78);
        addEdge(69, 70);
        addEdge(69, 79);
        addEdge(70, 80);
        addEdge(71, 72);
        addEdge(71, 81);
        addEdge(72, 73);
        addEdge(72, 82);
        addEdge(73, 74);
        addEdge(73, 83);
        addEdge(74, 75);
        addEdge(74, 84);
        addEdge(75, 76);
        addEdge(75, 85);
        addEdge(76, 77);
        addEdge(76, 86);
        addEdge(77, 78);
        addEdge(77, 87);
        addEdge(78, 79);
        addEdge(78, 88);
        addEdge(79, 80);
        addEdge(79, 89);
        addEdge(80, 90);
        addEdge(81, 82);
        addEdge(81, 91);
        addEdge(82, 83);
        addEdge(82, 92);
        addEdge(83, 84);
        addEdge(83, 93);
        addEdge(84, 85);
        addEdge(84, 94);
        addEdge(85, 86);
        addEdge(85, 95);
        addEdge(86, 87);
        addEdge(86, 96);
        addEdge(87, 88);
        addEdge(87, 97);
        addEdge(88, 89);
        addEdge(88, 98);
        addEdge(89, 90);
        addEdge(89, 99);
        addEdge(90, 100);
        addEdge(90, 91);
        addEdge(91, 92);
        addEdge(92, 93);
        addEdge(93, 94);
        addEdge(94, 95);
        addEdge(95, 96);
        addEdge(96, 97);
        addEdge(97, 98);
        addEdge(98, 99);
        addEdge(99, 100);
    }
    
    public void addNodes() {
        int Number = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                nodes.add(new Node(j * 50, i * 50, Number));
                Number += 1;
                numberNodes++;
            }
        }
    }
    
    public void addEdge(int start, int finish) {
        Adj[start][finish] = Adj[finish][start] = 1;
        int x = nNumber(start).getX();
        int y = nNumber(start).getY();
        int x1 = nNumber(finish).getX();
        int y1 = nNumber(finish).getY();
        int resX = x1 - x;
        int resY = y1 - y;
        resX = (int) Math.pow(resX, 2);
        resY = (int) Math.pow(resY, 2);
        int sum = resX + resY;
        int dist = (int) Math.sqrt(sum);
        Weight[start][finish] = Weight[finish][start] = dist;
    }
    
    public Node nNumber(int Number) {
        int i = 0;
        boolean sw = false;
        Node n = null;
        while (i < numberNodes && sw == false) {
            if (nodes.get(i).number == Number) {
                sw = true;
                n = nodes.get(i);
            }
            i++;    
        }
        return n;
    }
    
    public void shortestPathDijkstra(Node start) {
        for (int i = 1; i <= numberNodes; i++) {
            if (Adj[start.number][i] == 1) {
                Distance[i] = Weight[start.number][i];
            } else {
                Distance[i] = Integer.MAX_VALUE;
            }
            vertexes[i] = start;
        }
        Distance[start.number] = 0;
        visited[start.number] = true;

        for (int i = 1; i <= numberNodes; i++){
            int v = minimumVertex();
            visited[v] = true;
            for (int j = 1; j <= numberNodes; j++) {
                if (Adj[v][j] == 1 && !visited[j]) {
                    if (Distance[v] + Weight[v][j] < Distance[j]) {
                        Distance[j] = Distance[v] + Weight[v][j];
                        vertexes[j] = nNumber(v);
                    }
                }
            }
        }
    }
    
    private int minimumVertex() {
        int max = Integer.MAX_VALUE;
        int v = 1;
        for (int i = 1; i <= numberNodes; i++) {
            if (!visited[i] && Distance[i] < max) {
                max = Distance[i];
                v = i; 
            }
        }
        return v;
    }
    
    public void getPath (Node start, Node end) {
        int v = end.number;
        path = new ArrayList();
        while (v != start.number) {
           path.add(nNumber(v));
           v = vertexes[v].number;
        }
        path.add(start);
        Collections.reverse(path);
    }
    
    public void addPath(int x1, int y1) {
        path.add(new Node(x1, y1, numberNodes + 1));
    }
    
    public Node nearestNode(int x, int y) {
        Node near = null;
        int distance = Integer.MAX_VALUE;
        for (int i = 1; i <= numberNodes; i++) {
            int x1 = nNumber(i).getX();
            int y1 = nNumber(i).getY();
            int resX = x1 - x;
            int resY = y1 - y;
            resX = (int) Math.pow(resX, 2);
            resY = (int) Math.pow(resY, 2);
            int sum = resX + resY;
            int dist = (int) Math.sqrt(sum);
            if (dist <= distance) {
                distance = dist;
                near = nNumber(i);
            } 
        }
        return near;
    }
}
