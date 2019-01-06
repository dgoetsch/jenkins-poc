#!/bin/bash

kubectl create secret generic jenkins-ssh-key --from-file=id_rsa=../ci/jenkins/.ssh/id_rsa
kubectl create -f resources/