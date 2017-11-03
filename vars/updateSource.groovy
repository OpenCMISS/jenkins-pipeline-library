#!/usr/bin/groovy

def call() {
    String nodeName = "${env.NODE_NAME}";
    String jobName = "${env.JOB_NAME}";
    
    String rootName = "opencmiss";
    if (jobName.contains("Dependencies") {
        rootName = "opencmiss_dependencies"; 
    }

    if (nodeName.startsWith("Windows")) {
        dir("./${rootName}/build/manage/") {
            bat '"C:\\Program Files\\CMake\\bin\\cmake.exe" --build . --target update_all --config Release'
        }
    } else {
        dir ("./${rootName}/build/manage/release") {
            sh 'make update_all'
        }
    }
}

