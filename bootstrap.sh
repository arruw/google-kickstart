#!/bin/bash

YEAR=$1
ROUND=$2
PROBLEM=$3
EXT=${4:-cpp}

mkdir -p rounds/$YEAR/$ROUND/$PROBLEM/

CODE="rounds/$YEAR/$ROUND/$PROBLEM/Solution.$EXT"
STDIN="rounds/$YEAR/$ROUND/$PROBLEM/.stdin"
STDOUT="rounds/$YEAR/$ROUND/$PROBLEM/.stdout"

if  [ ! -f $CODE ]; then
    cp .template/code.$EXT $CODE && echo "Created $CODE"
fi

if  [ ! -f $STDIN ]; then
    touch  $STDIN   && echo "Created $STDIN"
fi

if  [ ! -f $STDOUT ]; then
    touch $STDOUT  && echo "Created $STDOUT"
fi

code -r $CODE $STDIN $STDOUT