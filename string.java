// public class string {
//     public static void main(String[] args) {
//         String name = "hello student this is java class";
//         // String temp = name;
//         String res ="";

//         for(int i=name.length()-1;i>=0;i--){
//             res+=name.charAt(i);
//         }
//         System.out.println(res);

//     }
// }




// public class string{
//     public static void main(String[] args) {
//         String name = "hello student this is java class";

//         String[] words = name.split(" ");
//         String res ="";
//         for(int i=0;i<words.length;i++){
//             String word = words[i];
//             String revword = "";
//             for(int j=word.length()-1;j>=0;j--){
//                 revword+=word.charAt(j);
//             }
//             res+=revword;
//             if(i<words.length-1){
//                 res+=" ";
//             }
//         }
//         System.out.println(res);
//     }
    
// }



// public class string{
//     public static void main(String[] args) {
//         String name = "hello student this is java class";
//         String[] words = name.split(" ");
//         for(int i=0;i<words.length;i++){
//             String word = words[i];
//             String upper = "";
//             String lower ="";
//             for(int j=0;j<word.length();j++){
//                 if(word.charAt(j).lower()){
//                     upper=upper+j-32;
//                 }else{
//                     lower = lower+j+32
//                 }
//             }
//         }  
//     }
// }




// public class string{
//     public static void main(String[] args) {
//         String name = "Hello stuDent this IS java class";
//         String[] words = name.split(" ");
//         String toggle="";
//         for(int i=0;i<name.length();i++){
//             if(name.charAt(i)>='a' && name.charAt(i)<='z'){
//                 toggle+=(char)(name.charAt(i)-32);
//             }else if(name.charAt(i)>='A' && name.charAt(i)<='Z'){
//                 toggle+=(char)(name.charAt(i)+32);
//             }else{
//                 toggle+=name.charAt(i);
//             }
//         }
//         System.out.println(toggle);
//     }
// }



// public class string{
//     public static void main(String[] args) {
//         String name = "madam";
//         int start = 0;
//         int end = name.length()-1;
//         boolean flag = false;
        
//         while(start<end){
//             if(name.charAt(start)!=name.charAt(end))
//             {
//                 flag = false;
//                 break;
//             }
//             start++;
//             end--;
//             flag = true;
            
//         }
//         if(flag == true){
//             System.out.println("Polindrome");
//         }else{
//             System.out.println("Not ploindrome");
//         }
//     }
// }





// public class string{
//     public static void main(String[] args) {
//         // int a=2,b=10;
//         for(int i=2;i<10;i++){
//             for(int j=1;j<=10;j++){
//                 System.out.println(i*j);
//             }
//             System.out.println();
//         }
//     }
// }



// public class string{
//     public static void main(String[] args) {
//         // int a=2,b=10;
        
//             for(int j=1;j<=10;j++){
//                 for(int i=2;i<10;i++){
//                 System.out.print(i*j+"\t");
//             }
//             System.out.println();
//         }
//     }
// }


import java.util.*;

public class string{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(a);
    }
}