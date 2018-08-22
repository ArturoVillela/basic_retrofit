package charlieandroidblog.esy.es.testaltimetrik.Rest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface IEndPointAPI {

    //lo que llega del server..
    //@GET(RetrofitConstants.URL)
    //Call<BeanResponseObject> getResponseForNotificationMade();


    @GET(RetrofitConstants.URL)
    Call<BeanResponseObject> getResponseForNotificationMade(
            @QueryMap Map<String, String> options
    );


}
