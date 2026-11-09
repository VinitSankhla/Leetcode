class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // {finishTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];

            // free up servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }

            // no servers available, drop the request
            if (available.isEmpty()) {
                continue;
            }

            int target = i % k;
            Integer server = available.ceiling(target);
            if (server == null) { // wrap around
                server = available.first();
            }

            available.remove(server);
            busy.add(new int[]{time + load[i], server});
            count[server]++;
        }

        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}