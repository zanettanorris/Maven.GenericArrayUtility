package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <G> {
    G[] array;

    public ArrayUtility(G[] array) {
        this.array = array;
    }

    Integer countDuplicatesInMerge(G[] arrayToMerge, G valueToEvaluate) {
        Integer counter = 0;
        G[] mergedArray = mergeWithArray(arrayToMerge);
        for (G element : mergedArray) {
            if (element.equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public G getMostCommonFromMerge(G[] arrayToMerge) {
//        this could return a long, string, integer or object.

        G[] mergedArray = mergeWithArray(arrayToMerge);
      G mostCommon = null;
      Integer counterOfMostCommon =0;
      for(Integer i =0; i<mergedArray.length; i++){
          G currentItem = mergedArray[i];
        Integer counterOfOccurrences  = 0;
      for (Integer j = 0; j<mergedArray.length; j++){
          if (mergedArray[i].equals(mergedArray[j])){
              counterOfOccurrences++;}
          }
      if (counterOfOccurrences > counterOfMostCommon){
          counterOfMostCommon = counterOfOccurrences;
          mostCommon = currentItem;
      }
      }
      return mostCommon;
    }

    Integer getNumberOfOccurrences(G valueToEvaluate) {
        Integer counter = 0;
        for (G element : array) {
            if (element.equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public G[] mergeWithArray(G[] mergingArray) {
        //copy of original array with a trail of empty spaces at the end.
        // total length, original array length  + merge array length;
        G[] resultArray = Arrays.copyOf(array, array.length + mergingArray.length);
        System.arraycopy(mergingArray, 0, resultArray, array.length, mergingArray.length);
        return resultArray;
    }

    public G[] removeValue(G valueToRemove) {
        Integer counter = getNumberOfOccurrences(valueToRemove);
        G[] arrayWithValueRemoved = Arrays.copyOf(array, array.length - counter);
        Integer newIndex = 0;
        for (Integer oldIndex = 0; oldIndex < array.length; oldIndex++) {
            if (!array[oldIndex].equals(valueToRemove)) {
                arrayWithValueRemoved[newIndex] = array[oldIndex];
                newIndex++;
            }
        }
        return arrayWithValueRemoved;
    }
    public Class findType (G array){
        Class typeG = array.getClass();
        return typeG;
    }

}