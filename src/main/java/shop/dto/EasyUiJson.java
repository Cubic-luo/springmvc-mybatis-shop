package shop.dto;

import java.util.List;

/**
 * easyUI要求的json输出格式
 * Created by Administrator on 2017/3/18.
 */
public class EasyUiJson<T> {
    private long total;
    private T rows;

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyUiJson{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
