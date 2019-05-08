package search;


import tree.TreeNode;

import java.util.ArrayList;

public class DFS {
    private ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null)  return allLists;
        list.add(root.val);
        target -=root.val;
        if(target==0&&root.left==null&&root.right==null){
            allLists.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return allLists;

    }

    class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        public RandomListNode Clone(RandomListNode pHead)
        {
            if(pHead==null) return null;

            RandomListNode pCur = pHead;
            //copy next node
            while(pCur!=null){
                RandomListNode node = new RandomListNode(pCur.label);
                node.next = pCur.next;
                pCur.next = node;
                pCur = node.next;
            }

            pCur =pHead;
            while(pCur!=null){
                if(pCur.random!=null)
                    pCur.next.random = pCur.random.next;
                pCur = pCur.next.next;
            }
            RandomListNode head = pHead.next;
            RandomListNode cur = head;
            pCur = pHead;
            while(pCur!=null){
                pCur.next = pCur.next.next;
                if(cur.next!=null)
                    cur.next = cur.next.next;
                cur = cur.next;
                pCur = pCur.next;
            }

            return head;

        }
    }

}
