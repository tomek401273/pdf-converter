package pl.com.vigo.odtpdfconverter.ODT2PDF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapProvider {
    public static Map<String, String> getProjectMap() {
        Map<String, String> project = new HashMap<String, String>();
        project.put("Name", "Vigo Test");
        project.put("HomePage", "http://www.vigo.com.pl");
        project.put("Developer", "mkrolikowski@vigo.com.pl");
        return project;
    }


    public static List<Map<String, String>> getDevelopers() {
        List<Map<String, String>> developers = new ArrayList<>();
        Map<String, String> developer1 = new HashMap<>();
        developer1.put("Name", "Mirosław");
        developer1.put("LastName", "Królikowski");
        developer1.put("Mail", "mkrolikowski@vigo.com.pl");
        developers.add(developer1);
        Map<String, String> developer2 = new HashMap<>();
        developer2.put("Name", "Joanna");
        developer2.put("LastName", "Senyszyn");
        developer2.put("Mail", "jsenyszyn@vigo.com.pl");
        developers.add(developer2);
        return developers;
    }
}
