class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winner=new HashSet<>();
        Map<Integer, Integer> loser=new HashMap<>();
        List<Integer> notLost=new ArrayList<>();
        List<Integer> lostOne=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();

        for(int[] match: matches){
            winner.add(match[0]);
            loser.put(match[1],loser.getOrDefault(match[1],0)+1);
        }
        // System.out.println(winner);
        // System.out.println(loser);
        for(int w:winner){
            if(!loser.containsKey(w)){
             notLost.add(w);
            }
        }
        for(int l:loser.keySet()){
            if(loser.get(l)==1){
                lostOne.add(l);
            }
        }
        Collections.sort(notLost);
        Collections.sort(lostOne);
        ans.add(notLost);
        ans.add(lostOne);
        return ans;
    }
}
