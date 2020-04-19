#include <iostream>

using namespace std;

int solve() {
    int H[3];
    int N, c, p, pp, result = 0;
    cin >> N;

    for (auto i = 0; i < N; i++)
    {
        c = i%3;
        cin >> H[c];
        
        if (1 < i && H[pp] < H[p] && H[p] > H[c]) {
            result++;
        }

        pp = p;
        p = c;
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
