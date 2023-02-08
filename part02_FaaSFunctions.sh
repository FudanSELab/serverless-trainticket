echo "Part02 FaaS Backend Deployment"

PROJECT_DIR=$(cd $(dirname $0); pwd)

cd src/backend/FaaS/
cd Part01/

MASTER_ID=172.17.8.101
DOCKER_USERNAME=diomwu

echo "Part1 function deployment start"

cd getLeftTicketOfInterval/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-left-ticket-of-interval.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-left-ticket-of-interval.yml
faas-cli up -f get-left-ticket-of-interval.yml
cd ..
echo "FINISHED 1/13"

cd getLeftTripTickets/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-left-trip-tickets.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-left-trip-tickets.yml
faas-cli up -f get-left-trip-tickets.yml
cd ..
echo "FINISHED 2/13"

cd getPriceByRouteIdAndTrainType/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-price-by-routeid-and-traintype.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-price-by-routeid-and-traintype.yml
faas-cli up -f get-price-by-routeid-and-traintype.yml
cd ..
echo "FINISHED 3/13"

cd getRouteByRouteId/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-route-by-routeid.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-route-by-routeid.yml
faas-cli up -f get-route-by-routeid.yml
cd ..
echo "FINISHED 4/13"

cd getRouteByTripId/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-route-by-tripid.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-route-by-tripid.yml
faas-cli up -f get-route-by-tripid.yml
cd ..
echo "FINISHED 5/13"

cd getSoldTickets/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-sold-tickets.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-sold-tickets.yml
faas-cli up -f get-sold-tickets.yml
cd ..
echo "FINISHED 6/13"

cd getToken/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-token.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-token.yml
faas-cli up -f get-token.yml
cd ..
echo "FINISHED 7/13"

cd getTrainTypeByTrainTypeId/
sed -i s/10.141.212.140/$MASTER_ID/ get-traintype-by-traintypeid.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-traintype-by-traintypeid.yml
faas-cli up -f get-traintype-by-traintypeid.yml
cd ..
echo "FINISHED 8/13"

cd getTrainTypeByTripId/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-traintype-by-tripid.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-traintype-by-tripid.yml
faas-cli up -f get-traintype-by-tripid.yml
cd ..
echo "FINISHED 9/13"

cd queryAlreadySoldOrders/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ query-already-sold-orders.yml
sed -i s/286071421/$DOCKER_USERNAME/ query-already-sold-orders.yml
faas-cli up -f query-already-sold-orders.yml
cd ..
echo "FINISHED 10/13"

cd queryConfigEntityByConfigName/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ query-config-entity-by-config-name.yml
sed -i s/286071421/$DOCKER_USERNAME/ query-config-entity-by-config-name.yml
faas-cli up -f query-config-entity-by-config-name.yml
cd ..
echo "FINISHED 11/13"

cd queryForStationIdByStationName/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ query-for-station-id-by-station-name.yml
sed -i s/286071421/$DOCKER_USERNAME/ query-for-station-id-by-station-name.yml
faas-cli up -f query-for-station-id-by-station-name.yml
cd ..
echo "FINISHED 12/13"

cd queryForTravel/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ query-for-travel.yml
sed -i s/286071421/$DOCKER_USERNAME/ query-for-travel.yml
faas-cli up -f query-for-travel.yml
cd ..
echo "FINISHED 13/13"

echo "Part1 function deployment finish"
cd ..
cd Part02/
echo "Part2 function deployment start"

cd checkSecurity/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ check-security.yml
sed -i s/286071421/$DOCKER_USERNAME/ check-security.yml
faas-cli up -f check-security.yml
cd ..
echo "FINISHED 1/10"

cd checkSecurityAboutOrder/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ check-security-about-order.yml
sed -i s/286071421/$DOCKER_USERNAME/ check-security-about-order.yml
faas-cli up -f check-security-about-order.yml
cd ..
echo "FINISHED 2/10"

cd createNewContacts/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ create-new-contacts.yml
sed -i s/286071421/$DOCKER_USERNAME/ create-new-contacts.yml
faas-cli up -f create-new-contacts.yml
cd ..
echo "FINISHED 3/10"

cd createOrder/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ create-order.yml
sed -i s/286071421/$DOCKER_USERNAME/ create-order.yml
faas-cli up -f create-order.yml
cd ..
echo "FINISHED 4/10"

cd dipatchSeat/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ dipatch-seat.yml
sed -i s/286071421/$DOCKER_USERNAME/ dipatch-seat.yml
faas-cli up -f dipatch-seat.yml
cd ..
echo "FINISHED 5/10"

cd findContactsByAccountId/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ find-contacts-by-accountid.yml
sed -i s/286071421/$DOCKER_USERNAME/ find-contacts-by-accountid.yml
faas-cli up -f find-contacts-by-accountid.yml
cd ..
echo "FINISHED 6/10"

cd getContactsByContactsId/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-contacts-by-contactsid.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-contacts-by-contactsid.yml
faas-cli up -f get-contacts-by-contactsid.yml
cd ..
echo "FINISHED 7/10"

cd getTripAllDetailInfo/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-trip-all-detai-info.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-trip-all-detai-info.yml
faas-cli up -f get-trip-all-detai-info.yml
cd ..
echo "FINISHED 8/10"

cd getUserByUserId/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-user-by-userid.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-user-by-userid.yml
faas-cli up -f get-user-by-userid.yml
cd ..
echo "FINISHED 9/10"

cd preserveTicket/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ preserve-ticket.yml
sed -i s/286071421/$DOCKER_USERNAME/ preserve-ticket.yml
faas-cli up -f preserve-ticket.yml
cd ..
echo "FINISHED 10/10"


echo "Part2 function deployment finish"
cd ..
cd Part03/
echo "Part3 function deployment start"


cd calculateRefund/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ calculate-refund.yml
sed -i s/286071421/$DOCKER_USERNAME/ calculate-refund.yml
faas-cli up -f calculate-refund.yml
cd ..
echo "FINISHED 1/10"

cd cancelTicket/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ cancel-ticket.yml
sed -i s/286071421/$DOCKER_USERNAME/ cancel-ticket.yml
faas-cli up -f cancel-ticket.yml
cd ..
echo "FINISHED 2/10"

cd createThirdPartyPaymentAndPay/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ create-third-party-payment-and-pay.yml
sed -i s/286071421/$DOCKER_USERNAME/ create-third-party-payment-and-pay.yml
faas-cli up -f create-third-party-payment-and-pay.yml
cd ..
echo "FINISHED 3/10"

cd drawBack/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ drawback.yml
sed -i s/286071421/$DOCKER_USERNAME/ drawback.yml
faas-cli up -f drawback.yml
cd ..
echo "FINISHED 4/10"

cd getOrderById/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-order-by-id.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-order-by-id.yml
faas-cli up -f get-order-by-id.yml
cd ..
echo "FINISHED 5/10"

cd getStationIdListByNameList/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ get-stationid-list-by-name-list.yml
sed -i s/286071421/$DOCKER_USERNAME/ get-stationid-list-by-name-list.yml
faas-cli up -f get-stationid-list-by-name-list.yml
cd ..
echo "FINISHED 6/10"

cd modifyOrder/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ modify-order.yml
sed -i s/286071421/$DOCKER_USERNAME/ modify-order.yml
faas-cli up -f modify-order.yml
cd ..
echo "FINISHED 7/10"

cd payForTheOrder/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ pay-for-the-order.yml
sed -i s/286071421/$DOCKER_USERNAME/ pay-for-the-order.yml
faas-cli up -f pay-for-the-order.yml
cd ..
echo "FINISHED 8/10"

cd queryOrdersForRefresh/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ query-orders-for-refresh.yml
sed -i s/286071421/$DOCKER_USERNAME/ query-orders-for-refresh.yml
faas-cli up -f query-orders-for-refresh.yml
cd ..
echo "FINISHED 9/10"

cd saveOrderInfo/
cp -r $PROJECT_DIR/template ./
sed -i s/10.141.212.140/$MASTER_ID/ save-order-info.yml
sed -i s/286071421/$DOCKER_USERNAME/ save-order-info.yml
faas-cli up -f save-order-info.yml
cd ..
echo "FINISHED 10/10"


echo "Part3 function deployment finish"
cd $PROJECT_DIR

echo "Done"