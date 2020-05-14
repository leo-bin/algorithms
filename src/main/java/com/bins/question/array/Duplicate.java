package com.bins.question.array;


/**
 * @author leo-bin
 * @date 2020/3/15 15:15
 * @apiNote 重复数组
 */
public class Duplicate {


    /**
     * 题目描述：
     * 1.在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 2.数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 3.也不知道每个数字重复几次。
     * 4.请找出数组中任意一个重复的数字。
     * 5.例如
     * 如果输入长度为7的数组{2,3,1,0,2,5,3}
     * 那么对应的输出是第一个重复的数字2
     *
     * @apiNote 思路：
     * 1.遇到这种元素有重复，需要你去重，或者判断出现的次数，出现重复的元素是什么这种题型
     * 2.可以使用一个额外的空间来存放所有的元素，比如说HashMap，HashSet等等。
     * 3.你只要依次遍历所有元素，写这个HashMap，到了第二次如果出现重复的数的话，你就判断成功，记录一下就行
     * 4.但是这种方式的时间复杂度一般都是O（n），而且需要O（n）的空间复杂度
     * 5.这里我们可以投机取巧一点，因为题目中说到数组中的元素都是小于n-1的
     * 6.所以我们可以创建一个大小和原数组相同的数组，基本类型是boolean，因为在boolean数组，一个元素是占一个字节
     * 7.虽然时间复杂度没有减少，但是可以少占一点内存
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        //鲁棒
        if (length == 0) {
            return false;
        }
        //类似于一个布隆过滤器，所有元素的值作为过滤器的位置，在对应的位置置为true，代表这个数出现过了
        boolean[] filter = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (filter[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            filter[numbers[i]] = true;
        }
        return false;
    }


    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[2];
        if (duplicate.duplicate(numbers, numbers.length, duplication)) {
            System.out.println("数组中第一个重复出现的数字为：" + duplication[0]);
        } else {
            System.out.println("没有重复的");
        }
    }
}
