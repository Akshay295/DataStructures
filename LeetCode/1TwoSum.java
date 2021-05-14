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