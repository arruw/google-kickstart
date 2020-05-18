#include <iostream>

using namespace std;

int solve()
{
    int N, K;
    cin >> N >> K;

    int A[N];
    for (auto i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    
    int c = 0;
    int k = 0;
    for (auto i = N-1; i > 0; i--)
    {
        if (A[i] == 1) k = 1;
        if (k > 0 && A[i-1]-1 == A[i]) k++;
        if (A[i-1]-1 != A[i]) k = 0;
        if (k == K) {
            c++;
            k = 0;
        }
    }

    return c;
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
