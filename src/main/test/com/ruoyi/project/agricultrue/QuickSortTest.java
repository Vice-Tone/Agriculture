package com.ruoyi.project.agricultrue;


import org.junit.Test;
import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void test(){
        QuickSort quickSort=new QuickSort();
        int[]  arr={5,9,7,4,5,7,6,1,9,9,7,4};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
