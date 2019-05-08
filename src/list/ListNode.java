package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode reverseNodeList = new ListNode(0);
        ListNode newList = stack.peek();

        while (!stack.isEmpty()) {
            ListNode nodeInStack = stack.pop();
            nodeInStack.next = null;
            reverseNodeList.next = nodeInStack;
            reverseNodeList = reverseNodeList.next;
        }

        return newList;
    }



    public ListNode Merge(ListNode list1,ListNode list2) {
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        List<ListNode> listNodeList = new ArrayList<>();
        while(pHead.next!=null){
            if(listNodeList.contains(pHead))
                return pHead;
            else {
                listNodeList.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        List<ListNode> listNodes =new ArrayList<>();
        ListNode head = pHead;
        while(pHead!=null){
            listNodes.add(pHead);
            pHead = pHead.next;
        }
        int i  =  1;
        List<ListNode> nodes = new ArrayList<>();
        while(i<listNodes.size()-1){

            if(listNodes.get(i).val==listNodes.get(i+1).val){
                int count = i+1;
                while(listNodes.get(count)!=null&&listNodes.get(count).val==listNodes.get(i).val){
                    count++;
                }
                i = count+1;
            }
             else
                nodes.add(listNodes.get(i));
        }

        for(int j=0;j<nodes.size()-1;j++)
            nodes.get(j).next = nodes.get(j+1);

        nodes.get(nodes.size()-1).next = null;
        head.next = nodes.get(0);

        return head;

    }

    public ListNode deleteDuplication1(ListNode pHead)
    {
        ListNode first = new ListNode(-1);//设置一个trick

        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;

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




}


//  1 -> 2 -> 3 -> 4

//  获得深度，倒叙获取node,重新构建

// 0 -> 4 ->3 ->2 -> 1
