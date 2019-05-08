

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack {

    private Stack<Integer>  data = new Stack<>();
    private Stack<Integer>  min = new Stack<>();

    public void push(int node) {
            data.push(node);

            if(min.isEmpty())
                min.push(node);
            else
                if(min.peek()>=node)
                    min.push(node);

    }

    public void pop() {
        int num = data.pop();

        if(min.peek()==num)
            min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }


    public boolean IsPopOrder(int [] pushA,int [] popA) {
            if(pushA.length==0 || popA.length == 0)
                return false;
            Stack<Integer> s = new Stack<>();
            int popIndex = 0;
        for (int aPushA : pushA) {
            s.push(aPushA);
            while (!s.isEmpty() && s.peek() == popA[popIndex]) {
                s.pop();
                popIndex++;
            }
        }
            return s.isEmpty();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            if(root==null) return null;
            else
                queue.add(root);
            ArrayList<Integer> list = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode node =queue.poll();
                list.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                   queue.offer(node.right);


            }
            return list;

    }


}
