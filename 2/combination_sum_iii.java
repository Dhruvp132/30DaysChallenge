
class Solution {
    public void help(int i, int k , int sumTillNow, int n, List<Integer> subSet, List<List<Integer>> ans){
        //base case
        // if(sumTillNow > n) return;
        if(k < 0) return;
        if (sumTillNow == n) {
            if (k == 0) ans.add(new ArrayList<>(subSet));
            return;
        }
        if(i == 10) return; //not go beyond 9

        //pick ith element
        sumTillNow += i;
        subSet.add(i);
        //k -= 1
        help(i+1, k-1, sumTillNow+i, n, subSet, ans);
        // k +=1; as if we're changing k outside this function you will have to undo this outside
        sumTillNow-=i;
        subSet.remove(subSet.size() - 1);

        //ignore the ith element 
        help(i+1, k, sumTillNow, n, subSet, ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        help(1, k, 0, n, subSet, ans);
        return ans;
    }
}
