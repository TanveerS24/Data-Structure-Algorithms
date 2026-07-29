package Basics;

import java.util.Scanner;

@SuppressWarnings("unused")
public class ReverseArray{

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
                    int temp = arr[i];
                    arr [i] = arr[j];
                    arr [j] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        ReverseArray ra = new ReverseArray();
        int n = 10;

        int[] arr = {1,2,4,3,5,6,7,8,9,10};

        ra.sort(arr);
        ra.traverse(arr);
        
    }
}