cmake_minimum_required(VERSION 3.9)
project(Server)

set(CMAKE_CXX_STANDARD 17)

add_executable(Server client.cpp server.cpp)