#include <iostream>

using namespace std;

int solve() {
  int N, D;
  cin >> N >> D;
  int X[N], Y[N];

  for (auto i = 0; i < N; i++)
  {
    cin >> X[i];
    Y[i] = D - D % X[i];
  }

  int i = 0;
  while(i < N-1)
  {
    if (Y[i] > Y[i+1])
    {
      Y[i] = Y[i+1] - Y[i+1] % X[i];
      i = max(0, i-1);
    } 
    else
    {
      i++;
    }
  }
  
  return Y[0];
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
