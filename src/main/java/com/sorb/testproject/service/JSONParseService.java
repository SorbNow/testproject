/*
package com.sorb.testproject.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class JSONParseService {

    public String parseJSON(String inputJSON, String requiredPartOfJSON) {
        String result = "";
        try {
            JSONObject object = (JSONObject) new JSONParser().parse(inputJSON);
            JSONArray array = (JSONArray) object.get(requiredPartOfJSON);
            if (array==null)
            {
                result = (String) object.get(requiredPartOfJSON);
            }
            else
            return array.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
*/
