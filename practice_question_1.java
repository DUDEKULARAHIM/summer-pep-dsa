import java.util.*;

public class practice_question_1 {

    static void question_1(){
        int[] arr = {45,32,67,21,12};
        int n = arr.length;
        int k = 3;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        System.out.println(arr[k-1]);
    }


    static void question_2(){
         int[] arr = {25,26,54,81,48};
        int k=4;
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int temp = arr[i]/k;
            sum= sum+temp;
        }
        System.out.println(sum);
    }



    static void question_3(){
        String str = "asfddagha";
        int len = str.length();
        Set<Character> seen = new HashSet<>();
        Set<Character> unique = new LinkedHashSet<>();
        for(char ch : str.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                unique.add(ch);
            }else{
                unique.remove(ch);
            }
        }
        for(char i : unique){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(unique.size());
    }



    static void question_4(){
        String str = "alphxxdida";
        int count=0;
        String rev = new StringBuilder(str).reverse().toString();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==rev.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    static void other_approach_of_question_4(){
        String str = "alphxxdida";
        int count=0;
        int n=str.length();
        // String rev = new StringBuilder(str).reverse().toString();
        for(int i=0,j=n-1;i<str.length()/2;i++,j--){
            if(str.charAt(i)==str.charAt(j)){
                count++;
            }
        }
        if(n%2==0){
           count= count *2;
        }else{
            count = count*2+1;
        }
        System.out.println(count);
    }



    static void question_5(){
        char[] arr = {'a','b','c','d','e','f','g','h','i','j'};
        int num = 12403;
        char[] res = new char[5];
        int temp = num;
        int j=4;
        while(temp>0){
            int n = temp%10;
             res[j] = arr[n];
             j--;
             temp = temp/10;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }


    static void question_6(){
        int[] arr = {15,5,3,7,9};
        int n1 = 135;
        int n2 = 90;
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(n1%arr[i]==0 && n2%arr[i]==0){
                count++;
            }
        }
        System.out.println(count);
    }

     static void other_approach_of_question_5(){
        char[] arr = {'a','b','c','d','e','f','g','h','i','j'};
        int num = 12403;
        String res = "";
        int temp = num;
        
        while(temp>0){
            int n = temp%10;
             res = arr[n]+res;
             temp = temp/10;
        }
        System.out.println(res);
    }


    static void question_7(){
        int[] arr = {100,560,23,19,53,20};
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            System.out.println(arr[right]+" "+arr[left]);
            left++;
            right--;
        }

    }

    static void other_approach_of_question_7(){
        int[] arr = {100,560,23,19,53,20};
        Arrays.sort(arr);
        for(int i=0;i<arr.length/2;i++){
            System.out.println(arr[arr.length-i-1]+" "+arr[i]);
        }
    }

    static void question_8(){
        String str = "helloworld";
        String res="";
        for(int i=0;i<str.length()-1;i+=2){
            if(str.charAt(i)<str.charAt(i+1)){
                res =res+str.charAt(i+1);
            }else{
                res = res+str.charAt(i);
            }
        }
         if (str.length() % 2 != 0) {
            res += str.charAt(str.length() - 1);
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        // question_1();
        // question_2();
        // question_3();
        // question_4();
        // other_approach_of_question_4();
        // question_5();
        // other_approach_of_question_5();
        // question_6();
        // question_7();
        // other_approach_of_question_7();
        question_8();
    }
}


// to do question 

// india is my country 100%

// uc = 4.0%
// lc = 62/0%
// digits = 12.0%
// other 20%
