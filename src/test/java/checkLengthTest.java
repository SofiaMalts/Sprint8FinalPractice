import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class checkLengthTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public final String name;
    private final int numberOfCharacters;
    private final int numberOfSpaces;
    private final int spaceIndex;
    private final boolean isLengthValid;
    private final boolean isSpaceCountValid;
    private final boolean isSpaceLocationValid;
    private final boolean isNameValid;

    public checkLengthTest(String name, int numberOfCharacters, int numberOfSpaces, int spaceIndex, boolean isLengthValid, boolean isSpaceCountValid, boolean isSpaceLocationValid, boolean isNameValid) {
        this.name = name;
        this.numberOfCharacters = numberOfCharacters;
        this.numberOfSpaces = numberOfSpaces;
        this.spaceIndex = spaceIndex;
        this.isLengthValid = isLengthValid;
        this.isSpaceCountValid = isSpaceCountValid;
        this.isSpaceLocationValid = isSpaceLocationValid;
        this.isNameValid = isNameValid;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"S A", 2, 1, 1, false, true, true, false},
                {"Sa A", 3, 1, 2, true, true, true, true},
                {"Sa AA", 4, 1, 2, true, true, true, true},
                {"Sofia Arkhipovaaaaa", 18, 1, 5, true, true, true, true},
                {"Sofia Arkhipovaaaaaa", 19, 1, 5, true, true, true, true},
                {"Sofia Arkhipovaaareru", 20, 1, 5, false, true, true, false},
                {"Sofia Arkhi pova", 14, 2, 5, true, false, true, false},
                {"SofiaArkhipova", 14, 0, -1, true, false, false, false},
                {" SofiaArkhipova", 14, 1, 0, true, true, false, false},
                {"SofiaArkhipova ", 14, 1, 14, true, true, false, false},
        };
    }
    @Mock
    Account accountMock;
    @Test
    @DisplayName("countNumberOfSpacesTest")

    public void countNumberOfSpacesTestReturnValidInt(){
        Account account = new Account(name);
        int actual = account.countNumberOfSpaces();
        assertEquals(numberOfSpaces, actual);
    }
    @Test
    @DisplayName("countNumberOfSpacesTest")
    public void getNumberOfCharactersTestReturnValidInt(){
        Account account = new Account(name);
        Mockito.when(accountMock.countNumberOfSpaces()).thenReturn(numberOfSpaces);
        int actual = account.getNumberOfCharacters();
        assertEquals(numberOfCharacters, actual);
    }


        @Test
        @DisplayName("checkLength Test")
        public void checkLengthReturnValidBoolean(){
            Account account = new Account(name);
        Mockito.when(accountMock.getNumberOfCharacters()).thenReturn(numberOfCharacters);
        boolean actualResult = account.checkLength();
        assertEquals(isLengthValid, actualResult);
        }
        @Test
    @DisplayName("checkSpacesNumber Test")
    public void checkSpacesNumberReturnValidBoolean(){
            Account account = new Account(name);
        Mockito.when(accountMock.countNumberOfSpaces()).thenReturn(numberOfSpaces);
        boolean actual = account.checkSpacesNumber();
        assertEquals(isSpaceCountValid, actual);
        }
        @Test
        @DisplayName("getSpaceIndex Test")
        public void getSpaceIndexReturnValidInt(){
            Account account = new Account(name);
        int actual = account.getSpaceIndex();
        assertEquals(spaceIndex, actual);
        }
        @Test
    @DisplayName("checkSpacesLocation Test")
    public void checkSpacesLocationReturnValidBoolean(){
            Account account = new Account(name);
            Mockito.when(accountMock.getSpaceIndex()).thenReturn(spaceIndex);
            boolean actual = account.checkSpacesLocation();
            assertEquals(isSpaceLocationValid, actual);
        }
        @Test
    @DisplayName("checkNameToEmboss Test")
    public void checkNameToEmbossReturnValidBoolean(){
            Account account = new Account(name);
           // !checkLength() || !checkSpacesNumber() || !checkSpacesLocation()
            Mockito.when(accountMock.checkLength()).thenReturn(isLengthValid);
            Mockito.when(accountMock.checkSpacesNumber()).thenReturn(isSpaceCountValid);
            Mockito.when(accountMock.checkSpacesLocation()).thenReturn(isSpaceLocationValid);
            boolean actual = account.checkNameToEmboss();
            assertEquals(isNameValid, actual);
        }


}
