#!/bin/bash

# See "Platform" section for details: https://codingcompetitions.withgoogle.com/kickstart/faq

PROBLEM=$1
EXT=${2:-.cpp}

if [ "$EXT" = ".cpp" ]; then
    echo "[C++] $PROBLEM/Solution.cpp" 
    g++ $PROBLEM/Solution.cpp -std=c++14 -pthread -O3 -o $PROBLEM/Solution.out
    diff --color=always -ys -EZb $PROBLEM/.stdout <($PROBLEM/Solution.out < $PROBLEM/.stdin)
elif [ "$EXT" = ".py" ]; then
    echo "[Python3] $PROBLEM/Solution.py" 
    diff --color=always -ys -EZb $PROBLEM/.stdout <(python3 $PROBLEM/Solution.py < $PROBLEM/.stdin)
elif [ "$EXT" = ".java" ]; then
    echo "[Java] $PROBLEM/Solution.java" 
    javac $PROBLEM/Solution.java
    diff --color=always -ys -EZb $PROBLEM/.stdout <(java -Xms896m -Xmx896m -Xss64m -XX:+UseSerialGC -cp $PROBLEM Solution < $PROBLEM/.stdin)
else
    echo "Extension '$EXT' not supported."
    exit 1
fi