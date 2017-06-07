package api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/products")
public class ProductResource {

    @Path("/category/{name}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getProductsByCategoryName(@PathParam("name") String name) {
      DataHelper dh = new DataHelper();
      List<Product> products = dh.getProducts(name);
      if (products == null || products.isEmpty()){
        return Response.status(Response.Status.NOT_FOUND).build();
      } else {
        return Response.ok(products).build();
      }
    }

    @Path("/categories")
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getProductCategories() {
      DataHelper dh = new DataHelper();
      HashMap<String,Category> categories = dh.getCategories();
      if (categories == null || categories.isEmpty()){
        return Response.status(Response.Status.NOT_FOUND).build();
      } else {
        return Response.ok(categories).build();
      }
    }

    @Path("/{id}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getProductById(@PathParam("id") int id) {
      DataHelper dh = new DataHelper();
      Product product = dh.getProduct(id);
      if (product == null){
        return Response.status(Response.Status.NOT_FOUND).build();
      } else {
        return Response.ok(product).build();
      }
    }

    @Path("/")
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getProductsByIds(@QueryParam("ids") List<Integer> ids) {
      DataHelper dh = new DataHelper();
      ArrayList<Product> products = dh.getProductList(new ArrayList<>(ids));
      if (products == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
      } else {
        return Response.ok(products).build();
      }
    }
}
