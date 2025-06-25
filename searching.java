
import java.util.*;

public class searching {

    public int linearsearch(int[] arr,int a){
        int pos =-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==a){
                pos = i;
                break;
            }

        }
        return pos;
        
    }


    public int binarysearch(int[] arr, int beg,int end,int a){

        // int pos =-1;
        while(beg<=end){
            int mid = (beg+end)/2;
            if(arr[mid]==a){
                return mid;
                
            }else if(arr[mid]>a){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int a = sc.nextInt();
        searching obj = new searching();

        int res = obj.linearsearch(arr,a);

        if(res==-1){
            System.out.println("not found");
        }else{
            System.out.println("found "+res);
        }


        
        int len= arr.length-1;
        int result = obj.binarysearch(arr,0, len, a);
        if(result ==-1){
            System.out.println("not found");
        }else{
            System.out.println("found "+ result);
        }

    }
}



// binary search in recersive method
// public class searching{
//     public static void main(String[] args){
//         int binarysearch(int arr[], int x , int beg,int end){
//             if(end>=beg){
//                 int mid = beg+(end-beg)/2;
//             }
//             if(arr[mid]==x){
//                 return mid;
//             }
//             if(arr[mid]>x){
//                 return binarysearch(arr,x,beg,mid-1);
//             }
//             if(arr[mid]<x){
//                 return binarysearch(arr,x,mid+1,end);
//             }
//             return -1;
//         }
//     }
// }