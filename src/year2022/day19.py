#!/usr/bin/python3
from collections import deque

infile = "./inputs/day19.in"
data = open(infile).read().strip()
lines = [x for x in data.split("\n")]


def solve(co, cc, co1, co2, cg1, cg2, t):
    best = 0
    state = (0, 0, 0, 0, 1, 0, 0, 0, t)
    q = deque([state])
    seen = set()
    while q:
        state = q.popleft()
        o, c, ob, g, r1, r2, r3, r4, t = state

        best = max(best, g)
        if t == 0:
            continue

        core = max([co, cc, co1, cg1])
        if r1 >= core:
            r1 = core
        if r2 >= co2:
            r2 = co2
        if r3 >= cg2:
            r3 = cg2
        if o >= t * core - r1 * (t - 1):
            o = t * core - r1 * (t - 1)
        if c >= t * co2 - r2 * (t - 1):
            c = t * co2 - r2 * (t - 1)
        if ob >= t * cg2 - r3 * (t - 1):
            ob = t * cg2 - r3 * (t - 1)

        state = (o, c, ob, g, r1, r2, r3, r4, t)

        if state in seen:
            continue
        seen.add(state)

        assert o >= 0 and c >= 0 and ob >= 0 and g >= 0, state
        q.append((o + r1, c + r2, ob + r3, g + r4, r1, r2, r3, r4, t - 1))
        if o >= co:  # buy ore
            q.append((o - co + r1, c + r2, ob + r3, g + r4, r1 + 1, r2, r3, r4, t - 1))
        if o >= cc:
            q.append((o - cc + r1, c + r2, ob + r3, g + r4, r1, r2 + 1, r3, r4, t - 1))
        if o >= co1 and c >= co2:
            q.append(
                (o - co1 + r1, c - co2 + r2, ob + r3, g + r4, r1, r2, r3 + 1, r4, t - 1)
            )
        if o >= cg1 and ob >= cg2:
            q.append(
                (o - cg1 + r1, c + r2, ob - cg2 + r3, g + r4, r1, r2, r3, r4 + 1, t - 1)
            )
    return best


p1 = 0
p2 = 1
for i, line in enumerate(lines):
    words = line.split()
    id_ = int(words[1][:-1])
    ore_cost = int(words[6])
    clay_cost = int(words[12])
    obsidian_cost_ore, obsidian_cost_clay = int(words[18]), int(words[21])
    geode_cost_ore, geode_cost_clay = int(words[27]), int(words[30])
    s1 = solve(
        ore_cost,
        clay_cost,
        obsidian_cost_ore,
        obsidian_cost_clay,
        geode_cost_ore,
        geode_cost_clay,
        24,
    )
    p1 += id_ * s1
    if i < 3:
        s2 = solve(
            ore_cost,
            clay_cost,
            obsidian_cost_ore,
            obsidian_cost_clay,
            geode_cost_ore,
            geode_cost_clay,
            32,
        )
        p2 *= s2

print("Part 1: %d" % p1)
print("Part 2: %d" % p2)
