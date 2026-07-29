package Basics;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Arrays{

    private void reverse(int[] arr){
        int n = arr.length;
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            int j = n-i-1;
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    private void traverse(int[] arr){
        for(int x:arr){
            System.out.println(x);
        }
    }

    private void rotateRight(int[] arr){
        int n = arr.length;
        int last = arr[n-1];
        for(int i = 1;i<n;i++){
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }

    private void rotateLeft(int[] arr, int pos){
        int n = arr.length;
        int first = arr[pos];
        for(int i=pos;i<n-1;i++){
            arr[i]= arr[i+1];
        }
        arr[n-1] = first;
    }

    private void insert(int[] arr,int num){
        rotateRight(arr);
        arr[0] = num;
    }

    private void delete(int[] arr,int num){
        int index = search(arr, num);
        if(index<0){
            return;
        }
        rotateLeft(arr, index);
        arr[index] = 0;
        
    }

    private int search(int[] arr,int num){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr,int num){
        sorterHelper(arr);

        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid] == num){
                return mid;
            }
            else if (arr[mid]>num){
                right = mid -1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

    private int ternarySearch(int[] arr,int num){
        sorterHelper(arr);

        int left = 0;
        int right = arr.length -1;

        while(left<=right){
            int mid1 = left + (right -left)/3;
            int mid2 = right - (right - left)/3;
            if(arr[mid1] == num){
                return mid1;
            }
            if (arr[mid2] == num){
                return mid2;
            }

            if(num<arr[mid1]){
                right= mid1-1;
            }
            else if (num>arr[mid2]){
                left = mid2 +1;
            }
            else{
                left = mid1+1;
                right = mid2-1;
            }
        }
        return -1;
    }

    private int jumpSearch(int[] arr,int num){
        sorterHelper(arr);
        int n = arr.length;
        int jump = (int)Math.sqrt(n);
        int i=0;
        int prev = 0;
        while(i<n){
            if(arr[i]==num){
                return i;
            }
            if(arr[i]<num){
                break;
            }
            prev = i;
            i += jump;
        }

        for(int j=prev+1;j<i && j<n; j++){
            if(arr[j] == num){
                return j;
            }
        }

        return -1;
    }

    private int[] prefixSum(int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];

        int sum = 0;

        for(int i=0;i<n;i++){
            sum += arr[i];
            prefix [i] = sum;
        }
        traverse(prefix);
        return prefix;
    }

    private int[] slidingWindow(int[] arr, int k){
        int n = arr.length;
        int[] window = new int[n];
        int sum = 0;

        for(int i=0;i<n;i++){
            sum+= arr[i];
            if(i>=k){
                sum -= arr[i-k];
            }
            window[i] = sum;
        }

        return window;

    }

    //kadane algorithm
    private int maxSubArray(int[] arr){
        int currentSum = arr[0];
        int maxSum = arr[0];

        for(int i=1;i<arr.length;i++){
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    //Dutch national Flag
    private void dutchNationalFlag(int[] arr,int a,int b,int c){
        int low =0;
        int mid =0;
        int high = arr.length-1;

        while(mid<=high){
            if(arr[mid] == a){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if (arr[mid]==b){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }

    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //Moore's Voting
    private int mooreVoting(int[] arr){
        int current = 0;
        int count =0;

        for(int num:arr){
            if(count == 0){
                current = num;
            }
            if(current ==num){
                count++;
            }
            else{
                count--;
            }
        }
        return current;
    }

    private void sorterHelper(int[] arr){
        if(!isSorted(arr)){
            sort(arr);
        }
    }

    private boolean isSorted(int[] arr){
        int prev = Integer.MIN_VALUE;

        for(int x: arr){
            if(prev>x){
                return false;
            }
            prev = x;
        }
        return true;
    }

    private void sort(int[] arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            for(int j = i;j<n;j++){
                if(arr[i]>arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private void mergeIntervals(int[][] arr){

    }

    private void sort(int[][] arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            for(int j = i;j<n;j++){
                if(arr[i][0]>arr[j][0]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private void swap(int[][] arr, int x,int y){
        int[] temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args){
        Arrays ra = new Arrays();
        int n = 10;

        int[] arr = {1,2,4,3};

        // ra.sort(arr);
        // ra.traverse(arr);

        ra.prefixSum(arr);        
    }
}