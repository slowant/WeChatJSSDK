package com.z.wechatjssdk.webview.service.impl;

import com.z.wechatjssdk.webview.bean.event.LocalImgId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 15-4-24.
 * 选择图片
 */
public class ChooseImageServiceImpl extends BaseServiceImpl {

    LocalImgId localImgId;

    @Override
    public void parserReqJSON(JSONObject jsonObject) throws JSONException {
        localImgId=(LocalImgId)mRequest.getTag();
    }
    @Override
    public void setResultJSON() throws JSONException {
       mJoResult.put("localIds", null==localImgId?"":toJsonArray(localImgId.getLocalIds()));
        setOkResult();
    }

    /**
     * 把图片ArrayList<String> 转为 JSONArray
     * @param list
     * @return
     * @throws JSONException
     */
    public JSONArray toJsonArray(ArrayList<String> list) throws JSONException{

        JSONArray array = new JSONArray();
        if (null!=list){
            for (int i=0;i<list.size();i++){
                array.put(i,list.get(i));
            }
        }

        return array;
    }
}
