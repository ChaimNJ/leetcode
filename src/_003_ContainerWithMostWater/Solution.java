package _003_ContainerWithMostWater;

public class Solution {
    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length ; j++) {
                max = Math.max(max, Math.min(height[i],height[j])*(j-i));
            }
        }
        return  max;
    }

    /**
     * 数组前后各设一个指针，线的长度小的一段向打的一段靠拢，以抵消距离的缩小时面积减少
     * 如果长的向短的靠拢，没有意义，面积只会更小。
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        int head = 0;
        int tail = height.length - 1;
        while(head < tail){
            max = Math.max(max,Math.min(height[head], height[tail]) * (tail - head));
            if(height[head] < height[tail]){
                head++;
            }else{
                tail--;
            }

        }
        return max;
    }

    public static void main(String[] args) {

    }
}
