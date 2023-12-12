package livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import leaflist.showcard.meadiablink.chemburplacard.Chemburmodel.AppDataResponse;

public class LocaladsResponce {

	@SerializedName("data")
	private List<AppDataResponse> data;

	@SerializedName("success")
	private int success;

	public void setData(List<AppDataResponse> data){
		this.data = data;
	}

	public List<AppDataResponse> getData(){
		return data;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}
}