class TreeNode:
    def __init__(self, val=0, left=None, right=None
                 ):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        length = len(nums) // 2
        root = TreeNode(nums[length])

        def insert(num, root):
            if root.val < num:
                if root.right is None:
                    root.right = TreeNode(num)
                else:
                    insert(num, root.right)
            elif root.val > num:
                if root.left is None:
                    root.left = TreeNode(num)
                else:
                    insert(num, root.left)

        for num in nums[:length]:
            insert(num, root)
        for num in nums[length + 1:]:
            insert(num, root)
        return root


import sys

sys.setrecursionlimit(150000)


class TreeNode:
    def __init__(self, val=0, left=None, right=None
                 ):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums:
            return None

        mid = len(nums) // 2

        node = TreeNode(nums[mid])
        node.left = self.sortedArrayToBST(nums[:mid])
        node.right = self.sortedArrayToBST(nums[mid + 1:])

        return node
