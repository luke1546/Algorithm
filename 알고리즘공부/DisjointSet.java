public class DisjointSet {
	static int parents[];
	public static void main(String args[]) {
		make();
	}
	private static void make() {
		parents = new int[10];
		for(int i=0; i<parents.length; i++)	parents[i] = i;
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
}
