#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    vector<int> V(N+1,0);
    vector<char> rst;

    for(int i=0; i<N; i++){
        cin >> V[i];
    }

    stack<int> s;
    int max=1;

    for(int i=0; i<N; i++){
        if(V[i] >= max){
            while(max <= V[i]){
                s.push(max);
                rst.push_back('+');
                max++;
            }
            s.pop();
            rst.push_back('-');
        }
        else{
            if(s.empty() || s.top() != V[i]){
                cout << "NO" << '\n';
                return 0;
            }
            s.pop();
            rst.push_back('-');
        }
    }
    for(char a : rst){
        cout << a << '\n';
    }
    
    return 0;
}