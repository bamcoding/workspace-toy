package com.log.algorithm.stack;

public class DfsImpl {
    public static void run() {
        String[] nodeList = new String[9];
        nodeList[0] = "";
        nodeList[1] = "238";
        nodeList[2] = "17";
        nodeList[3] = "145";
        nodeList[4] = "35";
        nodeList[5] = "34";
        nodeList[6] = "7";
        nodeList[7] = "268";
        nodeList[8] = "17";

        boolean[] visited = new boolean[9];
        for(int i=0;i<visited.length;i++) {
            System.out.println(visited[i]);
        }

        for(String node : nodeList){
            for(int i=0;i<node.length();i++){
                node.charAt(i);
            }
        }

        System.out.println((char) 48);
    }
}
