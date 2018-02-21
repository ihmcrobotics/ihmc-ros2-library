cmake_minimum_required(VERSION 3.1)
project(IHMCJavaRTPS)

add_executable(SerializationTest IDLElementTest IDLElementTestPubSubTypes NestedElement idlelementserializetest)
target_link_libraries(SerializationTest ${FastRTPS_LIBRARIES})


