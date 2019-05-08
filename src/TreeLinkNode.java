public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;

        TreeLinkNode rightChild = pNode.right;

        if(rightChild!=null){
            TreeLinkNode treeLinkNode = rightChild;
            while(rightChild!=null){
                treeLinkNode = rightChild;
                rightChild = rightChild.left;
            }
            return treeLinkNode;
        }


        TreeLinkNode fatherNode = pNode.next;

        while(fatherNode!=null){
            if(fatherNode.left == pNode)
                return fatherNode;
            pNode = fatherNode;
            fatherNode = fatherNode.next;

        }

        return null;

    }




    public int lastLength(String str){
        if(str==null||str.length()==0) return 0;
        String[] strs = str.split(" ");
        String res =  strs[strs.length-1];
        return res.length();

    }

}
