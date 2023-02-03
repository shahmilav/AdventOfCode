package year2022;

import helpers.AoCSolver;

import java.util.ArrayList;
import java.util.List;

public class Day20 extends AoCSolver {
    public Day20(int year, String day) {
        super(year, day);
    }

    public static void main(String[] args) {
        new Day20(2022, "20");
    }

    private static long getSum(Node zeroNode) {
        long sum = 0;
        Node node = zeroNode;
        for (int i = 0; i <= 3000; i++) {
            if (i % 1000 == 0) {
                sum = Math.addExact(sum, node.val);
            }
            node = node.next;
        }
        return sum;
    }

    private static void mix(List<Node> nodes) {
        for (Node n : nodes) {
            long effectiveVal = n.val % (nodes.size() - 1);
            if (effectiveVal == 0) {
                continue;
            }
            n.prev.next = n.next;
            n.next.prev = n.prev;
            Node newPrev = n.prev;
            if (n.val < 0) {
                for (long i = 0; i > effectiveVal; i--) {
                    newPrev = newPrev.prev;
                }
            } else {
                for (long i = 0; i < effectiveVal; i++) {
                    newPrev = newPrev.next;
                }
            }
            n.next = newPrev.next;
            n.prev = newPrev;
            n.next.prev = n;
            n.prev.next = n;
        }
    }

    private static void adjustLinks(List<Node> nodes) {
        nodes.get(0).prev = nodes.get(nodes.size() - 1);
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i).prev = nodes.get(i - 1);
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        nodes.get(nodes.size() - 1).next = nodes.get(0);
    }

    @Override
    public void solvePartOne(List<String> input) {

        List<Node> nodes = new ArrayList<>();
        Node zeroNode = null;
        for (String s : input) {

            Node node = new Node(Integer.parseInt(s));
            nodes.add(node);
            if (node.val == 0) {
                zeroNode = node;
            }
        }
        adjustLinks(nodes);
        mix(nodes);
        lap(getSum(zeroNode));
    }

    @Override
    public void solvePartTwo(List<String> input) {
        List<Node> nodes = new ArrayList<>();
        Node zeroNode = null;
        for (String s : input) {

            Node node = new Node(Integer.parseInt(s));
            nodes.add(node);
            if (node.val == 0) {
                zeroNode = node;
            }
        }
        adjustLinks(nodes);
        mix(nodes);
        adjustLinks(nodes);
        for (Node n : nodes) {
            n.val = Math.multiplyExact(n.val, 811589153L);
        }
        for (int i = 0; i < 10; i++) {
            mix(nodes);
        }
        lap(getSum(zeroNode));
    }

    static class Node {
        private Node prev;
        private long val;
        private Node next;

        public Node(long val) {
            this.val = val;
        }

    }
}
