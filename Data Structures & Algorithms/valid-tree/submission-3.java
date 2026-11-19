class Solution {
    List<List<Integer>> adj;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){//edges should equal to n-1 node length
            return false;
        }
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){//create the  arrayList which  traversed to the length of the node
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){// connect the nodes on the both side since it is undirected
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis=new boolean[n];
        if(dfs(0,-1,vis)){
            return false;//cycle detected
        }
        for(boolean v:vis){
            if(!v){// checks if every node is visited if the node is unvisisted then it is discoonected
                return false;
            }
        }
        return true;

    }

    private boolean dfs(int src,int parent,boolean[] vis){
        vis[src]=true;
        for(int v:adj.get(src)){
            if(!vis[v]){
                if(dfs(v,src,vis)){
                    return true;
                }
                }else if(v!=parent){
                    return true;
                
            }
        }
        return false;
    }
}
