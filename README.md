# selenium-grid-example
A small project I created to help me learn Selenium Grid

### Tools
* My development machine is running Ubuntu 16.04.
* I used Eclipse Neon for development, with the TestNG plugin.
* Vagrant version 1.8.7
* VirtualBox version 5.1.12
* Ansible version 2.2.0.0

### Start Selenium Grid on a Virtual Machine
This would be used for production testing.

1. In a terminal, cd to: `selenium-grid-example` project directory
2. Run the command `vagrant up` to start the virtual machine.
3. Run command `ansible-playbook main.yml` to configure the virtual machine and start Selenium hub and nodes.

### Start Selenium Grid on your Development Machine
This would be used on your development machine to see what is going on when writing tests.
Setup:

1. Look at `main.yml` file for URLs from where to download the Chrome and Gecko drivers. Download the drivers and unzip/extract them into a directory on your hard drive that is also on your $PATH or %PATH%. I put them in  `/usr/local/bin`. We put the drivers on our $PATH so we won't need to specify the driver later when starting the node.
2. Look at `main.yml` file for URL from where to download the Selenium JAR. Put the JAR in a directory of your choice on your local machine. I put it in `/opt/selenium` on my machine. You'll reference this location when starting the hub and nodes.
3. In `testng.xml` change the `hubIpAddress` parameter to `127.0.0.1`. Note also that we will specify the host from the command line when starting the hub and nodes to override the default value in the JSON files.

Start Selenium Hub:

1. In a terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar /opt/selenium/selenium-server-standalone-3.0.1.jar -role hub -hubConfig hub.json -host 127.0.0.1`

Start Node for Firefox/Linux:

1. In another terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar /opt/selenium/selenium-server-standalone-3.0.1.jar -role node -nodeConfig firefox-linux.json -hubHost 127.0.0.1`

Start Node for Chrome/Linux:

1. In another terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar /opt/selenium/selenium-server-standalone-3.0.1.jar -role node -nodeConfig chrome-linux.json -hubHost 127.0.0.1`

### Run the tests and see test reports
Regardless of whether Selenium grid is running on the virtual machine or on our development machine, we start the tests from our development machine and see the test
reports on our development machine.
* Run tests using Gradle: In the project directory run `./gradlew test` from the command line to have Gradle build the project and run the tests. Alternatively you could also kick off the Gradle build in the Gradle Tasks view in Eclipse by double-clicking on the "test" task.
In a browser, you can see the Gradle test report by navigating to: `file:///my_dir/selenium-grid-example/build/reports/tests/index.html` (Change `my_dir` to the directory you have the project in).
* Run the tests from Eclipse using the TestNG plugin. Right-click on `testng.xml` and select Run As ... > TestNG Suite.
In a browser, you can see the TestNG Reports by navigating to: `file:///my_dir/selenium-grid-example/test-output/index.html` (Change `my_dir` to the directory you have the project in).

### Things to improve/fix:
* Have Vagrant run the Ansible script to provision. When I tried, it didn't seem to run.

### Gotcha's I had to resolve
1. I read somewhere before I started the project that to run the tests in parallel you have to use TestNG instead of JUnit. So I went that route early on.
3. In the Ansible script, I had to install the `daemon` package so I could use it to run Xvfb, and the Selenium hub and node in the background.
4. The `DISPLAY` environment variable needs to match the value passed to Xvfb.
5. I could run tests against both nodes on my development machine, and run tests against one node on the vm, but would get strange inconsistent results when running both nodes at the same time on the vm.  I solved this by bumping up the memory for the vm in the Vagrantfile.
