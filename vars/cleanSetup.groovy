#!/usr/bin/groovy

def call() {
    dir ('./setup-build') {
        deleteDir()
    }
    dir ('./opencmiss/build') {
        deleteDir()
    }
    dir ('./opencmiss/install') {
        deleteDir()
    }
}

