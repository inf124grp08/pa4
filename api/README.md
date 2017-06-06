# pa3

URL: http://andromeda-16.ics.uci.edu:5016/app/home

General layout: Organized by category. Clicking category takes you to product listing for that category. Clicking the product itself takes you to the product detail page, which has the "add to cart" button. Setting a quantity, and clicking the button will add to your cart. Notice the numnber in the top right corner.

If you click the cart link at the top right corner, you will be taken to a page in which you can see the contents of your cart and submit the order form. Upon submission, you will be forwarded to a receipt page showing you your order details.

In addition, the last 5 products you have viewed are visible on the home page.

Group memebrs:
Keyvan Fatehi
Kyle San Clemente

Lastly, the github for this assignment is here: https://github.com/inf124grp08/pa3

## Requirements

1. Using JSP reimplement the product list page. This is the page that contains the list of your products. 

2. Create REST services to allow for interaction with the order and product resources stored in your application database. You will need to implement services that use the following verbs

     i.   GET

     ii.  PUT

     iii. POST

     iv. DELETE

Ensure that the proper REST principles and conventions are followed while creating your REST services. For example: A GET method should be used only for retrieving an existing resource, A POST method should be used for creating a new resource, etc. Do not forget to perform validation for certain methods. For instance, when implementing methods like GET, PUT, & DELETE to interact with existing resources, you will need to verify if the resource being queried actually exists. If the resource is not found. You will need to throw a 404 - Not Found response.

You are required to create your new REST service application in Java. It is mandatory that you use the Jersey REST framework.  For the scope of this assignment, it is sufficient that your REST services communicate in JSON. (You are free to implement support for other media types, but you will have to make sure that your e-commerce web application communicates successfully with the REST service.)

3. You will now need to replace all the database interactions in your web application with REST calls. Your web application will now act as a REST client and retrieve the MySQL data indirectly through the new RESTful web service.

In the readme file, provide proper documentation highlighting the details for each RESTful service method that you implement. Your documentation should include the following at the very least 

     i.    Method Type.

     ii.   Request URL.

     iii.  Sample Response.

     iv.  Sample Request (if applicable)

 

Grading

This assignment is worth 12 points; 4 points for implementing each of the requirements above.

The grader may deduct points for the overall quality of the website, its look and feel, performance, and generally how professional the website looks. 

Submission

You need to submit a compressed file containing all of the files comprising your website using Canvas. Include a readme file that specifies the URL address of your website and its general layout/design to help the grader navigate the site. The readme file should make it clear where in the website each requirement is satisfied. If this is a group submission, the readme file should specifically state the name of both group members. Only one group member needs to submit the assignment in that case. The grader will uncompress your files and will look for this readme file in the base directory to find the URL where your website is running. Failure to include this file will result in grade deduction.

Each group member is expected to contribute to all phases of software development, including coding. It is recommended, but not required, to use a version control system, such as Github (Links to an external site.)Links to an external site., for managing your code. This way, team members can collaborate and work effectively on the same code base. 

We will grade both the HTML pages available from your web server and the files you submit. The submitted files should be identical to those hosted on the web server. If not, you will receive a 0 on this assignment. This obviously means that you are not allowed to change the files on your web server after you have submitted your assignment.

Make sure your web server is running and available for the grader to check your website. Failure to access your website will result in grade deduction.

You are not allowed to work with anyone outside of your group to complete this assignment. Please be informed that we will be using automated tools to catch potential cases of plagiarism in this class.  
