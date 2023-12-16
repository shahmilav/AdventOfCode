package year2023;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day08 extends AoCSolver {
    public Day08(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day08(2023, "08");
    }

    @Override
    public void solvePartOne(List<String> input) {
        HashMap<String, List<String>> nav = new HashMap<>();

        CircularLinkedList cll = getDirections(input);


        populateNavigationMap(input, nav);

        System.out.println(nav);

        String currentLocation = "AAA";
        int moves = 0;
        while (!currentLocation.equals("ZZZ")) {
            String dir = cll.head.value;
            System.out.println(dir);

            List<String> lr = nav.get(currentLocation);
            System.out.println(lr);


            if (dir.equals("L")) {
                currentLocation = lr.get(0);
            } else {
                currentLocation = lr.get(1);
            }

            moves++;
            cll.rotate();
        }

        lap(moves);
    }

    @Override
    public void solvePartTwo(List<String> input) {
        CircularLinkedList dirs = getDirections(input);
        HashMap<String, List<String>> nav = new HashMap<>();


        HashMap<String, Map<String, String>> lookup = new HashMap<>();

        populateNavigationMap(input, nav);

        List<String> starting = new ArrayList<>();
        for (int i = 2; i < input.size(); i++) {
            if (input.get(i).charAt(2) == 'A') {
                starting.add(input.get(i).substring(0, 3));
            }
        }

        solvePartOne(starting);
    }

    private boolean isAllEndZ(List<String> list) {
        System.out.println(list);
        for (String a : list) {
            if (!a.substring(2).equals("Z")) {
                return false;
            }
        }
        return true;
    }

    private void populateNavigationMap(List<String> input, HashMap<String, List<String>> nav) {
        for (int i = 2; i < input.size(); i++) {
            String s = input.get(i);
            s = s.replaceAll("= ", "").replaceAll("\\(", "").replaceAll(",", "").replaceAll("\\)", "");

            String[] split = s.split(" ");

            List<String> leftright = new ArrayList<String>();

            leftright.add(split[1]);
            leftright.add(split[2]);
            nav.put(split[0], leftright);

        }
    }

    private CircularLinkedList getDirections(List<String> input) {
        CircularLinkedList cll = new CircularLinkedList();
        for (int i = 0; i < input.get(0).length(); i++) {
            cll.addNode(input.get(0).charAt(i) + "");
        }
        return cll;
    }

    class Node {

        String value;
        Node nextNode;

        public Node(String value) {
            this.value = value;
        }

    }

    class CircularLinkedList {
        private Node head = null;
        private Node tail = null;

        public void addNode(String value) {
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
            } else {
                tail.nextNode = newNode;
            }

            tail = newNode;
            tail.nextNode = head;
        }

        public void rotate() {
            this.head = this.head.nextNode;
            this.tail = this.tail.nextNode;
        }

    }
}
