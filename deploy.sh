find . -name "*deployment.yaml" \
 	-exec sed -i "s/@IMAGE_VERSION@/$1/g" {} \; \
 	-exec kubectl apply -f {} \;
