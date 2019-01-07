#!/bin/bash

#clean
rm resources/jenkins-deployment.yaml

PASSWORD=`uuidgen`
#generate configuration from templates
cat templates/jenkins-deployment.yaml.tmpl | sed "s/ADMIN_PASSWORD_VALUE/$PASSWORD/g" > resources/jenkins-deployment.yaml

# create secrets that can't be created via files (I think)
kubectl create secret generic jenkins-ssh-key --from-file=id_rsa=../ci/jenkins/.ssh/id_rsa

# have k8s create resources
kubectl create -f resources/

echo "Initial login: 'admin' / '$PASSWORD'"
