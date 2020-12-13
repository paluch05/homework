package pl.orzechsoft.paluch.tasks.Task24v2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@AllArgsConstructor
public class Operation {

    @Getter
    private final double amount;
    private final long timestamp;
    @Getter
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return Double.compare(operation.amount, amount) == 0 &&
                timestamp == operation.timestamp &&
                Objects.equals(name, operation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, timestamp, name);
    }

    @Override
    public String toString() {
        return "\n[" + name +  "] => " +
                String.format("(%.2f$)",amount);
    }
}
