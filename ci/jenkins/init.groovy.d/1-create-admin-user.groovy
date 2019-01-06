/*
https://github.com/thbkrkr/jks/blob/master/init.groovy.d/1-create-admin-user.groovy
*/

import jenkins.model.*
import hudson.security.*

def adminUsername = System.getenv("ADMIN_USERNAME")
def adminPassword = System.getenv("ADMIN_PASSWORD")
def jenkinsHome = System.getenv("JENKINS_HOME")

def logFile = new File(jenkinsHome + '/admin_user.lock')

if(adminPassword?.trim() && adminUsername?.trim() 
    && jenkinsHome?.trim() && !logFile.exists()) {
    def instance = Jenkins.getInstance()

    def hudsonRealm = new HudsonPrivateSecurityRealm(false)
    hudsonRealm.createAccount(adminUsername,adminPassword)
    instance.setSecurityRealm(hudsonRealm)

    def strategy = new GlobalMatrixAuthorizationStrategy()
    strategy.add(Jenkins.ADMINISTER, adminUsername)
    instance.setAuthorizationStrategy(strategy)
        
    instance.save()

    logFile.createNewFile()
    logFile << "Delete this file to recreate admin user on restart"
}