// // Abstract class
// abstract class Animal {
//     // Abstract method (no body)
//     abstract void makeSound();

//     // Regular method
//     void sleep() {
//         System.out.println("Sleeping...");
//     }
// }

// // Subclass inherits from Animal
// class Dog extends Animal {
//     // Implementing the abstract method
//     void makeSound() {
//         System.out.println("Bark");
//     }
// }

// public class first {
//     public static void main(String[] args) {
//         // Animal a = new Animal(); // ❌ Error: cannot instantiate abstract class
//         Dog d = new Dog();
//         d.makeSound();  // Output: Bark
//         d.sleep();      // Output: Sleeping...
//     }
// }




import java.util.*;
// public class first{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int a= sc.nextInt();
//         int b = sc.nextInt();
//         int c = sc.nextInt();
//         switch(c){
//             case 1:
//             System.out.println(a+b);
//             break;
//             case 2:
//             System.out.println(a-b);
//             break;
//             case 3:
//             System.out.println(a*b);
//             break;
//             case 4:
//             System.out.println(a/b);
//             break;
//             default:
//             System.out.println("Invalid");
//         }
//     }
// }


// class arithematic{
//     private double num1;
//     private double num2;

//     public arithematic(double num1,double num2){
//         this.num1=num1;
//         this.num2=num2;
//     }
//     public double add(){
//         return num1+num2;  
//     }
//     public double sub(){
//         return num1-num2;  
//     }
//     public double mul(){
//         return num1*num2;  
//     }
//     public double div(){
//         return num1/num2;  
//     }

// }

// public class first{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         double a = sc.nextInt();
//         double b = sc.nextInt();

//         arithematic op = new arithematic(a, b);
//         System.out.println(op.add());
//         System.out.println(op.sub());
//         System.out.println(op.mul());
//         System.out.println(op.div());
//     }
// }



// wap to take the input upto user enter value as nams and print it 

public class first{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        sc.nextLine();
        int j=0;
        String [] arr = new String[a];
        for(int i=0;i<a;i++){
            String name = sc.nextLine();
            arr[j] = name;
            j++;
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}