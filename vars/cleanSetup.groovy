#!/usr/bin/groovy

def call(String directory) {
    dir ('./setup-build') {
        echo 'delete setup-build'
        deleteDir()
    }
    dir ('./${directory}/build') {
        echo 'delete ${directory}/build'
        deleteDir()
    }
    dir ('./${directory}/install') {
        echo 'delete ${directory}/install'
        deleteDir()
    }
}

