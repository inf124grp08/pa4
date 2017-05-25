<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <jsp:include page="head.jsp" />
	<body>
    <div id="content">
      <jsp:include page="navbar.jsp" />
      <h2>${product.description}</h2>
      <div id="product">
        <div id="product-info">
          <img class="product-image" src="${product.image}"/>
          <div>
            <h3 class="brand"><strong>Brand: </strong>${product.brand}</h3>
            <h4 class="price"><strong>Price: </strong><span id="price">${product.price}</span></h4>
          </div>
          <form method="post" action="${context}/cart">
            <input type="hidden" name="id" value="${product.id}">
            Quantity: <input type="text" name="qty">
            <input type="submit" value="Add To Cart" name="submit">
          </form>
        </div>
        </div>
      </div>
    </div>
	</body>
</html>
