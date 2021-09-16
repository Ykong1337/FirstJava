package com.ftg.learn.doc.provider;

import com.ftg.learn.doc.entity.FrameEnum;
import com.ftg.learn.doc.service.SelectService;
import org.apache.ibatis.jdbc.SQL;

public class ISaleframerProvider {

    //只用来UPDATE
    public String updatePro(Integer id, String name, String address, String boss, FrameEnum type) {

        SelectService si = new SelectService();

        return new SQL() {
            {
                UPDATE("saleframer");

                if (name != null) {
                    SET("name=#{arg1}");
                }
                if (address != null) {
                    SET("address=#{arg2}");
                }
                if (boss != null) {
                    SET("boss=#{arg3}");
                }
                if (type != null) {
                    SET("type=#{arg4}");
                }
                if (id > 0 && id <= si.sidTest()) {
                    WHERE("id=#{arg0} and flag=1");
                } else {
                    throw new ArrayIndexOutOfBoundsException("sale表的id越界");
                }
            }
        }.toString();
    }
}
