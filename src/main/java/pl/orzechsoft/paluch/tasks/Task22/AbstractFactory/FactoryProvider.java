package pl.orzechsoft.paluch.tasks.Task22.AbstractFactory;

public class FactoryProvider {

    public static Object getFactory(String choice){

        if("Instrument".equalsIgnoreCase(choice)){
            return new InstrumentFactory();
        }
        else if("Material".equalsIgnoreCase(choice)){
            return new MaterialFactory() {
                @Override
                public String getMaterial() {
                    return null;
                }
            };
        }

        return null;
    }
}
