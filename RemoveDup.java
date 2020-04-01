
public class RemoveDup {

	public static void main(String args[])
	{
		int count = 0;
		int[] nums = {1,1,2};
		if(nums!=null)
		{
			count = 1;
		}
		for(int i=0;i<nums.length;i++)
		{
			for(int j=1;j<nums.length;j++)
			{
				if(nums[i]!=nums[j])
				{
					count++;
					i = j;
				}
			}
			
		}
		System.out.println(count);
	}
}
