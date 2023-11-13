import java.util.Random;

//this class work as backend and will generate the password
public class PasswordGenerator {
    //character pools
    //these String will hold all the
    public static final String LOWERCASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    //the random class allows us to generate a random number wich will be used to randomlyyy choos ethe characters
    private final Random random;

    //constructor
    public PasswordGenerator(){
        random=new Random();
    };

    public String generatePassword(int length,boolean includeUppercase,boolean includeLowercase,  boolean includeNumbers, boolean includeSpecialSymbol){

        //we are using String builder over String for better efficienty

        StringBuilder passwordBuilder = new StringBuilder();


        // Include at least one character from each selected set
        if (includeUppercase) {
            passwordBuilder.append(UPPERCASE_CHAR.charAt(random.nextInt(UPPERCASE_CHAR.length())));
            length--; // Decrement length since one character is already included
        }
        if (includeLowercase) {
            passwordBuilder.append(LOWERCASE_CHAR.charAt(random.nextInt(LOWERCASE_CHAR.length())));
            length--;
        }
        if (includeNumbers) {
            passwordBuilder.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
            length--;
        }
        if (includeSpecialSymbol) {
            passwordBuilder.append(SPECIAL_SYMBOLS.charAt(random.nextInt(SPECIAL_SYMBOLS.length())));
            length--;
        }


        //store valid characters
        String validCharacters= "";
        if(includeUppercase) validCharacters+=UPPERCASE_CHAR;
        if(includeLowercase) validCharacters+=LOWERCASE_CHAR;
        if(includeNumbers) validCharacters+=NUMBERS;
        if(includeSpecialSymbol) validCharacters+=SPECIAL_SYMBOLS;

        //build password
        for(int i=0;i<length;i++){
            //generate a random index
            int randomIndex = validCharacters.length() > 0 ? random.nextInt(validCharacters.length()) : 0;
            char randomChar = validCharacters.length() > 0 ? validCharacters.charAt(randomIndex) : ' ';
            //int randomIndex= validCharacters.isEmpty() ?0:random.nextInt(validCharacters.length());
            //get the char based on the random index
           // char randomChar= validCharacters.charAt(randomIndex);

            //store char into builder
            passwordBuilder.append(randomChar);
            // do this untill the we have reached the length that the user has provided to us l
        }

    //return result
        return passwordBuilder.toString();

    }
}

