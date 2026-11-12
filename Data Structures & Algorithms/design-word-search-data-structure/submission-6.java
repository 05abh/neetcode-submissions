public class TreeNode{
    TreeNode[] children;
    boolean eow;
    public TreeNode(){
        children=new  TreeNode[26];
        eow=false;
    }
}
class WordDictionary {

    private TreeNode root;

    public WordDictionary() {
        root =new TreeNode();
    }

    public void addWord(String word) {
        TreeNode cur=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null){
                cur.children[idx]= new TreeNode();
            }
            cur=cur.children[idx];
        }
        cur.eow=true;
    }

    public boolean search(String word) {
        return searchUtil(word,0,root);
    }

    private boolean searchUtil(String word,int j, TreeNode root){
        TreeNode cur=root;
        for(int i=j;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TreeNode child:cur.children){
                    if(child!=null&&searchUtil(word,i+1,child)){
                        return true;
                    }
                }
                return false;
            }else{
                int idx=c-'a';
                if(cur.children[idx]==null){
                return false;
            }
            cur=cur.children[idx];
            }
        }
        return cur.eow;
    }
}
