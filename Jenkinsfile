pipeline{
	agent any
	stages{
		stage('Compile Stage'){
			withMaven(maven:'Maven 3.8.1'){
			sh 'mvn clean compile'
			}
		}
		stage('Testing stage'){
			withMaven(maven:'Maven 3.8.1'){
			sh 'mvn test'
			}	
		}
	}
}