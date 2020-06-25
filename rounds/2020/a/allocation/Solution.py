def solve():
    N, B = map(int, input().split(' '))
    A = list(map(int, input().split(' ')))

    result = 0
    total = 0
    for Ai in sorted(A):
        if total + Ai > B: break
        total += Ai
        result += 1

    return result


def main():
    T = int(input())
    for t in range(T):
        print('Case #{}: {}'.format(t+1, solve()))


if __name__ == "__main__":
    main()
