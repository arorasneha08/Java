import java.util.*;
public class ServerBalancer {

    public static int minToolUsage(int[] serverLoad, int k) {
        // Sort descending
        Arrays.sort(serverLoad);
        int n = serverLoad.length;

        // Reverse for descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = serverLoad[i];
            serverLoad[i] = serverLoad[n - 1 - i];
            serverLoad[n - 1 - i] = temp;
        }

        // Manually offload top k servers
        int startIndex = Math.min(k, n); // skip these
        List<Integer> remaining = new ArrayList<>();

        for (int i = startIndex; i < n; i++) {
            remaining.add(serverLoad[i]);
        }

        // If no servers left, no tool use needed
        if (remaining.isEmpty()) return 0;

        int count = 0;

        while (!remaining.isEmpty()) {
            // Find current max L
            int L = Collections.max(remaining);
            int threshold = L / 2;

            // Remove all workloads > L/2
            List<Integer> next = new ArrayList<>();
            for (int load : remaining) {
                if (load <= threshold) {
                    next.add(load);
                }
            }

            remaining = next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] serverLoad = {16, 12, 18, 10, 12};
        int k = 2;

        int result = minToolUsage(serverLoad, k);
        System.out.println("Minimum tool usage: " + result); // Output: 1
    }

}
