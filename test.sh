#!/bin/bash

ROUND=$1
PROBLEM=$2
EXT=${3:-.cpp}

if [ "$EXT" = ".cpp" ]; then
    echo "[C++] $ROUND/$PROBLEM$EXT" 
    g++ $ROUND/$PROBLEM$EXT -std=c++14 -pthread -O3 -o test.out
    diff --color=always -ys -EZb $ROUND/files/$PROBLEM.stdout <(./test.out < $ROUND/files/$PROBLEM.stdin)
elif [ "$EXT" = ".py" ]; then
    echo "[Python3] $ROUND/$PROBLEM$EXT" 
    diff --color=always -ys -EZb $ROUND/files/$PROBLEM.stdout <(python3 $ROUND/$PROBLEM$EXT < $ROUND/files/$PROBLEM.stdin)
else
    echo "Extension '$EXT' not supported."
    exit 1
fi