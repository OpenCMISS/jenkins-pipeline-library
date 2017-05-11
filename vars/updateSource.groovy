#!/usr/bin/groovy

import jenkins.model.Jenkins

def call() {
    echo 'hi'
    def nodeName = System.getenv("NODE_NAME")
    echo 'hi'
    println nodeName
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

