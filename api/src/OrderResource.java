package api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Path("/orders")
public class OrderResource {

    @Path("/")
    @POST
    @Produces( { MediaType.APPLICATION_JSON })
    @Consumes( { MediaType.APPLICATION_JSON })
    public Response submitOrder(MultivaluedMap<String, HashMap<String,String>> order) {
      //DataHelper dh = new DataHelper();
      //boolean success = dh.submitOrder(
      //    new HashMap<Integer,Integer>(order.get("cart")),
      //    new HashMap<String,String>(order.get("form"))
      //    );
      //if (products == null || products.isEmpty()){
      //  return Response.status(Response.Status.NOT_FOUND).build();
      //} else {
      //  return Response.ok(products).build();
      //}
      return Response.status(Response.Status.NOT_FOUND).build();
    }
}
