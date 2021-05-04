// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes :
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];  
        });
        
        List<int []> result = new ArrayList<>();
        
        for(int i = 0; i < people.length; i++){
            result.add(people[i][1], people[i]);
        }
        
        int[][] matrix = new int[result.size()][];
        matrix = result.toArray(matrix);
        
        return matrix;
    }
}
