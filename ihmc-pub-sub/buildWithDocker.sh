#!/bin/bash
# Uncomment for debugging this script
set -o xtrace

# Make sure it works one way or the other to reduce possible errors
if (( EUID == 0 )); then
    echo "Run without sudo." 1>&2
    exit 1
fi

mkdir -p buildDocker

if [ ! "$(sudo -u root docker ps -a | grep pub-sub)" ]; then
    echo "pub-sub not found. Running new container."
    sudo -u root docker run \
        --tty \
        --interactive \
        --name pub-sub \
        --network host \
        --dns=1.1.1.1 \
        --volume "$(pwd)/../.git":/home/robotlab/dev/.git \
        --volume "$(pwd)/buildDocker":/home/robotlab/dev/ihmc-pub-sub/build \
        --volume "$(pwd)/cmake":/home/robotlab/dev/ihmc-pub-sub/cmake \
        --volume "$(pwd)/cppsrc":/home/robotlab/dev/ihmc-pub-sub/cppsrc \
        --volume "$(pwd)/src":/home/robotlab/dev/ihmc-pub-sub/src \
        --volume "$(pwd)/swig":/home/robotlab/dev/ihmc-pub-sub/swig \
        --volume "$(pwd)/thirdparty":/home/robotlab/dev/ihmc-pub-sub/thirdparty \
        --volume "$(pwd)/build.gradle.kts":/home/robotlab/dev/ihmc-pub-sub/build.gradle.kts \
        --volume "$(pwd)/gradle.properties":/home/robotlab/dev/ihmc-pub-sub/gradle.properties \
        --volume "$(pwd)/settings.gradle.kts":/home/robotlab/dev/ihmc-pub-sub/settings.gradle.kts \
        --volume "$(pwd)/CMakeLists.txt":/home/robotlab/dev/ihmc-pub-sub/CMakeLists.txt \
        --volume "$(pwd)/build.sh":/home/robotlab/dev/ihmc-pub-sub/build.sh \
        ihmcrobotics/pub-sub:0.2
else
    sudo -u root docker start --attach pub-sub
fi
