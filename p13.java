import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to store nodes, ordered by their values
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-empty list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // Dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            // Extract the smallest node from the heap
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = tail.next;

            // If the extracted node has a successor, add it to the heap
            if (minNode.next != null) {
                queue.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
