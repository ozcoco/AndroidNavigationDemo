# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

#compile configure
#cppFlags "-std=c++11 -frtti -fexceptions -D__STDC_FORMAT_MACROS"
#cFlags "-D_EXAMPLE_C_FLAG1", "-D_EXAMPLE_C_FLAG2"

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -D_EXAMPLE_C_FLAG1 -D_EXAMPLE_C_FLAG2 -Wall")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14 -frtti -fexceptions -D__STDC_FORMAT_MACROS -Wall")

# openGL Supportability
# platform         status
#   (0 12)           ES2/ES3 not supported
#   [12, 18)         ES2 only, for ES3, app do dynamic load
#   [18, 24)         ES2 & ES3
#   [24, infinite)   ES2 & ES3 & Vulkan

if (${ANDROID_PLATFORM_LEVEL} LESS 12)
  message(FATAL_ERROR "OpenGL 2 is not supported before API level 11 (currently using ${ANDROID_PLATFORM_LEVEL}).")
  return()
elseif (${ANDROID_PLATFORM_LEVEL} LESS 18)
  add_definitions("-DDYNAMIC_ES3")
  set(OPENGL_LIB GLESv2)
else ()
  set(OPENGL_LIB GLESv3)
endif (${ANDROID_PLATFORM_LEVEL} LESS 11)


message(STATUS "-------------------------------->CMAKE_SOURCE_DIR:         " ${CMAKE_SOURCE_DIR})

aux_source_directory(${CMAKE_SOURCE_DIR} MY_NATIVE_LIB_SRC)

set(MY_MODULE_DIR "${CMAKE_SOURCE_DIR}/../../..")

message(STATUS "-------------------------------->MY_MODULE_DIR:         " ${MY_MODULE_DIR})

#libevent ^_^ ---->

#set(MY_LIBEVENT_DIR ${MY_MODULE_DIR}/thirdparty/libevent-2.1.8/${ANDROID_ABI})

set(MY_FFMPEG_DIR ${MY_MODULE_DIR}/src/ffmpeg/${ANDROID_ABI})

include_directories(${CMAKE_SOURCE_DIR}
                    ${MY_MODULE_DIR}/src/ffmpeg/include/)

#add_library(event SHARED IMPORTED)
#
#set_target_properties(event
#                      PROPERTIES IMPORTED_LOCATION
#                      ${MY_LIBEVENT_DIR}/libevent.so)

#add_library(event_core SHARED IMPORTED)
#
#set_target_properties(event_core
#                      PROPERTIES IMPORTED_LOCATION
#                      ${MY_LIBEVENT_DIR}/libevent_core.so)

#add_library(event_extra SHARED IMPORTED)
#
#set_target_properties(event_extra
#                      PROPERTIES IMPORTED_LOCATION
#                      ${MY_LIBEVENT_DIR}/libevent_extra.so)

#libevent <---- ^_^


#ffmpeg ^_^ ---->

add_library(avcodec SHARED IMPORTED)

set_target_properties(avcodec PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libavcodec.so)

add_library(avdevice SHARED IMPORTED)

set_target_properties(avdevice PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libavdevice.so)

add_library(avfilter SHARED IMPORTED)

set_target_properties(avfilter PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libavfilter.so)

add_library(avformat SHARED IMPORTED)

set_target_properties(avformat PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libavformat.so)

add_library(avutil SHARED IMPORTED)

set_target_properties(avutil PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libavutil.so)

add_library(swresample SHARED IMPORTED)

set_target_properties(swresample PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libswresample.so)

add_library(swscale SHARED IMPORTED)

set_target_properties(swscale PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libswscale.so)

#add_library(postproc SHARED IMPORTED)
#set_target_properties(postproc PROPERTIES IMPORTED_LOCATION ${MY_FFMPEG_DIR}/libpostproc.so)

#ffmpeg <---- ^_^


add_library(native-lib SHARED ${MY_NATIVE_LIB_SRC})

target_link_libraries(native-lib
                      android
                      log
                      ${OPENGL_LIB}
                      EGL
                      m
                      swscale
                      swresample
                      avutil
                      avformat
                      avfilter
                      avdevice
                      avcodec)


