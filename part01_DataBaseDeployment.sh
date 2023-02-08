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
 
PROJECT_DIR=$(cd $(dirname $0); pwd)

cd deployment/Part01-database/
kubectl apply -f ts-serverless-database-deployment.yml

kubectl apply -f ts-serverless-persistent-deployment.yml
cd ..
cd ..

cd src/initDB/initDatabaseFunctions/

cd initAuthMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-auth-mongo.yml
cd ..
echo "FINISHED 1/13"

cd initConfigMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-config-mongo.yml
cd ..
echo "FINISHED 2/13"

cd initContactsMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-contacts-mongo.yml
cd ..
echo "FINISHED 3/13"

cd initInsidePaymentMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-inside-payment-mongo.yml
cd ..
echo "FINISHED 4/13"

cd initOrderMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-order-mongo.yml
cd ..
echo "FINISHED 5/13"

cd initPaymentMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-payment-mongo.yml
cd ..
echo "FINISHED 6/13"

cd initPriceMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-price-mongo.yml
cd ..
echo "FINISHED 7/13"

cd initRouteMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-route-mongo.yml
cd ..
echo "FINISHED 8/13"

cd initSecurityMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-security-mongo.yml
cd ..
echo "FINISHED 9/13"

cd initStationMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-station-mongo.yml
cd ..
echo "FINISHED 10/13"

cd initTrainMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-train-mongo.yml
cd ..
echo "FINISHED 11/13"

cd initTravelMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-travel-mongo.yml
cd ..
echo "FINISHED 12/13"

cd initUserMongo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f init-user-mongo.yml
cd ..
echo "FINISHED 13/13"


echo "DONE"



