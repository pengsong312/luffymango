package luffy.zhconverter;

import com.spreada.utils.chinese.ZHConverter;

/**
 * @Author luffy
 * @Date: 2017/7/21 10:23
 */
public class ZHConverterTest {

    public static void main(String[] args) throws Exception {
        // Instantiation will fetch the property file which load the Chinese character mappings
        //中英文转换
        ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);

        String traditionalSrc = "有背光的機械式鍵盤";
        String simplified = converter.convert(traditionalSrc);
        System.out.println(simplified);


        // Or
        String simplifiedSrc = "简体字";
        String traditional = ZHConverter.convert(simplifiedSrc, ZHConverter.TRADITIONAL);
        System.out.println(traditional);

        ZHConverter traditionalConverter = ZHConverter.getInstance(ZHConverter.TRADITIONAL);

        System.out.println(traditionalConverter.convert("汉语"));


    }
}
