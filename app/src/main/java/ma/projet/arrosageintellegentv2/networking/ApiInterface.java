package ma.projet.arrosageintellegentv2.networking;

import java.util.List;

import ma.projet.arrosageintellegentv2.beans.AppUser;
import ma.projet.arrosageintellegentv2.beans.EspaceVert;
import ma.projet.arrosageintellegentv2.beans.Plante;
import ma.projet.arrosageintellegentv2.beans.TypePlante;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("/user/api/login")
    Call<AppUser> Authentifcate(@Body AppUser appUser);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("/user/{id}")
    Call<AppUser> getUser(@Path("id") String id);


    //@Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("espace/api/farmer/espaces_verts/{id}")
    Call<List<EspaceVert>> getespace(@Path("id") String id);
  /*  @GET("/api/products")
    Call<List<Product>> getProducts();

    @GET("/products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    @GET("/products/{id}/sellers")
    Call<Seller> getProductSellers(@Path("id") int id);
*/

    @GET("plante/getallplante")
    Call<List<Plante>> getplante();

    @GET("type/getalltype")
    Call<List<TypePlante>> getTypePlante();
}
