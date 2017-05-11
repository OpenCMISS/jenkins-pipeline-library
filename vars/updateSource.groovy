#!/usr/bin/groovy

import jenkins.model.Jenkins

def call() {
    echo 'hi'
    echo '${NODE_NAME}'
    echo ${NODE_NAME}
    def envVars = Jenkins.instance.getGlobalNodeProperties()[0].getEnvVars()
    def nodeName = envVars['NODE_NAME']
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

