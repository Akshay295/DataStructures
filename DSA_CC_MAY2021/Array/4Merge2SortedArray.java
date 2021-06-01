/*
Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
*/


class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int m, int n) 
    {
		long last=0;
		
		for(int i=n-1;i>=0;i--) {
			
			int j=0;
			last=arr1[m-1];
			for(j=m-2;j>=0 && arr1[j]>arr2[i] ;j--) {
				arr1[j+1]=arr1[j];
			}
			
			if(j!=m-2 || last>arr2[i]) {
				arr1[j+1]=arr2[i];
				arr2[i]=last;
			}
			
		}
    }
    
   
}
