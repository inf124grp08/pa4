package app;
import java.util.*;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class RestHelper {
  private URI getBaseURI() {
    return UriBuilder.fromUri("http://andromeda-16.ics.uci.edu:5016/pa4api").build();
  }

  public HashMap<String,Category> getCategories() {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget target = client.target(getBaseURI());
    String jsonResponse = target.
      path("v1").path("api").path("products").path("categories").
      request().
      accept(MediaType.APPLICATION_JSON).
      get(String.class);

    Gson gson = new Gson();
    Type type = new TypeToken<HashMap<String, Category>>(){}.getType();
    return gson.fromJson(jsonResponse, type);
  }

  public ArrayList<Product> getProducts(String catName) {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget target = client.target(getBaseURI());
    String jsonResponse = target.
      path("v1").path("api").path("products").path("category").path(catName).
      request().
      accept(MediaType.APPLICATION_JSON).
      get(String.class);

    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<Product>>(){}.getType();
    return gson.fromJson(jsonResponse, type);
  }

  public Product getProduct(int id) {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget target = client.target(getBaseURI());
    String jsonResponse = target.
      path("v1").path("api").path("products").path(Integer.toString(id)).
      request().
      accept(MediaType.APPLICATION_JSON).
      get(String.class);

    Gson gson = new Gson();
    Type type = new TypeToken<Product>(){}.getType();
    return gson.fromJson(jsonResponse, type);
  }

  public ArrayList<Product> getProductList(ArrayList<Integer> ids) {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget target = client.target(getBaseURI()).
      path("v1").path("api").path("products");

    for (int id : ids) {
      target = target.queryParam("ids", Integer.toString(id));
    }

    String jsonResponse = target.request().
      accept(MediaType.APPLICATION_JSON).
      get(String.class);

    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<Product>>(){}.getType();
    return gson.fromJson(jsonResponse, type);
  }

  public boolean submitOrder(HashMap<Integer,Integer> cart, HashMap<String, String> form) {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget target = client.target(getBaseURI()).
      path("v1").path("api").path("orders");

    Gson gson = new Gson();
    JsonObject payload = new JsonObject();
    HashMap<String,String> cartStr = new HashMap<String,String>();
    for (Map.Entry<Integer,Integer> e : cart.entrySet()){
      cartStr.put(Integer.toString(e.getKey()), Integer.toString(e.getValue()));
    }
    payload.add("cart", gson.toJsonTree(cartStr));
    payload.add("form", gson.toJsonTree(form));

    Response response = target.
      request("application/json").post(Entity.json(payload.toString()));
    return response.getStatus() == 200;
  }
}
