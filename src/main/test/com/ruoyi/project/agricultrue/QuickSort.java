package com.ruoyi.project.agricultrue;

public class QuickSort {

    public void sort(int[] a) {
        if (a.length > 0) {
            sort(a, 0, a.length - 1);
        }
    }

    public void sort(int[] a, int low, int height) {
        int i = low;
        int j = height;
        if (i > j) {    //放在k之前，防止下标越界
            return;
        }
        int k = a[i];
        while (i < j) {
            while (i < j && a[j] > k) j--;  //找出小的数
            while (i < j && a[i] <= k) i++; //找出大的数
            if (i < j) {   //交换
                int swap = a[i];
                a[i] = a[j];
                a[j] = swap;
            }
        }
        //交换K
        k = a[i];
        a[i] = a[low];
        a[low] = k;
        //对左边进行排序,递归算法
        sort(a, low, i - 1);
        //对右边进行排序
        sort(a, i + 1, height);
    }

}
