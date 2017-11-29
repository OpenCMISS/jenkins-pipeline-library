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
            try {
                sh 'make update_all'
            } catch () {
                echo 'Error trying to update_all.'
            }
        }
        dir("./${rootName}/src/cmake_modules/") {
                sh 'git pull'
        }
        dir("./${rootName}/src/manage/") {
                sh 'git pull'
        }
    }
}

