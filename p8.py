class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        insert_index = 1
        
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[insert_index] = nums[i]
                insert_index += 1
        return insert_index
