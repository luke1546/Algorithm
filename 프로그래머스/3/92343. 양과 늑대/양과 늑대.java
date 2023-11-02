import java.util.ArrayList;
class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int max = 0;
    public int solution(int[] info, int[][] edges) {
        for(int i=0; i<info.length; i++) graph.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        ArrayList<Integer> canGo = new ArrayList<>();
		canGo.add(0);
		dfs(0,0,0,info,canGo);
        return max;
    }
    private static void dfs(int n, int sheep, int wolf, int[] info, ArrayList<Integer> canGo) {
		if(info[n] == 0)		sheep++;
		else	wolf++;
		if(wolf >= sheep)	return;
		max = Math.max(max, sheep);
		ArrayList<Integer> al = new ArrayList<Integer>(canGo);
		if(!graph.get(n).isEmpty())	al.addAll(graph.get(n));
		al.remove(Integer.valueOf(n));
		for(int i : al) {
			dfs(i, sheep, wolf, info, al);
		}
	}
}