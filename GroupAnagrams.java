/*
 * Given an array of strings, group anagrams together.
Example: Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
Note: All inputs will be in lowercase. The order of your output does not matter.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
    
import java.math.BigInteger;
class Solution {

int[] primeNumber = new int[26];
        private boolean isPrime(int key){
        int count =0;
        for(int i=2; i<=key/2; i++){
            if(key % i == 0){
                count++;
            }
        }
        if(count == 0)
            return true;
        return false;
    }

    private BigInteger calculatePrimeProduct(char[] myChar){
        BigInteger product = BigInteger.ONE;
        for(char c: myChar){
            BigInteger charPrimeValue = BigInteger.valueOf(primeNumber[c -'a']);
            product = product * charPrimeValue;
        }
        return product; 
    }

    public List<List<String>> groupAnagrams(String[] strs) {
    
        int index = 0;
        for(int i=2; i<=100; i++){
        if(isPrime(i)){
            System.out.println(i);
            primeNumber[index] = i;
            index++;
        }
    }
    Map<BigInteger, List<String>> myMap = new HashMap<>();
    for(String str: strs){
        char[] myCharArray = str.toCharArray();
        BigInteger primeNum = calculatePrimeProduct(myCharArray);
        if(!myMap.containsKey(primeNum)){
            myMap.put(primeNum, new ArrayList<>(Arrays.asList(str)));
        }
        else
        {
            myMap.get(primeNum).add(str);
        }
    }
    return new ArrayList(myMap.values());
}

    //     Map<String, List<String>> myMap = new HashMap<>();
    //     for(String str: strs){
    //         char[] charStr = str.toCharArray();
    //         Arrays.sort(charStr);
    //         String newStr = new String(charStr);
    //         if(!myMap.containsKey(newStr)){
    //             myMap.put(newStr, new ArrayList<>(Arrays.asList(str)));
    //         }
    //         else{
    //             myMap.get(newStr).add(str);
    //         }
    //     }
    //     return new ArrayList<>(myMap.values());
    // }
}


