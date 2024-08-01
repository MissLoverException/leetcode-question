//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 334 👎 0

package com.changhongyuan.leetcode.editor.cn;
class DiagonalTraverse{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (null == mat || mat.length == 0) {
            return new int[0];
        }
        int[] result = new int[mat.length * mat[0].length];
        int r = 0;
        int c = 1;
        boolean flag = true;
        boolean sideFlag = true;
        result[0] = mat[0][0];
        for (int i = 1; i < result.length; i++) {
            if (sideFlag) {
                if (r == 0) {
                    result[i] = mat[c--][++r];
                    flag = true;
                } else if (c == 0) {
                    result[i] = mat[++c][r--];
                    flag = false;
                } else if (r == mat.length) {
                    result[i] = mat[++c][r--];
                    flag = true;
                } else if (c == mat[0].length) {
                    result[i] = mat[c--][++r];
                    flag = false;
                }
                sideFlag = false;
            } else {
                if (r == 0 || c == 0 || r == mat.length || c == mat[0].length) {
                    sideFlag = true;
                }
                if (flag) {
                    result[i] = mat[c++][r--];
                } else {
                    result[i] = mat[c--][r++];
                }
            }
            for (int a : result) {
                System.out.print(a + " ");
            }
            System.out.println("\n" + r + " " + c);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        Solution solution = new DiagonalTraverse().new Solution();
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for (int[] arr : mat) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[] result = solution.findDiagonalOrder(mat);
        for (int a : result) {
            System.out.print(a + " ");
        }
    }
}