class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        for (String s : folder){
            boolean flag = true;
            for(String t : ans) {
                if((s+"/").startsWith(t + "/")){
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(s);
        }
        return ans;
    }
}