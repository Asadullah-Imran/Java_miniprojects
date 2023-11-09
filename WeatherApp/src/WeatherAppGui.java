import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGui extends JFrame {
    private JSONObject weatherData;

    public WeatherAppGui(){
        super("Weather App");
        //configure that on close button it will end the program
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(450,650);

        //load our gui at the center of the screen
        setLocationRelativeTo(null);

        //make layout null so that we can manually position our components
        setLayout(null);

        //prevent any resize
        setResizable(false);

        addGuiComponents();
    }
    public void addGuiComponents(){

        //search Field
        JTextField searchTextField = new JTextField();

        searchTextField.setBounds(15,15,351,45);

        //change fonst style and size
        searchTextField.setFont(new Font("Dialog", Font.PLAIN,24));

        //adding searchText field
        add(searchTextField);





        //Weather Image
        JLabel weatherConditionImage= new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0,125,450,217);
        add(weatherConditionImage);


        //temperature text
        JLabel temperatureText= new JLabel("10 C");
        temperatureText.setBounds(0,350,450,54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        //center the Text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);


        //weather condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0,405,450,36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.BOLD, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);



        //humidity Image
        JLabel humidityImage= new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15,500,74,66);
        add(humidityImage);

        //humidity text
        JLabel humidityText = new JLabel("Cloudy");
        humidityText.setBounds(90,500,85,55);
        humidityText.setFont(new Font("Dialog", Font.BOLD, 16));
        add(humidityText);


        //windspeed Image
        JLabel windSpeedImage= new JLabel(loadImage("src/assets/windspeed.png"));
        windSpeedImage.setBounds(220,500,74,66);
        add(windSpeedImage);

        //windspeed text
        JLabel windSpeedText = new JLabel("<html><b>Windspeed</b></html>");
        windSpeedText.setBounds(310,500,85,55);
        windSpeedText.setFont(new Font("Dialog", Font.BOLD, 16));
        add(windSpeedText);



        //Search button
        JButton searchButton= new JButton(loadImage("src/assets/search.png"));

        //change the cursor to a hand cursor when hovering this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375 ,13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get location from user ;
                String userInput= searchTextField.getText();

                //validate input - remove whitespaces to wnsure non empty text
                if(userInput.replaceAll("\\s","").length()<=0){
                    return;
                }
                //retrieve weather data
                weatherData=WeatherApp.getWeatherData(userInput);

                //update gui

                //update weather imagee
                String weatherCondition=(String) weatherData.get("weather_condition");
                //depending on the condition, we will update the weather image tha tcorespinds with the condtion
                switch(weatherCondition){
                    case "Clear":
                        weatherConditionImage.setIcon(loadImage("src/assets/clear.png"));
                        break;
                    case "Cloudy":
                        weatherConditionImage.setIcon(loadImage("src/assets/cloudy.png"));
                        break;
                    case "Rain":
                        weatherConditionImage.setIcon(loadImage("src/assets/rain.png"));
                        break;
                    case "Snow":
                        weatherConditionImage.setIcon(loadImage("src/assets/snow.png"));
                        break;

                }

                //update temperature text
                double temperature =(double) weatherData.get("temperature");
                temperatureText.setText(temperature+" C");

                //update weather condition text
                weatherConditionDesc.setText(weatherCondition);

                //update Humidity Text
                long humidity= (long) weatherData.get("humidity");
                humidityText.setText("<html><b>Humidity</b> "+ humidity +"%</html>");

                //update windspeed text
                double windspeed= (double) weatherData.get("windspeed");
                windSpeedText.setText("<html><b>Windspeed</b> "+ windspeed +"km/h</html>");
            }
        });

        add(searchButton);


    }
    private ImageIcon loadImage(String reasourcePath){
        try {
            //read the image file from the path given
            BufferedImage image= ImageIO.read(new File(reasourcePath));

            //returns an imaage icon so that our component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Couldnot find the resource ");
        return  null;
        }
    }

