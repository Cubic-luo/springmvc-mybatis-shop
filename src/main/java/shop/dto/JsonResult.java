package shop.dto;

public class JsonResult<T> {

	private T data;

	public JsonResult() {

	}

	public JsonResult(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [data=" + data + "]";
	}

}
