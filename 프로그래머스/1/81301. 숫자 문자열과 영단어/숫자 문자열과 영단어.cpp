#include <string>
#include <vector>

using namespace std;

void replaceAll(string& s, string from, string to){
    int pos = 0;
    while((pos = s.find(from, pos)) != string::npos){
        s.replace(pos, from.size(), to);
        pos += to.size();
    }
}

int solution(string s) {
    replaceAll(s, "zero", "0");
    replaceAll(s, "one", "1");
    replaceAll(s, "two", "2");
    replaceAll(s, "three", "3");
    replaceAll(s, "four", "4");
    replaceAll(s, "five", "5");
    replaceAll(s, "six", "6");
    replaceAll(s, "seven", "7");
    replaceAll(s, "eight", "8");
    replaceAll(s, "nine", "9");
    return stoi(s);
}