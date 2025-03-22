class Pattern {
    public boolean wordPattern(String pattern, String s) {
        String [] sSplit = s.split(" ");
        if(pattern.length() != sSplit.length)
            return false;
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        for(int i=0; i< pattern.length(); i++){
            if(!patternMap.containsKey(pattern.charAt(i))){
                patternMap.put(pattern.charAt(i), sSplit[i]);
            }
            else if(!(patternMap.get(pattern.charAt(i)).equals(sSplit[i])))
                return false;

            if(!sMap.containsKey(sSplit[i])){
                sMap.put(sSplit[i], pattern.charAt(i));
            }
            else if(sMap.get(sSplit[i]) != pattern.charAt(i))
                return false;
        }
    return true;
    }
}