### mongodb
kubectl apply -f mongo-deployment.yaml

### item-service
sed -i "s/@IMAGE_VERSION@/$1/g" item-service/item-service-deployment.yaml
kubectl apply -f item-service/item-service-deployment.yaml

### client-service
sed -i "s/@IMAGE_VERSION@/$1/g" client-service/client-service-deployment.yaml
kubectl apply -f client-service/client-service-deployment.yaml

### frontend
sed -i "s/@IMAGE_VERSION@/$1/g" frontend/frontend-deployment.yaml
kubectl apply -f frontend/frontend-deployment.yaml