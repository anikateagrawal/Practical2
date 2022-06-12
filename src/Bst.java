import java.util.LinkedList;
import java.util.Queue;

public class Bst {
     class Node
    {
        Emp data;
        Node left;
        Node right;

        public Node(Emp data) {
            this.data = data;
        }
    }
    class Emp
    {
        String name;
        int salary;
        String designation;

        public Emp(String name, int salary, String designation) {
            this.name = name;
            this.salary = salary;
            this.designation = designation;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", designation='" + designation + '\'' +
                    '}';
        }
    }
    public Node add(Node root,Node n)
    {
        if(root==null)return n;
        if(n.data.name.compareTo(root.data.name)<0)root.left=add(root.left,n);
        else root.right=add(root.right,n);
        return root;
    }
    public boolean search(Node root,String Designation)
    {
        if(root==null)return false;
        if(root.data.designation==Designation)return true;
        boolean b= search(root.left,Designation);
        if(b==false)
        b= search (root.right,Designation);
        return b;
    }
public void dfs1(Node root)
{
    if(root==null)return ;
    System.out.println(root.data);
    dfs1(root.left);
    dfs1(root.right);
}
    public void dfs2(Node root)
    {
        if(root==null)return ;

        dfs1(root.left);
        System.out.println(root.data);
        dfs1(root.right);
    }
    public void dfs3(Node root)
    {
        if(root==null)return ;
        dfs1(root.left);
        dfs1(root.right);
        System.out.println(root.data);
    }
    public void bfs(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node n=q.poll();
                System.out.println(n.data);
                if(n.left!=null)
                q.add(n.left);
                if(n.right!=null)
                q.add(n.right);
        }
    }
    public static void main(String[] args) {
        Node root=null;
        Bst obj=new Bst();
        Emp e1=obj.new Emp("Anikate",500000,"Manager");
        Emp e2=obj.new Emp("Aditya",200000,"Assitant");
        Emp e3=obj.new Emp("Mohan",100000,"coder");
        Emp e4=obj.new Emp("Adi",50000,"Assitant Manager");
        Emp e5=obj.new Emp("Rohan",300000,"Junior");
        root=obj.add(root,obj.new Node(e1));
        root=obj.add(root,obj.new Node(e2));
        root=obj.add(root,obj.new Node(e3));
        root=obj.add(root,obj.new Node(e4));
        root=obj.add(root,obj.new Node(e5));
        obj.dfs1(root);
        System.out.println();
        obj.dfs2(root);
        System.out.println();
        obj.dfs3(root);
        System.out.println();
        System.out.println(obj.search(root,"Manager"));
        System.out.println();
        obj.bfs(root);
    }
}
