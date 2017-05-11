#!/usr/bin/groovy

def call() {
    def nodeName = ${env.NODE_NAME}
    echo 'hi'

    if (nodeName.startsWith('Ubuntu')) {
        println 'yes matching machine!'
    } else {
        println 'bummer not matched'
    }
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

