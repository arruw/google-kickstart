#!/bin/bash

YEAR=$1
ROUND=$2
PROBLEM=$3
EXT=${4:-cpp}

mkdir -p rounds/$YEAR/$ROUND/files

CODE="rounds/$YEAR/$ROUND/$PROBLEM.$EXT"
STDIN="rounds/$YEAR/$ROUND/files/$PROBLEM.stdin"
STDOUT="rounds/$YEAR/$ROUND/files/$PROBLEM.stdout"

if  [ ! -f $CODE ]; then
    cp .template/code.$EXT $CODE && echo "Created $CODE"
fi

if  [ ! -f $CODE ]; then
    cp .template/files/code.stdin  $STDIN   && echo "Created $STDIN"
fi

if  [ ! -f $CODE ]; then
    cp .template/files/code.stdout $STDOUT  && echo "Created $STDOUT"
fi

code -r $CODE $STDIN $STDOUT