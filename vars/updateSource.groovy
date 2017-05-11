#!/usr/bin/groovy

def call() {
    dir ('./opencmiss/build/manage/release') {
        sh 'make update_all'
    }
}

