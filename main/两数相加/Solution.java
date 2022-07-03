package 两数相加;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode root = new ListNode(0);
        // 对象赋值，复制引用地址
        ListNode cursor = root;
        
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0){
            int l1_val_1 = l1 != null ? l1.val : 0;
            int l2_val_2 = l2 != null ? l2.val : 0;
            int sumVal = l1_val_1 + l2_val_2 + carry;
            
            carry = sumVal / 10;
            
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            
            if (l1 != null){
                l1 = l1.next;
            }
            
            if (l2 != null){
                l2 = l2.next;
            }
        }
        
        return root.next;
    }
}
