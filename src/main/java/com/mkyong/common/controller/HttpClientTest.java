package com.mkyong.common.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.ObjectNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

public class HttpClientTest {

    public static void main(String args[]) throws IOException {

        doPost();

    }

    public static void doPost() throws IOException {

        String jsonStr="{\"startTime\":\"2018-07-25\",\"endTime\":\"2018-08-02\",\"trunkGroupName\":\"ATLAGAQLBS1_2748\"}";

        StringEntity entity = new StringEntity(jsonStr,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        String url="http://itchil130:8080/ReportingService/rest/services/getQOSCountsData";

        HttpPost request = new HttpPost(url);
        request.setEntity(entity);
        request.setHeader("X-Username","admin");

        HttpResponse response = httpClient.execute(request);
        String resultStr=toJsonString(response.getEntity());

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("status code:"+statusCode);
        if(statusCode>=200 && statusCode<=299)
            System.out.println(resultStr);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(resultStr);
        System.out.println(actualObj.get("status").asText());

        System.out.println(actualObj.get("countsDataResponse").get("allCountsList").withArray("allCountsListItem"));
    }


    public static String toJsonString(HttpEntity httpEntity) throws IOException {
        return EntityUtils.toString(httpEntity);
    }

}
