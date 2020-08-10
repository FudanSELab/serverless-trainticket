echo "Part01 DataBase Deployment"

mkdir /var/nfs/data/station
mkdir /var/nfs/data/auth
mkdir /var/nfs/data/config
mkdir /var/nfs/data/contacts
mkdir /var/nfs/data/insidePayment
mkdir /var/nfs/data/order
mkdir /var/nfs/data/payment
mkdir /var/nfs/data/price
mkdir /var/nfs/data/route
mkdir /var/nfs/data/security
mkdir /var/nfs/data/train
mkdir /var/nfs/data/travel
mkdir /var/nfs/data/user
 

cd deployment/Part01-database/
kubectl apply -f ts-serverless-database-deployment.yml

sed -i s/10.141.212.140/$MASTER_ID/g ts-serverless-persistent-deployment.yml
kubectl apply -f ts-serverless-persistent-deployment.yml
cd ..
cd ..

cd src/initDB/initDatabaseFunctions/

cd initAuthMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-auth-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-auth-mongo.yml
faas-cli up -f init-auth-mongo.yml
cd ..
echo "FINISHED 1/13"

cd initConfigMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-config-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-config-mongo.yml
faas-cli up -f init-config-mongo.yml
cd ..
echo "FINISHED 2/13"

cd initContactsMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-contacts-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-contacts-mongo.yml
faas-cli up -f init-contacts-mongo.yml
cd ..
echo "FINISHED 3/13"

cd initInsidePaymentMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-inside-payment-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-inside-payment-mongo.yml
faas-cli up -f init-inside-payment-mongo.yml
cd ..
echo "FINISHED 4/13"

cd initOrderMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-order-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-order-mongo.yml
faas-cli up -f init-order-mongo.yml
cd ..
echo "FINISHED 5/13"

cd initPaymentMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-payment-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-payment-mongo.yml
faas-cli up -f init-payment-mongo.yml
cd ..
echo "FINISHED 6/13"

cd initPriceMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-price-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-price-mongo.yml
faas-cli up -f init-price-mongo.yml
cd ..
echo "FINISHED 7/13"

cd initRouteMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-route-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-route-mongo.yml
faas-cli up -f init-route-mongo.yml
cd ..
echo "FINISHED 8/13"

cd initSecurityMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-security-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-security-mongo.yml
faas-cli up -f init-security-mongo.yml
cd ..
echo "FINISHED 9/13"

cd initStationMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-station-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-station-mongo.yml
faas-cli up -f init-station-mongo.yml
cd ..
echo "FINISHED 10/13"

cd initTrainMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-train-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-train-mongo.yml
faas-cli up -f init-train-mongo.yml
cd ..
echo "FINISHED 11/13"

cd initTravelMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-travel-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-travel-mongo.yml
faas-cli up -f init-travel-mongo.yml
cd ..
echo "FINISHED 12/13"

cd initUserMongo/
sed -i s/10.141.212.140/$MASTER_ID/ init-user-mongo.yml
sed -i s/286071421/$DOCKER_USERNAME/ init-user-mongo.yml
faas-cli up -f init-user-mongo.yml
cd ..
echo "FINISHED 13/13"

cd ..
cd ..
cd ..

echo "DONE"



