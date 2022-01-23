package co.mr.apiTest.service;

import org.springframework.ui.Model;

import java.io.IOException;

public interface GetTourInfoService {
    String getTourInfo(String pageNo) throws IOException;
}
