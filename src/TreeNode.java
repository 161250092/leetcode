import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(){}


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = 0;
        for(int i=0;i<in.length;i++)
            if(in[i]==pre[0]) {
                rootIndex = i;
                break;
            }
//        左树、右数的in order
        int[] left_in = Arrays.copyOfRange(in, 0, rootIndex);
        int[] right_in = Arrays.copyOfRange(in, rootIndex+1, in.length);

        int[] left_pre = Arrays.copyOfRange(pre, 1, left_in.length+1);
        int[] right_pre = Arrays.copyOfRange(pre,left_in.length+1,pre.length);

        root.left = reConstructBinaryTree(left_pre,left_in);
        root.right = reConstructBinaryTree(right_pre,right_in);


        return root;
    }



    private TreeNode buildTree(int[] pre,int[] in){
        if(pre.length==0){
            return null;
        }

        int rootIndex = 0;
        TreeNode node = new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++)
            if(in[i]==pre[0]) {
                rootIndex = i;
                break;
            }

        int[] left_in = Arrays.copyOfRange(in, 0, rootIndex);
        int[] right_in = Arrays.copyOfRange(in, rootIndex+1, in.length);

        int[] left_pre = Arrays.copyOfRange(pre, 1, left_in.length+1);
        int[] right_pre = Arrays.copyOfRange(pre,left_in.length+1,pre.length);

        node.left=buildTree(left_pre,left_in);
        node.right=buildTree(right_pre,right_in);

        return node;

    }

    public boolean VerifySquenceOfBST(int [] sequence) {
       if(sequence.length==0) return false;
       if(sequence.length==1) return true;
       return judge(sequence,0,sequence.length-1);

    }
    private boolean isBST(int[] sequence){
        if(sequence.length==0||sequence.length==1||sequence.length==2)
            return true;

        int left_right = 0;
        int rootNum = sequence[sequence.length-1];
//        System.out.println(rootNum);
        for(int i=0;i<sequence.length-1;i++)
            if(sequence[i]<rootNum&&rootNum<sequence[i+1]) {
                left_right = i;
//                System.out.println(left_right);
                break;

            }

//        for(int i=0;i<=left_right;i++)
//            if(sequence[i]>rootNum) {
////                System.out.println(i);
//                return false;
//            }
        for(int i=left_right+1;i<sequence.length;i++)
            if(sequence[i]<rootNum) {
//                System.out.println(i);
                return false;
            }


        int[] leftTree = Arrays.copyOfRange(sequence,0,left_right+1);
        int[] rightTree = Arrays.copyOfRange(sequence,left_right+1,sequence.length-1);


        return isBST(leftTree)&&isBST(rightTree);
    }

    public boolean judge(int[] a,int start,int end){
        if(start>=end) return true;
        int i = start;
        while(a[i]<a[end])
            i++;
        for(int j=i;j<end;j++){
            if(a[j]<a[end])
                return false;
        }

        return judge(a,start,i-1)&& judge(a,i,end-1);


    }

    public void preOrder(TreeNode node){
        if(node == null)
            return;
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);


        Stack<Integer> stack =  new Stack<>();

    }



    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        List<TreeNode> possibleNode = new ArrayList<>();
        getPossibleTreeNode(root1,root2.val,possibleNode);
        System.out.println(possibleNode.size());
        if(possibleNode.size()==0)
            return false;

        for(TreeNode treeNode:possibleNode)
            if(DoesTree1HaveTree2(treeNode,root2))
                return true;

        return false;


    }

    private void getPossibleTreeNode(TreeNode node,int val,List<TreeNode> possibleNode){
        if(node == null)
            return;
        if(node.val==val)
            possibleNode.add(node);
        getPossibleTreeNode(node.left,val,possibleNode);
        getPossibleTreeNode(node.right,val,possibleNode);

    }

    private boolean isSameTree(TreeNode node1,TreeNode node2){

        if(node1==null&&node2==null)
            return true;
        else if(node1==null||node2==null)
            return false;

        else {
            if(node1.val!=node2.val)
                return false;
            else
                return isSameTree(node1.left,node2.left)&&isSameTree(node1.right,node2.right);
        }

//        return false;
    }



    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 != null) return false;
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }



    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);


    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClockWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }


    public void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow&&startCol<endCol){
            for(int i=startCol;i<=endCol;i++) result.add(matrix[startRow][i]);

            for(int i=startRow+1;i<=endRow-1;i++) result.add(matrix[i][endCol]);

            for(int i=endCol;i>=startCol;i--)  result.add(matrix[endRow][i]);

            for(int i=endRow-1;i>=startRow+1;i--) result.add(matrix[i][startCol]);

            printMatrixClockWisely(matrix,startRow+1,startCol+1,endRow-1,endCol-1,result);
        }

        else if(startRow==endRow&&startCol<endCol){
            for(int i=startCol;i<=endCol;i++)
                result.add(matrix[startRow][i]);
        }

        else if(startCol==endCol&&startRow<endRow){
            for(int i=startRow;i<=endRow;i++)
                result.add(matrix[i][startCol]);
        }
        else if(startCol==endCol&&startRow==endRow){
                result.add(matrix[startRow][startCol]);
        }


    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        ArrayList<TreeNode> nodesAsc = new ArrayList<>();
        inOrder(pRootOfTree,nodesAsc);

        nodesAsc.get(0).left = null;
        for(int i=0;i<nodesAsc.size()-1;i++){
            nodesAsc.get(i).right = nodesAsc.get(i+1);
            nodesAsc.get(i+1).left = nodesAsc.get(i);
        }
        nodesAsc.get(nodesAsc.size()-1).right = null;
//        System.out.println(nodesAsc.get(0).val+" "+nodesAsc.get(0).left.val);
        return nodesAsc.get(0);

    }



    public ArrayList<String> Permutation(String str) {
            ArrayList<String> list =new ArrayList<>();
            if(str!=null&&str.length()>0){
                PermutationHelper(str.toCharArray(),0,list);
                Collections.sort(list);
            }
            return list;
    }

    private void PermutationHelper(char[] chars,int index,ArrayList<String> list){
            if(index==chars.length-1) {
                String val = String.valueOf((chars));
                if(!list.contains(val))
                    list.add(val);
            }
            else{
                for(int j=index;j<chars.length;j++){
                        swap(chars,index,j);
                        PermutationHelper(chars,index+1,list);
                        swap(chars,index,j);
                }

            }
    }

    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int size = array.length;
        for(int i=0;i<array.length;i++){
            int count = 0;
            int target = array[i];
            for(int j=0;j<size;j++){
                if(array[j]==target){
                    count++;
                }
                if(count>size/2)
                    return target;
            }
        }
        return 0;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
     /*
        假定 List1长度: a+n  List2 长度:b+n, 且 a<b
        那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
        接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
        将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。
        或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.

        
        时间复杂度O(n+a+b)

       */

            ListNode p1 = pHead1;
            ListNode p2 = pHead2;
            while(p1 != p2){
                if(p1 != null) p1 = p1.next;
                if(p2 != null) p2 = p2.next;
                if(p1!=p2){
                    if(p1 == null) p1 = pHead2;
                    if(p2 == null) p2 = pHead1;
                }
            }

            return p1;

    }



    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        return isSymmetrical(pRoot.left,pRoot.right);

    }

    public boolean isSymmetrical(TreeNode node1,TreeNode node2){
        if(node1==null&&node2!=null) return false;
        if(node1!=null&&node2==null) return false;
        if(node1==null&&node2==null) return true;

        if(node1.val==node2.val)
                return isSymmetrical(node1.left,node2.right);
        else
            return false;

    }

    public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        List<TreeNode> nodes = new ArrayList<>();
        int flag = 0;
        ArrayList<ArrayList<Integer>> res  = new ArrayList<>();
        if(pRoot==null) return res;

        nodes.add(pRoot);
        while(!nodes.isEmpty()){
            if(flag%2==0){
                int length = nodes.size();
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i=0;i<length;i++) {
                    arrayList.add(nodes.get(0).val);
                    TreeNode leftChild = nodes.get(0).left;
                    TreeNode rightChild = nodes.get(0).right;
                    if(leftChild!=null)
                        nodes.add(leftChild);
                    if(rightChild!=null)
                        nodes.add(rightChild);
                    nodes.remove(0);
                }
                flag++;
                res.add(arrayList);
            }

            else {
                int length = nodes.size();
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i=length-1;i>=0;i--){
                    arrayList.add(nodes.get(i).val);
                }

                for(int i=0;i<length;i++){
                    TreeNode leftChild = nodes.get(0).left;
                    TreeNode rightChild = nodes.get(0).right;
                    if(leftChild!=null)
                        nodes.add(leftChild);
                    if(rightChild!=null)
                        nodes.add(rightChild);
                    nodes.remove(0);
                }
                flag++;
                res.add(arrayList);
            }

        }

        return res;
    }


    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode> stack = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(pRoot==null) return res;
        stack.offer(pRoot);
        while(!stack.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int length = stack.size();
            for(int i=0;i<length;i++){
                TreeNode node = stack.poll();
                arrayList.add(node.val);
                TreeNode leftChild = node.left;
                TreeNode rightChild = node.right;
                if(leftChild!=null)
                    stack.offer(leftChild);
                if(rightChild!=null)
                    stack.offer(rightChild);
            }
            res.add(arrayList);
        }
        return res;
    }



    TreeNode KthNode(TreeNode pRoot, int k)
    {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRoot,list);
        if(k<=0||k>list.size())
            return null;

        return list.get(k-1);
    }


    public void inOrder(TreeNode node,ArrayList<TreeNode> nodeList){
        if(node==null) return;
        inOrder(node.left,nodeList);
        nodeList.add(node);
//        System.out.print(" "+node.val+" ");
        inOrder(node.right,nodeList);

    }

    int res  = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node){
        if(node == null)  return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res +=Math.abs(left)+Math.abs(right);
        return node.val+left+right-1;
    }

    public int twoCitySchedCost(int[][] costs){
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]-o1[0])-(o2[1]-o2[0]);
            }
        });

        int cost = 0;
        for(int i=0;i<costs.length/2;i++)
            cost +=costs[i][1]+costs[costs.length-1-i][0];
        return cost;
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        while(root.val<L||root.val>R){
            if(root.val<L)
                root = root.right;
            else
                root = root.left;
        }
        trimR(root.right,R,root);
        trimL(root.left,L,root);

        return root;
    }

    private void trimR(TreeNode node,int R,TreeNode fatherNode){
        if(node==null)
            return;

        if(node.val>R){
            node = node.left;
            fatherNode.right = node;
            trimR(node,R,fatherNode);
        }

        else if(node.val<=R){
            fatherNode = node;
            trimR(node.right,R,fatherNode);
        }
    }

    private void trimL(TreeNode node,int L,TreeNode fatherNode){
        if(node==null)
            return;
        if(node.val<L){
            node = node.right;
            fatherNode.left = node;
            trimL(node,L,fatherNode);
        }
        else if(node.val>=L){
            fatherNode = node;
            trimL(node.left,L,fatherNode);
        }
    }

    
//    int res=0;
//    public int distributeCoins(TreeNode root) {
//        if(root == null)
//            return 0;
//
//        pre_Order(root,true);
//        if(root.val==0)
//            res++;
//        return res;
//    }
//
//    public void pre_Order(TreeNode node,boolean isRoot){
//        if(node==null)
//            return;
//
//        vlr(node,isRoot);
//        res +=count;
//        count = 0;
//
//        pre_Order(node.left,true);
//        pre_Order(node.right,true);
//    }
//
//
//    //数节点的子节点数量
//    int count=0;
//    public void vlr(TreeNode node,boolean isRoot){
//        if(node==null)
//            return;
//        if(!isRoot)
//            count++;
//        vlr(node.left,false);
//        vlr(node.right,false);
//    }
//
//
//
//
//    public int countChildNode(TreeNode node,int childNodeNum){
//        if(node == null)
//            return childNodeNum;
//
//        int num = 0;
//        if(node.left!=null) {
//            childNodeNum++;
//            num +=countChildNode(node.left,childNodeNum);
//        }
//        if(node.right!=null){
//            childNodeNum++;
//            num +=countChildNode(node.right,childNodeNum);
//        }
//
//        return num;
//    }

}


