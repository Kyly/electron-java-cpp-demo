cmake_minimum_required(VERSION 3.6)
project(HelloWorld)

set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES HelloWorld.cpp HelloWorld.hpp)
add_library(HelloWorld SHARED ${SOURCE_FILES})

install(TARGETS HelloWorld LIBRARY DESTINATION lib)