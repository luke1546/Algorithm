#include <iostream>

using namespace std;

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		cout << "Case #" << i + 1 << ": " << a + b << endl;
	}
	return 0;
}

/*
5
1 1
2 3
3 4
9 8
5 2

Case #1: 2
Case #2: 5
Case #3: 7
Case #4: 17
Case #5: 7
*/