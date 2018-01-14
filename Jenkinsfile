node {
    def mvnHome = tool 'Maven3'
    def mvn = "${mvnHome}/bin/mvn"
    
    stage ("Stage hola mundo") {
        echo 'Hola mundo'
    }
    stage ("Stage agregando repositorio") {
        git 'https://github.com/phalcon30964/Learning.git'
    }
    stage ("Stage compilacion") {
        sh "${mvn} clean install"
    }
}
