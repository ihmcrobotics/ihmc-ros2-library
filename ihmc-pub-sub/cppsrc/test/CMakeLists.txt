cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

add_executable(SerializationTest IDLElementTest IDLElementTestPubSubTypes NestedElement idlelementserializetest)
target_link_libraries(SerializationTest ${FastRTPS_LIBRARIES})
