package com.ftg.learn.chapter22.jdbc.util.controller;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public abstract class AbsBaseController<T> {

    public String jsonStringToWeb(CodeType code, MsgType msg, List<T> data, Integer num, Integer page, Integer affected) {
        JSONObject reStr = new JSONObject();
        reStr.put("code", code);
        reStr.put("msg", msg);
        if (data != null || data.isEmpty()) {
            reStr.put("data", data);
        }
        if (num != null) {
            reStr.put("count", num);
        }
        if (page != null && page > 0) {
            reStr.put("page", page);
        }
        if (affected != null) {
            reStr.put("affected", affected);
        }
        return reStr.toString();
    }

    public String OK(List<T> data, Integer num, Integer page) {
        return this.jsonStringToWeb(CodeType.OK,MsgType.SUCCESS,data,null,null,null);
    }

    public String OK(List<T> data){
        return this.jsonStringToWeb(CodeType.OK,MsgType.SUCCESS,data,null,null,null);
    }

    public String OK(int affected){
        return this.jsonStringToWeb(CodeType.OK,MsgType.SUCCESS,null,null,null,affected);
    }


    public String failure(){
        return this.jsonStringToWeb(CodeType.OK,MsgType.FAILURE,null,null,null,-1);
    }
    /**
     * 状态码的枚举
     */
    private enum CodeType {
        /**
         * 成功状态
         */
        OK{
            /**
             * 返回操作的状态码
             * @return
             */
            public int getOk(){
                return 200;
            }
        }

    }

    /**
     * 消息的枚举
     */
    private enum MsgType {
        /**
         * 成功信息
         */
        SUCCESS {
            public String getSuccess() {
                return "当前操作已成功!!!!";
            }
        },
        FAILURE {
            public String getFailure() {
                return "当前操作已失败!!!!";
            }
        }
    }
}
