

public class ResponseEntity {
	/**
	 * 响应状态码
	 */
	private String statusCode;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	/**
	 * 响应内容
	 */
	private String content;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResponseEntity [statusCode=" + statusCode + ", errorMsg=" + errorMsg + ", content=" + content + "]";
	}
}
