
// Problem 5: Search all permutation pf pattern in string (Count occuerences of anangram)

public class problems18072025 {
    public static void main(String[] args) {
        
String str= BACDGABCDA
pat = ABCD
OUTPUT=3 (0 5 6)

//Insert pattern in map
for(int i<n; i++){
char c= pat.charAt(i);
freqpat.put(c, freqpat.getOrDefault(c,0)+1);
}

//Inserting string in map and solution. 
for(int i=0; i<n; i++){
char c=str.charAt(i);
freqstr.put(c, freqsstr.getOrDefault(c, 0)+1);
if(i>=m){
char removedChar = str.charAt(i-m);
if(freqstr.get(removedchar==1))
freqstr.remove(removedchar);
else
freqstr.put(removedchar, freqstr.get(removedchar)-1);
}
if(i>=m-1 && freqstr.equals(freqpat))
count++;
}

    }
}








// problem 4: Length of longest substring without repeating characters 

// String=ABCDEFABIHJKLABCD
// Output=11
