
// Algorithm :
// Calculate the ratio (profit/weight) for each product

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class greedy_algorithm {
    static double knapsack(int profit[], int weight[], int sack){
        double res=0;
        TreeMap<Double, List<Integer>> tm = new TreeMap<>();
        for(int i=0;i<profit.length;i++){
            List<Integer>list = new ArrayList<>();
            list.add(profit[i]);
            list.add(weight[i]);
            double temp = profit[i]/weight[i];
            tm.put(temp,list);
        }

        for(Map<Double , List<Integer>> entry : tm.entrySet()){
            if(entry.getValue().get(1)<sack){
                res+=(entry.getValue().get(0));
                sack-+(entry.getValue().get(1));
            }
        }

    }
    public static void main(String[] args) {
        int sack = 20;
        int[] weight = {17,13,8};
        int[] profit = {120,100,60};
        int res  = knapsack(profit,weight,sack);
        System.out.println(res);

    }
}




