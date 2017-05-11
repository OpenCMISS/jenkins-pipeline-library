#!/usr/bin/groovy

import jenkins.model.Jenkins

def call() {
    echo 'hi'
    def nodeName = System.getenv('NODE_NAME')
    echo 'hi'
    echo nodeName
    echo 'hi'
    println nodeName
    echo 'hi'
    println "node_name=${env.NODE_NAME}"

    if (nodeName.startsWith('Ubuntu')) {
        println 'yes matching machine!'
    } else {
        println 'bummer not matched'
    }
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

