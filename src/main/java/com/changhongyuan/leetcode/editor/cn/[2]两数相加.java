//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5378 👎 0

package com.changhongyuan.leetcode.editor.cn;

import com.changhongyuan.leetcode.ListNode;

class AddTwoNumbers{
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = new ListNode(0);
        return doCal(l1, l2, 0);
    }

    public ListNode doCal(ListNode l1, ListNode l2, int in) {
        //判断递归终止，包括进位也要判断
        if (null == l1 && null == l2 && in == 0) {
            return null;
        }
        int n1 = null != l1 ? l1.val : 0;
        int n2 = null != l2 ? l2.val : 0;
        int sum = n1 + n2 + in;
        ListNode result = new ListNode(sum % 10);
        //判断递归，将next做一长串
        result.next = doCal(null != l1 ? l1.next : null, null != l2 ? l2.next : null, sum / 10);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        ListNode result = solution.addTwoNumbers(l1, l2);
//        System.out.println(result);
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println("l1 is " + l1);
        System.out.println("l2 is " + l2);
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);

    }
}