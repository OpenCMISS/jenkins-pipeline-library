#!/usr/bin/groovy

def call(String rootName) {
    dir ('./setup-build') {
        echo 'delete ./setup-build'
        deleteDir()
    }
    dir ("./${rootName}/build") {
        echo "delete ./${rootName}/build"
        deleteDir()
    }
    dir ("./${rootName}/install") {
        echo "delete ./${rootName}/install"
        deleteDir()
    }
}

