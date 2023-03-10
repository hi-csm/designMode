/**
 * 责任链模式
 */

public class ChainOfResponsibilityPattern {
    public static void main(String[] args){
        Handler fudaoyuan = new FuDaoYuan();
        Handler yuanzhang = new YuanZhang();
        Handler xiaozhang = new XiaoZhang();

        fudaoyuan.setNext(yuanzhang);
        yuanzhang.setNext(xiaozhang);

        fudaoyuan.HandlerRequest(30);
    }
}

abstract class Handler{
    protected Handler next;

    public void setNext(Handler next){
        this.next = next;
    }

    public abstract void HandlerRequest(int request);
}

class FuDaoYuan extends Handler{

    @Override
    public void HandlerRequest(int request) {
        if (request <= 7){
            System.out.println("辅导员审批通过");
        }else {
            if (next != null){
                next.HandlerRequest(request);
            }else {
                System.out.println("无法审批");
            }
        }
    }
}

class YuanZhang extends Handler{

    @Override
    public void HandlerRequest(int request) {
        if (request <= 15){
            System.out.println("院长审批通过");
        }else {
            if (next != null){
                next.HandlerRequest(request);
            }else {
                System.out.println("无法审批");
            }
        }
    }
}

class XiaoZhang extends Handler{

    @Override
    public void HandlerRequest(int request) {
        if (request <= 30){
            System.out.println("校长审批通过");
        }else {
            if (next != null){
                next.HandlerRequest(request);
            }else {
                System.out.println("无法审批");
            }
        }
    }
}