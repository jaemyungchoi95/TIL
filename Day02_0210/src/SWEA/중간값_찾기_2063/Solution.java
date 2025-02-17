package SWEA.중간값_찾기_2063;

import java.util.*;
import java.io.*;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
         
        System.out.println(arr[arr.length/2]);
         
    }
}
