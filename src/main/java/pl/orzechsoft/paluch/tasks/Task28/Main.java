package pl.orzechsoft.paluch.tasks.Task28;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws MyDatabaseException, SQLException {
        MySQLDatabase mySQLDatabase = new MySQLDatabase("jdbc:mysql://localhost/orzech_task_schema?user=root&password=123&serverTimezone=UTC");
        mySQLDatabase.add(new Phone("6", "fbehjrew", 632));
        mySQLDatabase.add(new Phone("7", "iphone", 512));
        mySQLDatabase.deleteById("5");
        mySQLDatabase.update(new Phone("4", "Motorola", 64));
        mySQLDatabase.getAll();
        Phone phone = mySQLDatabase.get("iphone");
        System.out.println("Phone id: " + phone.getId() + " model: " + phone.getModel());
    }
}
