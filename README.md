# adpro-pepe

## 1. Module 1
### A. Reflection 1

In this first exercise, I've implemented some clean code principles. Here's the list of clean code principles that have been applied:
1. Meaningful Names: I've tried to name all the variables and methods as clearly as possible so that I won't need comments to explain it.

2. Function: The functions I've implemented are supposed to do exactly one thing. The updateProduct function only updates the products and the deleteProduct function only deletes the products.

3. Comments: I didn't enter any comments in my code for now because everything is simple and direct. Besides that, the code also speaks for itself due to the meaningful names.

4. Objects and Data Structure: I've followed the tutorial to make every data structure and object attributes private. People can only modify the data structure and objects through public functions throughout the code.

In this first exercise, I didn't any secure coding principles at all. This is because the app doesn't have an authentication page and everyone can still add, edit, and remove product anonymously. Besides that, the app doesn't have an input data validation and output data validation because everything is still hard coded, so there's not a lot of vulnerabilities there. In my source code, there's no error handling page that shows the user what went wrong. This can be fixed by adding an error handling page, so that users won't get directed to a page with long error lines.

### B. Reflection 2
1. Answer to Question 1: After writing the unit test, I feel more secure and happier. I get it why Kent Beck says that writing tests is like turning on the lights in a dark room. This fact is especially true in Phasmophobia (a horror game) where lights reduce anxierty and sanity drain. Back to the point, the number of unit tests in a class should be just enough to test every cases in every part of the app. If I have 100% code coverage, it doesn't mean that my code has no bugs or errors. It just mean I've covered all parts of the code, but it doesn't show how well my tests are. This is true based on personal experience from PBP. A high coverage is easy, but making good tests isn't.

2. Answer to Question 2: The code of the new functional test suite isn't that clean because there's redundancy in our tests. The new code will reduce the code quality because there's more tests to run and that reduces the efficiency of the test. The clean code issues is redundant functional test code. This issue can be improved by not splitting the functional test suite into two when it's not that huge.

## 2. Module 2
### A. Reflection 1

1. Answer to Question 1:
   a. The first severe code quality issue is creating an empty setUp function in ProductRepositoryTest. First of all, I thought it was all fine, but Sonar Cloud Cube says that this practice is a bad idea. To fix this issue, I just remove the setUp function from the file and done.
   b. The second issue is naming a function using PascalCase. In Java, the convention is naming methods using camelCase. To fix this issue, I rename the method HomePage in HomePageController to homePage and done.
   
2. Answer to Question 2: The current implementation has met the definition of Continuous Integration and Continuous Deployment. Continuous Integration is a process where software is automatically built, tested, and integrated into the main project. This step is implemented via 3 workflow files, which are ci.yml, scorecard.yml, and sonarqube.yml. These 3 files allows continuous integration and testing via sonarqube and scorecard. So, this implementation checks the box for continuous integration. On the other hand, continuous deployment is a process where software gets deployed automatically to production environment. For continuous Deployment, I've implemented this by using Koyeb as a deployment service. I've added a Dockerfile in my repository, so that every time I push Koyeb will pull the repository and auto deploy the changes made to production environment. In conclusion, I've implemented continuous integration and continuous deployment.
