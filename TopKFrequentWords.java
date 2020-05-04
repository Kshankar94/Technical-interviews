class Solution {
    public List<String> topKFrequent(String[] words, int k) {
     
        List<String> list = new ArrayList<String>();
        
        if(words.length == 0) return list;
        
        //1st hashmap to know the word frequencies.
        //2nd hashmap to group the frequencies.
        //then, print the words according to k.
        
        Map<String, Integer> map1 = new HashMap<>();
        
        TreeMap<Integer, PriorityQueue<String>> map2 = new TreeMap<>(Collections.reverseOrder());
        
        //counts words and their counts
        for(String word: words){
            map1.put(word, map1.getOrDefault(word,0)+1);
        }
        
       
        //groups the words according to the counts. For eg, 2:[i, love]
        for(Map.Entry<String, Integer> entry: map1.entrySet()){
            Integer key = entry.getValue();
            if(map2.containsKey(key)){
                map2.get(key).add(entry.getKey());
            }
            else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(entry.getKey());
                map2.put(key, pq);
            }
        }
        
        //removes all the words from priority queue and adds to the list result 
        for(Map.Entry<Integer, PriorityQueue<String>> entry: map2.entrySet()){
            PriorityQueue<String> freq = entry.getValue();
            while(!freq.isEmpty() && k-- > 0){
                list.add(freq.poll());
            }
            if(k <= 0) break;
            
        }
        
        
       return list;
    }
}