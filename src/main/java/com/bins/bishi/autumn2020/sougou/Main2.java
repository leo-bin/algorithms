package com.bins.bishi.autumn2020.sougou;


/**
 * @author leo-bin
 * @date 2020/9/5 17:55
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 某市政府规划建设一个新的小镇
     * 要求小镇上的所有房屋都坐落在同一条东西向大街的北侧并且临街（两座房子不能重叠）
     * 到目前为止，这条街上已经建造了n座房子，每座房子的位置是xi，面宽是ai。
     * 建造工程师小汪受命在该小镇建造一座新房屋
     * 客户希望他的新房屋面宽为t，并且至少贴着之前已有的一座房子建造
     * 您能帮小汪算出这座房屋一共有多少种建法吗？
     * 注意： xi为每座房子的中心坐标
     * <p>
     * 示例1
     * 输入
     * 2,[-1,4,5,2]
     * 输出
     * 4
     * 说明
     * 要创建一个房屋面宽为2的房屋，其中已有两个房屋A、B
     * 其中A坐标为-1宽度为4，B坐标5宽度为2，这样A占据了-3~1，B占据了4~6。
     * 因此我们能紧挨这A的东面或西面、或者B的东面或西面建造新房子，一共4种建法。
     * <p>
     * 备注:
     * 输入数据是有序的，保证Xi<Xi+1
     *
     * @apiNote 思路：
     * 1.模拟+贪心
     */
    public static int code(int t, int[] xa) {
        int maxCount = 2;
        int[] nums = new int[(xa.length / 2) - 1];
        for (int index = 0, i = 0, j = 2; i < xa.length && j < xa.length; i += 2, j += 2, index++) {
            nums[index] = (xa[j] - xa[j + 1] / 2) - (xa[i] + xa[i + 1] / 2);
        }
        for (int n : nums) {
            if (n == t) {
                maxCount++;
            }
            if (n > t) {
                maxCount += 2;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int t = 2;
        int[] xa = {-1, 4, 5, 2};
        System.out.println(code(t, xa));
    }
}
