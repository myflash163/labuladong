package 算法思维系列;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class 常用的位操作 {
    Logger logger = LoggerFactory.getLogger(常用的位操作.class);

    @Test
    public void test() {

        //1.利用或操作 `|` 和空格将英文字符转换为小写
        char c1 = 'a' | ' ';
        char c2 = 'A' | ' ';
        logger.info(String.valueOf(c1));
        logger.info(String.valueOf(c2));
        //2.利用与操作 `&` 和下划线将英文字符转换为大写
        c1 = 'b' & '_';
        c2 = 'B' & '_';
        logger.info(String.valueOf(c1));
        logger.info(String.valueOf(c2));
        //3.利用异或操作 `^` 和空格进行英文字符大小写互换
        c1 = 'd' ^ ' ';
        c2 = 'D' ^ ' ';
        logger.info(String.valueOf(c1));
        logger.info(String.valueOf(c2));
        //4.判断两个数是否异号
        int x = -1, y = 2;
        boolean f = ((x ^ y) < 0); // true
        logger.info(String.valueOf(f));
        x = 3;
        y = 2;
        f = ((x ^ y) < 0); // false
        logger.info(String.valueOf(f));
        //5.交换两个数
        int a = 1, b = 2;
        a ^= b;
        b ^= a;
        a ^= b;
        logger.info("a={}, b={}", a, b);
        //6.加一
        int n = 1;
        n = -~n;
        logger.info(String.valueOf(n));
        //7.减一
        n = 2;
        n = ~-n;
        logger.info(String.valueOf(n));
    }

    //计算汉明权重（Hamming Weight）就是让你返回 n 的二进制表示中有几个 1
    int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    @Test
    public void testHammingWeight() {
        logger.info(String.valueOf(hammingWeight(12)));
    }
    //判断一个数是不是 2 的指数
    boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    @Test
    public void testIsPowerOfTwo() {
        logger.info(String.valueOf(isPowerOfTwo(12)));
    }

}
