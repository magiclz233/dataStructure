package basic.enums;

/**
 * @author magic_lz
 * Description TODO 四则运算
 * @version 1.0
 * @ClassName Operation
 * @date 2020/1/6 21:27
 */
public enum BaseOperation implements OperationI {
    /**
     * 运算符
     */
    PLUS,MINUS,TIMES,DIVIDE;



    @Override
    public double apply(double x, double y){
        switch (this){
            case PLUS:
                return x+y;
            case MINUS:
                return x-y;
            case TIMES:
                return x*y;
            case DIVIDE:
                return x/y;
            default:
                throw new NullPointerException("请输入正确的运算符:"+this);
        }
    }
    public static void main(String[] args){

        System.out.println(BaseOperation.PLUS);
    }
}
