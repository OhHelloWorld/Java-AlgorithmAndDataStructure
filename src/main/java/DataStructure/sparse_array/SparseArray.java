package DataStructure.sparse_array;

public class SparseArray {

    public static void main(String[] args) {

        int[][] arr = new int[11][11];
        arr[0][1] = 1;
        arr[1][2] = 2;
        arr[2][5] = 1;
        arr[3][8] = 2;

        System.out.println("原始数组：\n");
        for (int[] arr1 : arr){
            for (int temp : arr1){
                System.out.printf("%d\t",temp);
            }
            System.out.println();
        }

        int sum = 0;
        for(int i = 0; i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                if(arr[i][j] != 0){
                    sum++;
                }
            }
        }

        System.out.println("总共有效的数据为：" + sum);

        int[][] sparseArr = new int[sum + 1][3];

        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;

        int count = 1;

        for(int i =0; i < arr.length;i++){
            for(int j = 0; j < arr[i].length;j++){
                if(arr[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count++;
                }
            }
        }

        System.out.println("稀疏数组为：");
        for(int i = 0;i < sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        int[][] backArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1;i<sparseArr.length;i++){
                backArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("恢复后的原数组：");
        for (int[] arr1 : backArr){
            for (int temp : arr1){
                System.out.printf("%d\t",temp);
            }
            System.out.println();
        }

    }
}
