class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();

        for(String str: strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String word=new String(chars);
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<>());
            }
            map.get(word).add(str);
        }

        List<List<String>>ans=new ArrayList<>();
        for(ArrayList<String> list : map.values()) {
            ans.add(list);
        }



        return ans;

        

    }
}