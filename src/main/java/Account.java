public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
if(!checkLength() || !checkSpacesNumber() || !checkSpacesLocation()){
    return false;
}
else {
    return true;
}
    }
    public boolean checkLength(){
        int numberOfCharacters = getNumberOfCharacters();
        if(numberOfCharacters < 3 || numberOfCharacters>19){

            return false;

        }
        else {
            return true;}
        }
        public int getNumberOfCharacters(){
            int numberOfSpaces = countNumberOfSpaces();
            int numberOfCharacters = name.length() - numberOfSpaces;
            System.out.println("numberOfCharacters: "+numberOfCharacters);
            return numberOfCharacters;
        }

    public boolean checkSpacesNumber(){
    int numberOfSpaces = countNumberOfSpaces();
    System.out.println("Number of spaces: "+numberOfSpaces);
    if(numberOfSpaces != 1){

        return false;
    }
    else {return true;}

    }
    public boolean checkSpacesLocation(){
    int i = getSpaceIndex();
    int stringStartIndex = 0;
    int stringEndIndex = name.length() - 1;
    System.out.println("Space index: "+i);
    if(i == stringStartIndex || i == stringEndIndex || i == -1){

        return false;
    }
    else {return true;}
    }
    public int getSpaceIndex(){
      return name.indexOf(" ");
    }
    public int countNumberOfSpaces(){
    int i = name.indexOf(" ");
    int count = 0;
    while (i != -1) {
        i = name.indexOf(" ", i + 1);
        count += 1;
    }
    return count;
}
}