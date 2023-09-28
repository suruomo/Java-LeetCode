package advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: suruomo
 * @Date: 2021/7/24 14:26
 * @Description: 1106. 解析布尔表达式
 *给你一个以字符串形式表述的布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *
 */
public class ParseBoolExpression {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> deque=new ArrayDeque<>();
        int len=expression.length();
        for (int i = 0; i < len; i++) {
            char c=expression.charAt(i);
            if (c==','){
                continue;
            }
            if (c!=')'){
                deque.offerLast(c);
            }else {
                Deque<Character> deque1=new ArrayDeque<>();
                while (deque.peekLast()!='('){
                    deque1.offerLast(deque.pollLast());
                }
                // 弹出（
                deque.pollLast();
                // 弹出运算符
                char ex=deque.pollLast();
                deque.addLast(calculate(deque1,ex));
            }
        }
        return deque.peek()=='t';
    }

    private Character calculate(Deque<Character> deque, char ex) {
      if (ex=='!'){
          return deque.pollLast()=='t'?'f':'t';
      }
      if (ex=='&'){
          while (!deque.isEmpty()){
              if(deque.pollLast()=='f'){
                  return 'f';
              }
          }
          return 't';
      }
      if (ex=='|'){
          while (!deque.isEmpty()){
              if (deque.pollLast()=='t'){
                  return 't';
              }
          }
          return 'f';
      }
      return ' ';
    }
}
