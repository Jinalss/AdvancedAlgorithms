import java.util.ArrayList;
import java.util.List;

class TreeNNode{
    int val;
    List<TreeNNode> adjList = new ArrayList<TreeNNode>();
    public TreeNNode(int val){
        this.val = val;
    }
    public List<TreeNNode> getAdjList(){
        return adjList;
    }
    public void setAdjList(TreeNNode val){
        this.adjList.add(val);
    }
}

public class LCAForNary {

    static TreeNNode result;

    public static boolean getLCA(TreeNNode root, int p, int q){

        boolean ans = (root.val==p || root.val==q) ? true : false;

        int count = 0;
        for(TreeNNode node : root.getAdjList()){
            if(getLCA(node,p,q)){
                count++;
            }
        }
        if(count==2 || (ans && count==1)) {
            result = root;
            return true;
        }

        return ans || count==1;
    }

    public static void main(String[] args) {
        TreeNNode n1 = new TreeNNode(1);
        TreeNNode n2 = new TreeNNode(2);
        TreeNNode n3 = new TreeNNode(3);
        TreeNNode n4 = new TreeNNode(4);
        TreeNNode n5 = new TreeNNode(5);
        TreeNNode n6 = new TreeNNode(6);
        TreeNNode n7 = new TreeNNode(7);
        TreeNNode n8 = new TreeNNode(8);
        TreeNNode n9 = new TreeNNode(9);
        n1.setAdjList(n2);
        n1.setAdjList(n3);
        n1.setAdjList(n4);
        n2.setAdjList(n5);
        n2.setAdjList(n6);
        n3.setAdjList(n7);
        n4.setAdjList(n8);
        n6.setAdjList(n9);

        getLCA(n1,5,9);

        if(result != null)
            System.out.println(result.val);
        else
            System.out.println(-1);
    }

}
