#!/bin/bash

ROUND=$1
PROBLEM=$2

g++ $ROUND/$PROBLEM.cpp -std=c++14 -pthread -O3 -o test.out

diff --color=always -ys -EZb $ROUND/files/$PROBLEM.stdout <(./test.out < $ROUND/files/$PROBLEM.stdin)