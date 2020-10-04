package com.bins.javabasic.tree;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/21 20:13
 * @apiNote 二叉堆
 */
public class BinaryHeap {

    /**
     * 构建一个二叉堆（小顶堆）
     *
     * @apiNote 思路：
     * 1.因为leftChildIndex=2*parentIndex+1,所以parentIndex=（leftChildIndex-1）/2
     * 2.下面之所减了两个1，那是因为len是数组的长度，所以len永远都要比数组下标大1
     */
    public static void buildHeap(int[] nums) {
        int len = nums.length;
        //直接找到第一个非叶子节点的下标
        for (int i = (len - 1 - 1) / 2; i >= 0; i--) {
            downAdjust(nums, i, len);
        }
    }

    /**
     * 下沉操作
     *
     * @apiNote 思路：
     * 1.对节点进行下沉操作
     * 2.先找到该节点的左孩子和右孩子
     * 3.先比较左右孩子的大小，取比较小的那个
     * 4.该节点和比较小的那个节点比较，如果当前节点要大的话，直接退出，没有必要进行比较了
     * 5.如果要小的话，说明该节点需要下沉，并且和较小的那个节点交换
     * 6.这里采用的是单向赋值的方法，不需要每次比较都需要互换一次，直到循环结束之后，在进行最终赋值
     * 7.一次交换之后，让找到的较小的那个节点重新成为父节点，并找出该父节点的左孩子
     * 8.继续循环，直到节点没有孩子节点为止（说明是叶子节点了）
     * 9.时间复杂度：O(log(n))
     * 10.空间复杂度：O(1)
     */
    public static void downAdjust(int[] nums, int parentIndex, int len) {
        //暂存nums[parentIndex],以便最后的交换
        int tmp = nums[parentIndex];
        //1.找parentIndex的左孩子
        int childIndex = 2 * parentIndex + 1;
        //当找到的左孩子下标大于整个数组的长度时，说明，该左孩子的父节点就是叶子节点，父节点没有任何孩子节点
        while (childIndex < len) {
            //2.比较左右孩子的大小，取较小的那个
            if (childIndex + 1 < len && nums[childIndex + 1] < nums[childIndex]) {
                childIndex++;
            }
            //父节点比左右孩子节点都要小，没有必要下沉了
            if (tmp <= nums[childIndex]) {
                break;
            }
            //3.单向赋值
            nums[parentIndex] = nums[childIndex];
            //4.孩子节点作为新的父节点
            parentIndex = childIndex;
            //5.找到新父节点的左孩子
            childIndex = 2 * parentIndex + 1;
        }
        //6.最终替换
        nums[parentIndex] = tmp;
    }


    /**
     * 二叉堆的上浮操作
     *
     * @apiNote 思路：
     * 1.先定位到要插入的元素的位置
     * 2.找到该元素的父节点
     * 3.比较父节点和该元素的大小，如果元素小于父节点则进行交换
     * 4.交换完之后该元素的父节点成为新的孩子节点，继续往上遍历，直到自己的父节点比自己要大
     * 5.最后交换
     * 6.时间复杂度为：O(logn)
     * 7.空间复杂度：O(1)
     */
    public static void upAdjust(int[] nums) {
        int len = nums.length;
        //1.找到被插入元素的下标
        int childIndex = len - 1;
        //暂存被插入的元素
        int tmp = nums[childIndex];
        //2.使用公式反推出该元素的父节点下标
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && tmp < nums[parentIndex]) {
            //单向赋值
            nums[childIndex] = nums[parentIndex];
            //父节点成为新的孩子节点，开始往上走了
            childIndex = parentIndex;
            //反推出新的父节点
            parentIndex = (childIndex - 1) / 2;
        }
        //3.最后交换
        nums[childIndex] = tmp;
    }


    public static void main(String[] args) {
        //随机指定一个无序的数组
        int[] nums = {2, 4, 1, 5, 7, 6, 8, 3, 9};
        System.out.println("原来的树的序列是：" + Arrays.toString(nums));
        //使用nums来构建一个二叉堆
        buildHeap(nums);
        System.out.println("构建的二叉堆的序列是：" + Arrays.toString(nums));

/*        //使用构建好的一个二叉堆的数组的末尾随机加上一个元素来模拟插入一个元素
        int[] nums2 = {1, 3, 2, 4, 7, 6, 8, 5, 9, 0};
        System.out.println("原来的二叉堆的序列为：" + Arrays.toString(nums2));
        upAdjust(nums2);
        System.out.println("新增一个元素0，现在的二叉堆的序列为;" + Arrays.toString(nums2));*/
    }
}
