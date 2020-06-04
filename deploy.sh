### set docker env
eval $(minikube docker-env)

### build the repository
#mvn clean install -DskipTests

### mongodb
kubectl apply -f mongo-deployment.yaml

### item-service
kubectl apply -f item-service/item-service-deployment.yaml

### client-service
kubectl apply -f client-service/client-service-deployment.yaml

### frontend
kubectl apply -f frontend/frontend-deployment.yaml

# Check that the pods are running
kubectl get pods

minikube service frontend-service
