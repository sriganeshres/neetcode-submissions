class CountSquares {
    private Map<List<Integer>, Integer> mp;
    private List<List<Integer>> points;

    public CountSquares() {
        mp = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> ls = Arrays.asList(point[0], point[1]);
        mp.put(ls, mp.getOrDefault(ls, 0) + 1);
        points.add(ls);
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        int res = 0;
        for(List<Integer> p: points) {
            int px = p.get(0), py = p.get(1);
            if(px == x || py == y || Math.abs(px - x) != Math.abs(py - y)) {
                continue;
            }

            res += mp.getOrDefault(Arrays.asList(px, y), 0) * mp.getOrDefault(Arrays.asList(x, py), 0);
        }

        return res;
    }
}
