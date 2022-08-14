### **稀疏数组**

        当一个数组中大部分的元素为0，或为同一个值的数组时，可以使用稀疏数组来保存该数组

​    

### **为什么使用稀疏数组？** 

        当二维数组相同的值过多或者0过多时使用二维数组会造成空间的浪费


![051ba8d6069f9d1b27146ece3a01bf9.png](https://s2.loli.net/2022/08/13/ytXkqV6wFDzeAIH.png)
        
        稀疏数组最左边的一列为非0数值的顺序（从左往右，从上往下）
        比如：第一个非0数值在第0行第3列的位置，值为3

### **Java实现上图二维数组转稀疏数组，稀疏数组转二维数组**

### **1.定义初始化二维数组方法**

​            

```java
            public static int[][] initArray() {
                //根据图片所给定义二维数组几行几列
                int[][] array =  new int[5][4];
                //定义非0值位置
                array[0][3] = 3;
                array[1][1] = 1;
                array[2][2] = 11;
                array[3][0] = 22;
                array[3][2] = 55;
                array[4][3] = 7;
                //返回定义好的数组
                return array;
            }
```

### **2.遍历二维数组并打印二维数组**

```java
            public static void printfArray(int[][] array) {
                for (int[] row : array) {
                    for (int data : row) {
                        System.out.printf("%s\t", data);
                    }
                    //为方便观察，换行
                    System.out.println();
                }
            }
```

### **3.遍历二维数组获取非零值个数**

​                

```java
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
```

### **4.普通数组转稀疏数组**

​                

```java
            public static int[][] sparseArray(int[][] array) {
                
                //获取稀疏数组第0个非零数值的行列值
                int row = array.length; //二维数组中的行数
                int col = array[0].length; //二维数组中的列数
                int value = countArray(array); //二维数组中的非零值总数
                
                //稀疏数组有(非零值个数+1)行，固定3列
                int[][] sparseArray = new int[value+1][3];
                
                //给稀疏数组第0个非零数值的行列值赋值
                sparseArray[0][0] = row;
                sparseArray[0][1] = col;
                sparseArray[0][2] = value;

                //遍历二维数组给稀疏数组赋值
                int sum = 1; //从第一个非零数组开始
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j ++) {
                        if (array[i][j] != 0) {
                            sparseArray[sum][0] = i;
                            sparseArray[sum][1] = j;
                            sparseArray[sum][2] = array[i][j];
                            sum++;
                        }
                    }
                }
                return sparseArray;
            }
```

#### **跟我一起学习的小伙伴对以下代码有点困扰，这张图或许有帮助**

​        

```java
        sparseArray[sum][0] = i;
        sparseArray[sum][1] = j;
        sparseArray[sum][2] = array[i][j];
```
![稀疏数组1.png](https://s2.loli.net/2022/08/13/8oQF5s2BALbcwdG.png)

### **5.稀疏数组转普通数组**


```java
public static int[][] toArray(int[][] sparseArray) {
    //获取二维数组的行列及非零个数值
    int rowNum = sparseArray[0][0];
    int colNum = sparseArray[0][1];
    int valueNum = sparseArray[0][2];
    //定义二维数组
    int [][] array = new int[rowNum][colNum];
    
    //从第一个非零值开始遍历所有数值，其他默认值为0
    for (int i = 1; i < valueNum+1; i++) {
        //此处从第一个非零值开始来获得其行列值
        int row = sparseArray[i][0];
        int col = sparseArray[i][1];
        int value = sparseArray[i][2];
        array[row][col] = value;
    }
    return array;
}
```

### **测试**

​    

```java
public static void main(String[] args) {
    System.out.println("二维数组");
    printfArray(initArray());
    System.out.println("二维变稀疏");
    int[][] sparseArray = sparseArray(initArray());
    printfArray(sparseArray);
    System.out.println("稀疏变二维");
    int[][] toArray = toArray(sparseArray);
    printfArray(toArray);
}
```

![sparseArray.png](https://s2.loli.net/2022/08/13/v1NrQFW4UAhbcPg.png)