package com.mycompany.csis.project9;

//##################################################
// File: PrettyPrintTree.java
// Author: Richard Cameron
// Description: This file conatins the blueprint and interface for the pretty
// print tree class.
// Date: May 19, 2022
//#################################################

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintTree 
{
    int width = 0;

    public interface AVLNodeGraphicalPrint 
    {
        String getKey();

        Pair getData();

        AVLNodeGraphicalPrint getLeft();

        AVLNodeGraphicalPrint getRight();
    }

    //#################################################
    // @par Name
    // levelDataWidthMod
    // @purpose
    // Responsible for width modification and sequential print of both entries
    // of current Pair object's data.
    // @param [in] :
    // int lowLevel, int width, List<AVLNodeGraphicalPrint> currentLineLevels, 
    // List<AVLNodeGraphicalPrint> nextArray, List<List<String>> StringcurrentLines
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void levelDataWidthMod(int lowLevel, int width, List<AVLNodeGraphicalPrint> currentLineLevels, List<AVLNodeGraphicalPrint> nextArray, List<List<String>> StringcurrentLines) {
        while (lowLevel != 0) 
        {
            List<String> currentLine = new ArrayList<>();

            lowLevel = 0;

            for (AVLNodeGraphicalPrint n : currentLineLevels) 
            {
                if (n == null) 
                {
                    currentLine.add(null);

                    nextArray.add(null);
                    nextArray.add(null);
                } 
                else 
                {
                    String topLevel = n.getKey();

                    topLevel = topLevel + " <--> " + n.getData().mSecond;

                    currentLine.add(topLevel);
                    if (topLevel.length() > this.width) 
                    {
                        this.width = topLevel.length();
                    }

                    nextArray.add(n.getLeft());
                    nextArray.add(n.getRight());

                    if (n.getLeft() != null) 
                    {
                        lowLevel++;
                    }
                    if (n.getRight() != null) 
                    {
                        lowLevel++;
                    }
                }
            }

            if (this.width % 2 == 1) 
            {
                this.width++;
            }
            StringcurrentLines.add(currentLine);
            List<AVLNodeGraphicalPrint> temp = currentLineLevels;
            currentLineLevels = nextArray;
            nextArray = temp;
            nextArray.clear();
        }
    }
    
    //#################################################
    // @par Name
    // printNavMap
    // @purpose
    // Responsible for printring traversal character, sequentially modifies
    // base route.
    // @param [in] :
    // int index, List<String> currentLine, int pieceWise, int pwFloor
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void printNavMap(int index, List<String> currentLine, int pieceWise, int pwFloor) {
        if (index > 0) {
            for (int b = 0; b < currentLine.size(); b++) 
            {
                char c = ' ';
                if (b % 2 == 1) 
                {
                    if (currentLine.get(b - 1) != null) 
                    {
                        c = (currentLine.get(b) != null) ? '^' : '|';
                    } 
                    else 
                    {
                        if (b < currentLine.size() && currentLine.get(b) != null) 
                        {
                            c = '|';
                        }
                    }
                }
                System.out.print(c);
                if (currentLine.get(b) == null) 
                {
                    for (int k = 0; k < pieceWise - 1; k++) 
                    {
                        System.out.print(" ");
                    }
                } 
                else 
                {

                    for (int k = 0; k < pwFloor; k++) 
                    {
                        System.out.print(b % 2 == 0 ? " " : "-");
                    }
                    System.out.print(b % 2 == 0 ? "|" : "|");
                    for (int k = 0; k < pwFloor; k++) 
                    {
                        System.out.print(b % 2 == 0 ? "-" : " ");
                    }
                }
            }
            System.out.println();
        }
    }

    //#################################################
    // @par Name
    // printSeqGap
    // @purpose
    // Responsible for printing sequential gaps with floor pieceWise mod. 
    // @param [in] :
    // List<String> currentLine, int pieceWise
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void printSeqGap(List<String> currentLine, int pieceWise) 
    {
        for (int j = 0; j < currentLine.size(); j++) 
        {
            String form = currentLine.get(j);
            if (form == null) 
            {
                form = "";
            }
            int sequentialGap = (int) Math.ceil(pieceWise / 2f - form.length() / 2f);
            int sequentialGap1 = (int) Math.floor(pieceWise / 2f - form.length() / 2f);

            for (int k = 0; k < sequentialGap; k++) 
            {
                System.out.print(" ");
            }
            System.out.print(form);
            for (int k = 0; k < sequentialGap1; k++) 
            {
                System.out.print(" ");
            }
        }
    }

    //#################################################
    // @par Name
    // graphicalPrint
    // @purpose
    // main function for PrettyPrintTree. Sequentially prints the whole AVL tree.
    // @param [in] :
    // List<String> currentLine, int pieceWise
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void graphicalPrint(AVLNodeGraphicalPrint root) 
    {
        List<AVLNodeGraphicalPrint> nextArray = new ArrayList<>();
        List<List<String>> StringcurrentLines = new ArrayList<>();
        List<AVLNodeGraphicalPrint> currentLineLevels = new ArrayList<>();
        currentLineLevels.add(root);

        int lowLevel = 1;
        this.width = 0;
        this.levelDataWidthMod(lowLevel, this.width, currentLineLevels, nextArray, StringcurrentLines);
        int pieceWise = StringcurrentLines.get(StringcurrentLines.size() - 1).size() * (this.width + 4);
       
        for (int index = 0; index < StringcurrentLines.size(); index++) 
        {
            List<String> currentLine = StringcurrentLines.get(index);
            int pwFloor = (int) Math.floor(pieceWise / 2f) - 1;
            this.printNavMap(index, currentLine, pieceWise, pwFloor);
            this.printSeqGap(currentLine, pieceWise);
            System.out.println();
            pieceWise /= 2;
        }
    }
}
