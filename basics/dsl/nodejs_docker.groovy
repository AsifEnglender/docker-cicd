job('NodeJS Docker example') {
    scm {
        git('https://github.com/AsifEnglender/docker-cicd.git','master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@devophift.work')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
   
    
    steps {
        dockerBuildAndPublish {
            repositoryName('asifeng/newjenkinstest')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('8d2f03eb-cc76-4a1a-b749-6cfd5caa566c')
            buildContext('./basics/')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

