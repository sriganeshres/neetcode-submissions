/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hp = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            Node tmp = new Node(curr.val);
            hp.put(curr, tmp);
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            Node tmp = hp.get(curr);
            tmp.next = hp.get(curr.next);
            tmp.random = hp.get(curr.random);
            curr = curr.next;
        }

        return hp.get(head);
    }
}
