import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    class Edge implements Comparable<Edge>
    {
        int v1,v2,weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        public int compareTo(Edge o)
        {
            return this.weight-o.weight;
        }
    }
    int v,e;

    public Kruskal(int v, int e) {
        this.v = v;
        this.e = e;
    }

    public void kruskal(Edge e[])
    {
        Arrays.sort(e);
        Edge mst[] =new Edge[v-1];
        int count=0;
        int i=0;
        int parent[]=new int[v];
        for (int j = 0; j < v; j++) {
            parent[j]=j;
        }
        while(count!=v-1)
        {
            Edge ed=e[i++];
            int v1parent=findparent(ed.v1,parent);
            int v2parent=findparent(ed.v2,parent);
            if(v1parent!=v2parent)
            {
                mst[count++]=ed;
                parent[ed.v1]=ed.v2;
            }
        }
        print(mst);
    }
    public void print(Edge mst[])
    {
        for (int i = 0; i < mst.length; i++) {
            if(mst[i].v1<mst[i].v2)
                System.out.println(mst[i].v1+"  -> " +mst[i].v2+"  weight "+mst[i].weight);
            else
                System.out.println(mst[i].v2+"  -> " +mst[i].v1+"  weight "+mst[i].weight);
        }
    }
    public int findparent(int v,int parent[])
    {
        if(v==parent[v])return v;
        return findparent(parent[v],parent);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        Kruskal obj=new Kruskal(v,e);
        Edge ar[]=new Edge[e];
        for (int i = 0; i < e; i++) {
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            int weight=sc.nextInt();
            ar[i]=obj.new Edge(v1,v2,weight);
        }
        obj.kruskal(ar);
    }
}
