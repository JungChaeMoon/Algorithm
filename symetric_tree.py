from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        queue = deque([])
        if root is None:
            return True
        queue.append(root)
        while queue:
            check_list = []
            for _ in range(len(queue)):
                node = queue.popleft()
                if node is None:
                    continue

                check_list.append(node.left)
                queue.append(node.left)
                check_list.append(node.right)
                queue.append(node.right)

            size = len(check_list) // 2
            for node1, node2 in zip(check_list[:size], reversed(check_list[size:])):
                if node1 is None and node2 is None:
                    continue
                else:
                    if node1 is None or node2 is None:
                        return False
                    else:
                        if node1.val != node2.val:
                            return False
        return True