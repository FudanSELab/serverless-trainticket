echo "Part02 BaaS Backend Deployment"

cd deployment/Part02-backend/service/
kubectl apply -f ts-serverless-service-deployment.yml

cd -

echo "Done"