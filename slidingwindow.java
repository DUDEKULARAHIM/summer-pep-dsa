import java.net.SocketPermission;

public class slidingwindow {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        int weight = 3;
        // for(int i=0;i<n;i++){
        //     for(int j =i;j<n;j++){
        //         for(int k=i;k<=j;k++){
        //             System.out.print(arr[k]);
        //         }
        //          System.out.println();
        //     } 
        // }

        int sum=0;
        for(int i=0;i<n;i++){
            int len=0;
            for(int j=i;j<n;j++){
                len++;
                if(len==weight){
                    int min=Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    for(int k=i;k<=j;k++){
                        if(min>arr[k]){
                            min=arr[k];
                        }
                        if(max<arr[k]){
                            max=arr[k];
                        }
                    }
                    sum= sum+min+max;
                     
                }
               
            }  
            
             
        }
        System.out.println(sum);
        
    }
}


main(){
    //knive approach
}
dist(int[],int n,int w){
    for(int i=0;i<n;i++){
        System.out.println(countdistinct(Arrays.copyOfRange(arr,i,n)),w);
    }
}

countdistint(int[] arr,int w){
    int c=0;


}

1,2,1,3,4,2,3
w=4
output 3 4 4 3



