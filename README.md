# selenium-grid-example

A small project I created to help me learn Selenium Grid


Start Selenium Hub:
~/selenium-grid$ sudo java -jar selenium-server-standalone-2.53.1.jar -port 4444 -role hub -nodeTimeout 600

Start Chrome node:
~/selenium-grid$ java -jar -Dwebdriver.chrome.driver=/home/joe/drivers/chromedriver selenium-server-standalone-2.53.1.jar -role webdriver -hub http://localhost:4444/grid/register -nodeConfig defaultNodeConfig.json