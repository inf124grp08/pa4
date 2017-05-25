<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <jsp:include page="head.jsp" />
	<body>
    <div id="content">
      <jsp:include page="navbar.jsp" />
      <table id="cat-table">
        <thead id="cat-table-labels">
          <tr>
            <th>Image</th>
            <th>Description</th>
            <th>Price</th>
            <th>Qty</th>
          </tr>
        </thead>
        <tbody id="cat-table-body">
        <c:forEach items="${cartProducts}" var="p">
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
            <td class="cat-table-qty">
              ${cart[p.id]}
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
	</body>
</html>
