<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <jsp:include page="head.jsp" />
	<body>
    <div id="content">
      <jsp:include page="navbar.jsp" />

      <div id="title">
        <h1>Cart</h1>
      </div>

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
      <div id="order-form">
        <form id="form-order-form" action="${context}/checkout" method="POST">
          <h4> First Name: </h4>
          <input name="firstname" type="text" required/>
          <h4> Last Name: </h4>
          <input name="lastname" type="text" required/>
          <h4> Phone Number: </h4>
          <input name="phone-number" type="tel" required/>
          <h4>Shipping Address: </h4>
          <input placeholder="street address" name="street" required/>
          <input placeholder="zip code" name="zip" id="zip" required/>
          <input placeholder="city" name="city" id="city" required/>
          <input placeholder="state" name="state" id="state" required/>
          <h4>Shipping Method: </h4>
          <input name="shipping" type="radio" value="overnight" required/><span>overnight</span><br>
          <input name="shipping" type="radio" value="2-days expedited"/><span>2-days expedited</span><br>
          <input name="shipping" type="radio" checked value="6-days ground"/><span>6-days ground</span><br>
          <br>
          <h4>Creditcard Number: <img id="cc-logo" style="height: 35px;" /> </h4>
          <input type="hidden" name="cc"/>
          <input type="number" min="0" max="9999" name="creditCard1" id="cc1" class="cc-input" required/>
          -
          <input type="number" min="0" max="9999" name="creditCard2" class="cc-input" required/>
          -
          <input type="number" min="0" max="9999" name="creditCard3" class="cc-input" required/>
          -
          <input type="number" min="0" max="9999" name="creditCard4" class="cc-input" required/>
          
          <br>
          <br>
          <h4>Expiration Date: </h4>
          <input class="inputCard" name="expiry" id="expiry" type="month" value="2018-01"  required/>
          <br>
          <h4>Total: $<span id="total">${totalPrice}</span></h4>
          <input type="submit" value="order" />
        </form>
      </div>
    </div>
	</body>
</html>
