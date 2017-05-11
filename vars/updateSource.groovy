#!/usr/bin/groovy

def call() {
    String nodeName = "${env.NODE_NAME}";

    if (nodeName.startsWith("Windows")) {
        dir('./opencmiss/build/manage/') {
            bat '"C:\\Program Files\\CMake\\bin\\cmake.exe" --build . --target update_all --config Release'
        }
    } else {
        dir ('./opencmiss/build/manage/release') {
            sh 'make update_all'
        }
    }
}

