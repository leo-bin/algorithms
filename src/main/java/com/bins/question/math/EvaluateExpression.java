package com.bins.question.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/8/20 22:30
 * @apiNote 表达式求值
 */
public class EvaluateExpression {

    /**
     * 构造方法，初始化优先级表
     */
    public EvaluateExpression() {
        // initialize stack
        optStack.push("#");

        // initialize priority table
        // +
        Map<String, String> subMap = new HashMap<>(16);
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("+", subMap);

        // -
        subMap = new HashMap<>(16);
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("-", subMap);

        // *
        subMap = new HashMap<>(16);
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", ">");
        subMap.put("/", ">");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("*", subMap);

        // /
        subMap = new HashMap<>(16);
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", ">");
        subMap.put("/", ">");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("/", subMap);

        // (
        subMap = new HashMap<>(16);
        subMap.put("+", "<");
        subMap.put("-", "<");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        subMap.put(")", "=");
        //subMap.put("#", ">");
        priorityMap.put("(", subMap);

        // )
        subMap = new HashMap<>(16);
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", ">");
        subMap.put("/", ">");
        //subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put(")", subMap);

        // #
        subMap = new HashMap<>(16);
        subMap.put("+", "<");
        subMap.put("-", "<");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        //subMap.put(")", ">");
        subMap.put("#", "=");
        priorityMap.put("#", subMap);
    }

    /**
     * 运算符优先级关系表
     */
    private Map<String, Map<String, String>> priorityMap = new HashMap<>(16);
    /**
     * 运算符栈
     */
    private Stack<String> optStack = new Stack<>();
    /**
     * 操作数栈
     */
    private Stack<Double> numStack = new Stack<>();

    /**
     * 计算表达式
     *
     * @param exp 四则运算表达式, 每个符号必须以空格分隔
     */
    public double calculate(String exp) {
        char[] chs = exp.toCharArray();
        for (char c : chs) {
            process(c + "");
        }
        //返回结果
        return numStack.pop();
    }

    /**
     * 读入一个符号串。
     * 如果是数字，则压入numStack
     * 如果是运算符，则将optStack栈顶元素与该运算符进行优先级比较
     * 如果栈顶元素优先级低，则将运算符压入optStack栈,如果相同，则弹出左括号
     * 如果高，则取出２个数字，取出一个运算符执行计算，然后将结果压入numStack栈中
     */
    private void process(String token) {
        while (!"#".equals(optStack.peek()) || !"#".equals(token)) {
            if (isNumber(token)) {
                numStack.push(Double.parseDouble(token));
                break;
            } else {
                String priority = priority(optStack.peek(), token);
                if ("<".equals(priority)) {
                    optStack.push(token);
                    break;
                } else if ("=".equals(priority)) {
                    optStack.pop();
                    break;
                } else {
                    double res = calculate(optStack.pop(), numStack.pop(), numStack.pop());
                    numStack.push(res);
                }
            }
        }
    }

    /**
     * 执行四则运算
     */
    private double calculate(String opt, double n1, double n2) {
        if ("+".equals(opt)) {
            return n2 + n1;
        } else if ("-".equals(opt)) {
            return n2 - n1;
        } else if ("*".equals(opt)) {
            return n2 * n1;
        } else if ("/".equals(opt)) {
            return n2 / n1;
        } else {
            throw new RuntimeException("unsupported operator:" + opt);
        }
    }

    /**
     * 检查一个String是否为数字
     */
    private boolean isNumber(String token) {
        for (int ix = 0; ix < token.length(); ++ix) {
            char ch = token.charAt(ix);
            // 跳过小数点
            if (ch == '.') {
                continue;
            }
            if (!isNumber(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查一个字符是否为数字
     */
    private boolean isNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    /**
     * 查表得到op1和op2的优先级
     *
     * @param op1 运算符1
     * @param op2 运算符2
     * @return ">", "<" 或 "="
     */
    public String priority(String op1, String op2) {
        return priorityMap.get(op1).get(op2);
    }


    public static void main(String[] args) {
        EvaluateExpression expression = new EvaluateExpression();
        String exp = "4*(10+2)+1";
        System.out.println(expression.calculate(exp));
    }
}
