package livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia;

import com.google.gson.annotations.SerializedName;

public class AdListResponse {

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@SerializedName("data")
	public String data;

	@SerializedName("success")
	private int success;


	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}
}