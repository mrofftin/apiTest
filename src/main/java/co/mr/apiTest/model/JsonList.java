package co.mr.apiTest.model;

package com.example;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Body {

    private String dataType;
    private Items items;
    private Integer pageNo;
    private Integer numOfRows;
    private Integer totalCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
        this.numOfRows = numOfRows;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//-----------------------------------com.example.Example.java-----------------------------------

        package com.example;

        import java.util.HashMap;
        import java.util.Map;
        import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Example {

    private Response response;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//-----------------------------------com.example.Header.java-----------------------------------

        package com.example;

        import java.util.HashMap;
        import java.util.Map;
        import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Header {

    private String resultCode;
    private String resultMsg;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//-----------------------------------com.example.Item.java-----------------------------------

        package com.example;

        import java.util.HashMap;
        import java.util.Map;
        import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Item {

    private String tm;
    private String thema;
    private String courseId;
    private String courseAreaId;
    private String courseAreaName;
    private String courseName;
    private Integer spotAreaId;
    private String spotAreaName;
    private String spotName;
    private Integer th3;
    private Integer wd;
    private Integer ws;
    private Integer sky;
    private Integer rhm;
    private Integer pop;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseAreaId() {
        return courseAreaId;
    }

    public void setCourseAreaId(String courseAreaId) {
        this.courseAreaId = courseAreaId;
    }

    public String getCourseAreaName() {
        return courseAreaName;
    }

    public void setCourseAreaName(String courseAreaName) {
        this.courseAreaName = courseAreaName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getSpotAreaId() {
        return spotAreaId;
    }

    public void setSpotAreaId(Integer spotAreaId) {
        this.spotAreaId = spotAreaId;
    }

    public String getSpotAreaName() {
        return spotAreaName;
    }

    public void setSpotAreaName(String spotAreaName) {
        this.spotAreaName = spotAreaName;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public Integer getTh3() {
        return th3;
    }

    public void setTh3(Integer th3) {
        this.th3 = th3;
    }

    public Integer getWd() {
        return wd;
    }

    public void setWd(Integer wd) {
        this.wd = wd;
    }

    public Integer getWs() {
        return ws;
    }

    public void setWs(Integer ws) {
        this.ws = ws;
    }

    public Integer getSky() {
        return sky;
    }

    public void setSky(Integer sky) {
        this.sky = sky;
    }

    public Integer getRhm() {
        return rhm;
    }

    public void setRhm(Integer rhm) {
        this.rhm = rhm;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//-----------------------------------com.example.Items.java-----------------------------------

        package com.example;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Items {

    private List<Item> item = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//---------------com.example.Response.java-----------------------------------

        package com.example;

        import java.util.HashMap;
        import java.util.Map;
        import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Response {

    private Header header;
    private Body body;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
