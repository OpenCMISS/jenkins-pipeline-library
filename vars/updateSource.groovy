#!/usr/bin/groovy

def call() {
    if (${NODE_NAME}.startsWith('Ubuntu')) {
        echo 'yes matching machine!'
    } else {
        echo 'bummer not matched'
    }
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

