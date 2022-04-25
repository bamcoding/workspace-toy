package com.log.algorithm;

import com.log.algorithm.greedy.GreedyImpl;
import com.log.algorithm.stack.DfsImpl;
import com.log.algorithm.stack.StackImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class AlgorithmMain {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public static int getOccurrenceCount(String toSearch, InputStream stream) throws Exception {
        List<String> lineList = new ArrayList<>();
        String line = "";
        int ch = 0;
        while((ch = stream.read()) != -1){
            line+=(char)ch;
            if((char)ch == '\n'){
                lineList.add(line);
            }
        }
        stream.close();
        lineList.forEach(System.out::println);

        int count=0;
        for(String l : lineList){
            if(l.indexOf(toSearch)>-1){
                count++;
            }
        }

        return count;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    public static String simplify(String input) {
        char temp = 0;
        String str ="";
        for(int i=0;i<input.length();i++){
            if(temp != input.charAt(i)){
                str +=input.charAt(i);
            }
            temp = input.charAt(i);
        }
        return str;
    }

    public static String simplify2(String input) {
        if(input.length() ==1){
            return input.charAt(0)+"";
        }
        if(input.charAt(0) == input.charAt(1)){
            return simplify(input.substring(1,input.length()));
        }
        return input.charAt(0)+simplify(input.substring(1,input.length()));
    }

    public static  void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println(simplify("ghhrkkb"));
        long end = System.currentTimeMillis();
        System.out.println("수행시간 : " + (end - start)/1000.0);

        start = System.currentTimeMillis();
        System.out.println(simplify2("ghhrkkb"));
        end = System.currentTimeMillis();
        System.out.println("수행시간 : " + (end - start)/1000.0);

        //        String msg = "Hey! How are you?\nI am good, how about you?\nI am good too.";
//
//        try(InputStream stream = new ByteArrayInputStream(msg.getBytes())) {
//            System.out.println(getOccurrenceCount("good", stream));
//        }


        //System.out.println(average(2,1));


        //        DfsImpl dfs = new DfsImpl();
//        dfs.run();
        //monster();


/*        List<List<Integer>> node = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(3);
        temp.add(8);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(7);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(4);
        temp.add(5);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(5);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(7);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(6);
        temp.add(8);
        node.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(7);
        node.add(temp);

        boolean[] visited = new boolean[9];

        bfs(1, node, visited);*/
        //dfs(1, node, visited);
    }

    //스택 오버 플로우 에러
    static void recursiveFunc(int i){
        System.out.println(i+" 재귀 함수를 호출합니다.");
        if(i == 50) {
            System.out.println(i+"재귀 함수를 종료합니다.");
            return;
        }
        recursiveFunc(i+1);
        System.out.println(i+"재귀 함수를 종료합니다.");
    }

    static int test(int a, int b) {
        System.out.println(a%b);
        if(a % b == 0){
            return b;
        }

        return test(a, a%b);
    }

    //번호가 낮은 인접 노드부터 접근한다.
    static void dfs(int index, List<List<Integer>> node, boolean[] visited){
        visited[index] = true;
        System.out.println(index);
        for (int n : node.get(index)){
            if(visited[n] != true) dfs(n, node, visited);
        }
    }

    static void bfs(int start, List<List<Integer>> node, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        System.out.println("insert q => " + start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i = 0; i < node.get(x).size(); i++) {
                int y = node.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    System.out.println("insert q => " + y);
                    visited[y] = true;
                }
            }
        }
    }

    static void monster() {
        int n = 5;
        int m = 6;
        int[][] map = new int[n][m];
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<m;j++){
                map[i][j] = line.charAt(j) - 48;
            }
        }
        sc.close();

        for(int i=0;i<n;i++){
            String line = "";
            for(int j=0;j<m;j++){
                line += map[i][j];
            }
            System.out.println(line);
        }

        monsterBfs(0,0);
    }

    static void monsterBfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
    }

}
