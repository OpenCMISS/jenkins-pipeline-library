#!/usr/bin/groovy

import jenkins.model.Jenkins

def call() {
    echo 'hi'
    echo '${NODE_NAME}'
    def envVars = Jenkins.instance.getGlobalNodeProperties()[0].getEnvVars()
    echo 'hi'
    def nodeName = envVars['NODE_NAME']
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

