class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        /*
        
        */
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        
        int index1 = 0, index2 = 0;
        
        List<Integer> result = new ArrayList<Integer>();
        
        
        while(index1 < nums1.length && index2 < nums2.length){
            
            
            if((index1 == 0 || nums1[index1] != nums1[index1 - 1]) && nums1[index1] == nums2[index2]){
                result.add(nums1[index1]);
                index1++;
                index2++; 
            }
            
           else if(nums1[index1] < nums2[index2]){
                index1++;
            }
            else{
                index2++;
            }
            
        }
        
        
        //copying list to array format 
        int[] intersections = new int[result.size()];
        int count = 0; 
        for(int i = 0; i < result.size(); i++){
            intersections[count++] = result.get(i);
        }
        return intersections;
    }
}