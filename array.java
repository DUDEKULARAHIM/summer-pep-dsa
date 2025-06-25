// public class array {
//     public static void main(String[] args) {
//         int[] arr = {1,2,3,4,5};
//         int[] temp = new int[arr.length-1];
//         int a = 2;
//         int j=0;
//         for(int i=0;i<arr.length;i++){
//             if(i!=a){
//                 temp[j]=arr[i];
//                 j++;
//             }
//         }
//         for(int i=0;i<arr.length;i++){
//             System.out.print(arr[i]);
//         }
//         System.out.println();
//         for(int i=0;i<arr.length;i++){
//             System.out.print(temp[i]);
//         }
//         System.out.println();
//     }
// }




import java.util.*;
public class array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]= sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                
                System.out.print(arr[i][j]+" ");
                sum= sum+arr[i][j];
            }
            System.out.println("\t"+sum);
        }

        
    }
}