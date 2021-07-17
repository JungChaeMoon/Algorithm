import random
import copy


class Solution:

    def __init__(self, nums: List[int]):
        self.init_list = copy.deepcopy(nums)
        self.num_list = copy.deepcopy(nums)
        

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        self.num_list = copy.deepcopy(self.init_list)
        return self.num_list
        

    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        random.shuffle(self.num_list)
        return self.num_list
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
