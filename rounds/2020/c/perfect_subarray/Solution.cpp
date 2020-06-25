#include <iostream>
#include <math.h>
#include <unordered_set>

using namespace std;


int  sum[100001];

bool possible(const int x) {
    int y = x % 10;
    return (y == 0) || (y == 1) || (y == 4) || (y == 5) || (y == 6) || (y == 9);
}

int solve(unordered_set<int> &s)
{
    int N;
    cin >> N;

    int ai;
    sum[0] = 0;
    for (auto i = 1; i <= N; i++)
    {
        cin >> ai;
        sum[i] = sum[i-1] + ai;
    }


    int c = 0;
    int sas;
    double intpart;
    for (auto i = 0; i < N; i++)
    {
        for (auto j = i+1; j <= N; j++)
        {
            sas = sum[j] - sum[i];
            if (sas<0)
                continue;

            if (s.count(sas))
            {
                c++;
            }
            else if (possible(sas) && modf(sqrt(sas), &intpart) == 0.0)
            {
                s.insert(sas);
                c++;
            }
        }
        
    }
    

    return c;
}

int main(int argc, char const *argv[])
{
    int T;
    cin >> T;

    unordered_set<int> s;
    for (auto x = 1; x <= T; x++)
    {
        auto y = solve(s);

        cout << "Case #" << x << ": " << y << endl;
    }
    
    return 0;
}
