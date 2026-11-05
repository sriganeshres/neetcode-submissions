/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> hp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        hp.put(node, new Node(node.val));
        q.add(node);

        while(!q.isEmpty()) {
            Node n = q.poll();
            for(Node neigh: n.neighbors) {
                if(!hp.containsKey(neigh)) {
                    hp.put(neigh, new Node(neigh.val));
                    q.add(neigh);
                }
                hp.get(n).neighbors.add(hp.get(neigh));
            }

        }
        return hp.get(node);
    }
}