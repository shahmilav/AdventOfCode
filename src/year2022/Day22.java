//package year2022;
//
//import java.io.BufferedReader;
//import java.util.ArrayList;
//import java.util.Objects;
//
//class Player {
//    public static final int EAST = 0;
//    public static final int SOUTH = 1;
//    public static final int WEST = 2;
//    public static final int NORTH = 3;
//    private int x;
//    private int y;
//    private boolean phase2;
//    public boolean isPhase2() {
//        return phase2;
//    }
//    public void setPhase2(boolean phase2) {
//        this.phase2 = phase2;
//    }
//    public int getDirection() {
//        return direction;
//    }
//    private int direction;
//
//    public Player(int x, int y) {
//        this.x = x;
//        this.y = y;
//        this.direction = EAST;
//        phase2 = false;
//    }
//    public void turn(Character turnDirection) {
//        if(turnDirection == 'R') {
//            direction++;
//        } else {
//            direction--;
//        }
//        if(direction > NORTH) {
//            direction = EAST;
//        } else if(direction < EAST) {
//            direction = NORTH;
//        }
//    }
//    public void move(int distance, char[][] map) {
//        for(int i = 0; i < distance; i++) {
//            int[] nextPosition = getNextPosition();
//            if(isValidCoordinate(nextPosition[0], nextPosition[1], map)) {
//                if(isSpace(nextPosition[0], nextPosition[1], map)) {
//                    nextPosition = flyThroughSpace(nextPosition[0], nextPosition[1], map);
//                    if(nextPosition[0] < 0 && nextPosition[1] < 0) {
//                        break;
//                    } else {
//                        x = nextPosition[0];
//                        y = nextPosition[1];
//                    }
//                } else if(isWall(nextPosition[0], nextPosition[1], map)) {
//                    break;
//                } else {
//                    x = nextPosition[0];
//                    y = nextPosition[1];
//                }
//            } else {
//                nextPosition = wrapAround(nextPosition[0], nextPosition[1], map);
//                if(nextPosition[0] < 0 && nextPosition[1] < 0) {
//                    break;
//                } else {
//                    x = nextPosition[0];
//                    y = nextPosition[1];
//                }
//            }
//        }
//    }
//    public boolean isSpace(int x, int y, char[][] map) {
//        return map[y][x] == ' ' || map[y][x] == '\u0000';
//    }
//    public int[] flyThroughSpace(int x, int y, char[][] map) {
//        int[] nextPosition = getNextPosition(x, y);
//        if(isValidCoordinate(nextPosition[0], nextPosition[1], map)) {
//            if(isSpace(nextPosition[0], nextPosition[1], map)) {
//                return flyThroughSpace(nextPosition[0], nextPosition[1], map);
//            } else if(isWall(nextPosition[0], nextPosition[1], map)) {
//                return new int[]{-1, -1}; // hit a wall, go back
//            } else {
//                return nextPosition;
//            }
//        } else {
//            return wrapAround(nextPosition[0], nextPosition[1], map);
//        }
//    }
//
//    private int[] wrapAround(int x, int y, char[][] map) {
//        if(this.isPhase2()) {
//            return wrapAroundPhase2(x, y, map);
//        }
//        return wrapAroundPhase1(x, y, map);
//    }
//    public int[] getCoodinates() {
//        return new int[] {x, y};
//    }
//    private int[] wrapAroundPhase1(int x, int y, char[][] map) {
//        int tempx = x;
//        int tempy = y;
//        switch (direction) {
//            case EAST -> tempx = 1;
//            case SOUTH -> tempy = 1;
//            case WEST -> tempx = map[y].length - 1;
//            case NORTH -> tempy = map.length - 1;
//        }
//        while(map[tempy][tempx] == ' ') {
//            int[] nextPosition = getNextPosition(tempx, tempy);
//            tempx = nextPosition[0];
//            tempy = nextPosition[1];
//        }
//        if(isWall(tempx,tempy, map)) {
//            return new int[] {-1, -1}; // hit a wall, go back
//        } else {
//            return new int[] {tempx, tempy};
//        }
//    }
//    private int[] wrapAroundPhase2(int x, int y, char[][] map) {
//        if(x == 102 && y==4) {
//            System.out.println("STOP");
//        }
//        int tempx = x <= 0 ? 1 : x >= map[0].length ? map[0].length - 1 : x;
//        int tempy = y <= 0 ? 1 : y >= map.length ? map.length - 1 : y;
//        int newDirection = direction;
//        int mod = (map.length - 1) / 4;
//        switch (this.getDirection()) {
//            case EAST -> {
//                switch (whichFraction(tempy - 1, map.length - 1, 4) + 1) {
//                    case 1 -> {
//                        tempy = fractionTranslation(tempy % mod - 1, map.length - 1, 3, 4, true);
//                        tempx = map[tempy].length - 1;
//                        newDirection = WEST;
//                    }
//                    case 2 -> {
//                        tempx = fractionTranslation(tempy % mod, map[tempy].length - 1, 3, 3, false);
//                        tempy = map.length - 1;
//                        newDirection = NORTH;
//                    }
//                    case 3 -> {
//                        tempy = fractionTranslation(tempy % mod - 1, map.length - 1, 1, 4, true);
//                        tempx = map[tempy].length - 1;
//                        newDirection = WEST;
//                    }
//                    case 4 -> {
//                        tempx = fractionTranslation(tempy % mod, map[tempy].length - 1, 2, 3, false);
//                        tempy = map.length - 1;
//                        newDirection = NORTH;
//                    }
//                }
//            }
//            case SOUTH -> {
//                switch (whichFraction(tempx - 1, map[tempy].length - 1, 3) + 1) {
//                    case 1 -> {
//                        tempx = fractionTranslation(tempx % mod, map[tempy].length - 1, tempx == mod ? 4 : 3, 3, false);
//                        tempy = 1;
//                        newDirection = SOUTH;
//                    }
//                    case 2 -> {
//                        tempy = fractionTranslation(tempx % mod, map.length - 1, 4, 4, false);
//                        tempx = map[tempy].length - 1;
//                        newDirection = WEST;
//                    }
//                    case 3 -> {
//                        tempy = fractionTranslation(tempx % mod, map.length - 1, 2, 4, false);
//                        tempx = map[tempy].length - 1;
//                        newDirection = WEST;
//                    }
//                }
//            }
//            case WEST -> {
//                switch (whichFraction(tempy - 1, map.length - 1, 4) + 1) {
//                    case 1 -> {
//                        tempy = fractionTranslation(tempy % mod - 1, map.length - 1, tempy == mod ? 2 : 3, 4, true);
//                        tempx = 1;
//                        newDirection = EAST;
//                    }
//                    case 2 -> {
//                        tempx = fractionTranslation(tempy % mod, map[tempy].length - 1, 1, 3, false);
//                        tempy = 1;
//                        newDirection = SOUTH;
//                    }
//                    case 3 -> {
//                        tempy = fractionTranslation(tempy % mod - 1, map.length, 1, 4, true);
//                        tempx = 1;
//                        newDirection = EAST;
//                    }
//                    case 4 -> {
//                        tempx = fractionTranslation(tempy % mod, map[tempx].length - 1, tempy == 200 ? 3 : 2, 3, false);
//                        tempy = 1;
//                        newDirection = SOUTH;
//                    }
//                }
//            }
//            case NORTH -> {
//                switch (whichFraction(tempx - 1, map[tempy].length - 1, 3) + 1) {
//                    case 1 -> {
//                        tempy = fractionTranslation(tempx % mod, map.length - 1, tempx == mod ? 3 : 2, 4, false);
//                        tempx = 1;
//                        newDirection = EAST;
//                    }
//                    case 2 -> {
//                        tempy = fractionTranslation(tempx % mod, map.length - 1, 4, 4, false);
//                        tempx = 1;
//                        newDirection = EAST;
//                    }
//                    case 3 -> {
//                        tempx = fractionTranslation(tempx % mod, map[tempy].length - 1, tempx == 150 ? 2 : 1, 3, false);
//                        tempy = map.length - 1;
//                        newDirection = NORTH;
//                    }
//                }
//            }
//        }
//        while(map[tempy][tempx] == ' ') {
//            int[] nextPosition = getNextPosition(tempx, tempy, newDirection);
//            tempx = nextPosition[0];
//            tempy = nextPosition[1];
//        }
//        if(isWall(tempx, tempy, map)) {
//            return new int[] {-1, -1}; // hit a wall, go back
//        } else {
//            this.direction = newDirection;
//            return new int[] {tempx, tempy};
//        }
//    }
//    public int whichFraction(int i, int size, int denominator) {
//        if(denominator == 3 && i == size) {
//            return 2;
//        }
//        if(denominator == 4 && i == size) {
//            return 3;
//        }
//        return (int) Math.floor((double) i / (double) size * denominator);
//    }
//    public int fractionTranslation(int i, int size, int numerator, int denominator, boolean inverted) {
//        if(inverted) {
//            return size / denominator * (numerator) - i;
//        }
//        return size / denominator * (numerator - 1) + i;
//    }
//    private boolean isValidCoordinate(int x, int y, char[][] map) {
//        return x > 0 && y > 0 && y < map.length && x < map[y].length;
//    }
//    private boolean isWall(int x, int y, char[][] map) {
//        return map[y][x] == '#';
//    }
//    private int[] getNextPosition() {
//        return getNextPosition(this.x, this.y);
//    }
//    private int[] getNextPosition(int x, int y) {
//        return switch (direction) {
//            case NORTH -> new int[]{x, y - 1};
//            case EAST -> new int[]{x + 1, y};
//            case SOUTH -> new int[]{x, y + 1};
//            case WEST -> new int[]{x - 1, y};
//            default -> null;
//        };
//    }
//    private int[] getNextPosition(int x, int y, int dir) {
//        return switch (dir) {
//            case NORTH -> new int[]{x, y - 1};
//            case EAST -> new int[]{x + 1, y};
//            case SOUTH -> new int[]{x, y + 1};
//            case WEST -> new int[]{x - 1, y};
//            default -> null;
//        };
//    }
//}
//public class Day22 {
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        String fileName = "src/year2022/inputs/day22.in";
//        int Phase1Answer;
//        int Phase2Answer;
//        BufferedReader reader;
//        char[][] grid = new char[0][];
//        Object[] instructions = null;
//        try {
//            reader = new BufferedReader(new java.io.FileReader(fileName));
//            String line = reader.readLine();
//            ArrayList<ArrayList<Character>> gridList = new ArrayList<>();
//            ArrayList<Character> preRow = new ArrayList<>();
//            preRow.add(' ');
//            gridList.add(preRow); // starting at 1,1 makes it easier on me later
//            while (!line.isEmpty()) {
//                ArrayList<Character> row = new ArrayList<>();
//                row.add(' ');
//                for (char c : line.toCharArray()) {
//                    row.add(c);
//                }
//                gridList.add(row);
//                line = reader.readLine();
//            }
//            int maxCol = 0;
//            for (ArrayList<Character> row : gridList) {
//                if (row.size() > maxCol) {
//                    maxCol = row.size();
//                }
//            }
//            grid = new char[gridList.size()][maxCol];
//            for (int i = 1; i < gridList.size(); i++) {
//                for (int j = 1; j < maxCol; j++) {
//                    grid[i][j] = j < gridList.get(i).size() ? gridList.get(i).get(j) : ' ';
//                }
//            }
//            instructions = parseInstructions(reader.readLine());
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int startingX = 1;
//        while(grid[1][startingX] != '.') {
//            startingX++;
//        }
//        Player player = new Player(startingX, 1);
//        for(Object instruction : Objects.requireNonNull(instructions)) {
//            if(instruction instanceof Integer) {
//                player.move((Integer) instruction, grid);
//            } else {
//                player.turn(((String) instruction).charAt(0));
//            }
//        }
//        int[] coordinates = player.getCoodinates();
//        Phase1Answer = (4*(coordinates[0])) + (1000*(coordinates[1])) + player.getDirection();
//        System.out.println("Phase 1 Answer: " + Phase1Answer);
//        player = new Player(startingX, 1);
//        player.setPhase2(true);
//        for(Object instruction : instructions) {
//            if(instruction instanceof Integer) {
//                player.move((Integer) instruction, grid);
//            } else {
//                player.turn(((String) instruction).charAt(0));
//            }
//        }
//        coordinates = player.getCoodinates();
//        Phase2Answer = (4*(coordinates[0])) + (1000*(coordinates[1])) + player.getDirection();
//        System.out.println("Phase 2 Answer: " + Phase2Answer);
//        long currentTime = System.currentTimeMillis();
//        double elapsedTime = (currentTime - startTime) / 1000.0;
//        System.out.println("Time in seconds : " + elapsedTime);
//    }
//    private static Object[] parseInstructions(String directions) {
//        ArrayList<Object> directionsArray = new ArrayList<>();
//        int start = 0;
//        int end = 0;
//        while (start < directions.length()) {
//            if (directions.charAt(start) != 'L' && directions.charAt(start) != 'R') {
//                while(end < directions.length() && directions.charAt(end) != 'L' && directions.charAt(end) != 'R') {
//                    end++;
//                }
//                directionsArray.add(Integer.parseInt(directions.substring(start, end)));
//            } else if (directions.charAt(start) == 'L' || directions.charAt(start) == 'R') {
//                directionsArray.add(directions.substring(start, ++end));
//            }
//            start = end;
//        }
//        return directionsArray.toArray();
//    }
//}

package year2022;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day22 {
    public static void main(String[] args) throws IOException {
        // Initialize
        long begin = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("src/year2022/inputs/day22.in"));
        String s;
        int row = 1;
        Tile start = null;
        HashMap<Integer, HashMap<Integer, Tile>> tiles = new HashMap<>();
        while (!(s = br.readLine()).isEmpty()) {
            Tile first = null;
            Tile prev = null;
            HashMap<Integer, Tile> curRow = new HashMap<>();
            tiles.put(row, curRow);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    if (prev != null) {
                        throw new IllegalStateException();
                    }
                    continue;
                }
                Tile tile = new Tile(i + 1, row, c == '#');
                if (start == null) {
                    start = tile;
                }
                if (first == null) {
                    first = tile;
                }
                if (prev != null) {
                    prev.neighbors[0] = tile;
                    tile.neighbors[2] = prev;
                }
                prev = tile;
                curRow.put(i + 1, tile);
            }
            first.neighbors[2] = prev;
            prev.neighbors[0] = first;
            row++;
        }
        int numRows = row - 1;
        // link up down
        for (var cur : tiles.entrySet()) {
            for (var entry : cur.getValue().entrySet()) {
                Tile tile = entry.getValue();
                int tst = tile.row == 1 ? numRows : tile.row - 1;
                while (tiles.get(tst).get(tile.col) == null) {
                    if (tst == 1) {
                        tst = numRows;
                    } else {
                        tst--;
                    }
                }
                Tile neighbor = tiles.get(tst).get(tile.col);
                neighbor.neighbors[1] = tile;
                tile.neighbors[3] = neighbor;
                tst = tile.row == numRows ? 1 : tile.row + 1;
                while (tiles.get(tst).get(tile.col) == null) {
                    if (tst == numRows) {
                        tst = 1;
                    } else {
                        tst++;
                    }
                }
                neighbor = tiles.get(tst).get(tile.col);
                neighbor.neighbors[3] = tile;
                tile.neighbors[1] = neighbor;
            }
        }
        String directions = br.readLine();
        br.close();

        // part 1
        System.out.println("part 1: " + walk(start, directions));
        long pt1 = System.currentTimeMillis() - begin;
        System.out.println(pt1 + "ms");

        // part 2, first adjust wraparound
        int faceSize = numRows / 4;
        // sample: int faceSize = numRows / 4;
        for (int i = 1; i <= faceSize; i++) {
            adjustForCube(tiles, faceSize, i);
            //adjustForSampleCube(tiles, faceSize, i);
        }
        System.out.println("part 2: " + walk(start, directions));
        long pt2 = System.currentTimeMillis() - begin + pt1;
        System.out.println(pt2 + "ms");
    }

    private static void adjustForCube(HashMap<Integer, HashMap<Integer, Tile>> tiles, int faceSize, int i) {
        Tile a1 = tiles.get(1).get(faceSize + i);
        Tile a6 = tiles.get(3 * faceSize + i).get(1);
        a1.neighbors[3] = a6;
        a1.facingAdjust[3] = 1;
        a6.neighbors[2] = a1;
        a6.facingAdjust[2] = 3;

        Tile b2 = tiles.get(1).get(faceSize * 2 + i);
        Tile b6 = tiles.get(faceSize * 4).get(i);
        b2.neighbors[3] = b6;
        b6.neighbors[1] = b2;

        Tile c2 = tiles.get(i).get(faceSize * 3);
        Tile c5 = tiles.get(faceSize * 3 - i + 1).get(faceSize * 2);
        c2.neighbors[0] = c5;
        c2.facingAdjust[0] = 2;
        c5.neighbors[0] = c2;
        c5.facingAdjust[0] = 2;

        Tile d2 = tiles.get(faceSize).get(faceSize * 2 + i);
        Tile d3 = tiles.get(faceSize + i).get(faceSize * 2);
        d2.neighbors[1] = d3;
        d2.facingAdjust[1] = 1;
        d3.neighbors[0] = d2;
        d3.facingAdjust[0] = 3;

        Tile e5 = tiles.get(faceSize * 3).get(faceSize + i);
        Tile e6 = tiles.get(3 * faceSize + i).get(faceSize);
        e5.neighbors[1] = e6;
        e5.facingAdjust[1] = 1;
        e6.neighbors[0] = e5;
        e6.facingAdjust[0] = 3;

        Tile f4 = tiles.get(faceSize * 2 + i).get(1);
        Tile f1 = tiles.get(faceSize - i + 1).get(faceSize + 1);
        f4.neighbors[2] = f1;
        f4.facingAdjust[2] = 2;
        f1.neighbors[2] = f4;
        f1.facingAdjust[2] = 2;

        Tile g3 = tiles.get(faceSize + i).get(faceSize + 1);
        Tile g4 = tiles.get(2 * faceSize + 1).get(i);
        g3.neighbors[2] = g4;
        g3.facingAdjust[2] = 3;
        g4.neighbors[3] = g3;
        g4.facingAdjust[3] = 1;
    }

    private static void adjustForSampleCube(HashMap<Integer, HashMap<Integer, Tile>> tiles, int faceSize, int i) {
        Tile at1 = tiles.get(i).get(2 * faceSize + 1);
        Tile at3 = tiles.get(faceSize + 1).get(faceSize + i);
        at1.neighbors[2] = at3;
        at1.facingAdjust[2] = 3;
        at3.neighbors[3] = at1;
        at3.facingAdjust[3] = 1;

        Tile bt1 = tiles.get(1).get(2 * faceSize + i);
        Tile bt2 = tiles.get(faceSize + 1).get(faceSize - i + 1);
        bt1.neighbors[3] = bt2;
        bt1.facingAdjust[3] = 2;
        bt2.neighbors[3] = bt1;
        bt2.facingAdjust[3] = 2;

        Tile ct1 = tiles.get(i).get(3 * faceSize);
        Tile ct6 = tiles.get(3 * faceSize - i + 1).get(4 * faceSize);
        ct1.neighbors[0] = ct6;
        ct1.facingAdjust[0] = 2;
        ct6.neighbors[0] = ct1;
        ct6.facingAdjust[0] = 2;

        Tile dt2 = tiles.get(faceSize + i).get(1);
        Tile dt6 = tiles.get(faceSize * 3).get(faceSize * 4 - i + 1);
        dt2.neighbors[2] = dt6;
        dt2.facingAdjust[2] = 1;
        dt6.neighbors[1] = dt2;
        dt6.facingAdjust[1] = 3;

        Tile et2 = tiles.get(faceSize * 2).get(i);
        Tile et5 = tiles.get(faceSize * 3).get(faceSize * 3 - i + 1);
        et2.neighbors[1] = et5;
        et2.facingAdjust[1] = 2;
        et5.neighbors[1] = et2;
        et5.facingAdjust[1] = 2;

        Tile ft3 = tiles.get(faceSize * 2).get(faceSize + i);
        Tile ft5 = tiles.get(faceSize * 3 - i + 1).get(faceSize * 2 + 1);
        ft3.neighbors[1] = ft5;
        ft3.facingAdjust[1] = 3;
        ft5.neighbors[2] = ft3;
        ft5.facingAdjust[2] = 1;

        Tile gt4 = tiles.get(faceSize + i).get(faceSize * 3);
        Tile gt6 = tiles.get(faceSize * 2 + 1).get(faceSize * 4 - i + 1);
        gt4.neighbors[0] = gt6;
        gt4.facingAdjust[0] = 1;
        gt6.neighbors[3] = gt4;
        gt6.facingAdjust[3] = 3;
    }

    private static int walk(Tile start, String directions) {
        Pattern pat = Pattern.compile("(\\d+)([RL])?");
        Matcher m = pat.matcher(directions);
        Tile cur = start;
        int facing = 0;
        while (m.find()) {
            int steps = Integer.parseInt(m.group(1));
            System.out.println("@" + cur.row + "," + cur.col + " " + facing + " -> " + steps + " " + m.group(2));
            while (steps > 0) {
                if (!cur.neighbors[facing].wall) {
                    int facingAdjust = cur.facingAdjust[facing];
                    cur = cur.neighbors[facing];
                    facing = (facing + facingAdjust) % 4;
                    steps--;
                } else {
                    break;
                }
            }
            if (m.group(2) != null) {
                char turn = m.group(2).charAt(0);
                if (turn == 'L') {
                    facing = (facing + 3) % 4;
                } else {
                    facing = (facing + 1) % 4;
                }
            }
        }
        int result = 1000 * cur.row + 4 * cur.col + facing;
        System.out.println(cur.row + " " + cur.col + " " + facing);
        return result;
    }

    static class Tile {
        int row, col;
        Tile[] neighbors = new Tile[4];
        int[] facingAdjust = new int[4];
        boolean wall;

        public Tile(int col, int row, boolean wall) {
            this.col = col;
            this.row = row;
            this.wall = wall;
        }
    }
}