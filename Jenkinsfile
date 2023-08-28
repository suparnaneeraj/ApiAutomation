pipeline{
	agent any
	stages{
		stage('Compile Stage'){
		 	steps {
				withMaven(maven:''){
				sh 'mvn clean compile'
				}
			}
		}
		stage('Testing stage'){
			steps{
				withMaven(maven:'Maven 3.8.1'){
				sh 'mvn test'
				}		
			}
		}
	}
}