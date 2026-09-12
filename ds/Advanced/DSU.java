package Advanced;

public class DSU {
    
    private int[] parent;
    private int[] size;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(parent[node] == node){
            return node;
        }

        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int u,int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV){
            return;
        }

        if(size[rootU] <= size[rootV]){
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }

    public boolean isConnected(int u,int v){
        return find(u)==find(v);
    }

    public int getSize(int node){
        int root = find(node);
        return size[root];
    }

    public void printParent(){
        System.out.print("Parent: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    public void printSize(){
        System.out.print("Size:   ");
        for (int i = 0; i < size.length; i++) {
            System.out.print(size[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(7); // Nodes 0 to 6

        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);
        dsu.union(5, 6);
        dsu.union(4, 5);

        dsu.printParent();
        dsu.printSize();

        System.out.println("0 and 2 connected: " + dsu.isConnected(0, 2));
        System.out.println("2 and 3 connected: " + dsu.isConnected(2, 3));

        dsu.union(2, 3);

        System.out.println("2 and 3 connected: " + dsu.isConnected(2, 3));
        System.out.println("Component size of 6: " + dsu.getSize(6));
    }
}
