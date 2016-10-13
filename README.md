# selenium-grid-example

A small project I created to help me learn Selenium Grid

### Tools
I ran the tests on Ubuntu 16.04, and used Eclipse for development.

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

Start Node:
1. In another terminal, cd to: `selenium-grid-example/src/test/resources`
2. Run the following command: `java -jar selenium-server-standalone-2.47.0.jar -role node -nodeConfig node.json`
