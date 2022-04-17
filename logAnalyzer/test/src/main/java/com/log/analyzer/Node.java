package com.log.analyzer;

public class Node {
    private int x;
    private int y;
    private int depth;
    private boolean visited;

    public Node (int x, int y){
        this.x = x;
        this.y = y;
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

    public String toString(){
        return "("+this.x+", "+this.y+")("+this.depth+")";
    }

    public boolean equals(Node node) {
        if(this.x == node.getX() && this.y == node.getY()) {
            return true;
        }
        return false;
    }
}
