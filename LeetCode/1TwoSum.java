/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
       Map<Integer,Integer> tempMap=new HashMap<>();
		
		int[] result=new int[2];
		for(int i=0;i<nums.length;i++) {
			int diff=target-nums[i];
			if(null!=tempMap.get(diff))
			{
				result[0]=tempMap.get(diff);
				result[1]=i;
				return result;
			}
			tempMap.put(nums[i], i);
		}
        return result;
    }
}