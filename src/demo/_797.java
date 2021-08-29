package demo;

import java.util.*;

/**
 * 797. 所有可能的路径
 *
 * @date 2021/8/25开始 2021/8/28完成
 * @decripton 有状态回溯，保证每条递归链上的List是唯一的
 * @result 给的实例都能正确输出，但是无法通过答案
 */
public class _797 {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null) {
            return null;
        }
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            process(graph, graph[0][i], list);
        }
        return result;
    }

    public static void process(int[][] graph, int index, List<Integer> list) {
        list.add(index);

        if (index == graph.length - 1) {
            //result.add(list);
            //上面这种会重复
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < graph[index].length; i++) {
            process(graph, graph[index][i], list);
            //状态需要回溯
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> list = allPathsSourceTarget(graph);
        System.out.println(list.toString());
    }
}
