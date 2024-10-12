#include <iostream>
#include <queue>
#include <vector>

using namespace std;


int main() {
	deque<vector<int>> dq;
	const int maxN = 1000;
	int N, W, L, cnt=0;
	cin >> N >> W >> L;
	int truck[maxN];
	for (int i = 0; i < N; i++) cin >> truck[i];
	int index = 0;
	while (true) {
		cnt++;
		int size = dq.size();
		
		for (int i = 0; i < size; i++) {
			vector<int> cur = dq.front();
			dq.pop_front();
			cur[1]++;
			if (cur[1] < W) dq.push_back(cur);
			else L+=cur[0];
		}

		if (index < N) {
			if (L >= truck[index]) {
				L -= truck[index];
				dq.push_back(vector<int>{ truck[index],0 });
				index++;
			}
		}
		else if (dq.empty()) break;

	}
	cout << cnt << endl;
	return 0;
}

/*
4 2 10
7 4 5 6

8
*/