#!/bin/sh

gradle distTar

tar xvf build/distributions/ihmc-pub-sub-generator-0.18.2.tar -C build

IDL_GENERATOR_OPTS="-Dwrite-preprocessed-checksum-idl=true -Dlog.level=debug" build/ihmc-pub-sub-generator-0.18.2/bin/IDLGenerator src/test/idl/IDLElementTest.idl test_msgs build
