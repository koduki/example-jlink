package cn.orz.pascal.lib;
import cn.orz.pascal.common.CommonLib;

public class MyLib {
    public void hello() {
        CommonLib common = new CommonLib();
        common.hello();
        System.out.println("Hello, " + this.getClass().getName());
    }
}