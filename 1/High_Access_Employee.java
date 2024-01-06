import java.util.*;
class High_Access_Employee {
    public boolean isHighAccess(List<Integer> ls ) {
        int n = ls.size();
        if(n < 3) return false;

        for(int i=2 ; i<n ; i++) {
            int currTime = ls.get(i);
            int prevTime = ls.get(i-2);

            if(prevTime + 99 >= currTime) {
                return true;
            }
        }
        return false;
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(List<String> curr : access_times) {
            String emp = curr.get(0);
            String time = curr.get(1);

            if(!map.containsKey(emp)) {
                map.put(emp, new ArrayList<>());
            }
            int t = Integer.parseInt(time); //coz stored as a string format
            map.get(emp).add(t); //map.get(emp) will return value 
        }

        for(String emp : map.keySet()) {
            List<Integer> timesList = map.get(emp);
            Collections.sort(timesList);
            if(isHighAccess(timesList)) {
                ans.add(emp);
            }
        }

        return ans;
    }
}
