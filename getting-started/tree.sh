#!/usr/bin/env bash
COMMAND="tree --noreport --dirsfirst -I 'target|tree.sh|tree.txt|test.sh|test.txt|dependency-tree.sh|dependency-tree.txt|getting-started.iml|bootstrap.sh'"
eval "$COMMAND" > tree.txt
