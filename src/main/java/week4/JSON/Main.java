// using JSON.simple : a simple Java toolkit for JSON
// https://code.google.com/archive/p/json-simple and json_simple-1.1.jar

package week4.JSON;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) {

        int cnt = 0;
        JSONParser parser = new JSONParser();
        ArrayList<Flight> mylist = new ArrayList<Flight>();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(new File("departures.json")));
            JSONArray array = (JSONArray) jsonObject.get("departures");

            int id = 1;
            for (Object o : array) {
                JSONObject item = (JSONObject) o;

                Flight f = new Flight(id++, (String) item.get("time"), (String) item.get("destination"), (String) item.get("flight"), (String) item.get("gate"));
                // print the flight
                System.out.println(f);
            }       
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        try {
//            // JSONObject jsonObject =
//            // JSONArray array =
//
//            for (Object o : array) {
//                // your code
//
//                // print the flight
//                System.out.println(f);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        assert mylist.size() == 20;
    }
}
