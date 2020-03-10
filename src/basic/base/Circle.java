package basic.base;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/8 15:59
 */
public class Circle implements Comparable<Circle>,Cloneable {

    private final int x,y,r;

    public Circle(int x, int y, int r) {
        if(r < 0) throw new IllegalArgumentException("半径错误");
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError(e);
        }
    }

    // 替代clone方法
    public Circle(Circle o){
        x = o.x;
        y = o.y;
        r = o.r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    @Override public String toString(){
        return String.format("坐标为: (%d,%d); 半径为: %d",x,y,r);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;

        if(!(o instanceof Circle)) return false;
        Circle that = (Circle) o;
        if(this.x == that.x && this.y == that.y && this.r == that.r){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int result = 17; //来自Effective Java
        result = 37*result +x ;
        result  = 37*result +y;
        result = 37 * result +r;
        return result;
    }

    @Override
    public int compareTo(Circle o) {
        long result = o.y - this.y;
        if(result == 0) result = (long)this.x -o.x;
        if(result == 0) result = this.r - o.r;

        return Long.signum(result);
    }
}
