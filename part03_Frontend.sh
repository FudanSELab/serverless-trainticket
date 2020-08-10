echo "Part03 Front Deployment"

cd deployment/Part03-frontend/
kubectl create -f ts-serverless-frontend-deployment.yml

cd ..
cd ..

echo "Done"