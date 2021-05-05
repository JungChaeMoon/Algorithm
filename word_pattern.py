class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        if len(set(list(pattern))) != len(set(s.split())):
            return False
        if len(list(pattern)) != len(s.split()):
            return False
        pattern_dic = {}
        for p, a in zip(list(pattern), s.split()):
            if p not in pattern_dic:
                pattern_dic[p] = a
            else:
                if pattern_dic[p] != a:
                    return False
        return True


