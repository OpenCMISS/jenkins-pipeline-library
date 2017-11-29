#!/usr/bin/groovy

def call() {
    String nodeName = "${env.NODE_NAME}";
    String jobName = "${env.JOB_NAME}";
    
    String rootName = "opencmiss";
    if (jobName.contains("Dependencies")) {
        rootName = "opencmiss_dependencies"; 
    }

    if (nodeName.startsWith("Windows")) {
        dir("./${rootName}/build/manage/") {
            bat '"C:\\Program Files\\CMake\\bin\\cmake.exe" --build . --target update_all --config Release'
        }
        dir("./${rootName}/src/cmake_modules/") {
            bat 'git pull'
        }
        dir("./${rootName}/src/manage/") {
            bat 'git pull'
        }
    } else {
        dir ("./${rootName}/build/manage/release") {
            if (fileExists('CMakeCache.txt') {
                sh 'make update_all'
            } else {
                echo 'No CMakeCache.txt file.'
            }
        }
        dir("./${rootName}/src/cmake_modules/") {
            if (fileExists('CMakeLists.txt') {
                sh 'git pull'
            } else {
                echo 'No CMakeLists.txt file.'
            }
        }
        dir("./${rootName}/src/manage/") {
            if (fileExists('CMakeLists.txt') {
                sh 'git pull'
            } else {
                echo 'No CMakeLists.txt file.'
            }
        }
    }
}

