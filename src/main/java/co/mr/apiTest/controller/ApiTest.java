package co.mr.apiTest.controller;

import co.mr.apiTest.model.ThemaType;
import co.mr.apiTest.model.TourInfo;
import co.mr.apiTest.service.GetTourInfoService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiTest {

    @Autowired
    private GetTourInfoService infoService;

    @GetMapping("/apiTest")
    public String apiTest(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo,
                          @RequestParam(value = "thema", required = false, defaultValue = "") String thema,
                          Model model) throws IOException{

        String jsonData = infoService.getTourInfo(pageNo) ;

        // 필요데이터만을 처리하기 위한 파싱 작업
        JsonElement jsonElement = JsonParser.parseString(jsonData);
        // 자바 json 객체
        JsonObject object = jsonElement.getAsJsonObject();

        JsonObject responseObj = object.get("response").getAsJsonObject();
        JsonObject bodyObj = responseObj.get("body").getAsJsonObject();

        String totalCount = bodyObj.get("totalCount").toString();
        int intTotalCount = Integer.parseInt(totalCount);
        String numOfRows = bodyObj.get("numOfRows").toString();
        int intNumOfRows = Integer.parseInt(numOfRows);

        // 전체 페이지수
        int totalPages = (int) Math.ceil(intTotalCount * 1.0 / intNumOfRows);

        System.out.println(bodyObj);
        JsonObject itemsObj = bodyObj.get("items").getAsJsonObject();
        JsonArray arrayData = itemsObj.get("item").getAsJsonArray();

        Gson gson = new Gson();

        List<TourInfo> tourInfos = new ArrayList<TourInfo>();

        //https://www.jsonschema2pojo.org/   ----> json class 변환
        for (int i = 0; i < arrayData.size(); i++) {
//            JsonObject obj = arrayData.get(i).getAsJsonObject();
//            System.out.println(obj.get("thema").toString());
//            String str = "\"종교/역사/전통\"";
//            System.out.println(str);
//            System.out.println(obj.get("thema").toString().equals(str));
//            System.out.println((obj.get("thema").toString()).equals("종교/역사/전통"));
//            if(obj.get("thema").toString().equals(str)){
                TourInfo tourInfo = gson.fromJson(arrayData.get(i), TourInfo.class);
                tourInfos.add(tourInfo);
//            }
        }

        System.out.println("리스트 사이즈 :" + tourInfos.size());

        // paging
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

        thema = "종교/역사/전통";

        System.out.println("themaValue : " + thema);

        model.addAttribute("themaType", new ThemaType());

        model.addAttribute("themaValue", thema);
        model.addAttribute("pageNo", intPageNo);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("blockStart", blockStart);
        model.addAttribute("blockEnd", blockEnd);

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("tourInfos", tourInfos);

        return "test";
    }
}
