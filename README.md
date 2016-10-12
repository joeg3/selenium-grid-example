# selenium-grid-example

A small project I created to help me learn Selenium Grid


Start Selenium Hub:
~/selenium-grid$ sudo java -jar selenium-server-standalone-2.53.1.jar -port 4444 -role hub -nodeTimeout 600

Or more recently: 
~/code/joeg3/selenium-grid-example/src/test/resources$ java -jar selenium-server-standalone-2.53.1.jar -role hub -hubConfig hub.json

Start Chrome node:
~/selenium-grid$ java -jar -Dwebdriver.chrome.driver=/home/joe/drivers/chromedriver selenium-server-standalone-2.53.1.jar -role webdriver -hub http://localhost:4444/grid/register -nodeConfig defaultNodeConfig.json

Or more recently: 
~/code/joeg3/selenium-grid-example/src/test/resources$ java -jar selenium-server-standalone-2.53.1.jar -role node -hub http://10.0.1.7:4444/grid/register/ -nodeConfig node.json