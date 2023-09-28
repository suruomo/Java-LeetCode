package advanced.stackandqueue;

import java.util.Stack;

/**
 * @Author: suruomo
 * @Date: 2021/7/24 13:29
 * @Description:  439 三元表达式解析器
 * 给定一个以字符串表示的任意嵌套的三元表达式，计算表达式的值。
 *
 * 你可以假定给定的表达式始终都是有效的并且只包含数字 0-9, ?, :, T 和 F (T 和 F 分别表示真和假）。
 *
 * 注意：
 * 给定的字符串长度 ≤ 10000。
 * 所包含的数字都只有一位数。
 * 条件表达式从右至左结合（和大多数程序设计语言类似）。
 * 条件是 T 和 F其一，即条件永远不会是数字。
 * 表达式的结果是数字 0-9, T 或者 F。
 *
 * 示例 1：
 * 输入： "T?2:3"
 * 输出： "2"
 * 解释： 如果条件为真，结果为 2；否则，结果为 3。
 *
 * 示例 2：
 * 输入： "F?1:T?4:5"
 * 输出： "4"
 * 解释： 条件表达式自右向左结合。使用括号的话，相当于：
 *
 *              "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 *           -> "(F ? 1 : 4)"                 或者     -> "(T ? 4 : 5)"
 *           -> "4"                                    -> "4"
 *
 * 示例 3：
 * 输入： "T?T?F:5:3"
 * 输出： "F"
 * 解释： 条件表达式自右向左结合。使用括号的话，相当于：
 *
 *              "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 *           -> "(T ? F : 3)"                 或者       -> "(T ? F : 5)"
 *           -> "F"                                     -> "F"
 */
public class ParseTernary {
    public static void main(String[] args) {
        String express="T?T?F:5:3";
        System.out.println(parseTernary1(express));
    }
    /**
     * 1.递归
     * @param expression
     * @return
     */
    public static String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int j = 1; j < n; j++) {
            if (expression.charAt(j) == '?') {
                checkLevel++;
            }
            if (expression.charAt(j) == ':') {
                checkLevel--;
            }
            if (checkLevel == 0) {
                return (expression.charAt(0) == 'T') ?
                        parseTernary(expression.substring(2, j)) :
                        parseTernary(expression.substring(j+1, n));
            }
        }
        return expression;
    }

    /**
     * 2.栈,时间空间复杂度为n
     * @param expression
     * @return
     */
    public static String parseTernary1(String expression) {
        if (expression==null||expression.length()==0){
            return "";
        }
        int len=expression.length();
        // 存放每个字符
        Stack<Character> stack=new Stack<>();
        for (int i = len-1; i>=0;i--) {
            char c=expression.charAt(i);
            // 如果栈顶是？,弹出两个数字，结果压栈
            if (!stack.isEmpty()&&stack.peek().equals('?')){
                stack.pop();// 弹出？
                char first=stack.pop();
                stack.pop(); //弹出:
                char second=stack.pop();
                if (c=='T'){
                    stack.push(first);
                }else {
                    stack.push(second);
                }
            }else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.peek());
    }
}
