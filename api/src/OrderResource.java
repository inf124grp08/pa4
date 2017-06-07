package api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

@Path("/orders")
public class OrderResource {

    @Path("/")
    @POST
    @Produces( { MediaType.APPLICATION_JSON })
    @Consumes( { MediaType.APPLICATION_JSON })
    public Response submitOrder(String json) {
      DataHelper dh = new DataHelper();

      System.out.println("PROVED GOT TO API....");

      System.out.println(json);


      Gson gson = new Gson();
      Type type = new TypeToken<HashMap<String,HashMap<String,String>>>(){}.getType();
      HashMap<String, HashMap<String,String>> map = gson.fromJson(json, type);
      System.out.println(" NOW REALLY SUBMITTING ORDER LOL");

      boolean success = dh.submitOrder(map.get("cart"), map.get("form"));

      if (success){
        return Response.ok().build();
      } else {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
    }
}
