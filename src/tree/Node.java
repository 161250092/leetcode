package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> i_level = new ArrayList<>();

            for(int i=0;i<size;i++){
                Node currentNode = queue.poll();
                i_level.add(currentNode.val);

                for(Node node:currentNode.children){
                    if(node!=null)
                    queue.offer(node);
                }

            }
            res.add(i_level);
        }

        return res;

    }


}
