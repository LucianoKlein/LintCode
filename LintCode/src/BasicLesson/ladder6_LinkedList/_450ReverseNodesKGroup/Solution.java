package BasicLesson.ladder6_LinkedList._450ReverseNodesKGroup;

import util.listhelper.ListNode;

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        //这个题意是k个一反 k个一反
        while (prev != null) {
            prev = reverseKNodes(prev, k);
        }
        
        return dummy.next;
    }
    
    
    // prev -> n1 -> n2 ... nk -> nk+1
    // prev -> nk -> nk-1...n1 -> nk+1
    private ListNode reverseKNodes(ListNode prev, int k) {
        
        if (k <= 0) {
            return null;
        }
        
        if (prev == null) {
            return null;
        }
        
        ListNode nodek = prev;
        //从node1开始转
        ListNode node1 = prev.next;
        
        //k个节点, nodek指向
        for (int i = 0; i < k; i++) {
            if (nodek == null) {
                return null;
            }
            nodek = nodek.next;
        }
        
        //如果为空, 那就
        if (nodek == null) {
            return null;
        }
        
        //nodek的下一个 是nodekplus    
        ListNode nodekplus = nodek.next;
        
        //反转k个节点
        reverse(prev, prev.next, k);
        
        //node1一直指向的是
        node1.next = nodekplus;
        
        //prev传入参数, 有另外的副本, 此处的prev还是dummy那个
        prev.next = nodek;
        
        return node1;
    }
    
    //这里实际上可以用2个参数就够了
    private void reverse(ListNode prev, ListNode curt, int k) {
        //  1 -> 2 -> 3 -> 4 -> 5
        //  1 <- 2    3 -> 4 -> 5
        //       |    |
        //       prev curt
        //  .................
        //  1 <- 2 <- 3 <- 4 <- 5
        //                 |    |    |
        //                      prev curt
        for (int i = 0; i < k; i++) {
            //temp 记录当前节点的下一个节点
            ListNode temp = curt.next;
            //当前节点 和前一个连 
            curt.next = prev;
            //prev指向当前节点
            prev = curt;
            //curt指向 temp 
            curt = temp;
        }
    }
}
