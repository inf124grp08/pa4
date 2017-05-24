<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <jsp:include page="head.jsp" />
	<body>
    <div id="content">
      <jsp:include page="navbar.jsp" />

      <div id="title">
        <h1>Rock On</h1>
      </div>
        <div id="home-text">
          <p> 
            Rock On Climbing Gear is the number one seller of rock climing gear in the entire Informatics 124 class. We sell all the best most durable equiptment.
          </p>
          <p> 
            Our managment team is made up of two avid rock climbers, Keyvan and Kyle. These guys love to climb, and make sure that the gear on this site is top of the line.
          </p>
          <p> 
            Thank you for visiting our online store, we hope you will find what you are looking for!
          </p>
        </div>

      <table id="cat-table">
        <thead id="cat-table-labels">
          <tr>
            <th>Image</th>
            <th>Description</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody id="cat-table-body">
        <c:forEach items="${visitedProducts}" var="p">
          <tr class="cat-table-row">
            <td class="cat-table-image">
              <a href="product?id=${p.id}">
                <img class="product-image" src="${p.image}"/>
              </a>
            </td>
            <td class="cat-table-description">
              <a href="product?id=${p.id}">
                <p>${p.description}</p>
                <p><strong>brand: </strong>${p.brand}</p>
              </a>
            </td>
            <td class="cat-table-price">
              $${p.price}
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
	</body>
</html>
