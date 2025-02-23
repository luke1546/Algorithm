#include <string>
#include <vector>
#include <sstream>

using namespace std;

string solution(string phone_number) {
    ostringstream oss;
    for(int i=0; i<phone_number.size(); i++){
        if(i < phone_number.size()-4) oss << "*";
        else oss << phone_number[i];
    }
    return oss.str();
}