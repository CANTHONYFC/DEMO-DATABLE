/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.servlets;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Myuser
 */
public class JsonMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String StringJson = "{\"respuestas\":[\"{\\\"id\\\":1,\\\"resp\\\":1}\",\"{\\\"id\\\":2,\\\"resp\\\":1}\",\"{\\\"id\\\":3,\\\"resp\\\":1}\",\"{\\\"id\\\":4,\\\"resp\\\":1}\",\"{\\\"id\\\":5,\\\"resp\\\":1}\",\"{\\\"id\\\":6,\\\"resp\\\":1}\",\"{\\\"id\\\":7,\\\"resp\\\":1}\",\"{\\\"id\\\":8,\\\"resp\\\":1}\",\"{\\\"id\\\":9,\\\"resp\\\":1}\",\"{\\\"id\\\":10,\\\"resp\\\":1}\",\"{\\\"id\\\":11,\\\"resp\\\":1}\",\"{\\\"id\\\":12,\\\"resp\\\":1}\",\"{\\\"id\\\":13,\\\"resp\\\":1}\",\"{\\\"id\\\":14,\\\"resp\\\":1}\",\"{\\\"id\\\":15,\\\"resp\\\":1}\",\"{\\\"id\\\":16,\\\"resp\\\":1}\",\"{\\\"id\\\":17,\\\"resp\\\":1}\",\"{\\\"id\\\":18,\\\"resp\\\":1}\",\"{\\\"id\\\":19,\\\"resp\\\":1}\",\"{\\\"id\\\":20,\\\"resp\\\":1}\",\"{\\\"id\\\":21,\\\"resp\\\":1}\",\"{\\\"id\\\":22,\\\"resp\\\":1}\",\"{\\\"id\\\":23,\\\"resp\\\":1}\",\"{\\\"id\\\":24,\\\"resp\\\":1}\",\"{\\\"id\\\":25,\\\"resp\\\":1}\",\"{\\\"id\\\":26,\\\"resp\\\":1}\",\"{\\\"id\\\":27,\\\"resp\\\":1}\",\"{\\\"id\\\":28,\\\"resp\\\":1}\",\"{\\\"id\\\":29,\\\"resp\\\":1}\",\"{\\\"id\\\":30,\\\"resp\\\":1}\",\"{\\\"id\\\":31,\\\"resp\\\":1}\",\"{\\\"id\\\":32,\\\"resp\\\":1}\",\"{\\\"id\\\":33,\\\"resp\\\":1}\",\"{\\\"id\\\":34,\\\"resp\\\":1}\",\"{\\\"id\\\":35,\\\"resp\\\":1}\",\"{\\\"id\\\":36,\\\"resp\\\":1}\",\"{\\\"id\\\":37,\\\"resp\\\":1}\",\"{\\\"id\\\":38,\\\"resp\\\":1}\",\"{\\\"id\\\":39,\\\"resp\\\":1}\",\"{\\\"id\\\":40,\\\"resp\\\":1}\",\"{\\\"id\\\":41,\\\"resp\\\":1}\",\"{\\\"id\\\":42,\\\"resp\\\":1}\",\"{\\\"id\\\":43,\\\"resp\\\":1}\",\"{\\\"id\\\":44,\\\"resp\\\":1}\",\"{\\\"id\\\":45,\\\"resp\\\":1}\",\"{\\\"id\\\":46,\\\"resp\\\":1}\",\"{\\\"id\\\":47,\\\"resp\\\":1}\",\"{\\\"id\\\":48,\\\"resp\\\":1}\",\"{\\\"id\\\":49,\\\"resp\\\":1}\",\"{\\\"id\\\":50,\\\"resp\\\":1}\",\"{\\\"id\\\":51,\\\"resp\\\":1}\",\"{\\\"id\\\":52,\\\"resp\\\":1}\",\"{\\\"id\\\":53,\\\"resp\\\":1}\",\"{\\\"id\\\":54,\\\"resp\\\":1}\",\"{\\\"id\\\":55,\\\"resp\\\":1}\",\"{\\\"id\\\":56,\\\"resp\\\":1}\",\"{\\\"id\\\":57,\\\"resp\\\":1}\",\"{\\\"id\\\":58,\\\"resp\\\":1}\",\"{\\\"id\\\":59,\\\"resp\\\":1}\",\"{\\\"id\\\":60,\\\"resp\\\":1}\"],\"dni\":\"2\"}\n"
                + "";

        JSONObject json = new JSONObject(StringJson);
        System.out.println(json);
        String dni = json.getString("dni");
        System.out.println(dni);
        JSONArray respuestas = json.getJSONArray("respuestas");
        System.out.println(respuestas);

        String StringRespuesta = respuestas.getString(1);
        System.out.println(StringRespuesta);
        JSONObject respuesta = new JSONObject(StringRespuesta);
        System.out.println(respuesta);
        System.out.println(respuesta.getInt("resp"));
        System.out.println(respuesta.getInt("id"));
    }

}
