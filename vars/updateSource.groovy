#!/usr/bin/groovy

def call(String rootName) {
    String nodeName = "${env.NODE_NAME}";
    String jobName = "${env.JOB_NAME}";
    
    if (nodeName.startsWith("Windows")) {
        dir("./${rootName}/build/manage/") {
            try {
                bat '"C:\\Program Files\\CMake\\bin\\cmake.exe" --build . --target update_all --config Release'
            } catch (Exception ex) {
                echo 'Error trying to update_all.'
            }
        }
        dir("./${rootName}/src/cmake_modules/") {
            try {
                bat 'git pull'
            } catch (Exception ex) {
                echo 'Error trying to update CMake modules.'
            }
        }
        dir("./${rootName}/src/manage/") {
            try {
                bat 'git pull'
            } catch (Exception ex) {
                echo 'Error trying to update manage.'
            }
        }
    } else {
        dir ("./${rootName}/build/manage/release") {
            try {
                sh 'make update_all'
            } catch (Exception ex) {
                echo 'Error trying to update_all.'
            }
        }
        dir("./${rootName}/src/cmake_modules/") {
            try {
                sh 'git pull'
            } catch (Exception ex) {
                echo 'Error trying to update CMake modules.'
            }
        }
        dir("./${rootName}/src/manage/") {
            try {
                sh 'git pull'
            } catch (Exception ex) {
                echo 'Error trying to update manage.'
            }
        }
    }
}

