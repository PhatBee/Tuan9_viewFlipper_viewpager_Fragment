package vn.phatbee.tuan9_viewflipper_viewpager_fragment.retrofit;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.model.MessageModel;

public interface ApiService {
    @FormUrlEncoded
    @POST("newimagesmanager.php")
    Call<MessageModel> getImageSlider(@Field("position") int position);
}
