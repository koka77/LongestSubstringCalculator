package service;

public class LongestCalculator {
    
    private LongestCalculator() {
    }

    public static int longestSubstring(String s1, String s2) {
        // создам массивы чаров просто для удобства чтения
        char[] arrCharFromS1 = s1.toCharArray();
        char[] arrCharFromS2 = s2.toCharArray();
        // размер матрицы строю по большему слову чтобы сравнимать совпадения в конце строки, но тут не точно
        int colRowLength = arrCharFromS1.length > arrCharFromS2.length ? arrCharFromS1.length : arrCharFromS2.length;
        //матрица значений заполненная нулями
        int[][] array = new int[colRowLength][colRowLength]; //не забываем что будет инициирован нулями
        int res = 0;
        // бежим по матрице
        for (int i = 0; i < colRowLength; i++) {
            for (int j = 0; j < colRowLength; j++) {
                //если выходим за границу слова то пропускаем т.к. нечего сравнивать
                if (arrCharFromS1.length <= i || arrCharFromS2.length <= j) break; // чтобы не выбежать за границы строк
                //проверяем совпадение и если совпадает в первой позиции то просто = 1
                if (arrCharFromS1[i] != arrCharFromS2[j]) {
                    array[i][j] = 0;
                } else {
                    int currentLength = 1;
                    if (i == 0 || j == 0) {
                        array[i][j] = 1;
                    } else {
                        currentLength = array[i - 1][j - 1] + 1;
                        array[i][j] = currentLength;
                    }
                    // в любом случае не меньше единицы
                    res = currentLength > res ? currentLength : res;
                }
            }
        }
        return res;
    }
}
