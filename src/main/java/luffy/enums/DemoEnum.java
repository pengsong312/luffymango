package luffy.enums;

/**
 * @author Luffy
 * @date 2017/8/3
 * @description todo
 */
public enum DemoEnum {

    USER(1,"luffy"),COMPANY(0,"公司");

    private int val;
    private String desc;

    DemoEnum(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public int getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }


    private static DemoEnum parse(int val){
        for(DemoEnum demoEnum:values()){
            if(demoEnum.getVal() == val){
                return demoEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        boolean d = DemoEnum.USER==DemoEnum.COMPANY;
        System.out.println(DemoEnum.parse(1).getDesc());
    }
}
