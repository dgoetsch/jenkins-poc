### Jenkins Kube deployment

Deploy jenkins to K8s

### Description

K8s running locally (minikube + kvm)
Jenkins Runs insidie K8s
Jenkins  launches nodes on K8s in pods
Can build docker images with Docker in Docker.


### Set up

1. Set up kubenetes
  1. Local: Set up minikube see `kube/local`
  2. Other: AWS, Gcloud
2. Launch jenkins, see `kube/resources`
    1. Service Account: https://kubernetes.io/docs/reference/access-authn-authz/rbac/
3. set up kube in jenkins
  1. add credentials
  2. configure jenkins "cloud"
4. set up project in jenkins
    1. ssh key
    2. multibranch pipelinne

Jenkins base image defined in `ci/jenkins`

Source:
https://cloud.google.com/solutions/configuring-jenkins-kubernetes-engine


READ LATER: https://medium.com/hootsuite-engineering/building-docker-images-inside-kubernetes-42c6af855f25