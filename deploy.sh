### set docker env
eval $(minikube docker-env)

### build the repository
mvn clean install -DskipTests

### build the docker images on minikube
cd frontend
npm run-script build
cd ../item-service
docker build -t item-service .
cd ../client-service
docker build -t client-service .
cd ../frontend
docker build -t frontend .
cd ..

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

minikube service frontend
