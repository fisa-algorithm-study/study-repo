import sys
from collections import Counter

class Word:
    def __init__(self, w, freq):
        self.w = w
        self.freq = freq
        self.length = len(w)

    def __lt__(self, other):
        if self.freq != other.freq:
            return self.freq > other.freq
        if self.length != other.length:
            return self.length > other.length
        return self.w < other.w

sys.stdin = open("input2.txt", "r")

total, limit = map(int, input().strip().split())

filtered = [w for _ in range(total) for w in input().strip().split() if len(w) >= limit]
counter = Counter(filtered)

word_objects = [Word(w, f) for w, f in counter.items()]
for word in sorted(word_objects):
    print(word.w)