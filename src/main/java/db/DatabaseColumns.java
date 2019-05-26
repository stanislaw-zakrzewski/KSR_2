package db;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseColumns {
    private Map<String, List<String>> map;

    private void initialize() {
        map = new HashMap<>();
        map.put("year", Arrays.asList("p", "w"));
        map.put("quarter", Arrays.asList("p", "w"));
        map.put("month", Arrays.asList("p", "w"));
        map.put("day_of_month", Arrays.asList("p", "w"));
        map.put("day_of_week", Arrays.asList("p", "w"));
        map.put("origin_city_name", Arrays.asList("p", "w"));
        map.put("origin_state_name", Arrays.asList("p", "w"));
        map.put("dest_city_name", Arrays.asList("p", "w"));
        map.put("dest_state_name", Arrays.asList("p", "w"));
        map.put("dep_delay", Arrays.asList("s"));
        map.put("dep_delay_15", Arrays.asList("p", "w"));
        map.put("arr_delay", Arrays.asList("s"));
        map.put("arr_delay_15", Arrays.asList("p", "w"));
        map.put("cancelled", Arrays.asList("p", "w"));
        map.put("cancellation_code", Arrays.asList("p", "w"));
        map.put("diverted", Arrays.asList("p", "w"));
        map.put("distance", Arrays.asList("s"));
        map.put("carrier_delay", Arrays.asList("s"));
        map.put("weather_delay", Arrays.asList("s"));
        map.put("nas_delay", Arrays.asList("s"));
        map.put("security_delay", Arrays.asList("s"));
        map.put("late_aircraft_delay", Arrays.asList("s"));
    }

    public Map<String, List<String>> getColumnsWithProperties() {
        if (map == null) {
            initialize();
        }
        return map;
    }

    public List<String> getColumnNames() {
        if (map == null) {
            initialize();
        }
        return (List<String>) map.keySet();
    }
}
