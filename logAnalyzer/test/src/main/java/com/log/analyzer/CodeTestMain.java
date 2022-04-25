package com.log.analyzer;

import java.util.*;

public class CodeTestMain {
//    주어진 가격정보의 배열에서 찾고자 하는 가격의 배열인덱스를 반환하는 함수를 구현하세요.
//    시간복잡도가 최상인 방법 (실행시간이 가장 낮은 방법) 으로 구현하세요.
//    단 Java에서 기본으로 제공되는 Util 함수를 사용하지 않고 직접 구현합니다.
//
//    단 아래의 조건을 가정합니다.
//    숫자배열은 오름차순으로 정렬되어 있음
//
//    ex> {1000,2000,3000,4000,....4000000}

    final static int[][] nightMove = {{-2,1},{-1,2},{-2,-1},{-1,-2},{2,1},{1,2},{2,-1},{1,-2}};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //1. 테스트 횟수
        int testCnt = sc.nextInt();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<testCnt;i++){
            //2. 체스 판의 개수
            int range = sc.nextInt();
            //3. 출발지 (x,y)
            int originX = sc.nextInt();
            int originY = sc.nextInt();
            Node originNode = new Node(originX,originY,0);
            //4. 목적지 (x,y)
            int destinationX = sc.nextInt();
            int destinationY = sc.nextInt();
            Node destinationNode = new Node(destinationX,destinationY,0);
            result.add(searchChessBfs(range, originNode, destinationNode));
        }

        result.forEach(System.out::println);

        System.out.println("끝");
    }

    static boolean validattionNode(int range, Node node) {
        if((x<0 || range<=x())
                || (y()<0 || range<=y())) {
            return false;
        }

        return true;
    }

    static int searchChessBfs(int r, Node o, Node d){
        Queue<Node> q = new LinkedList<>();
        q.offer(o);

        while(q.size() > 0){
            Node originNode = q.poll();

            originNode.setVisited(true);

            if(originNode.equals(d)) {
                int result = originNode.getDepth();
                return result;
            }

            int nextDepth = originNode.getDepth()+1;
            int ox = originNode.getX();
            int oy = originNode.getY();

            for(int i=0;i<nightMove.length;i++){
                int i1 = originNode.getX() + nightMove[i][0];
            }
            if(!validattionNode(r, originNode)) {
                continue;
            }


            //왼쪽 위1
            Node node1 = new Node(originNode.getX()-2, originNode.getY()+1,nextDepth);
            q.offer(node1);

            //왼쪽 위2
            Node node2 = new Node(originNode.getX()-1, originNode.getY()+2,nextDepth);
            q.offer(node2);

            //왼쪽 아래1
            Node node3 = new Node(originNode.getX()-2, originNode.getY()-1,nextDepth);
            q.offer(node3);

            //왼쪽 아래2
            Node node4 = new Node(originNode.getX()-1, originNode.getY()-2,nextDepth);
            q.offer(node4);

            //오른쪽 위1
            Node node5 = new Node(originNode.getX()+2, originNode.getY()+1,nextDepth);
            q.offer(node5);

            //오른쪽 위2
            Node node6 = new Node(originNode.getX()+1, originNode.getY()+2,nextDepth);
            q.offer(node6);

            //오른쪽 아래1
            Node node7 = new Node(originNode.getX()+2, originNode.getY()-1,nextDepth);
            q.offer(node7);

            //오른쪽 아래2
            Node node8 = new Node(originNode.getX()+1, originNode.getY()-2,nextDepth);
            q.offer(node8);
        }
        return 0;
    }

    public static class Node {
        private int x;
        private int y;
        private int depth;
        private boolean visited;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public boolean equals(com.log.analyzer.Node node) {
            if (this.x == node.getX() && this.y == node.getY()) {
                return true;
            }
            return false;
        }
    }
}
