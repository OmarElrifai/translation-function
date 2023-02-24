package com.vbs.translation;

import com.vbs.Utils.ArabicUtils;
import sun.awt.X11.XSystemTrayPeer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Hello world!
 */
public class Translate {

    private static Map<String, String> dataMap = new HashMap<>();
    private static String dictionaryPath = "./dictionary.txt";

    public static String translateToEnglish(String arabicName) {
        getDatamapFromDictionary(dataMap, dictionaryPath);
        String englishName = translate(arabicName);
        return englishName;
    }

//    private static void writingContentIntoFile(){
//
//    }
//    private static Map<String,String> CompareTwoFilesAndExtractTheDifference(String oldFilePath , String newFilePath){
//        try{
//            File oldFile = new File(oldFilePath);
//            Scanner oldFileReader = new Scanner(oldFile);
//            File newFile = new File(newFilePath);
//            Scanner newFileReader = new Scanner(oldFile);
//            Map<String,String> englishArabicPair = new HashMap<String,String>();
//            while(oldFileReader.hasNextLine()){
//                String lineContent = oldFileReader.nextLine();
//                String[] splitedLineContent = lineContent.split("[\\t|,]");
//                if (splitedLineContent.length ==2){
//
//                    String arabicName = splitedLineContent[0].trim();
//                    arabicName = normalize(arabicName);
//                    String englishName = splitedLineContent[1].trim();
//                    englishName = normalize(englishName);
//
//                    if(!isArabic(arabicName)){
//                        String tempArabicName = englishName;
//                        englishName = arabicName;
//                        arabicName = tempArabicName;
//                    }
//
//                    if(!englishArabicPair.containsKey(arabicName)){
//                        englishArabicPair.put(arabicName,englishName);
//                    }
//                }
//            }
//
//            if(oldFileReader.nextLine()){
//
//            }
//        }catch (FileNotFoundException e){
//
//        }
//    }
    private static String translate(String arabicName) {
        String englishName = dataMap.get(arabicName);
        return englishName != null ? englishName : "" ;
    }

    private static void getDatamapFromDictionary(Map<String, String> dataMap, String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            int numberOfLines = 0;
            int corruptedLines = 0;
            int lineNumber = 0;
            int duplicateLines = 0;
            while (myReader.hasNextLine()) {
                lineNumber++;
                numberOfLines++;
                String line = myReader.nextLine();
                String[] lineData = line.split("[\\t|,]");
                if (lineData.length == 2) {
                    String arabicName = lineData[0].trim();
                    String englishName = lineData[1].trim();
                    if (!ArabicUtils.isArabic(arabicName)){
                        String temp = arabicName;
                        arabicName = englishName;
                        englishName = temp;
                    }
                    arabicName = ArabicUtils.normalize(arabicName);
                    if (!dataMap.containsKey(arabicName)) {
                        dataMap.put(arabicName, englishName);
                    } else {
                        duplicateLines++;
                    }
                } else {
                    corruptedLines++;
                    System.out.println("Found corrupted name at " + lineNumber);
                }
            }
            myReader.close();
//            System.out.println("Total number of names " + numberOfLines);
//            System.out.println("Number of corrupted names " +  corruptedLines);
//            System.out.println("Final number of unique names " + dataMap.entrySet().size());
//            System.out.println("Duplicate lines " + duplicateLines);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found, please check the file path." );
        } catch (Exception e) {
            System.out.println("Error happened, " + e.getMessage() );
            e.printStackTrace();
        }
    }



}

