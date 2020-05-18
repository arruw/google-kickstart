#!/bin/bash

ROUND=$1
PROBLEM=$2

mkdir -p rounds/$ROUND/files

CODE="rounds/$ROUND/$PROBLEM.cpp"
STDIN="rounds/$ROUND/files/$PROBLEM.stdin"
STDOUT="rounds/$ROUND/files/$PROBLEM.stdout"

if  [ -f $CODE ]; then
    echo "File $CODE already exists, exiting..."
    exit 1
fi

cp .template/code.cpp $CODE && echo "Created $CODE"
cp .template/files/code.stdin  $STDIN   && echo "Created $STDIN"
cp .template/files/code.stdout $STDOUT  && echo "Created $STDOUT"

code -r $CODE $STDIN $STDOUT