package co.mr.apiTest.controller;

import co.mr.apiTest.model.TourInfo;
import com.google.gson.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiTest {

    @GetMapping("/apiTest")
    public String apiTest(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo, Model model) throws IOException{
        System.out.println("start");
        String date = "2022011010";
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=NgM4AEfqR5lvPHpMnDdOqa1EgpcRUSBeiKmvLmo3RyleWNOBGKNWS%2FNPLpkP12MlI6GGER6keJzILgL2dnuUuQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)*/
        urlBuilder.append("&" + URLEncoder.encode("CURRENT_DATE", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*2016-12-01 01시부터 조회*/
        urlBuilder.append("&" + URLEncoder.encode("HOUR", "UTF-8") + "=" + URLEncoder.encode("24", "UTF-8")); /*CURRENT_DATE부터 24시간 후까지의 자료 호출*/
        urlBuilder.append("&" + URLEncoder.encode("COURSE_ID", "UTF-8") + "=" + URLEncoder.encode("341", "UTF-8")); /*관광 코스ID*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
//        System.out.println(sb);
        // 문자열 객체로 만들어준다. 네트워크를 통해 들어오는 데이터는 일반 텍스트
        String jsonData = sb.toString();

        // 필요데이터만을 처리하기 위한 파싱 작업
        JsonElement jsonElement = JsonParser.parseString(jsonData);
        // 자바 json 객체
        JsonObject object = jsonElement.getAsJsonObject();

        JsonObject responseObj = object.get("response").getAsJsonObject();
//        System.out.println(responseObj);
        JsonObject bodyObj = responseObj.get("body").getAsJsonObject();

        String totalCount = bodyObj.get("totalCount").toString();
        int intTotalCount = Integer.parseInt(totalCount);
        String numOfRows = bodyObj.get("numOfRows").toString();
        int intNumOfRows = Integer.parseInt(numOfRows);

        // 전체 페이지수
        int totalPages = (int) Math.ceil(intTotalCount * 1.0 / intNumOfRows);


//        System.out.println("totalCount : " + totalCount);
//        System.out.println("numOfRows : " + numOfRows);

//        System.out.println(bodyObj);
        JsonObject itemsObj = bodyObj.get("items").getAsJsonObject();
        JsonArray arrayData = itemsObj.get("item").getAsJsonArray();

//        System.out.println(itemsObj.get("item"));
//        JsonArray arrayData = itemsObj.get("item").getAsJsonArray();
//        System.out.println(arrayData);
        Gson gson = new Gson();

//        System.out.println(arrayData.size());
//        TourInfo tourInfo = gson.fromJson(arrayData.get(0), TourInfo.class);

//        System.out.println(tourInfo.getCourseName());
//        System.out.println(tourInfo.getSpotAreaName());

        List<TourInfo> tourInfos = new ArrayList<TourInfo>();

        //https://www.jsonschema2pojo.org/   ----> json class 변환
        for (int i = 0; i < arrayData.size(); i++) {
            TourInfo tourInfo = gson.fromJson(arrayData.get(i), TourInfo.class);
            tourInfos.add(tourInfo);
        }

//        for (TourInfo tInfo : tourInfos) {
//            System.out.println(tInfo.getCourseName());
//            System.out.println(tInfo.getThema());
//        }
        int blockSize = 5;
        int intPageNo = Integer.parseInt(pageNo);


        // 현재 페이지의 블럭 위치
        int blockNum = (intPageNo - 1)/blockSize;

        // 블럭의 시작값 : 1, 6, 11 ... ...
        int blockStart = (blockSize*blockNum)+1;
        // 블럭의 마지막 값 : 5, 10, 15, 20,...
        int blockEnd = blockStart + (blockSize - 1);
        if(blockEnd > totalPages) blockEnd = totalPages;

        int prevPage = blockStart - 1;
        int nextPage = blockEnd + 1;
        if (nextPage > totalPages) nextPage = totalPages;

        model.addAttribute("pageNo", intPageNo);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("blockStart", blockStart);
        model.addAttribute("blockEnd", blockEnd);

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("tourInfos", tourInfos);


//        sb.toString();
//        Gson gson = new GsonBuilder().create();
        // 두번째 인자: 변환하고자 하는 객체
//        DaejeonTourList dinfo = gson.fromJson(sb.toString(), DaejeonTourList.class);
//        return dinfo; // 객체 리턴
//        System.out.println(sb.toString());

        return "test";
    }
}
