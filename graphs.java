
import java.util.*;

public class graphs {
    static void addedge(int src, int des, int[][] graph){
        graph[src][des] =1;
        graph[des][src] =1;
    }
    static void printgraph(int[][] graph,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(graph[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] graph = new int[v+1][v+1];

    }
}


// with list for graph

class listgraph{
    static int v;
    static ArrayList<Integer> adj[];

    listgraph(int v){
        this.v = v;
        adj = new ArrayList[v+1];

        for(int i=0;i<=v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    void addedge(int src , int des){
        adj[src].add(des);
        adj[des].add(src);
    }
    void printgraph(){
        for(int i=0;i<=v;i++){
            System.out.print(i+"-->");
            System.out.println(adj[i]+" ");
        }
    }
    public static void main(String[] args) {
        Listgraph graph = new Listgraph(4);

        graph.addedge(0,1);
        graph.addedge(0,2);
        graph.addgraph(2,1);
        graph.addedge(2,3);
        graph.printgraph();
    }
}
