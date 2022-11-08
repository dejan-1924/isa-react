package isa.tim65.projekat.model.DTO;

public class RetValDTO {

	private Boolean isSuccess;
	
	private String responseMessage;

	public RetValDTO(Boolean isSuccess, String responseMessage) {
		super();
		this.isSuccess = isSuccess;
		this.responseMessage = responseMessage;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
