package com.mars;

public class RoverAction {

    /*
    * Constructor
    * */
    public RoverAction(){

    }

    /*
    * Give the values of X and Y as a array
    * */
    protected int[] getXAndY(String roverPosition) {
        int roverX=0;
        int roverY=0;
        roverX=Integer.parseInt(roverPosition.split(" ")[0]);
        roverY=Integer.parseInt(roverPosition.split(" ")[1]);
        int arr[]= new int[4];
        arr[0]=roverX;
        arr[1]=roverY;
        return arr;
    }

    /*
    * find whether both rovers are in the same position, if that is true throw eception
    * */
    protected void authenticateRoversStartPosition(String rover1Position, String rover2Position) {
        int[] arr1 = getXAndY(rover1Position);
        int[] arr2 = getXAndY(rover2Position);
        int rover1X=arr1[0];
        int rover1Y=arr1[1];
        int rover2X=arr2[0];
        int rover2Y= arr2[1];
        if(rover1X==rover2X&&rover1Y==rover2Y) {
            throw new IllegalArgumentException("Error: Both Rovers cannot start in the same position.");
        }
    }

    /*
    * find out rovers positions, if rovers are on same position throw exception
    * */
    protected void authenticateRoversPosition(String finalPosition1, String finalPosition2, String rover2Position, String rover1Position) {
        int[] arr2 = getXAndY(rover2Position);
        int rover2X=arr2[0];
        int rover2Y= arr2[1];

        int rover1FinalX=Integer.parseInt(finalPosition1.split(" ")[0]);
        int rover1FinalY=Integer.parseInt(finalPosition1.split(" ")[1]);
        int rover2FinalX=Integer.parseInt(finalPosition2.split(" ")[0]);
        int rover2FinalY=Integer.parseInt(finalPosition2.split(" ")[1]);
        if((rover1FinalX==rover2X &&rover1FinalY==rover2Y)||(rover2FinalX==rover1FinalX&&rover2FinalY==rover1FinalY))
        {
            throw new IllegalArgumentException("Error: Rovers positions cannot intersect.");
        }
    }

    /*
    * make sure only N,S,W,E can be given as directions
    * */
    protected void authenticateRoverDirection(String roverPosition) {
        if(!roverPosition.contains("N")&&!roverPosition.contains("S")&&!roverPosition.contains("E")&&!roverPosition.contains("W"))
        {
            throw new IllegalArgumentException("Error: Rover position must be N S W or E.");
        }
    }


    /*
    * find out if rovers are in the outside of plateu, if they are throw exception
    * */
    protected void authenticatePositionOfRoverIsOutsidePlateu(String plateuDimentionsInput, String roverPosition) {
        int[] arr = getXAndY(roverPosition);
        int roverX=arr[0];
        int roverY=arr[1];

        int plateuX=Integer.parseInt(plateuDimentionsInput.split(" ")[0]);
        int plateuY=Integer.parseInt(plateuDimentionsInput.split(" ")[1]);

        if(roverX>plateuX||roverY>plateuY)
        {
            throw new IllegalArgumentException("Error: The position of the rover cannot be outside the dimentions of the plateu");
        }
    }


    /*
    * check whether Input values of positions are empty or not valide, then throw exception
    * */

    protected void checkIfInputsAreNotEmptyOrNegative(String plateuDimentionsInput, String roverPosition, String roverInstructions) {
        if(roverPosition.isEmpty()||roverPosition.contains("-"))
            throw new IllegalArgumentException("Error: Rover position cannot be empty or contain any negative number and the position must be N S W or E.");
        else if(plateuDimentionsInput.isEmpty()||plateuDimentionsInput.contains("-"))
            throw new IllegalArgumentException("Error: Plateu dimentions cannot be empty or contain any negative number.");
        else if(roverInstructions.isEmpty())
            throw new IllegalArgumentException("Error: Instructions cannot be empty.");
    }


    /*
    * find out Intial Direction
    * */
    protected int getInitialDirectionIndex(String[] directionArr, String roverInitialDirection, int directionIndex) {
        for(int i=0;i<directionArr.length;i++){
            if(directionArr[i].equals(roverInitialDirection)){
                directionIndex=i;
                break;
            }
        }
        return directionIndex;
    }

    /*
    * get moving direction Index
    * */

    protected int moveDirectionRL(String roverInstructions, String[] directionArr, int directionIndex, int s) {
        if(roverInstructions.charAt(s)=='R'){
            if(directionIndex==directionArr.length-1)
                directionIndex=0;
            else
                directionIndex++;
        }
        else if (roverInstructions.charAt(s)=='L'){
            if(directionIndex==0)
                directionIndex=directionArr.length-1;
            else
                directionIndex--;
        }
        return directionIndex;
    }

    /*
    * find out rovers final positions and directions
    * */

    protected String roverPositionAndDirection(String plateuDimentionsInput, String roverPosition, String roverInstructions) {
        String [] directionArr={"N","E","S","W"};
        String roverInitialDirection=roverPosition.split(" ")[2];
        int[] arr = getXAndY(roverPosition);
        int roverX=arr[0];
        int roverY=arr[1];
        int directionIndex=0;
        directionIndex = getInitialDirectionIndex(directionArr, roverInitialDirection, directionIndex);
        for (int s=0;s<roverInstructions.length();s++){
            String currentDirection=directionArr[directionIndex];
            if(s==0&&roverInstructions.charAt(s)=='M'){
                if(currentDirection.equals("N"))
                    roverY++;
                else if(currentDirection.equals("S"))
                    roverY--;
                else if(currentDirection.equals("E"))
                    roverX++;
                else if(currentDirection.equals("W"))
                    roverX--;
            }
            directionIndex = moveDirectionRL(roverInstructions, directionArr, directionIndex, s);
            currentDirection=directionArr[directionIndex];
            char nextChar = 0;
            if(s!=roverInstructions.length()-1)
                nextChar=roverInstructions.charAt(s+1);

            if(nextChar=='M'){
                if(currentDirection.equals("N"))
                    roverY++;
                else if(currentDirection.equals("S"))
                    roverY--;
                else if(currentDirection.equals("E"))
                    roverX++;
                else if(currentDirection.equals("W"))
                    roverX--;
            }
        }
        String finalPosition=roverX+" "+roverY+" "+directionArr[directionIndex];
        return finalPosition;
    }


}
