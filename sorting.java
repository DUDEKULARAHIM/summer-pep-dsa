
import java.util.*;

// public class sorting {

//     public int[] bubblesort(int[] arr){
//         int i,j,temp=0;
//         int n = arr.length;
//         for(i=0;i<n-1;i++){
//             for(j=0;j<n-i-1;j++){
//                 if(arr[j]>arr[j+1]){
//                     temp = arr[j];
//                     arr[j]= arr[j+1];
//                     arr[j+1]= temp;
//                 }
//             }
//         }
//         return arr;
//     }


//     public int[] selectionsort(int[] arr){
//         int i,j,small;
//         int n= arr.length;
//         for(i=0;i<n-1;i++){
//             small =i;
//             for(j=i+1;j<n;j++){
//                 if(arr[j]<arr[small]){
//                     small = j;
//                 }
//             }
//             int temp = arr[small];
//             arr[small]= arr[i];
//             arr[i] =  temp;

//         }
//         return arr;
//     }


//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] arr = {1,3,5,2,7};
//         System.out.print("Original array : ");
//         for(int i=0;i<arr.length;i++){
//             System.out.print(arr[i]);
//         }
//         System.out.println();
//         sorting obj = new sorting();
//         int[] result1 = obj.bubblesort(arr);
//         System.out.print("bubble sort: ");
//         for(int i=0;i<result1.length;i++){
//             System.out.print(result1[i]);
//         }
//         System.out.println();
//         int[] result2 = obj.selectionsort(arr);
//         System.out.print("Selection sort : ");
//         for(int i=0;i<result2.length;i++){
//             System.out.print(result2[i]);
//         }
//     }
// }





// public class sorting{

    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n= sc.nextInt();
//         char[] name = new char[n];
//         for(int i=0;i<n;i++){
//             name[i] = sc.next().charAt(0);
//         }

//         for (char c : name) {
//             System.out.print(c + " ");
//         }
//         System.out.println();

//         for(int i=0;i<name.length-1;i++){
//             for(int j=0;j<name.length-i-1;j++){
//                 if(name[j]>name[j+1]){
//                     char temp = name[j];
//                     name[j]= name[j+1];
//                     name[j+1]= temp;
//                 }
//             }
//         }
//         for (char c : name) {
//             System.out.print(c + " ");
//         }
//     }
// }


public class sorting{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] arr = new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                arr[i][j]= sc.nextInt();
            }
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                for(int k=j+1;k<b;k++){
                    if(arr[i][j]>arr[i][k]){
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][k];
                        arr[i][k]= temp;
                    }
                }
            }
        }

        System.out.println();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
       
// wrong code for row sort 
// upto above code is correct
        for(int j=0;j<b;j++){
            for(int i=0;i<a;i++){
                for(int k=i+1;k<a;k++){
                    if(arr[i][j]>arr[k][j]){
                        int temp = arr[i][j];
                        arr[i][j] = arr[k][j];
                        arr[k][j]= temp;
                    }
                }
            }
        }

        System.out.println();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }
}