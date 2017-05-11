#!/usr/bin/groovy

def call() {
    echo 'hi'
    echo '${NODE_NAME}'

    if (${NODE_NAME}.startsWith('Ubuntu')) {
        println 'yes matching machine!'
    } else {
        println 'bummer not matched'
    }
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

