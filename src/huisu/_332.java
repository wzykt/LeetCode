package huisu;

import java.util.*;

/**
 * @date 2022-1-2
 * @description 332. 重新安排行程
 *
 * 现在可以找到所有可能的结果，但是没有按字典序最小的进行返回
 */
public class _332 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        list.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backTracking(tickets, used);
        System.out.println();
        return res.get(0);
    }

    public void backTracking(List<List<String>> tickets, boolean[] used) {
        if (list.size() >= tickets.size() + 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).get(0));
            if (used[i] == true) {
                continue;
            }
            if (tickets.get(i).get(0).equals(list.getLast())) {
                list.addLast(tickets.get(i).get(1));
                used[i] = true;
                backTracking(tickets, used);
                list.removeLast();
                used[i] = false;
            }
        }
    }
//答案
/*    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;
    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        System.out.println(map.toString());
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }*/
}
