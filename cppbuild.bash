#!/bin/bash
# This build script is designed to work on Linux and Windows. For Windows, run from a bash shell launched with launchBashWindows.bat

if [ -z "$1" ]; then
  REPO_ROOT=$(pwd)
else
  REPO_ROOT=$1
fi

BUILD_ROOT=$REPO_ROOT/ihmc-pub-sub/buildc

rm -rf $BUILD_ROOT # Optional clean
mkdir -p $BUILD_ROOT

#### Update git submodules ####
git submodule update --init --recursive
cd $REPO_ROOT/ihmc-pub-sub/thirdparty/Fast-RTPS
git reset --hard
cd $REPO_ROOT

#### Apply patches ####
patch $REPO_ROOT/ihmc-pub-sub/thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd $REPO_ROOT/ihmc-pub-sub/patches/fastRTPS_profiles.patch

if [ "$JUST_CLONE_AND_PATCH" == "1" ]; then
  exit
fi

#### Building FastDDS, ihmc-pub-sub natives ####
cd $BUILD_ROOT
if [ "$MAC_CROSS_COMPILE_ARM" == "1" ]; then
  cmake -DCMAKE_BUILD_TYPE=Release \
        -DSTANDALONE_PLUGIN=ON \
        -DCMAKE_TOOLCHAIN_FILE=../macos-aarch64-toolchain.cmake \
        ..
elif [ "$LINUX_CROSS_COMPILE_ARM" == "1" ]; then
  cmake -DCMAKE_BUILD_TYPE=Release \
        -DSTANDALONE_PLUGIN=ON \
        -DCMAKE_TOOLCHAIN_FILE=../linux-aarch64-toolchain.cmake \
        ..
else
  cmake -DCMAKE_BUILD_TYPE=Release \
        -DSTANDALONE_PLUGIN=ON \
        ..
fi
cmake --build . --config Release --target install
cd $REPO_ROOT
