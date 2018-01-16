package _002_MedianOfTwoArr;

/**
 * A[0] A[1] A[2] ...  A[i-1]  |  A[i] ... A[m-1]
 * B[0] B[2] B[2] ...  B[j-1]  |  B[j] ... B[n-1]
 *    left                           right
 *    A的左边有i个元素，右边m-i
 *    B的左边有j个元素，右边n-j
 *    保证m<n,基于短的数组向长的数组做匹配
 *
 *    保证左边部分和右元素的个数相等
 *    i+j=m-i+n-j or m-i+n-j+1
 *    j=(m+n+1)/2-i
 *    同时 A[i-1] <B[j] B[j-1]<A[i] 此时
 *    如果m+n是奇数，MAX（A[i-1],B[j-1]）就是中位数
 *    如果为偶数，MAX（A[i-1],B[j-1]）和MAX（A[i],B[j]）的平均数就是中位数
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int imin = 0;
        int imax = m;
        while(imin<=imax) {
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            if(i<imax && nums1[i] < nums2[j-1]){
                imin ++;
            }
            else if(i>imin && nums1[i-1] > nums2[j]){
                imax --;
            }else{
                int maxLeft;
                if(i==0){
                    maxLeft = nums2[j-1];
                }
                else if(j==0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2==1){
                    return maxLeft;
                }
                int minRight;
                if(i==m){
                    minRight = nums2[j];
                }else if(j==n){
                    minRight = nums1[i];
                }else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,1},new int[]{1,2}));
    }
}
