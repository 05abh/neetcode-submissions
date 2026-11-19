class Solution {
    private List<List<Integer>> adj;

    public int countComponents(int n, int[][] edges) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis=new boolean[n];
        int count =0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis);
            }
        }
        return count;

    }
    private void dfs(int src,boolean[] vis){
        vis[src]=true;
        for(int v:adj.get(src)){
            if(!vis[v]){
                dfs(v,vis);
            }
        }
    }
}
