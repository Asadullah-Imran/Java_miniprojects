import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//retrieve weather data from api - this backend logic will fetch the latest wether
//data from the external api and return it , the gui will
// dispplay this data to the users
public class WeatherApp {
//fetch weather data for given location
    public static JSONObject getWeatherData(String locationName){
        //get location coordinates useing hte the geolocation api
        JSONArray locationData =getLocationData(locationName);

        //extract latitute and logitude data (from the data we can see the first objext stored is usually the city we are looking for )
        JSONObject location= (JSONObject) locationData.get(0);
        double latitude= (double) location.get("latitude");
        double longitude= (double) location.get("longitude");

        //build API request URL with location coordinates


        String urlString="https://api.open-meteo.com/v1/forecast?" +
                "latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m&timezone=Asia%2FTokyo";




        try{
            //call api and get response
            HttpURLConnection conn= fetchApiResponse(urlString);

            //check response status
            //  200 means successfull connection
            if(conn.getResponseCode()!=200){
                System.out.println("Error: could not connect to API");
                return null;
            }else{

                StringBuilder resultJson= new StringBuilder();
                Scanner scanner= new Scanner(conn.getInputStream());

                //read and store the resulting json data int o outr string builder
                while(scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                }
                scanner.close();

                //close url connection
                conn.disconnect();

                //parse json string into a json obh
                JSONParser parser= new JSONParser();
                JSONObject resultsJsonObj= (JSONObject) parser.parse(String.valueOf(resultJson));

                //retrieve hourly data

                JSONObject hourly= (JSONObject) resultsJsonObj.get("hourly");

                //we want to get the current hours data
                // so we need to get the index of our current hour
                JSONArray time =(JSONArray) hourly.get("time");
                int index= findIndexOfCurrentTime(time);


                //get temperature 
                JSONArray temperatureData= (JSONArray) hourly.get("temperature_2m");
                double temperature= (double) temperatureData.get(index);

                //get weather code 
                JSONArray weathercode= (JSONArray) hourly.get("weather_code");
                String weatherCondition= convertWeatherCode((long) weathercode.get(index)); 
                
                //get Humidity
                JSONArray relativeHumidty= (JSONArray) hourly.get("relative_humidity_2m");
                long humidity= (long) relativeHumidty.get(index);

                //get wind speed
                JSONArray windspeedData= (JSONArray) hourly.get("wind_speed_10m");
                double windspeed=(double) windspeedData.get(index);

                //build the weather json data object that we are going to access in our frondtend
                JSONObject weatherData= new JSONObject();
                weatherData.put("temperature",temperature);
                weatherData.put("weather_condition", weatherCondition);
                weatherData.put("humidity",humidity);
                weatherData.put("windspeed",windspeed);

                return weatherData;

            }

        }
        catch(Exception e){e.printStackTrace();}


        return null;
    }

    //retrieve geographic coordinates for given location name
    public static JSONArray getLocationData(String locationName){
        //replace any whitespaces in location name to + to adhere to apis request format
        locationName= locationName.replaceAll(" ","+");

        //build api url location parameter
        String urlString="https://geocoding-api.open-meteo.com/v1/search?name=" +
                locationName+"&count=10&language=en&format=json";

        try{
            //call api and get a response
            HttpURLConnection conn = fetchApiResponse(urlString);

            //check response status
            //  200 means successfull connection
            if(conn.getResponseCode()!=200){
                System.out.println("Error: could not connect to API");
                return null;
            }else{
                StringBuilder resultJson= new StringBuilder();
                Scanner scanner= new Scanner(conn.getInputStream());

                //read and store the resulting json data int o outr string builder
                while(scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                }
                scanner.close();

                //close url connection
                conn.disconnect();

                //parse json string into a json obh
                JSONParser parser= new JSONParser();
                JSONObject resultsJsonObj= (JSONObject) parser.parse(String.valueOf(resultJson));

                //get the list of location data the api alternated from the location name
                JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
                return  locationData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //as could not find
        return null;
    }


    private static HttpURLConnection fetchApiResponse(String urlString){
        try{
            //attempt to create connection

            URL url= new URL(urlString);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();

            //set request method to get

            conn.setRequestMethod("GET");

            //connect to our API
            conn.connect();
            return conn;

        }catch(Exception e){e.printStackTrace();

        }
        return null;
    }


    private static int findIndexOfCurrentTime(JSONArray timeList){
        String currentTime= getCurrentTime();

        //iterate through the time list and see which are mathces our current time
        for(int i=0;i<timeList.size();i++){
            String time=(String) timeList.get(i);
            if(time.equalsIgnoreCase(currentTime)){
                //return the index
                return i;
            }
        }



        return 0;
    }
    public static String getCurrentTime(){
        //get current date and time
        LocalDateTime currentDateTIme=LocalDateTime.now();

        //format date to be 2023-11-04T00:00 (this is how is read in the api)
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");

        //format and print the current data and time
        String formattedDateTime= currentDateTIme.format(formatter);
        return formattedDateTime;
    }
    
    
    //convert the weather code to something more readable
    private static String convertWeatherCode(long weathercode){
        String weatherCondition="";
        if(weathercode==0L){
            weatherCondition="Clear";
        } else if (weathercode>0L && weathercode<=3L) {
            weatherCondition="Cloudy";
        } else if ((weathercode>=51L && weathercode<=67L)|| (weathercode>=80L && weathercode<=99L)) {
            weatherCondition="Rain";
        } else if (weathercode>=71L && weathercode<=77L) {
            weatherCondition="Snow";
        }

        return weatherCondition;
    }

}
