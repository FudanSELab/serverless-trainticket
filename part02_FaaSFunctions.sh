echo "Part02 FaaS Backend Deployment"

PROJECT_DIR=$(cd $(dirname $0); pwd)

cd src/backend/FaaS/
cd Part01/


echo "Part1 function deployment start"

cd getLeftTicketOfInterval/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-left-ticket-of-interval.yml
cd ..
echo "FINISHED 1/13"

cd getLeftTripTickets/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-left-trip-tickets.yml
cd ..
echo "FINISHED 2/13"

cd getPriceByRouteIdAndTrainType/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-price-by-routeid-and-traintype.yml
cd ..
echo "FINISHED 3/13"

cd getRouteByRouteId/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-route-by-routeid.yml
cd ..
echo "FINISHED 4/13"

cd getRouteByTripId/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-route-by-tripid.yml
cd ..
echo "FINISHED 5/13"

cd getSoldTickets/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-sold-tickets.yml
cd ..
echo "FINISHED 6/13"

cd getToken/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-token.yml
cd ..
echo "FINISHED 7/13"

cd getTrainTypeByTrainTypeId/
faas-cli up -f get-traintype-by-traintypeid.yml
cd ..
echo "FINISHED 8/13"

cd getTrainTypeByTripId/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-traintype-by-tripid.yml
cd ..
echo "FINISHED 9/13"

cd queryAlreadySoldOrders/
cp -r $PROJECT_DIR/template ./
faas-cli up -f query-already-sold-orders.yml
cd ..
echo "FINISHED 10/13"

cd queryConfigEntityByConfigName/
cp -r $PROJECT_DIR/template ./
faas-cli up -f query-config-entity-by-config-name.yml
cd ..
echo "FINISHED 11/13"

cd queryForStationIdByStationName/
cp -r $PROJECT_DIR/template ./
faas-cli up -f query-for-station-id-by-station-name.yml
cd ..
echo "FINISHED 12/13"

cd queryForTravel/
cp -r $PROJECT_DIR/template ./
faas-cli up -f query-for-travel.yml
cd ..
echo "FINISHED 13/13"

echo "Part1 function deployment finish"
cd ..
cd Part02/
echo "Part2 function deployment start"

cd checkSecurity/
cp -r $PROJECT_DIR/template ./
faas-cli up -f check-security.yml
cd ..
echo "FINISHED 1/10"

cd checkSecurityAboutOrder/
cp -r $PROJECT_DIR/template ./
faas-cli up -f check-security-about-order.yml
cd ..
echo "FINISHED 2/10"

cd createNewContacts/
cp -r $PROJECT_DIR/template ./
faas-cli up -f create-new-contacts.yml
cd ..
echo "FINISHED 3/10"

cd createOrder/
cp -r $PROJECT_DIR/template ./
faas-cli up -f create-order.yml
cd ..
echo "FINISHED 4/10"

cd dipatchSeat/
cp -r $PROJECT_DIR/template ./
faas-cli up -f dipatch-seat.yml
cd ..
echo "FINISHED 5/10"

cd findContactsByAccountId/
cp -r $PROJECT_DIR/template ./
faas-cli up -f find-contacts-by-accountid.yml
cd ..
echo "FINISHED 6/10"

cd getContactsByContactsId/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-contacts-by-contactsid.yml
cd ..
echo "FINISHED 7/10"

cd getTripAllDetailInfo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-trip-all-detai-info.yml
cd ..
echo "FINISHED 8/10"

cd getUserByUserId/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-user-by-userid.yml
cd ..
echo "FINISHED 9/10"

cd preserveTicket/
cp -r $PROJECT_DIR/template ./
faas-cli up -f preserve-ticket.yml
cd ..
echo "FINISHED 10/10"


echo "Part2 function deployment finish"
cd ..
cd Part03/
echo "Part3 function deployment start"


cd calculateRefund/
cp -r $PROJECT_DIR/template ./
faas-cli up -f calculate-refund.yml
cd ..
echo "FINISHED 1/10"

cd cancelTicket/
cp -r $PROJECT_DIR/template ./
faas-cli up -f cancel-ticket.yml
cd ..
echo "FINISHED 2/10"

cd createThirdPartyPaymentAndPay/
cp -r $PROJECT_DIR/template ./
faas-cli up -f create-third-party-payment-and-pay.yml
cd ..
echo "FINISHED 3/10"

cd drawBack/
cp -r $PROJECT_DIR/template ./
faas-cli up -f drawback.yml
cd ..
echo "FINISHED 4/10"

cd getOrderById/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-order-by-id.yml
cd ..
echo "FINISHED 5/10"

cd getStationIdListByNameList/
cp -r $PROJECT_DIR/template ./
faas-cli up -f get-stationid-list-by-name-list.yml
cd ..
echo "FINISHED 6/10"

cd modifyOrder/
cp -r $PROJECT_DIR/template ./
faas-cli up -f modify-order.yml
cd ..
echo "FINISHED 7/10"

cd payForTheOrder/
cp -r $PROJECT_DIR/template ./
faas-cli up -f pay-for-the-order.yml
cd ..
echo "FINISHED 8/10"

cd queryOrdersForRefresh/
cp -r $PROJECT_DIR/template ./
faas-cli up -f query-orders-for-refresh.yml
cd ..
echo "FINISHED 9/10"

cd saveOrderInfo/
cp -r $PROJECT_DIR/template ./
faas-cli up -f save-order-info.yml
cd ..
echo "FINISHED 10/10"


echo "Part3 function deployment finish"
cd $PROJECT_DIR

echo "Done"