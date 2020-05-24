#include <iostream>
#include <stack> 

using namespace std;

struct state
{
  int w;
  int h;
};

state solve() {
  
  string P;
  cin >> P;

  const int limit = 1000000000;
  state s = {1, 1};
  int i = 0;
  stack<int> n;
  n.push(1);

  while(i < P.length()) {
    switch (P[i])
    {
      case 'N':
        s.h -= n.top();
        break;
      case 'S':
        s.h += n.top();
        break;
      case 'E':
        s.w += n.top();
        break;
      case 'W':
        s.w -= n.top();
        break;
      case '(':
        break;
      case ')':
        n.pop();
        break;
      default:
        n.push((P[i] - '0') * n.top());
        break;
    }
    i++;
  }

  s.w %= limit;
  s.h %= limit;
  if(s.w <= 0) s.w = limit + s.w;
  if(s.h <= 0) s.h = limit + s.h;

  return s;
}

int main(int argc, char const *argv[])
{
    int T;
    cin >> T;
    for (auto x = 1; x <= T; x++)
    {
        auto y = solve();

        cout << "Case #" << x << ": " << y.w << " " << y.h << endl;
    }
    
    return 0;
}
