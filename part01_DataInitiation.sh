echo "Part01 Data Initiation"


echo "" | faas-cli invoke init-auth-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-config-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-contacts-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-inside-payment-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-order-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-payment-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-price-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-route-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-security-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-station-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-train-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-travel-mongo --gateway http://10.141.212.140:31112
echo "" | faas-cli invoke init-user-mongo --gateway http://10.141.212.140:31112


faas-cli remove init-auth-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-config-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-contacts-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-inside-payment-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-order-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-payment-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-price-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-route-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-security-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-station-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-train-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-travel-mongo --gateway http://10.141.212.140:31112
faas-cli remove init-user-mongo --gateway http://10.141.212.140:31112


echo "Done"
