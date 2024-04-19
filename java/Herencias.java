interface B {
    void b();
}

interface C {
    void c();
}

class A implements B {
    @Override
    public void b() {
    }
}

class D extends A {
    @Override
    public void b() {
    }

    // @Override
    // public void c() {
    // }
}

public class Herencias {
    public static void main(String[] args) {
        D d = new D();
        d.
    }
}
