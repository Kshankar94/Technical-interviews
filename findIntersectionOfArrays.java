class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        /*
        
        */
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));
        
        int n1p = 0, n2p = 0;
        
        List<Integer> result = new ArrayList<Integer>();
        
        
        while(n1p < nums1.length && n2p < nums2.length){
            
            
            if((n1p == 0 || nums1[n1p] != nums1[n1p - 1]) && nums1[n1p] == nums2[n2p]){
                result.add(nums1[n1p]);
                n1p++;
                n2p++; 
            }
            
           else if(nums1[n1p] < nums2[n2p]){
                n1p++;
            }
            else{
                n2p++;
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