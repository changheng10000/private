package tkj;

interface FactoryI<T>{
    T create();
}
class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return 0;
    }
}

class Widget{
    public static class Factory implements FactoryI<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

class Foo<T>{
    private T t;
    public <F extends FactoryI<T>> Foo(F factory){
        this.t = factory.create();
    }


}

public class FactoryConstraint {
    public static void main(String[] args) {
        Foo<Integer> integerFoo = new Foo<>(new IntegerFactory());
        Foo<Widget> widgetFoo = new Foo<>(new Widget.Factory());

    }
}


