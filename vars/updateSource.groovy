#!/usr/bin/groovy

def call() {
    echo 'hi ${env.NODE_NAME}'
    String nodeName = ${env.NODE_NAME};
    echo 'hi ${env.NODE_NAME}'

    if (nodeName.startsWith('Ubuntu')) {
        println 'yes matching machine!'
    } else {
        println 'bummer not matched'
    }
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

