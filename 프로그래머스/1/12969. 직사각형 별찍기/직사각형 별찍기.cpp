#include <iostream>

using namespace std;

int main(void) {
    int r,c;
    cin >> c >> r;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cout << "*";
        }
        cout << endl;
    }
    return 0;
}