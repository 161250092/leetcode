import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
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


}


//  1 -> 2 -> 3 -> 4

//  获得深度，倒叙获取node,重新构建

// 0 -> 4 ->3 ->2 -> 1
