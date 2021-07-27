package com.lwq.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: LWQ
 * @create: 2020/10/23
 * @description: Graph
 **/
public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexs = {"A", "B", "C", "D", "E"};
        for (int i = 0; i < vertexs.length; i++) {
            graph.insertVertex(vertexs[i]);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(2, 1, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);

        int[][] edges = graph.getEdges();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.printf(edges[i][j] + "\t");
            }
            System.out.println();
        }

        graph.dfs();
        System.out.println();
        graph.bfs();
    }

    private List<String> vertexs;
    private int[][] edges;
    private int numOfEdges;

    public Graph(int n) {
        this.vertexs = new ArrayList<>(n);
        this.edges = new int[n][n];
    }

    public void bfs() {
        boolean[] isVisited = new boolean[vertexs.size()];
        for (int i = 0; i < vertexs.size(); i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited);
            }
        }
    }

    public void bfs(int vertexIndex, boolean[] isVisited) {
        // 队头的节点
        int u;
        // 邻接节点
        int w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.printf(getValueByIndex(vertexIndex) + "=>");
        isVisited[vertexIndex] = true;
        queue.addLast(vertexIndex);
        while (!queue.isEmpty()) {
            u = queue.removeFirst().intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.printf(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void dfs() {
        boolean[] isVisited = new boolean[vertexs.size()];
        for (int i = 0; i < vertexs.size(); i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited);
            }
        }
    }

    public void dfs(int vertexIndex, boolean[] isVisited) {
        System.out.printf(getValueByIndex(vertexIndex) + "->");
        isVisited[vertexIndex] = true;
        int w = getFirstNeighbor(vertexIndex);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(w, isVisited);
            }

            w = getNextNeighbor(vertexIndex, w);
        }

    }

    public int getFirstNeighbor(int index) {
        for (int i = 0; i < edges[index].length; i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < edges[v1].length; i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public String getValueByIndex(int index) {
        if (index < 0 || index >= vertexs.size()) {
            return null;
        }
        return vertexs.get(index);
    }

    public void insertVertex(String vertex) {
        vertexs.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        if (v1 < 0 || v1 >= edges.length || v2 < 0 || v2 >= edges.length) {
            System.out.println("没有该顶点!");
            return;
        }
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int[][] getEdges() {
        return edges;
    }
}
