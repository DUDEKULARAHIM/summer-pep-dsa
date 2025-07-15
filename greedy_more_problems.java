
import java.util.*;

public class greedy_more_problems {
    static void demonamount(int[] demo,int amount){
        int n = demo.length;
        Arrays.sort(demo);

        for(int i=n-1;i>=0;i--){
            if(demo[i]<=amount){
                int count = amount/demo[i];
                amount = amount%demo[i];
                System.out.println(count);
            }
        //     if (amount==0){
        //         break;
        //     }
         }

        //  Second method 
        //  LinkedHashMap<Integer,Integer> al = new LinkedHashMap<>();
        //     for(int i=n-1;i>=0;i--){
        //     if(demo[i]<=amount){
        //         int count = amount/demo[i];
        //         amount = amount%demo[i];
        //         al.put(demo[i],count);
        //     }
        // //     if (amount==0){
        // //         break;
        // //     }
        //  }
        //  for(Map.entry<Integer,Integer> x : al.entrySet()){
        //     System.out.println(x.getKey()+" "+x.getValue());
        //  }

    }
    public static void main(String[] args) {
        int[] demo = {1,2,10,20,50,100,200,500,2000};
        int amount = 93;
        demonamount(demo, amount);
        // int res = demonamount(demo,amount);
    }
}
