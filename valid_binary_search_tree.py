from collections import deque
import math


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        queue = deque([])
        queue.append((root, -math.inf, math.inf))

        while queue:
            node, lower, upper = queue.popleft()
            if node is None:
                continue

            val = node.val
            if lower >= node.val or node.val >= upper:
                return False

            queue.append((node.left, lower, val))
            queue.append((node.right, val, upper))
        return True




