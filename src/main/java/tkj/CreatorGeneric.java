package tkj;

abstract class GenericWithCreate<T>{
    final T element;
    GenericWithCreate(){
        this.element = create();
    }
    abstract T create();
}
class X{}
class Creator extends GenericWithCreate<X>{
    @Override
    X create() {
        return new X();
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.f();
    }

}
