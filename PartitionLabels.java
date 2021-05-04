// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a Hashmap to keep track of the last occurence of a character, then iterate through the string to find out the max length at each point, which checking if current index is equal to the max index.

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> partitions = new ArrayList<>();
        if(S == null || S.length() == 0) return partitions;
            
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i) , i );
        }
        
        int max = 0;
        
        int low = 0;
        
        for(int i = 0; i < S.length(); i++){
            
            max = Math.max(max, map.get(S.charAt(i)) );
            if(i == max){
                partitions.add(i - low + 1);
                low = i + 1;
                max = 0;
            }
        }
        
        return partitions;
    }
}
