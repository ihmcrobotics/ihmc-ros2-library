#!/bin/bash
# Uncomment for debugging this script
set -o xtrace

# Make sure it works one way or the other to reduce possible errors
if (( EUID == 0 )); then
    echo "Run without sudo." 1>&2
    exit 1
fi

sudo -u $(whoami) xhost +local:docker

if [ ! "$(sudo -u root docker ps -a | grep pub-clion)" ]; then
    echo "pub-clion not found. Running new container."
    sudo -u root docker run \
        --tty \
        --name pub-clion \
        --network host \
        --dns=1.1.1.1 \
        --privileged \
        --gpus all \
        --device /dev/dri:/dev/dri \
        --env "DISPLAY" \
        --volume "/tmp/.X11-unix:/tmp/.X11-unix:rw" \
        --volume "$HOME"/.ihmc/docker/pub-sub/JetBrains:/home/robotlab/.config/JetBrains:rw \
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
        --volume /usr/share/fonts:/usr/share/fonts \
        ihmcrobotics/pub-sub:0.2 clion
    else
    sudo -u root docker start --attach pub-clion
fi
