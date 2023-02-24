package com.vbs.translation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TranslateSingleNameTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        String englishName = Translate.translateToEnglish("روان");
        String englishName1 = Translate.translateToEnglish("كريم");
        String englishName2 = Translate.translateToEnglish("سعيد");
        String englishName3 = Translate.translateToEnglish("مصطفى");
        String englishName4 = Translate.translateToEnglish("سوسن");
        String englishName5 = Translate.translateToEnglish("هشام");
        String englishName6 = Translate.translateToEnglish("مدحت");

        assertTrue( englishName.equals("Rawan") );
        assertTrue( !englishName1.isEmpty() );
        assertTrue( !englishName2.isEmpty() );
        assertTrue( !englishName3.isEmpty() );
        assertTrue( !englishName4.isEmpty() );
        assertTrue( !englishName5.isEmpty() );
        assertTrue( !englishName6.isEmpty() );
        assertTrue(true);
    }
}
