# selenium-grid-example
A small project I created to help me learn Selenium Grid

### Tools
I ran the tests on Ubuntu 16.04. I used Eclipse Neon for development, with the TestNG plugin.

### Project Setup
1. Go to seleniumhq.org/download and download the Selenium server standalone jar file.  I used selenium-server-standalone-2.47.0.jar for this test.
2. Copy the downloaded jar into the project's `src/test/resources` folder. This is where the config files are, which makes it easier from the command line.
3. Download the chrome driver to a directory on your hard drive. I used `~/drivers`.
4. Add the driver directory to your $PATH or %PATH%.

### Start the Hub and Node
Note we don't need to specify the driver in the command because it is on our $PATH, and we don't need to specify the hub when starting the node becasue that is in the JSON files.

Start Selenium Hub:

1. In a terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar selenium-server-standalone-2.47.0.jar -role hub -hubConfig hub.json`

Start Node for Firefox/Linux:

1. In another terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar selenium-server-standalone-2.47.0.jar -role node -nodeConfig firefox-linux.json`

Start Node for Chrome/Linux:

1. In another terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar selenium-server-standalone-2.47.0.jar -role node -nodeConfig chrome-linux.json`

### Run the tests and see test reports
* In Eclipse, right-click on `testng.xml` and select Run As ... > TestNG Suite. In a browser, you can see the TestNG Reports by navigating to: `file:///my_dir/selenium-grid-example/test-output/index.html`. Change `mydir` to whatever directory you have the project in.
* In Eclipse, double-click on `testng.xml` in the Gradle Tasks view. In a browser, you can see the TestNG Reports by navigating to: `file:///my_dir/selenium-grid-example/build/reports/tests/index.html`. Change `mydir` to whatever directory you have the project in.

### Gotcha's I had to resolve
1. When I started this project, the latest version of Selenium was 2.53.1, and Firefox on my Ubuntu machine was 49.0.  I kept getting this error: org.openqa.selenium.firefox.NotConnectedException: Unable to connect to host 127.0.0.1 on port 7055 after 45000 ms. So from searching the web, I found that this has been happening for years where as Selenium and FF change versions, they don't always play well together, and the  solution usually is to play with version numbers. So I resolved this error by downgrading Selenium to 2.47.0.
2. I read somewhere before I started the project that to run the tests in parallel you have to use TestNG instead of JUnit. So I went that route early on.
3. I was having problems getting the Firefox and Chrome tests running in parallel. After a lot of Googling, I resolved it by switching the first line in `testng.xml` from `<suite name="Parallel Tests" verbose="1" thread-count="4" parallel="classes">` to `<suite name="Parallel Tests" verbose="1" thread-count="4" parallel="tests">`.
4. In the Ansible script, I had to install the `daemon` package so I could use it to run Xvfb, and the Selenium hub and node in the background.
5. I set the `DISPLAY` environment variable to `localhost:0.0` at the play level.
