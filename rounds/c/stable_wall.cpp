#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <set>
#include <algorithm>

using namespace std;

string solve()
{
    int R, C;
    cin >> R >> C;

    int r, c;
    vector<string> wall(R);
    for (r = 0; r < R; r++)
    {
        cin >> wall[r];
    }
    
    if(R == 1 || C == 1) return "0";

    char curr, prev, x;
    unordered_set<char> seq;
    for (c = 0; c < C; c++)
    {
        seq.clear();
        prev = wall[0][c];
        for (r = 1; r < R; r++)
        {
            curr = wall[r][c];
            x = seq.count(curr);
            if(prev != curr)
            {
                if (x) return "-1";
                seq.insert(prev);
            }
            prev = curr;
        }
    }
    
    string result = "";
    unordered_map<char, int> upper;
    unordered_map<char, int> lower;
    for (r = 0; r < R; r++)
    {
        upper.empty();
        lower.empty();

        if (r < R-1) {
            for (c = 0; c < C; c++)
            {
                x = wall[r+1][c];
                if (upper.count(x)) upper[x]++;
                else upper[x] = 1;
            }
        }
        for (c = 0; c < C; c++)
        {
            x = wall[r][c];
            if (lower.count(x)) lower[x]++;
            else lower[x] = 1;
        }

        for (auto &&kv : lower)
        {
            int u = 0;
            if (upper.count(kv.first)) u=upper[kv.first];
            if (u/kv.second < 1 && !result.find(kv.first)) result += kv.first;
        }
        
        for (auto &&kv : lower)
        {
            int u = 0;
            if (upper.count(kv.first)) u=upper[kv.first];
            if (u/kv.second > 1 && !result.find(kv.first)) result += kv.first;
        }
        
    }

    return result;
}

int main(int argc, char const *argv[])
{
    int T;
    cin >> T;
    for (auto x = 1; x <= T; x++)
    {
        auto y = solve();

        cout << "Case #" << x << ": " << y << endl;
    }
    
    return 0;
}
