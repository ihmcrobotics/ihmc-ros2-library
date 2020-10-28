#   This helper finds or downloads the OpenJDK to include in the project.
#
#   A custom target "JDK" is defined that pulls in the JDK dependency if JNI does not found a system installation.
#
#   Variables set:
#   
#   JNI_INCLUDE_DIRS

find_package(JNI QUIET)

if(JNI_FOUND)
    message(STATUS "Found JNI. Using system installation")
    add_custom_target(JDK)
else()
    include(ExternalProject)

    # Unset cache variables from FindJNI, not used here.
    unset(JAVA_AWT_LIBRARY CACHE)
    unset(JAVA_JVM_LIBRARY CACHE)
    unset(JAVA_INCLUDE_PATH CACHE)
    unset(JAVA_INCLUDE_PATH2 CACHE)
    unset(JAVA_AWT_INCLUDE_PATH CACHE)
    
    # Unset libraries
    unset(JNI_INCLUDE_DIRS)

    if(WIN32)
        SET(JDK_URL "https://cdn.azul.com/zulu/bin/zulu8.44.0.11-ca-jdk8.0.242-win_x64.zip")
    elseif(APPLE)
        SET(JDK_URL "https://cdn.azul.com/zulu/bin/zulu8.44.0.11-ca-jdk8.0.242-macosx_x64.zip")
    else()
        SET(JDK_URL "https://cdn.azul.com/zulu/bin/zulu8.44.0.11-ca-jdk8.0.242-linux_x64.tar.gz")
    endif()
    
    message(STATUS "JNI not found, downloading from ${JDK_URL}")

    ExternalProject_Add(JDK
        PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/JDK"
        URL "${JDK_URL}"
        CONFIGURE_COMMAND ""
        BUILD_COMMAND ""
        INSTALL_COMMAND ""
    )
    
    ExternalProject_Get_Property(JDK source_dir)

    set(JAVA_INCLUDE_PATH "${source_dir}/include")
    SET(JAVA_INCLUDE_PATH2 
        ${JAVA_INCLUDE_PATH}/darwin
        ${JAVA_INCLUDE_PATH}/win32
        ${JAVA_INCLUDE_PATH}/linux
        ${JAVA_INCLUDE_PATH}/freebsd
        ${JAVA_INCLUDE_PATH}/openbsd
        ${JAVA_INCLUDE_PATH}/solaris
        ${JAVA_INCLUDE_PATH}/hp-ux
        ${JAVA_INCLUDE_PATH}/alpha
        ${JAVA_INCLUDE_PATH}/aix
    )

    set(JNI_INCLUDE_DIRS
        ${JAVA_INCLUDE_PATH}
        ${JAVA_INCLUDE_PATH2}
        ${JAVA_AWT_INCLUDE_PATH}
    )
endif()

unset(JNI_LIBRARIES)
