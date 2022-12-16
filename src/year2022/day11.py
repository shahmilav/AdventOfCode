from math import prod


class Monkey:
    def __init__(self, x):
        x = x.split("\n")
        self.items = [*map(int, x[1][18:].split(","))]
        self.op = eval(f"lambda old: {x[2][19:]}")
        self.div = int(x[3][20:])
        self.true = int(x[4][28:])
        self.false = int(x[5][29:])
        self.act = 0


ms = [*map(Monkey, open("inputs/day11.in").read().split("\n\n"))]
p = prod(m.div for m in ms)

for _ in range(10000):
    for m in ms:
        for worry in m.items:
            worry = m.op(worry) % p
            dest = m.false if worry % m.div else m.true
            ms[dest].items.append(worry)
            m.act += 1
        m.items = []

print(prod(sorted(m.act for m in ms)[-2:]))
