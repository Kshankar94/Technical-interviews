class Solution {
    
    private class Valid{
        Integer index;
        char c;
        public Valid(int index, char c){
            this.index = index;
            this.c = c;
        }
    }
    
    public String minRemoveToMakeValid(String s) {
       if(s.length() == 0) return s;
        
      //Define map to check the characters(,).
        Map<Character, Character> paranMap = new HashMap<>();
        
        char leftP = '(', rightP = ')';
        
        paranMap.put('(', ')');
      //set to remove and add objects
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
      //stack to check the validity
        Deque<Valid> stack = new ArrayDeque<>();
      
        //stack accepts left open brackets and looks for the closing pair. 
        //treeSet adds indexes of ')' to help deletion 
        for(int i = 0; i<s.length(); i++){
             if(paranMap.containsKey(s.charAt(i))){
                Valid valid = new Valid(i, s.charAt(i));
                stack.addFirst(valid);
            }
            else if((paranMap.get(leftP)).equals(s.charAt(i))){
                if(stack.isEmpty()) {treeSet.add(i);}
                else{
                    Valid va = stack.removeFirst();
                }
            }
        }
      
    
        //unmatched '(' characters are also added to the treeSet for deletion
        while(!stack.isEmpty()){
            treeSet.add(stack.removeFirst().index);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(!treeSet.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}