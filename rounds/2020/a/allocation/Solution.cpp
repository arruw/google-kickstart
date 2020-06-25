#include <bits/stdc++.h>
using namespace std;

int solve()
{
    int N, B;
    cin >> N >> B;
    vector<int> A(N);
    for (auto i = 0; i < N; i++)
        cin >> A[i];

    sort(A.begin(), A.end());

    int sum = 0;
    int result = 0;
    for (auto i = 0; i < N; i++)
    {
        if (sum + A[i] > B) continue;

        sum += A[i];
        ++result;
    }
    
    return result;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(false);
	cin.tie(NULL);

    int T = 0;
    cin >> T;
    for (auto x = 1; x <= T; x++)
    {
        auto y = solve();
        cout << "Case #" << x << ": " << y << endl;
    }
    
    return 0;
}
