<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <jsp:include page="head.jsp" />
	<body>
    <div id="content">
      <jsp:include page="navbar.jsp" />
      <h2>${category.label}</h2>
      <img class="cat-image" src="${category.image}"/>
      <p>${category.description}</p>
      <table id="cat-table">
        <thead id="cat-table-labels">
          <tr>
            <th>Image</th>
            <th>Description</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody id="cat-table-body">
        <c:forEach items="${products}" var="p">
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
