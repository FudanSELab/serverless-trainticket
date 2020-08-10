echo "Part02 BaaS Backend Deployment"

cd deployment/Part02-backend/service/
kubectl create -f ts-serverless-service-deployment.yml

cd ..
cd ..
cd ..

echo "Done"