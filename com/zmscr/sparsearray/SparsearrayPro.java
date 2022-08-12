package com.zmscr.sparsearray;

public class SparsearrayPro {
    public static void main(String[] args) {
        int[][] array = intArray();
        System.out.println("普通数组");
        printArray(array);
        System.out.println("普通数组转稀疏数组");
        int[][] sparseArray = sparseArray(array);
        printArray(sparseArray);
        System.out.println("稀疏数组变普通数组");
        int[][] commonArray = toArray(sparseArray);
        printArray(commonArray);
    }

    /*
     *
     * 输入数组
     *
     * */
    public static int[][] intArray() {
        int[][] array = new int[8][5];
        array[2][1] = 1;
        array[3][2] = 2;
        return array;
    }


    /*
     *
     *
     * 打印数组
     *
     *
     * */
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%s\t", data);
            }
            System.out.println();
        }

    }


    //获得非零数组个数
    public static int countArray(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }

        }
        return count;
    }


    //普通数组转化为稀疏数组
    public static int[][] sparseArray(int[][] array) {
        int rowNum = array.length;
        int colNUm = array[0].length;
        int valueNum = countArray(array);


        //稀疏数组矩阵格式
        int[][] spareArray = new int[valueNum + 1][3];
        spareArray[0][0] = rowNum;
        spareArray[0][1] = colNUm;
        spareArray[0][2] = valueNum;

        int sum = 1; //记录第几个非零数组元素
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    spareArray[sum][0] = i;
                    spareArray[sum][1] = j;
                    spareArray[sum][2] = array[i][j];
                    sum++;
                }
            }
        }

        return spareArray;
    }

    //稀疏数组转普通数组
    public static int[][] toArray(int[][] sparseArray) {
        int rowNum = sparseArray[0][0];
        int colNum = sparseArray[0][1];
        int valueNum = sparseArray[0][2];

        int [][] array = new int[rowNum][colNum];

        for (int i = 1; i < valueNum+1; i++) {
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int value = sparseArray[i][2];
            array[row][col] = value;
        }
        return array;
    }
}
