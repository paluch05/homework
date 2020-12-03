package pl.orzechsoft.paluch.tasks.Task22.AbstractFactory;

public interface AbstractFactory<T> {
    T create(String instrumentType) ;
}
