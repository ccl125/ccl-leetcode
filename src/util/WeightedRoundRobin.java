package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author CuiChengLong
 * @Date 2024/5/16 17:19
 * @Description
 */

public class WeightedRoundRobin {
    private static class WeightedIP {
        String ip;
        int weight;

        public WeightedIP(String ip, int weight) {
            this.ip = ip;
            this.weight = weight;
        }
    }

    private List<WeightedIP> weightedIPs;
    private Random random;

    public WeightedRoundRobin() {
        weightedIPs = new ArrayList<>();
        random = new Random();
    }

    public void addIP(String ip, int weight) {
        weightedIPs.add(new WeightedIP(ip, weight));
    }

    public String getNextIP() {
        int totalWeight = weightedIPs.stream().mapToInt(ip -> ip.weight).sum();
        int randomWeight = random.nextInt(totalWeight);
        int cumulativeWeight = 0;

        for (WeightedIP weightedIP : weightedIPs) {
            cumulativeWeight += weightedIP.weight;
            if (randomWeight < cumulativeWeight) {
                return weightedIP.ip;
            }
        }

        // Should never reach here
        return weightedIPs.get(weightedIPs.size() - 1).ip;
    }

    public static void main(String[] args) {
        WeightedRoundRobin roundRobin = new WeightedRoundRobin();
        roundRobin.addIP("IP1", 5);
        roundRobin.addIP("IP2", 10);

        int requests = 1000;
        int ip1Count = 0;
        int ip2Count = 0;

        for (int i = 0; i < requests; i++) {
            String ip = roundRobin.getNextIP();
            if (ip.equals("IP1")) {
                ip1Count++;
            } else if (ip.equals("IP2")) {
                ip2Count++;
            }
        }

        System.out.println("IP1 count: " + ip1Count);
        System.out.println("IP2 count: " + ip2Count);
    }
}