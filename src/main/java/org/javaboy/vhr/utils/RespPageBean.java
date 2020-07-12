package org.javaboy.vhr.utils;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-11 10:06
 **/
public class RespPageBean {

    /**
     * 总数据条数
     */
    private long total;

    /**
     * 每页展示的数据
     */
    private List<?> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
