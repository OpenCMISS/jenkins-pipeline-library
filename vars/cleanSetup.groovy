#!/usr/bin/groovy

def call(String rootName) {
    dir ('./setup-build') {
        echo 'delete setup-build'
        deleteDir()
    }
    dir ('./${rootName}/build') {
        echo 'delete ${directory}/build'
        deleteDir()
    }
    dir ('./${rootName}/install') {
        echo 'delete ${directory}/install'
        deleteDir()
    }
}

