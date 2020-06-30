package com.bins.question.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author leo-bin
 * @date 2020/6/29 10:22
 * @apiNote 数组中的第K个最大元素
 * 来源：leetcode-215
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {

    private static Random random = new Random(System.currentTimeMillis());

    /**
     * 题目描述：
     * 1.在未排序的数组中找到第 k 个最大的元素
     * 2.请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素
     * <p>
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * <p>
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * <p>
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
     *
     * @apiNote 思路：
     * 1.这道题拿到手发现是中等，有点奇怪
     * 2.因为很快就能够想到排序的解法，然后这里还可以用api来做，更加简单了
     * 3.但是想了下，发现这道题的出题动机肯定不是让你直接用api来做，要不然这题可以上easy的
     * 4.所以我们最好是自己实现排序吧！顺便复习下快排和堆排序
     * 5.时间复杂度：O(n*log(n))
     * 6.空间复杂度：O(1)
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * 自己实现快速排序！
     *
     * @apiNote 思路：
     * 1.自己实现快速排序
     * 2.然后直接返回原数组的倒数第k个元素就行
     * 3.时间复杂度：O(n*log(n))
     * 4.空间复杂度：O(1)
     */
    public static int findKthLargestV2(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }


    /**
     * 快排
     */
    public static void quickSort(int[] nums, int low, int high) {
        //递归结束条件
        if (low >= high) {
            return;
        }
        int midIndex = partition(nums, low, high);
        //左右分别进行分治
        quickSort(nums, low, midIndex - 1);
        quickSort(nums, midIndex + 1, high);
    }

    /**
     * 分治
     *
     * @apiNote 思路：
     * 1.每次以区间的第一个元素作为中轴
     * 2.然后同时从右边和左边一起开始遍历
     * 3.右边遇到比中轴元素要大的，就跳过，要小的就退出循环，准备交换
     * 4.同样的，左边也是，遇到比中轴元素小的就跳过，要大的直接退出循环
     * 5.然后现在开始交换此时的左指针和右指针所指的元素。
     * 6.最后就能实现以中轴为准，中轴左边的所有元素都要小于中轴，右边的都要大于中轴
     * 7.这就叫做分治
     * 8.时间复杂度：O(log(n))
     * 9.空间复杂度：O(1)
     */
    public static int partition(int[] nums, int low, int high) {
        //考虑到某些极端用例，这里的中轴不能直接选择low，应该时随机选一个，然后和low进行交换
        if (high > low) {
            int randomIndex = low + 1 + random.nextInt(high - low);
            swap(nums, low, randomIndex);
        }
        int midValue = nums[low];
        int midIndex = low;
        while (low != high) {
            while (low < high && nums[high] > midValue) {
                high--;
            }
            while (low < high && nums[low] <= midValue) {
                low++;
            }
            //交换
            if (low < high) {
                swap(nums, low, high);
            }
        }
        //将中轴复原并返回中轴所在的位置
        nums[midIndex] = nums[low];
        nums[low] = midValue;
        return low;
    }


    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    /**
     * 解法三，使用优先级队列
     *
     * @apiNote 思路：
     * 1.这个思路我觉得特比的巧妙！神仙呀
     * 2.首先我确实是想到了优先级队列，其实也就是二叉堆去做这个题目
     * 3.大顶堆和小顶堆都可以解决
     * 4.如果选大顶堆的话，我们首先会想到，一次遍历将数组变成一个大顶堆
     * 5.然后再一次遍历，从堆顶元素开始一直遍历k个数，最后第k个数就是第k大的元素
     * 6.小顶堆原理也是一样的，这样做就比较直接
     * 7.构造大顶堆的时间复杂度是O(n*log(n))
     * 8.后面的一次遍历时间复杂度是O(k)，综合就是O(n*log(n))
     * 9.但是这样感觉重复做了很多步骤，代码不是很优雅
     * 10.于是，就有了下面的神仙代码！
     * 11.在我们构造小顶堆的过程中，就能够间接的找到这第k个数
     * 12.我们去想这样一个问题，假设我们的数据是：[3,2,1,5,6,4],k=2
     * 13.我们要找第2大的元素，然后构造小顶堆
     * 14.我们是不是只要实现一次遍历之后，最后就只剩下最大的两个数，然后直接取第一个数，答案不就出来了？
     * 15.但是如何实现呢？我们一步一步的来！首先！我们想简单一点！
     * 16.如果要你实现最后只剩下k个元素，但是暂时不用考虑大小的，你会怎么做？
     * 17.简单！我们只要在队列中一旦出现个元素数大于k时，我们就主动将堆顶元素拉出来！
     * 18.ok！是不是很简单？接下来，我们想第二个问题！如何保证剩下的这k个元素就是最大的k个数呢？
     * 19.因为我们这里使用了小顶堆！队头元素一定是队列中最小的那一个！
     * 20.也就是说，我们每次poll出来的元素一定是当前队列中的最小的那个！
     * 21.这样一想，那剩下的k个元素不就是最大的两个元素吗！而且！现在的队头元素，一定是第k大的！而不是最大的！
     * 22.虽然说这种解法的时间复杂度和之前的想法没什么区别！但是!很明显这个效率就要高多了！
     * 23.时间复杂度：O(n*log(n))
     * 24.空间复杂度：O(n)
     */
    public static int findKthLargestV3(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }


    /**
     * 解法四，基于快速排序的基础上，我们进行分治
     *
     * @apiNote 思路：
     * 1.
     */
    public static int findKthLargestV4(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        //我们要找第k大的元素，从小到大排序之后其实就是找len-k个元素
        int kthIndex = nums.length - k;
        while (true) {
            int index = partition(nums, low, high);
            if (index == kthIndex) {
                return nums[index];
            } else if (index < kthIndex) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
    }


    /**
     * 我们直接使用堆排序
     *
     * @apiNote 思路：
     * 1.使用堆排序
     * 2.时间复杂度：O(n*log(n))
     * 3.空间复杂度：O(1)
     */
    public static int findKthLargestV5(int[] nums, int k) {
        heapSort(nums, nums.length);
        return nums[nums.length - k];
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] nums, int len) {
        //1.构建大顶堆(这里是找最后一个非叶子节点)
        for (int i = (len - 2) / 2; i >= 0; i--) {
            downJust(nums, i, len);
        }
        //2.找二叉堆的堆顶元素，并重新进行调整
        for (int i = len - 1; i > 0; i--) {
            int t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;
            //重新调整
            downJust(nums, 0, i);
        }
    }

    /**
     * 元素下沉操作
     */
    public static void downJust(int[] nums, int parentIndex, int len) {
        int parentValue = nums[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < len) {
            if (childIndex + 1 < len && nums[childIndex + 1] > nums[childIndex]) {
                childIndex++;
            }
            if (parentValue > nums[childIndex]) {
                break;
            }
            nums[parentIndex] = nums[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        nums[parentIndex] = parentValue;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(findKthLargestV2(nums1, k1));
        System.out.println(findKthLargestV2(nums1, k1));
        System.out.println(findKthLargestV3(nums1, k1));
        System.out.println(findKthLargestV4(nums1, k1));
    }
}
