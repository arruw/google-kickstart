import operator

from typing import Tuple, List, Set

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
        
        queue.append((rn-1, cn))
        queue.append((rn+1, cn))
        queue.append((rn, cn-1))
        queue.append((rn, cn+1))
    
    return (tmp_ground, True)


def solve():
    R, C = map(int, input().split(' '))
    WALL = []
    for _ in range(R):
        WALL.append(input())
    result = ''

    ground = set()
    for r in range(R-1, -1, -1):
        
        has_solution = False
        # while is_placed:

        blocks = dict()
        for c in range(C):
            if (r, c) not in ground:
                blocks[WALL[r][c]] = (r, c)
        blocks = list(blocks.items())

        while blocks:
            x, rc = blocks.pop(0)
            if x in ground: continue
            ground, is_placed = place(WALL, R, C, *rc, ground)
            if not is_placed:
                blocks.append((x, rc))
            else:
                # is_placed = True
                result += x

    return result

def main():
    T = int(input())
    for t in range(T):
        print(f'Case #{t+1}: {solve()}')


if __name__ == "__main__":
    main()
