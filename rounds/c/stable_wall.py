from typing import Tuple, List, Set
from itertools import permutations

def place(WALL, R: int, C: int, r: int, c: int, ground: Set[Tuple[int, int]]) -> Tuple[Set[Tuple[int, int]], bool]:
    tmp_ground = set(ground)

    x = WALL[r][c]
    queue = [(r, c)]
    while queue:
        rn, cn = queue.pop(0)

        if 0 > rn or rn >= R or 0 > cn or cn >= C: continue # off the grid
        y = WALL[rn][cn]
        if y != x: continue # not of the same type
        if (rn, cn) in tmp_ground: continue # already placed

        # can not place it
        if rn < R-1 and (rn+1, cn) not in tmp_ground:
            return (ground, False) 
        
        tmp_ground.add((rn, cn))
        
        queue.append((rn, cn-1))
        queue.append((rn, cn+1))
        queue.append((rn-1, cn-1))
        queue.append((rn-1, cn))
        queue.append((rn-1, cn+1))
    
    return (tmp_ground, True)


def solve():
    R, C = map(int, input().split(' '))
    WALL = []
    for _ in range(R):
        WALL.append(input())
    result = ''

    ground = set()
    for r in range(R-1, -1, -1):
        
        # find blocks in the row
        blocks = dict()
        for c in range(C):
            if (r, c) not in ground:
                blocks[WALL[r][c]] = (r, c)
        blocks = list(blocks.items())

        # place all the block
        for _ in blocks:
            has_solution = False
            # try placing one block at most once
            for x, rc in blocks:
                if rc in ground: continue
                ground, is_placed = place(WALL, R, C, *rc, ground)
                if is_placed:
                    has_solution = True
                    result += x
                    break

            # no solution
            if not has_solution:
                return '-1'

    return result


def valid(WALL, R, C, permutation):
    order = {o: i for i, o in enumerate(permutation)}
    for r in range(R-2, -1, -1):
        for c in range(C):
            if order[WALL[r][c]] < order[WALL[r+1][c]]:
                return False

    return True

def solve2():
    R, C = map(int, input().split(' '))
    CHARS = set()
    WALL = []
    for _ in range(R):
        row = input()
        CHARS |= set(row)
        WALL.append(row)

    if R == 1 or C == 1:
        return ''.join(CHARS)

    for p in permutations(CHARS, len(CHARS)):
        if valid(WALL, R, C, p):
            return ''.join(p)
        
    return '-1'


def main():
    T = int(input())
    for t in range(T):
        print('Case #{}: {}'.format(t+1, solve2()))


if __name__ == "__main__":
    main()
