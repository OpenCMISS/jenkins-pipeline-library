#!/usr/bin/groovy

def call() {
    println 'hi ${env.NODE_NAME}'
    String nodeName = '${env.NODE_NAME}';
    println 'hi ${env.NODE_NAME}'
    println nodeName

    if (nodeName.startsWith('Ubuntu')) {
        println 'yes matching machine!'
    } else {
        println 'bummer not matched'
    }
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

