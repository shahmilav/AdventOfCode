package year2022;

import helpers.AoCSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day19 extends AoCSolver {
    static HashMap<State, Integer> cache = new HashMap<>();

    public Day19(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) throws IOException {
        new Day19(2022, "19");
    }

    private static int findRecursive(Blueprint bp, State state) {
        if (state.minutes == 1) {
            return state.geode + state.geodeBots;
        }
        Integer cand = cache.get(state);
        if (cand != null) {
            return cand;
        }
        int best = 0;
        if (state.ore >= bp.geodeOre && state.obs >= bp.geodeObs) {
            best = Math.max(best, findRecursive(bp, state.buildGeodeBot(bp)));
        } else {
            boolean all = true;
            if (state.ore >= bp.oreOre) {
                best = Math.max(best, findRecursive(bp, state.buildOreBot(bp)));
            } else {
                all = false;
            }
            if (state.ore >= bp.clayOre) {
                best = Math.max(best, findRecursive(bp, state.buildClayBot(bp)));
            } else {
                all = false;
            }
            if (state.ore >= bp.obsOre && state.clay >= bp.obsClay) {
                best = Math.max(best, findRecursive(bp, state.buildObsidianBot(bp)));
            } else {
                all = false;
            }
            if (!all) {
                best = Math.max(best, findRecursive(bp, state.doNothing()));
            }
        }
        cache.put(state, best);
        return best;
    }

    private static int findBfs(Blueprint bp, State in) {
        LinkedList<State> queue = new LinkedList<>();
        queue.add(in);
        int best = 0;
        while (!queue.isEmpty()) {
            State state = queue.removeFirst();
            if (state.minutes == 0) {
                best = Math.max(best, state.geode);
            } else {
                queue.add(state.doNothing());
                if (state.ore >= bp.oreOre) {
                    queue.add(state.buildOreBot(bp));
                }
                if (state.ore >= bp.clayOre) {
                    queue.add(state.buildClayBot(bp));
                }
                if (state.ore >= bp.obsOre && state.clay >= bp.obsClay) {
                    queue.add(state.buildObsidianBot(bp));
                }
                if (state.ore >= bp.geodeOre && state.obs >= bp.geodeObs) {
                    queue.add(state.buildGeodeBot(bp));
                }
            }
        }
        return best;
    }

    @Override
    public void solvePartOne(List<String> input) {
        List<Blueprint> blueprints = createBlueprints(input);
        int total = 0;
        for (Blueprint bp : blueprints) {
            cache.clear();
            int max = findRecursive(bp, new State(24, 1, 0, 0, 0, 0, 0, 0, 0));
            total += max * bp.id;
        }
        lap(total);
    }

    @Override
    public void solvePartTwo(List<String> input) {

        List<Blueprint> blueprints = createBlueprints(input);
        cache.clear();
        int g1 = findRecursive(blueprints.get(0), new State(32, 1, 0, 0, 0, 0, 0, 0, 0));
        cache.clear();
        int g2 = findRecursive(blueprints.get(1), new State(32, 1, 0, 0, 0, 0, 0, 0, 0));
        int g3 = findRecursive(blueprints.get(2), new State(32, 1, 0, 0, 0, 0, 0, 0, 0));
        lap(g1 * g2 * g3);
    }

    private List<Blueprint> createBlueprints(List<String> input) {
        Pattern pat = Pattern.compile("Blueprint (\\d+): Each ore robot costs (\\d+) ore. Each clay robot costs (\\d+) ore. Each obsidian robot costs (\\d+) ore and (\\d+) clay. Each geode robot costs (\\d+) ore and (\\d+) obsidian.");
        List<Blueprint> blueprints = new ArrayList<>();
        for (String s : input) {
            Matcher m = pat.matcher(s);
            m.find();
            blueprints.add(new Blueprint(m));
        }
        return blueprints;
    }

    record State(int minutes, int oreBots, int clayBots, int obsBots, int geodeBots, int ore, int clay, int obs,
                 int geode) {
        public State doNothing() {
            return new State(minutes - 1, oreBots, clayBots, obsBots, geodeBots, ore + oreBots, clay + clayBots, obs + obsBots, geode + geodeBots);
        }

        public State buildOreBot(Blueprint bp) {
            return new State(minutes - 1, oreBots + 1, clayBots, obsBots, geodeBots, ore + oreBots - bp.oreOre, clay + clayBots, obs + obsBots, geode + geodeBots);
        }

        public State buildClayBot(Blueprint bp) {
            return new State(minutes - 1, oreBots, clayBots + 1, obsBots, geodeBots, ore + oreBots - bp.clayOre, clay + clayBots, obs + obsBots, geode + geodeBots);
        }

        public State buildObsidianBot(Blueprint bp) {
            return new State(minutes - 1, oreBots, clayBots, obsBots + 1, geodeBots, ore + oreBots - bp.obsOre, clay + clayBots - bp.obsClay, obs + obsBots, geode + geodeBots);
        }

        public State buildGeodeBot(Blueprint bp) {
            return new State(minutes - 1, oreBots, clayBots, obsBots, geodeBots + 1, ore + oreBots - bp.geodeOre, clay + clayBots, obs + obsBots - bp.geodeObs, geode + geodeBots);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State state)) return false;
            if (minutes != state.minutes) return false;
            if (oreBots != state.oreBots) return false;
            if (clayBots != state.clayBots) return false;
            if (obsBots != state.obsBots) return false;
            if (geodeBots != state.geodeBots) return false;
            if (ore != state.ore) return false;
            if (clay != state.clay) return false;
            if (obs != state.obs) return false;
            return geode == state.geode;
        }

        @Override
        public int hashCode() {
            int result = minutes;
            result = 31 * result + oreBots;
            result = 31 * result + clayBots;
            result = 31 * result + obsBots;
            result = 31 * result + geodeBots;
            result = 31 * result + ore;
            result = 31 * result + clay;
            result = 31 * result + obs;
            result = 31 * result + geode;
            return result;
        }
    }

    record Blueprint(int id, int oreOre, int clayOre, int obsOre, int obsClay, int geodeOre, int geodeObs) {
        public Blueprint(Matcher m) {
            this(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)), Integer.parseInt(m.group(5)), Integer.parseInt(m.group(6)), Integer.parseInt(m.group(7)));
        }
    }
}