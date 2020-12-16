//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1386 👎 0

package com.changhongyuan.leetcode.editor.cn;
class LongestCommonPrefix{
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String result = "";
            if (null == strs || strs.length == 0 || null == strs[0]) {
                return result;
            }
            int minLength = strs[0].length();
            for (String s : strs) {
                minLength = Math.min(minLength, s.length());
            }
            for (int i = 0; i < minLength; i++) {
                boolean isEqual = true;
                for (int j = 0; j < strs.length - 1; j++) {
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    result += strs[0].charAt(i);
                } else {
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[10];
        System.out.println(solution.longestCommonPrefix(strs));
    }
}