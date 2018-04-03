package unify.result;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5984256803098100090L;
	
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
	
	private String errMsg = "success";
	private int	sign = SUCCESS;
	private T data = null;
	
	public ResultBean() {}
	
	public ResultBean(T data) {
		this.data = data;
	}
	
	public ResultBean(Throwable e) {
		this.errMsg = e.getMessage();
		this.sign = FAIL;
		this.data = null;
	}
	
	public int getSign() {
		return this.sign;
	}
	
	public String getErrMsg() {
		return this.errMsg;
	}

	public T getData() {
		return this.data;
	}
}
