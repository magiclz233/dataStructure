package designpattern.state.test1;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 糖果机
 * @version 1.0
 * @ClassName GumballMachine
 * @date 2020/1/6 10:56
 */
public class GumballMachine {
//    糖果卖完了
    public static final int SOLD_OUT = 0;
//   没有投币
    public static final int NO_QUARTER = 1;
//    已经投币
    public static final int HAS_QUARTER = 2;
    //出售中
    public static final int SOLD = 3;

    //当前的状态
    int state = SOLD_OUT;
    //机器内糖果的数量
    int count = 0;

    public GumballMachine(int count){
        this.count = count;
        if(count > 0){
            state = NO_QUARTER;
        }
    }

    /**
     * 投币
     */
    public void insertQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("你已经投币了,别再投了");
        }else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("投币成功");
        }else if(state == SOLD_OUT){
            System.out.println("糖果销售完了,不能投币购买");
        }else if(state == SOLD){
            System.out.println("请等待片刻,机器正在销售中");
        }
    }

    /**
     * 退回币
     */
    public void ejectQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("正在退币");
        }else if(state == SOLD){
            System.out.println("无法退币,你已经进行了购买操作");
        }else {
            System.out.println("没有币可以退给你");
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank(){
        if(state == SOLD){
            System.out.println("已经转过曲柄了,请等待糖果发放后再次投币购买");
        }else if(state == NO_QUARTER) {
            System.out.println("请投币后再转动");
        }else if(state == SOLD_OUT) {
            System.out.println("糖果售空");
        }else if(state == HAS_QUARTER){
            System.out.println("正在转动曲柄");
            state = SOLD;
            dispense();
        }
    }

    /**
     * 发放糖果
     */
    public void dispense(){
        if(state == SOLD){
            count = count - 1;
            if(count == 0){
                System.out.println("糖果售完");
                state = SOLD_OUT;
            }else {
                state = NO_QUARTER;
            }
        }else {
            System.out.println("状态不对,无法发放糖果");
        }
    }
}
