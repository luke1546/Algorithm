#include <string>
#include <vector>

using namespace std;

int transI(string time){
    string m = time.substr(0,2);
    string s = time.substr(3);
    return stoi(m)*60 + stoi(s);
}

string transS(int time){
    string result = "";
    int s = time%60;
    int m = time/60;
    if(m < 10) result+="0";
    result+=(to_string(m) + ":");
    if(s < 10) result+="0";
    result+=(to_string(s));
    return result;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    int videoLenI = transI(video_len);
    int posI = transI(pos);
    int opStartI = transI(op_start);
    int opEndI = transI(op_end);
    if(posI >= opStartI && posI <= opEndI) posI = opEndI;
    for(auto s : commands){
        if(s == "next"){
            posI+=10;
            if(posI > videoLenI) posI = videoLenI;
        }
        else if(s == "prev"){
            posI-=10;
            if(posI < 0) posI = 0;
        }
        if(posI >= opStartI && posI <= opEndI) posI = opEndI;
    }
    return transS(posI);
}