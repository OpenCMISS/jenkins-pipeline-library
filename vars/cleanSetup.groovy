#!/usr/bin/groovy

def call(String rootName) {
    def workspace = pwd()
    dir ('./setup-build') {
        echo 'delete setup-build'
        deleteDir()
    }
    dir ('./${rootName}/build') {
        echo "delete ${workspace}/${rootName}/build"
        deleteDir()
    }
    dir ('./${rootName}/install') {
        echo "delete ${workspace}/${rootName}/install"
        deleteDir()
    }
}

