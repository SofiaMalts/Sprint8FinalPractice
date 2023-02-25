public class Practicum {
    private static final String name = "Sofia Arkhipova";
    //private static final String name = "Sofia Arkhipovaaarer";
    //private static final String name = "S o";
    //private static final String name = "Sofia Arkhi pova";
    //private static final String name = "SofiaArkhipova";

   // private static final String name = " SofiaArkhipova";
   // private static final String name = "SofiaArkhipova ";
    //private static final String name = " SofiaArkhipova ";
    public static void main(String[] args) {
        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */

        Account account = new Account(name);
        if(!account.checkNameToEmboss()){
            System.out.println("The name is INCORRECT");
        }
        else {System.out.println("The name is CORRECT");}

    }
}
