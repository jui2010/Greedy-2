// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Refer the testcase
// Testcase : [A, B, C, D, A, B, V], n = 3 
// Hashmap : { A : 2, B : 2, C : 1, D : 1, V : 1} , 
// maxCount : 2,
// potential slots = maxCount * (n+1) = 2 * (3+1) = 8
// actual slots = number of tasks = 7
// Since actual slots < potential slots
// count (number of tasks in hashmap having frequency == maxCount) = 2 , since A, B have frequency = 2
// hence return MAX(potential slots - n - (count - 1) , actual slots) ie MAX(8 - 3 - (2 - 1) , 7) ie MAX(6, 7) = 7 ie & slots are required

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxCount = 0;
        int actual = tasks.length;
        for(int i = 0; i < actual; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxCount = Math.max(maxCount, map.get(tasks[i]));
        }
        
        int potential = maxCount * (n+1);
        
        if(potential <= actual){
            return actual;
        } else {
            int count = -1; 
            for(Map.Entry element : map.entrySet() ){
                int value = (int)element.getValue();
                if(value == maxCount){
                    count++;
                }
            }
            return Math.max( potential - (n - count), actual) ;
        }
    }
}
