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
            repositoryName('asifeng/newjenkinstest2')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('c5c3af58-5a12-40a9-bb06-4b7d99655c03')
            buildContext('./basics/')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

