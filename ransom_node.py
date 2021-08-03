from collections import Counter


def check_magazine(magazine, note):
    dict_of_magazine = dict(Counter(magazine.split()))
    for char in note.split():
        if char not in dict_of_magazine:
            return 'No'
    return 'Yes'


print(check_magazine('give me one grand today night',
'give one grand today'))