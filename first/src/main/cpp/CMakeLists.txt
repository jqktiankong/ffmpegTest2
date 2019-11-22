cmake_minimum_required(VERSION 3.4.1)

#获取上级目录的路径
get_filename_component(PARENT_DIR ${PROJECT_SOURCE_DIR} PATH)

#add libavcodec
add_library(libavcodec
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libavcodec
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libavcodec.so
)

#add libavdevice
add_library(libavdevice
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libavdevice
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libavdevice.so
)

#add libavfilter
add_library(libavfilter
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libavfilter
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libavfilter.so
)


#add libavformat
add_library(libavformat
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libavformat
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libavformat.so
)


#add libavutil
add_library(libavutil
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libavutil
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libavutil.so
)


#add libpostproc
add_library(libpostproc
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libpostproc
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libpostproc.so
)

#add libswresample
add_library(libswresample
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libswresample
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libswresample.so
)

#add libswscale
add_library(libswscale
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libswscale
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libswscale.so
)

#add libavresample
add_library(libavresample
        SHARED
        IMPORTED
        )

SET_TARGET_PROPERTIES(
        libavresample
        PROPERTIES IMPORTED_LOCATION
        ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libavresample.so
)

add_library(
        helloworld
        SHARED
        ffmpeg_helloworld.c)

#头文件
include_directories(
        ffmpeg/
        src/main/cpp/)

find_library(
        log-lib
        log)

target_link_libraries(
        helloworld

        libavcodec
        libavdevice
        libswscale
        libswresample
        libpostproc
        libavutil
        libavformat
        libavfilter
        libavresample
        ${log-lib})