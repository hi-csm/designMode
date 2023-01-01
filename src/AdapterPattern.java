/**
 * 适配器模式
 */

public class AdapterPattern {
    public static void main(String[] args){
        USB usb = new Adapter();
        usb.Request();

        TypeC typeC = new Adapter1();
        typeC.SpecificRequest();
    }

}

class USB{
    public void Request(){
        System.out.println("USB数据线");
    }
}

class Adapter extends USB{
    private TypeC typeC = new TypeC();

    public void Request(){
        typeC.SpecificRequest();
    }
}

class Adapter1 extends TypeC{
    private USB usb = new USB();

    public void SpecificRequest(){
        usb.Request();
    }
}

class TypeC{
    public void SpecificRequest(){
        System.out.println("Type-C数据线");
    }
}
