package charlieandroidblog.esy.es.testaltimetrik.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * es para devolver un metodo tipo EndPointApi..  EndPointApi indica el modelo de objetos que se obtienen de
 * la peticion Rest
 */
public class RestAdapterAPI {

    public IEndPointAPI makeRetrofitCall(){

        //esta peticion es solo si el modelo es exactamente igual al del json obtenido del Rest
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitConstants.ROOT_URL) //la base del rest service
                .addConverterFactory(GsonConverterFactory.create())  //deserializa el json..
                .build();

        return retrofit.create(IEndPointAPI.class);
    }
}
