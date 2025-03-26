/**
 * ## Problem 2:
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
Using HashMaps
Using HashSet
 */

 class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<Character, Character>();
         Set<Character> mySet = new HashSet<>();
         for(int i=0; i< s.length(); i++){
            if(sMap.containsKey(s.charAt(i))){
                if(sMap.get(s.charAt(i)) != t.charAt(i))
                    return false;   
            }
            else if(mySet.contains(t.charAt(i))){
                    return false;
            }
            sMap.put(s.charAt(i), t.charAt(i));
            mySet.add(t.charAt(i));
         }
        return true;
    }
}

/*
 * 
 *  Map<Character, Character> tMap = new HashMap<Character, Character>();

        for(int i=0; i< s.length(); i++){
         if(!sMap.containsKey(s.charAt(i))){
                 sMap.put(s.charAt(i), t.charAt(i));
            }
             else if(sMap.get(s.charAt(i)) != t.charAt(i))
                 return false;

             if(!tMap.containsKey(t.charAt(i))){
                 tMap.put(t.charAt(i), s.charAt(i));
             }
             else if(tMap.get(t.charAt(i)) != s.charAt(i))
                 return false;
         }
         return true;
     }
 */