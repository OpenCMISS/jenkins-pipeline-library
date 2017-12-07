#!/usr/bin/groovy

def call() {
    String jobName = "${env.JOB_NAME}";
    
    String rootName = "opencmiss";
    if (jobName.contains("Dependencies")) {
        rootName = "opencmiss_dependencies"; 
    }

    dir ('./setup-build') {
        deleteDir()
    }
    dir ('./${rootName}/build') {
        deleteDir()
    }
    dir ('./${rootName}/install') {
        deleteDir()
    }
}

