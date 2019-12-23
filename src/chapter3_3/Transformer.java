package chapter3_3;

import java.util.HashMap;
import java.util.Stack;

/**
 * 中缀表达式->后缀表达式，对后缀表达式求值，合为一趟来做
 */
public class Transformer{
    private static HashMap<Character, Integer> priority = new HashMap<>();
    static {
        priority.put('#', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);
    }
    public void transform(String infix){
        Stack<Character> operator = new Stack<>(); // 用于储存操作符的栈
        Stack<Integer> num = new Stack<>(); // 用于储存数字的栈
        for (int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);

            // 若为左括号，入栈
            if (ch == '('){
                operator.push(ch);
            }
            // 若为右括号，不断从栈中弹出，至弹出左括号
            else if (ch == ')'){
                while (operator.peek() != '('){
                    System.out.print(operator.pop()+" ");
                }
                operator.pop();
            }
            // 若为'#'，字符串扫描结束，全部弹出
            else if (ch == '#'){
                while (!operator.empty()){
                    // 每当要弹出运算符时，从num里弹出两个数字，做相应的运算，再压入num
                    char c = operator.pop();
                    int a = num.pop();
                    int b = num.pop();
                    if (c == '+'){
                        num.push(a+b);
                    } else if (c == '-'){
                        num.push(a-b);
                    } else if (c == '*'){
                        num.push(a * b);
                    } else {
                        num.push(a/b);
                    }
                    System.out.print( c +" ");                }
            }
            // 若为运算符 + - * / ，当栈为空时直接压栈；当栈不为空时，判断运算符与当前栈顶运算符的优先级
            // 如果新扫描到的运算符优先级高，则直接压入栈中
            // 如果新扫描到的运算符优先级<=栈顶运算符优先级，则不断弹出运算符，直至新扫描到的运算符优先级高
            else if (isOperator(ch)){
                if (operator.empty()){
                    operator.push(ch);
                } else if (priority.get(ch) <= priority.get(operator.peek())){
                    while (!operator.empty()){
                        if (priority.get(ch) <= priority.get(operator.peek())){
                            // 每当要弹出运算符时，从num里弹出两个数字，做相应的运算，再将结果压入num
                            int a = num.pop();
                            int b = num.pop();
                            char c = operator.pop();
                            if (c == '+'){
                                num.push(a+b);
                            } else if (c == '-'){
                                num.push(a-b);
                            } else if (c == '*'){
                                num.push(a * b);
                            } else {
                                num.push(a/b);
                            }
                            System.out.print( c +" ");
                        }
                    }
                    operator.push(ch);
                } else {
                    operator.push(ch);
                }
            }
            // 如果扫描到到为数字，则压入num栈中，并接输出
            else {
                num.push(Integer.parseInt(String.valueOf(ch)));
                System.out.print(ch+" ");
            }
        }
        System.out.println();
        System.out.println(num.peek());
    }
    private boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

    public static void main(String[] args) {
        Transformer transformer = new Transformer();
        transformer.transform("1+3/3#");
    }
}
