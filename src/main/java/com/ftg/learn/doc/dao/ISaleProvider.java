package com.ftg.learn.doc.dao;

import org.apache.ibatis.jdbc.SQL;

public class ISaleProvider {

    //只用来UPDATE
    public String updatePro(Integer id, String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate) {

        SelInfoDao si = new SelInfoDao();

        return new SQL() {
            {
                UPDATE("sale");

                if (name != null) {
                    SET("name=#{arg1}");
                }
                if (address != null) {
                    SET("address=#{arg2}");
                }
                if (fid != null) {
                    if (fid > 0 && fid <= si.fidTest()) {
                        SET("fid=#{arg3}");
                    } else {
                        throw new ArrayIndexOutOfBoundsException("请输入正确的农场id");
                    }
                }
                if (unit != null) {
                    SET("unit=#{arg4}");
                }
                if (price != null) {
                    SET("price=#{arg5}");
                }
                if (type != null) {
                    SET("type=#{arg6}");
                }
                if (scdate != null) {
                    SET("scdate=#{arg7}");
                }
                if (ccdate != null) {
                    SET("ccdate=#{arg8}");
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
