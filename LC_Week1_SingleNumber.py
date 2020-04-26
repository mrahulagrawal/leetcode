class LC_Week1_SingleNumber:
    """
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    Example 1:
    Input: [2,2,1]
    Output: 1
    Example 2:
    Input: [4,1,2,1,2]
    Output: 4
    """
    def singleNumber1(self, nums: List[int]) -> int:
        no_duplicate_list = []
        for i in nums:
            if i not in no_duplicate_list:
                no_duplicate_list.append(i)
            else:
                no_duplicate_list.remove(i)
        return no_duplicate_list.pop

from collections import defaultdict
    def singleNumber2(self, nums: List[int]) -> int:
        hash_table = defaultdict(int)
        for i in nums:
            hash_table[i] += 1

        for i in hash_table:
            if hash_table[i] == 1:
                return i

    def singleNumber3(self, nums: List[int]) -> int:
        """
        Concept:
        2∗(a+b+c)−(a+a+b+b+c)=c
        """
        return 2 * sum(set(nums)) - sum(nums)

    def singleNumber4(self, nums: List[int]) -> int:
    """
    Concept
        If we take XOR of zero and some bit, it will return that bit
        a⊕0=a
        a⊕0=a
        If we take XOR of two same bits, it will return 0
        a⊕a=0
        a⊕a=0
        a ⊕ b ⊕ a = (a⊕a)⊕b = 0⊕b = ba⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
    """
        a = 0
        for i in nums:
            a ^= i
        return a