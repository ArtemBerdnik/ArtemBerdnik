package api;

import api.enums.Language;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import static api.core.YandexSpellerApi.*;
import static api.core.YandexSpellerConstants.*;
import static api.enums.ErrorCodes.*;
import static api.enums.Language.EN;
import static api.enums.Language.INSISTING_LANGUAGE;
import static api.enums.Options.*;
import static api.enums.TestWordsEng.*;
import static api.enums.TestWordsRus.CITY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class TestYandexSpellerJSON {

    @Test
    public void checkSeveralWordsWithMisspelling() {
        responses = getYandexSpellerAnswers(with()
                .text(BROTHER.wrongVer(), LAPTOP.wrongVer())
                .language(EN)
                .callApi());

        assertTrue(responses.get(0).get(0).s.contains(BROTHER.corrVer()));
        assertTrue(responses.get(1).get(0).s.contains(LAPTOP.corrVer()));

    }

    @Test
    public void checkOptionToIgnoreDigits() {
        responses = getYandexSpellerAnswers(with()
                .text(WORD_WITH_LEADING_DIGITS.wrongVer(), WORD_WITH_ENDING_DIGITS.wrongVer())
                .language(EN)
                .callApi());

        assertTrue(responses.get(0).get(0).s.contains(WORD_WITH_LEADING_DIGITS.corrVer()));

        //This assert will fail (a bug in API might be?)
        assertTrue(responses.get(1).get(0).s.contains(WORD_WITH_ENDING_DIGITS.corrVer()));

        responses = getYandexSpellerAnswers(with()
                .text(WORD_WITH_LEADING_DIGITS.wrongVer(), WORD_WITH_ENDING_DIGITS.wrongVer())
                .language(EN)
                .options(IGNORE_DIGITS.code)
                .callApi());

        assertTrue(responses.get(0).isEmpty());
        assertTrue(responses.get(1).isEmpty());
    }

    @Test
    public void checkMultiplyOptionsForRequest() {
        String option = sumOfOptions(IGNORE_CAPITALIZATION, IGNORE_URLS);
        responses = getYandexSpellerAnswers(with()
                .text(WORD_WITH_URL.wrongVer(), WORD_WITH_CAPITALIZATION.wrongVer())
                .language(EN)
                .callApi());

        //2 assertions below will fail due to an empty response from the Speller
        assertTrue(responses.get(0).get(0).s.contains(WORD_WITH_URL.corrVer()));
        assertTrue(responses.get(1).get(0).s.contains(WORD_WITH_CAPITALIZATION.corrVer()));

        responses = getYandexSpellerAnswers(with()
                .text(WORD_WITH_URL.wrongVer(), WORD_WITH_CAPITALIZATION.wrongVer())
                .options(option)
                .language(EN)
                .callApi());

        //2 assertions below will pass, but not because of introducing "Option", but because the response is always empty
        assertTrue(responses.get(0).isEmpty());
        assertTrue(responses.get(1).isEmpty());
    }

    @Test
    public void checkRepeatWordError() {
        responses = getYandexSpellerAnswers(with()
                .text(WORD_WITH_REPEATS.wrongVer())
                .options(FIND_REPEAT_WORDS.code)
                .language(EN)
                .callApi());

        //Will fail due to the Speller does not handle "Options"
        assertThat(responses.get(0).get(1).code, equalTo(ERROR_REPEAT_WORD.errorCode));
    }

    @Test
    public void checkCapitalizationError() {
        responses = getYandexSpellerAnswers(with()
                .text(WORD_WITH_CAPITALIZATION.wrongVer())
                .language(EN)
                .callApi());

        //Will fail due to the Speller does not handle "Options"
        assertThat(responses.get(0).get(1).code, equalTo(ERROR_CAPITALIZATION.errorCode));
    }

    @Test
    public void checkResponseCodeInCaseOfWrongRequest() {
        RestAssured
                .given()
                .param(PARAM_LANG, INSISTING_LANGUAGE.langCode())
                .log().everything()
                .when()
                .get(YANDEX_SPELLER_API_URI)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void checkErrorAttributesInResponse() {
        responses = getYandexSpellerAnswers(with()
                .text(BROTHER.corrVer(), STRING_WITH_ERRORS.wrongVer())
                .language(EN)
                .callApi());

        assertThat(responses.get(1).get(0).code, equalTo(ERROR_UNKNOWN_WORD.errorCode));
        assertThat(responses.get(1).get(0).pos, equalTo(STRING_WITH_ERRORS.wrongVer().indexOf("t")));
        assertThat(responses.get(1).get(0).row, equalTo(0));
        assertThat(responses.get(1).get(0).col, equalTo(0));
        assertThat(responses.get(1).get(0).len, equalTo(responses.get(1).get(0).word.length()));

        assertThat(responses.get(1).get(1).code, equalTo(ERROR_UNKNOWN_WORD.errorCode));
        assertThat(responses.get(1).get(1).pos, equalTo(STRING_WITH_ERRORS.wrongVer().indexOf("f")));
        assertThat(responses.get(1).get(1).row, equalTo(1));
        assertThat(responses.get(1).get(1).col, equalTo(1));
        assertThat(responses.get(1).get(1).len, equalTo(responses.get(1).get(1).word.length()));
    }

    @Test
    public void checkPostRequestHandling() {
        RestAssured
                .given()
                .params(PARAM_LANG, Language.RU, PARAM_TEXT, CITY.wrongVer())
                .log().everything()
                .when()
                .post(YANDEX_SPELLER_API_URI)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.containsString(CITY.corrVer()));
        //Assertion will fail due to not handling russian language
    }
}
