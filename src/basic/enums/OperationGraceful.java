package basic.enums;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName OperationGraceful
 * @date 2020/1/6 21:34
 */
public enum OperationGraceful  {

    /**
     * 四则运算
     */
    PLUS("+"){
        @Override
        double apply(double x, double y){
            return x+y;
        }
    },MINUS("-"){
        @Override
        double apply(double x, double y){
            return x-y;
        }
    }, TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };
    /**
     * 符号
     */
    private String symbol;
    OperationGraceful(String symbol){
        this.symbol = symbol;
    }
    abstract double apply(double x,double y);

    public static void main(String[] args){
        double apply = OperationGraceful.MINUS.apply(1, 2);
        System.out.println(apply);
        String s = OperationGraceful.MINUS.symbol;
        System.out.println(s);
    }
}
