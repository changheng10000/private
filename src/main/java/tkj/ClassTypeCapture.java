package tkj;

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object obj){
        return kind.isInstance(obj);
    }

    public static void main(String[] args) {
        //编译器将确保类型标签可以匹配泛型参数
        ClassTypeCapture<Building> capture = new ClassTypeCapture<>(Building.class);
        System.out.println(capture.f(new Building()));
        System.out.println(capture.f(new House()));

        ClassTypeCapture<House> capture2 = new ClassTypeCapture<>(House.class);
        System.out.println(capture2.f(new Building()));
        System.out.println(capture2.f(new House()));
    }
}

class Building{}
class House extends Building{}
