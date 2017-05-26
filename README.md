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

1. Include the output of two servlets to create the homepage for your e-commerce site: the first servlet should handle the displaying of the list of products obtained from a backend database, and the second servlet should use session tracking to display the last 5 products that the user has visited (viewed the product details page). In case this number is less than 5, show whatever amount of information you have stored in the session. Use servlet "include" feature to implement this requirement. 

2. Using servlets create a "product details" page. This page should take a product identifier as a parameter and show the product details after getting the relevant information from the database. This page should NOT have an order form, only a button to "Add to Cart". Use servlet "session" to store the products in a shopping cart. 

3. Using servlets create a "check out" page, which allows the user to place an order. The page should show all the products in the shopping cart and the total price. This page should have a form which will allow the user to do the following:

Enter shipping information: name, shipping address, phone number, credit card number, etc.
Submit the order for storage in the backend database
On successful submission, forward to the order details page. Use servlet "forward" feature to implement this requirement. 
Grading

This assignment is worth 12 points; 4 points for implementing each of the requirements above.

The grader may deduct points for the overall quality of the website, its look and feel, performance, and generally how professional the website looks. 

Submission

You need to submit a compressed file containing all of the files comprising your website using Canvas. Include a readme file that specifies the URL address of your website and its general layout/design to help the grader navigate the site. The readme file should make it clear where in the website each requirement is satisfied. If this is a group submission, the readme file should specifically state the name of both group members. Only one group member needs to submit the assignment in that case. The grader will uncompress your files and will look for this readme file in the base directory to find the URL where your website is running. Failure to include this file will result in grade deduction.

Each group member is expected to contribute to all phases of software development, including coding. It is recommended, but not required, to use a version control system, such as Github (Links to an external site.)Links to an external site., for managing your code. This way, team members can collaborate and work effectively on the same code base. 

We will grade both the HTML pages available from your web server and the files you submit. The submitted files should be identical to those hosted on the web server. If not, you will receive a 0 on this assignment. This obviously means that you are not allowed to change the files on your web server after you have submitted your assignment.

Make sure your web server is running and available for the grader to check your website. Failure to access your website will result in grade deduction.

You are not allowed to work with anyone outside of your group to complete this assignment. Please be informed that we will be using automated tools to catch potential cases of plagiarism in this class.  
