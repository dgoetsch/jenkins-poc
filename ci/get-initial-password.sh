container_id=$(docker ps | grep "jenkins" | awk '{ print $1 }')
docker exec $container_id cat /var/jenkins_home/secrets/initialAdminPassword
