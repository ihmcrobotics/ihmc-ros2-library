#!/bin/bash
# Uncomment for debugging this script
set -o xtrace

cd build

cmake -DCMAKE_BUILD_TYPE=Release -DSTANDALONE_PLUGIN=ON ..
make
make install/strip
