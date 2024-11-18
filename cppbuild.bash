#!/bin/bash
# This build script is designed to work on Linux and Windows. For Windows, run from a bash shell launched with launchBashWindows.bat

REPO_ROOT=$(pwd)
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

# Generate Java from eprosima XML
xjc -p com.eprosima.xmlschemas.fastrtps_profiles -d $REPO_ROOT/ihmc-pub-sub/src/xjc/java $REPO_ROOT/ihmc-pub-sub/thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd

find "$REPO_ROOT/ihmc-pub-sub/src/xjc/java" -type f -name "*.java" -print0 | while IFS= read -r -d '' file; do
  # Replace javax.xml.* with jakarta.xml.*, but ignore javax.xml.namespace.QName
  # Replace @javax.xml.bind.annotation.* with @jakarta.xml.bind.annotation.*
  sed -i '
      /import javax\.xml\.namespace\.QName/!s/import javax\.xml\./import jakarta.xml./g
      s/@javax\.xml\.bind\.annotation\./@jakarta.xml.bind.annotation./g
      s/javax\.xml\.bind\.annotation\.XmlNsForm/jakarta.xml.bind.annotation.XmlNsForm/g
  ' "$file"
done

if [ "$ONLY_CLONE_AND_PATCH" == "1" ]; then
  exit 0
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
