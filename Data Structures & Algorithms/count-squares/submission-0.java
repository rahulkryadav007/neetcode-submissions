class CountSquares {

    HashMap<String, Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {

        String key = point[0] + "," + point[1];

        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int result = 0;

        for (String key : map.keySet()) {

            String[] parts = key.split(",");

            int x2 = Integer.parseInt(parts[0]);
            int y2 = Integer.parseInt(parts[1]);

            if (Math.abs(x2 - x) != Math.abs(y2 - y) || x2 == x) {
                continue;
            }

            String p1 = x + "," + y2;
            String p2 = x2 + "," + y;

            int freq1 = map.getOrDefault(p1, 0);
            int freq2 = map.getOrDefault(p2, 0);

            int diagonalFreq = map.get(key);

            result += diagonalFreq * freq1 * freq2;
        }

        return result;
    }
}